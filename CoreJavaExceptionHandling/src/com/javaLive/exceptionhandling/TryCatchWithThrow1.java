package com.javaLive.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchWithThrow1 {
	public static String readFirstLine(String url) {  
	    try {
	        Scanner scanner = new Scanner(new File(url));
	        return scanner.nextLine();
	    } catch(FileNotFoundException ex) {
	        System.out.println("File not found.");
	        return null;
	    }
	}
public static void main(String[] args) {
	System.out.println(TryCatchWithThrow1.readFirstLine("abc"));
}
}
