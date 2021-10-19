package com.javaLive.exceptionhandling;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The MyBusinessException wraps all checked standard Java exception and
 * enriches them with a custom error code. You can use this code to retrieve
 * localized error messages and to link to our online documentation.
 * 
 * @author JavaLive.com
 */
/*
 * Creating a custom checked exception is simple. You already saw multiple parts
 * of it when I explained the 4 best practices for implementing custom
 * exceptions.
 * 
 * When you implement a checked exception, you need to extend the class
 * Exception. That’s the only thing you need to do to create a custom exception
 * class. But as I explained earlier, you should also provide a constructor
 * method that sets the causing exception and provide a benefit compared to the
 * available standard exceptions.
 * 
 * The following example does all of that. As you can see, I added a Javadoc
 * comment that describes the exception. I also implemented a constructor method
 * that sets the causing exception on the superclass. And to provide a benefit
 * compared to the standard exceptions, MyBusinessException uses a custom
 * enumeration to store an error code that identifies the problem. Clients can
 * use the error code to show localized error messages or tell the user to
 * include this code in a support ticket.
 */
class MyBusinessException extends Exception {
	private static final long serialVersionUID = 7718828512143293558L;
	/*
	 * ErrorCode: Enumarion with a unique code which identifies this error, the
	 * errorCode tells what went wrong. This attribute indicates to the exception
	 * catching code what to do with the error.
	 */
	private final ErrorCode code;
	/*
	 * isSevere: indicates whether the error is severe or not, this attribute is
	 * updated as the exception traverse up the stack based on the context of the
	 * error, the severity indicates to the exception catching code whether to halt
	 * the application or keep processing.
	 */
	private boolean isSevere;

	public MyBusinessException(ErrorCode code) {
		super();
		this.code = code;
	}

	public MyBusinessException(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public MyBusinessException(String message, Throwable cause, ErrorCode code, boolean isSevere) {
		super(message, cause);
		this.code = code;
		this.isSevere = isSevere;
	}

	public MyBusinessException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public MyBusinessException(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}

	public ErrorCode getCode() {
		return this.code;
	}

	public boolean isSevere() {
		return isSevere;
	}

	public void setSevere(boolean isSevere) {
		this.isSevere = isSevere;
	}
}

public class RealTimeExampleForCheckedExceptionIMP {
	private static final Logger logger = LoggerFactory.getLogger(RealTimeExampleForCheckedExceptionIMP.class); // SLF4J

	public void handleExceptionInOneBlock() {
		try {
			wrapException(new String("99999999"));
		} catch (MyBusinessException e) {
			// handle exception
			logger.error(e.getMessage() + "\n" + e.getCode().getDescription());
		}
	}

	private void wrapException(String input) throws MyBusinessException {
		try {
			// do something
			//Integer.parseInt("po");
			throw new IOException();
		} catch (IOException e) {
			/*
			 * errorDescription: holds a description of the error with all the necessary
			 * details needed for users, application operators, and possibly the application
			 * developers, to understand what error occurred.
			 */
			throw new MyBusinessException("A message that describes the error.", e,
					ErrorCode.INVALID_PORT_CONFIGURATION);
		}
	}

	public static void main(String[] args) {
		RealTimeExampleForCheckedExceptionIMP obj = new RealTimeExampleForCheckedExceptionIMP();
		obj.handleExceptionInOneBlock();
	}
}
