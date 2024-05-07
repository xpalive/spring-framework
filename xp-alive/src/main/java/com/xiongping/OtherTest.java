package com.xiongping;

import org.openjdk.jol.info.ClassLayout;

public class OtherTest {

	static class Parent {
		private Long privateField = 1L;
		private boolean b = true;
		private Integer c = 1;
		private String d = "!";
		private byte e = 1;
		private char f = 1;

		private Parent() {
			System.out.println(this);
		}

		private void printPrivateField1() {

			System.out.println("Parent privateField: " + privateField + this + " privateField: " + privateField.hashCode());
		}
	}

	static class Child extends Parent {
		private Long privateField = 2L;

		private Child() {
			System.out.println(this);
		}


		public void printPrivateField() {
			System.out.println("Child privateField: " + privateField + this + " privateField: " + privateField.hashCode());
		}
	}

	public static void main(String[] args) {
		Child child = new Child();
		child.printPrivateField();
		((Parent) child).printPrivateField1();
		String objectSize = ClassLayout.parseInstance(child).toPrintable();
		System.out.println(objectSize);
	}
}
