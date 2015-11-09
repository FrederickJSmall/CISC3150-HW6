package pemdas;

public class Calc {
	public static void main(String[]args)
	{
		//String regex = "[0123456789]*";
		//String value = "-8965 +19411916165";
		
		//Calculator calc = new Calculator();
		Postfix parse = new Postfix();
		//System.out.println(calc.validate(value, regex));
		
		
		//Parser.calculate("(65 + (5 * 3)) - 83");
		//Parser.calculate("65 + 5 * 3 - 83");
		//Parser.calculate("65 3 5 * + 83 -");
		try
		{
			System.out.println(parse.calculate("12 3 + 7 9 x -"));
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
