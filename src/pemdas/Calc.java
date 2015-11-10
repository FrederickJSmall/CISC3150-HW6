package pemdas;

public class Calc {
	public static void main(String[]args)
	{
		Postfix postfix = new Postfix();

		try
		{
			System.out.println("Result for the satatement is : " + postfix.calculate("65 + 5"));
			System.out.println();
			System.out.println("Result for the satatement is : " + postfix.calculate("65 + 5 * 3 - 83"));
			System.out.println();
			System.out.println("Result for the satatement is : " + postfix.calculate("65"));
			System.out.println();
		}
		catch (NotANumberException exception) 
		{
			System.out.println("\nNotANumberException");
		}
		catch (NotEnoughNumbersException exception) 
		{
			System.out.println("\nNotEnoughNumbersException");
		}
		catch (IllegalArgumentException ex) 
		{
			System.out.println("\nIllegalArgumentException");
			System.out.println(ex.toString());
		}
	}
}
