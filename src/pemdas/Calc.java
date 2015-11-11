package pemdas;

public class Calc {
	public static void main(String[]args)
	{
		Postfix postfix = new Postfix();
		String expression = "";
		try
		{
			//expression="65 + 5";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			//expression="65 + 5 * 3 - 83";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			//expression="65 #";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();

			//expression="65 + ";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();

			//expression="65 @ 35";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();

			//expression="65 + y";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			//expression="65 / 0";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			expression="2 + 3 - 7 * 9 / 3 + 11";
			System.out.println("\nResult                    \t" + postfix.calculate(expression));
			System.out.println("**************************************************************");
			System.out.println();
		}
		catch (ArithmeticException exception) 
		{
			System.out.println("\nArithmetic Exception [" + expression + "]");
		}
		catch (NotANumberException exception) 
		{
			System.out.println("\nNotANumberException [" + expression + "]");
		}
		catch (NotEnoughNumbersException exception) 
		{
			System.out.println("\nNotEnoughNumbersException [" + expression + "]");
		}
		catch (IllegalOperationException ex) 
		{
			System.out.println("\nIllegalOperationException [" + expression + "]");
			//System.out.println(ex.getStackTrace());
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println("\nIllegalArgumentException [" + expression + "]");
			//System.out.println(ex.getStackTrace());
		}
	}
}
