package com.javaLive.exceptionhandling;


/**
 * The MyUncheckedBusinessException wraps all unchecked standard Java exception and enriches them with a custom error code.
 * You can use this code to retrieve localized error messages and to link to our online documentation.
 * 
 * @author TJanssen
 */
class MyUncheckedBusinessException extends RuntimeException {
    private static final long serialVersionUID = -8460356990632230194L;
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
	
    public MyUncheckedBusinessException(ErrorCode code) {
        super();
        this.code = code;
    }
    public MyUncheckedBusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }
    public MyUncheckedBusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
    public MyUncheckedBusinessException(String message, Throwable cause, ErrorCode code, boolean isSevere) {
		super(message, cause);
		this.code = code;
		this.isSevere = isSevere;
	}
    public MyUncheckedBusinessException(Throwable cause, ErrorCode code) {
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

public class RealTimeExampleForUncheckedExceptionIMP {
	private void wrapException(String input) {
	    try {
	        int num=Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        throw new MyUncheckedBusinessException("A message that describes the error.", e, ErrorCode.INVALID_PORT_CONFIGURATION);
	    }
	}
	public static void main(String[] args) {
		RealTimeExampleForUncheckedExceptionIMP obj=new RealTimeExampleForUncheckedExceptionIMP();
		obj.wrapException("abc");
	}
}
//We can further extend this program by catching the MyUncheckedBusinessException in main method
//and there by logging proper message in log file as in case of MyBusinessException.