package com.javaLive.exceptionhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TryThrowsFinally3 {
	/*
	 * We are required to mark our method signature with a throws clause. A method
	 * can add as many exceptions as needed in its throws clause, and can throw them
	 * later on in the code, but doesn't have to.Keep in mind that anyone who calls
	 * this method also needs to follow the handle-or-declare rule.
	 */
	public static String readFirstLine(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * finally Blocks: Introducing a new kind of block, the finally block executes
		 * regardless of what happens in the try block. Even if it ends abruptly by
		 * throwing an exception, the finally block will execute. This was often used to
		 * close the resources that were opened in the try block since an arising
		 * exception would skip the code closing them:
		 */

		finally {

			System.out.println("In the finally block.");
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return br.readLine();

	}

	public static void main(String[] args) throws IOException {

		System.out.println(TryThrowsFinally3.readFirstLine("abc"));

	}
}
