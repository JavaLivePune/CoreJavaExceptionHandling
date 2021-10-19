package com.javaLive.exceptionhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithException {
	private static final Logger logger = LoggerFactory.getLogger(LoggingWithException.class); // SLF4J

	void productCheck(int weight) throws InvalidProductException {
		if (weight < 100) {
			throw new InvalidProductException("Product Invalid");
		}
	}

	public static void main(String args[]) {
		UserDefinedExceptionDemo obj = new UserDefinedExceptionDemo();
		try {
			obj.productCheck(60);
		} catch (InvalidProductException ex) {
			System.out.println("Caught the exception");
			logger.error("\nRaised exception of type "+ex.getClass()+"\t"+ex.getMessage());//Logging the error message. 
		}
	}

}
