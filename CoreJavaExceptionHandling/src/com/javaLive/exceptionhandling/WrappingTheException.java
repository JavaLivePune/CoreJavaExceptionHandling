package com.javaLive.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author JavaLive.com
 * @description What is Exception Wrapping? Exception wrapping is wrapping is
 *              when you catch an exception, wrap it in a different exception
 *              and throw that exception.
 *
 */
public class WrappingTheException {
	@SuppressWarnings("finally")
	public static String readFirstLine(String url) {
		String result = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File(url));
			result = scanner.nextLine();
		} catch (FileNotFoundException ex) {
			System.out.println("Throwing user defined exception......");
			throw new InvalidProductException("Message sent while exception wrapping......");//Exception wrapped here.
		} finally {
			System.out.println("In the finally block......");
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(WrappingTheException.readFirstLine("abc"));
	}
}

/*
 * Why Use Exception Wrapping? The main reason one would use exception wrapping
 * is to prevent the code further up the call stack from having to know about
 * every possible exception in the system. There are two main reasons for this.
 * 
 * The first reason is, that declared exceptions aggregate towards the top of
 * the call stack. If you do not wrap exceptions, but instead pass them on by
 * declaring your methods to throw them, you may end up with top level methods
 * that declare many different exceptions. Declaring all these exceptions in
 * each method back up the call stack becomes tedious.
 * 
 * The second reason is that you may not want your top level components to know
 * anything about the bottom level components, nor the exceptions they throw.
 * For instance, the purpose of DAO interfaces and implementations is to
 * abstract the details of data access away from the rest of the application.
 * Now, if your DAO methods throw SQLException's then the code using the DAO's
 * will have to catch them. What if you change to an implementation that reads
 * the data from a web service instead of from a database? Then you DAO methods
 * will have to throw both RemoteException and SQLException. And, if you have a
 * DAO that reads data from a file, you will need to throw IOException too. That
 * is three different exceptions, each bound to their own DAO implementation.
 * 
 * To avoid this your DAO interface methods can throw DaoException. In each
 * implementation of the DAO interface (database, file, web service) you will
 * catch the specific exceptions (SQLException, IOException, RemoteException),
 * wrap it in a DaoException, and throw the DaoException. Then code using the
 * DAO interface will only have to deal with DaoException's. It does not need to
 * know anything about what data access technology is used in the various
 * implementations.
 */
