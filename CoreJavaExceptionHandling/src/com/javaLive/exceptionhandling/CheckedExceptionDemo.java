package com.javaLive.exceptionhandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author JavaLive.com
 * @description Checked are the exceptions that are checked at compile time. If
 *              some code within a method throws a checked exception, then the
 *              method must either handle the exception or it must specify the
 *              exception using throws keyword.
 * 
 *              For example, consider the following Java program that opens file
 *              at location “C:\test\a.txt” and prints the first three lines of
 *              it. The program doesn’t compile, because the function main()
 *              uses FileReader() and FileReader() throws a checked exception
 *              FileNotFoundException. It also uses readLine() and close()
 *              methods, and these methods also throw checked exception
 *              IOException
 */

public class CheckedExceptionDemo {
	public static void main(String args[]) throws Exception {
		FileReader file = new FileReader("C:\\test\\a.txt");
		BufferedReader fileInput = new BufferedReader(file);

		// Print first 3 lines of file "C:\test\a.txt"
		for (int counter = 0; counter < 3; counter++)
			System.out.println(fileInput.readLine());

		fileInput.close();
	}
}
/*
 * To fix the above program, we either need to specify list of exceptions using
 * throws, or we need to use try-catch block. We have used throws in the below
 * program. Since FileNotFoundException is a subclass of IOException, we can
 * just specify IOException in the throws list and make the above program
 * compiler-error-free.
 */
