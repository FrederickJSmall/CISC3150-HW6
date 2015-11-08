package pemdas;

public class Calc {
	public static void main(String[]args)
	{
		String regex = "[0123456789]*";
		String value = "-8965 +19411916165";
		
		Calculator calc = new Calculator();
		System.out.println(calc.validate(value, regex));
		
		String[] numbers = value.split(" ");
		calc.isNumber(numbers);
		
	}
}
