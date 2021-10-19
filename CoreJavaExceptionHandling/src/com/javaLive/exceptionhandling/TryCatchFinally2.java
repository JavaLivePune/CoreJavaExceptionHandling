package com.javaLive.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchFinally2 {
	@SuppressWarnings("finally")
	public static String readFirstLine(String url) {
		String result=null;
		try {
			Scanner scanner = new Scanner(new File(url));
			result=scanner.nextLine();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		}
		/*
		 * finally Blocks: Introducing a new kind of block, the finally block executes
		 * regardless of what happens in the try block. Even if it ends abruptly by
		 * throwing an exception, the finally block will execute. This was often used to
		 * close the resources that were opened in the try block since an arising
		 * exception would skip the code closing them:
		 */
		finally {
			System.out.println("In the finally block......");
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(TryCatchWithThrow1.readFirstLine("abc"));
	}
}
