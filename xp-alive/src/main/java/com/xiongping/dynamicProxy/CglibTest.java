package com.xiongping.dynamicProxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class CglibTest {
    
    public static void main(String[] args) {
        UserServiceImpl target = new UserServiceImpl();
        
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        // o 是代理对象
        // Method 是被代理对象的方法
        // objects是传入的参数
        // methodProxy是代理方法
        enhancer.setCallbacks(new Callback[] {(MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before");
            //通过原始对象 请求代理方法
                        final Object result = methodProxy.invoke(target, objects);
            //通过原始对象 请求原始对象的方法
//                        final Object result = method.invoke(target, objects);
            // 通过代理对象请求 原始对象的方法
//            final Object result = method.invoke(o, objects); //报错，执行代理类的当前方法，会栈溢出
            // 通过 代理对象请求父类的方法
//            final Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after");
            return result;
        }, NoOp.INSTANCE});
        
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("testVoid")) {
                    return 0;
                }
                return 1;
            }
        });
        
        final UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        //		System.out.println(userService.test());
        userService.testVoid();
    }
}
