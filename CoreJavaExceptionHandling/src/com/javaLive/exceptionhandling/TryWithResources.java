package com.javaLive.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Administrator
 * @description Support for try-with-resources – introduced in Java 7 – allows
 *              us to declare resources to be used in a try block with the
 *              assurance that the resources will be closed when after the
 *              execution of that block.
 * 
 *              The resources declared must implement the AutoCloseable
 *              interface.
 */

class MyFileReader {
	public void readMyFile1() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("test.txt"));
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public void readMyFile2() {
		try (Scanner scanner = new Scanner(new File("test.txt"))) {// This is Java 7 way
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}
}

public class TryWithResources {
	public static void main(String[] args) {
		MyFileReader obj1 = new MyFileReader();
		// obj1.readMyFile1();//Old way
		obj1.readMyFile2(); // New Java 7 way
	}

}
