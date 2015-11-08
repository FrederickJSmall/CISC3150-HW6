package pemdas;

import java.lang.Exception;

public class Calculator {
	boolean validate(String value,String regex)
	{
		if (isParenthesisBalanced(value) == false)
		{
			System.out.println("Unbalended statement");
			return false;
		}
		
		System.out.println("Value="+value);
		System.out.println("Regex="+regex);		
	    return value.matches(regex);
	}
	// Check to see if the parenthesis for the statement is properly
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
	// Check to see if the parenthesis for the statement is properly
	// balanced 
	boolean isNumber(String[] value)
	{
		for (int i=0; i< value.length; i++)
		{
			try
			{
				Double.parseDouble(value[i]);
				System.out.println("Is an number="+ value[i]);
			}
			catch(Exception ex)
			{
				System.out.println("Is not an number="+ value[i]);
				return false;
			}
		}
		return true; 
	}	
	// Check to see if its a valid operation
	// balanced 
	boolean isValidOperation(String[] value)
	{
		/*
		for (int i=0; i< value.length; i++)
		{
			if (value[i] !='')
			else (value[i] !='')
			
				return false;
			}
		}
		return true;
		*/
		return false;
	}		
	
	double performOperation(char operation, Double value1, Double value2)
	{
		Double result = 0.0;
		switch (operation)
		{
			case '^':
				result = exponent(value1,value2);
				break;		
			case '*':
				result = multiply(value1,value2);
				break;
			case '\\':
				result = divide(value1,value2);
				break;
			case '+':
				result = add(value1,value2);
				break;
			case '-':
				result = subtract(value1,value2);
				break;
			default:
				//throw new java.lang.Exception.;
				break;
		}
		return result;
	}		
	
	// Handle parentheses first
	double parentheses (double value1, double value2)
	{
		return value1 + value2;
	}

	
	
	// Handle exponential power and root functions
	double exponent (double value1, double value2)
	{
		return Math.pow(value1, value2);
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
