package com.javaLive.exceptionhandling;

/**
 * @author Administrator
 * @description In Java 7 it was made possible to catch multiple different
 *              exceptions in the same catch block. This is also known as multi
 *              catch.
 * 
 */
public class UnionCatchBlock {
	public static void main(String[] args) {
		//This is OLD way......
		/*try {
			int a[] = new int[5];
			//a[5] = 30 / 0;  // leads to Arithmetic Exception
			System.out.println(a[10]);  // Leads to ArrayIndexOutOfBounds Exception
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		}*/
		//This is NEW way.......
		try {
			int a[] = new int[5];
			// a[5] = 30 / 0; // leads to Arithmetic Exception
			System.out.println(a[10]); // Leads to ArrayIndexOutOfBounds Exception
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
