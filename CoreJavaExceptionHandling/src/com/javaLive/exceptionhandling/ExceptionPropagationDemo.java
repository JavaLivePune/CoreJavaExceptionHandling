package com.javaLive.exceptionhandling;

import java.io.IOException;

/**
 * @author Administrator
 * @description Exception propagation : An exception is first thrown from the
 *              top of the stack and if it is not caught, it drops down the call
 *              stack to the previous method. After a method throws an
 *              exception, the runtime system attempts to find something to
 *              handle it. The set of possible “somethings” to handle the
 *              exception is the ordered list of methods that had been called to
 *              get to the method where the error occurred. The list of methods
 *              is known as the call stack and the method of searching is
 *              Exception Propagation. When an exception happens, Propagation is
 *              a process in which the exception is being dropped from to the
 *              top to the bottom of the stack. If not caught once, the
 *              exception again drops down to the previous method and so on
 *              until it gets caught or until it reach the very bottom of the
 *              call stack. This is called exception propagation and this
 *              happens in case of Unchecked Exceptions. In the example below,
 *              exception occurs in m() method where it is not handled, so it is
 *              propagated to previous n() method where it is not handled, again
 *              it is propagated to p() method where exception is handled.
 *              Exception can be handled in any method in call stack either in
 *              main() method, p() method, n() method or m() method. Note : By
 *              default, Unchecked Exceptions are forwarded in calling chain
 *              (propagated)
 * 
 */

// Java program to illustrate exception propagation
// in checked exceptions and it can be propagated
// by throws keyword ONLY
public class ExceptionPropagationDemo {
	// exception propagated to n()
	void m() throws IOException {
		// checked exception occurred
		throw new IOException("device error");
	}

	// exception propagated to p()
	void n() throws IOException {
		m();
	}

	void p() {
		try {

			// exception handled
			n();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
	}

	public static void main(String args[]) {
		ExceptionPropagationDemo obj = new ExceptionPropagationDemo();
		obj.p();
		System.out.println("normal flow...");
	}
}
