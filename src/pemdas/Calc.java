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
			
			expression="65 #";
			System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			System.out.println();
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
