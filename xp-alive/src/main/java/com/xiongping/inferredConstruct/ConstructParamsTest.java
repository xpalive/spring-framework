package com.xiongping.inferredConstruct;

import com.sun.org.apache.bcel.internal.Const;
import org.springframework.asm.*;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用反射的方式获取构造方法的参数只能获取到arg0 arg1，或者启动参数加上-parameters
 * 所以spring选择了使用asm技术
 */
public class ConstructParamsTest {

	public static void main(String[] args) throws IOException {
//		Constructor<?>[] constructors = UserService.class.getConstructors();
//		for (Constructor<?> constructor : constructors) {
//			System.out.println(constructor.getName());
//			getParams(constructor);
//		}
		getParamsASM(UserService.class);
	}

	public static void getParams(Constructor<?> constructor) {
		Parameter[] parameters = constructor.getParameters();
		for (Parameter parameter : parameters) {
			System.out.println(parameter.getName());
		}
	}

	public static void getParamsASM(Class<?> clazz) throws IOException {
		InputStream is = clazz.getResourceAsStream(ClassUtils.getClassFileName(clazz));
		ClassReader classReader = new ClassReader(is);
		Map<Executable, String[]> map = new ConcurrentHashMap<>(32);
		classReader.accept(new ClassVisitor(SpringAsmInfo.ASM_VERSION) {
			@Override
			@Nullable
			public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
				// exclude synthetic + bridged && static class initialization
				if (!isSyntheticOrBridged(access) && !"<clinit>".equals(name)) {
					return new LocalVariableTableVisitor(clazz, map, name, desc, isStatic(access));
				}
				return null;
			}
			private boolean isSyntheticOrBridged(int access) {
				return (((access & Opcodes.ACC_SYNTHETIC) | (access & Opcodes.ACC_BRIDGE)) > 0);
			}

			private boolean isStatic(int access) {
				return ((access & Opcodes.ACC_STATIC) > 0);
			}
		}, 0);
		System.out.println(map);
	}

	private static class LocalVariableTableVisitor extends MethodVisitor {

		private static final String CONSTRUCTOR = "<init>";

		private final Class<?> clazz;

		private final Map<Executable, String[]> executableMap;

		private final String name;

		private final Type[] args;

		private final String[] parameterNames;

		private final boolean isStatic;

		private boolean hasLvtInfo = false;

		/*
		 * The nth entry contains the slot index of the LVT table entry holding the
		 * argument name for the nth parameter.
		 */
		private final int[] lvtSlotIndex;

		public LocalVariableTableVisitor(Class<?> clazz, Map<Executable, String[]> map, String name, String desc, boolean isStatic) {
			super(SpringAsmInfo.ASM_VERSION);
			this.clazz = clazz;
			this.executableMap = map;
			this.name = name;
			this.args = Type.getArgumentTypes(desc);
			this.parameterNames = new String[this.args.length];
			this.isStatic = isStatic;
			this.lvtSlotIndex = computeLvtSlotIndices(isStatic, this.args);
		}

		@Override
		public void visitLocalVariable(String name, String description, String signature, Label start, Label end, int index) {
			this.hasLvtInfo = true;
			for (int i = 0; i < this.lvtSlotIndex.length; i++) {
				if (this.lvtSlotIndex[i] == index) {
					this.parameterNames[i] = name;
				}
			}
		}

		@Override
		public void visitEnd() {
			if (this.hasLvtInfo || (this.isStatic && this.parameterNames.length == 0)) {
				// visitLocalVariable will never be called for static no args methods
				// which doesn't use any local variables.
				// This means that hasLvtInfo could be false for that kind of methods
				// even if the class has local variable info.
				this.executableMap.put(resolveExecutable(), this.parameterNames);
			}
		}

		private Executable resolveExecutable() {
			ClassLoader loader = this.clazz.getClassLoader();
			Class<?>[] argTypes = new Class<?>[this.args.length];
			for (int i = 0; i < this.args.length; i++) {
				argTypes[i] = ClassUtils.resolveClassName(this.args[i].getClassName(), loader);
			}
			try {
				if (CONSTRUCTOR.equals(this.name)) {
					return this.clazz.getDeclaredConstructor(argTypes);
				}
				return this.clazz.getDeclaredMethod(this.name, argTypes);
			}
			catch (NoSuchMethodException ex) {
				throw new IllegalStateException("Method [" + this.name +
						"] was discovered in the .class file but cannot be resolved in the class object", ex);
			}
		}

		private static int[] computeLvtSlotIndices(boolean isStatic, Type[] paramTypes) {
			int[] lvtIndex = new int[paramTypes.length];
			int nextIndex = (isStatic ? 0 : 1);
			for (int i = 0; i < paramTypes.length; i++) {
				lvtIndex[i] = nextIndex;
				if (isWideType(paramTypes[i])) {
					nextIndex += 2;
				}
				else {
					nextIndex++;
				}
			}
			return lvtIndex;
		}

		private static boolean isWideType(Type aType) {
			// float is not a wide type
			return (aType == Type.LONG_TYPE || aType == Type.DOUBLE_TYPE);
		}
	}
}
