package com.javaLive.exceptionhandling;

public class MultipleCatchBlocks {
	public static void main(String[] args) {

		try {
			int a[] = new int[5];
			//a[5] = 30 / 0;  // leads to Arithmetic Exception
			System.out.println(a[10]);  // Leads to ArrayIndexOutOfBounds Exception
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		} catch (Exception e) {
			System.out.println("Parent Exception occurs");
		}
		System.out.println("Rest of the code");
	}
}
