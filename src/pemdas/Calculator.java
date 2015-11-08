package pemdas;

public class Calculator {
	boolean validate(String value,String regex)
	{
		System.out.println("Value="+value);
		System.out.println("Regex="+regex);		
	    return value.matches(regex);
	}
	// Handle parentheses first
	double parentheses (double value1, double value2)
	{
		return value1 + value2;
	}
	// Check to see if the parenthesis for the statemant is properly
	// balanced 
	boolean isParenthesisBalanced(String value)
	{
		int balanced = 0;
		for (int i=0; i<value.length(); i++)
		{
			if (value.charAt(i)== '(')
				balanced++;
			if (value.charAt(i)== ')')
				balanced--;
	}
		return balanced == 0 ? true : false; 
	}
	
	
	// Handle exponential power and root functions
	double power (double value1, double value2)
	{
		return value1 + value2;
	}
	double root (double value1, double value2)
	{
		return value1 + value2;
	}
	// Handle division and multiplication
	double divide (double value1, double value2)
	{
		return value1 + value2;
	}
	double multiply (double value1, double value2)
	{
		return value1 * value2;
	}
	// Handle add and subtract
	double add (double value1, double value2)
	{
		return value1 + value2;
	}
	double subtract (double value1, double value2)
	{
		return value1 + value2;
	}


}
