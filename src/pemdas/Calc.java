package pemdas;

public class Calc {
	public static void main(String[]args)
	{
		String regex = "[0123456789]*";
		//String regex2 = "[\\]";
		
		Calculator calc = new Calculator();
		System.out.println(calc.validate("-8965+19411916165", regex));
		
	}
}
