package pemdas;

import java.util.Scanner;

public class Calc {
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		Postfix postfix = new Postfix();
		String expression = "";
		try
		{
    		expression = keyboard.nextLine();
			//expression="65 + 5";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			//expression="65 + 5 * 3 - 83";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();
			
			//expression="65 #";
			//System.out.println("Result for the satatement is : " + postfix.calculate(expression));
			//System.out.println();

			//expression="+ 12";
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
			
			//expression="2 + 3 - 7 * 9 / 3 + 11";
			System.out.println("\nResult                    \t" + postfix.calculate(expression));
			System.out.println("**************************************************************");
			System.out.println();
		}
		catch (ArithmeticException exception) 
		{
			System.out.println("\nArithmetic exception encountered [" + expression + "]");
		}
		catch (NotANumberException exception) 
		{
			System.out.println("\nNot all the expressions are numbers [" + expression + "]");
		}
		catch (NotEnoughNumbersException exception) 
		{
			System.out.println("\nNot enough numbers provided to perform calculation [" + expression + "]");
		}
		catch (IllegalOperationException ex) 
		{
			System.out.println("\nIllegal operation supplied [" + expression + "]");
			//System.out.println(ex.getStackTrace());
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println("\nUnknown illegal argument encountered [" + expression + "]");
			//System.out.println(ex.getStackTrace());
		}
	}
}
