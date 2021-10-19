package com.javaLive.exceptionhandling;

class InvalidProductException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3931808743260897079L;

	public InvalidProductException(String s)
    {
        // Call constructor of parent Exception
        super(s);
        System.out.println("In the user defined exception class.\n"+super.getMessage());
    }
}
 
public class UserDefinedExceptionDemo
{
   void productCheck(int weight) throws InvalidProductException{
	if(weight<100){
		throw new InvalidProductException("Product Invalid");
	}
   }
   
    public static void main(String args[])
    {
    	UserDefinedExceptionDemo obj = new UserDefinedExceptionDemo();
        try
        {
            obj.productCheck(60);
        }
        catch (InvalidProductException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
}