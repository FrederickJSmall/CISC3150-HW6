package pemdas;

import java.lang.Exception;

public class Calculator {
	
	//private String final operators = "*/%+-";
	
	void validate(String[] infixExpressions)
	{
		if (isParenthesisBalanced(infixExpressions) == false)
		{
			//System.out.println("Unbalended statement");
			throw new IllegalOperationException("Unbalended statement");
		}
		isToFewNumbers(infixExpressions);
		//System.out.println("Value="+value);
		//System.out.println("Regex="+regex);		
	    //return value.matches(regex);
		//return true;
	}
	// Check to see if the parenthesis for the statement is properly
	// balanced 
	boolean isParenthesisBalanced(String[] infixExpressions)
	{
		int balanced = 0;
		for (int i=0; i<infixExpressions.length; i++)
		{
			if (infixExpressions[i]== "(")
				balanced++;
			if (infixExpressions[i]== ")")
				balanced--;
		}
		return balanced == 0 ? true : false; 
	}
	void isToFewNumbers(String[] infixExpressions)
	{
		String operators = "[*/%+-]";
		
		int operandsCount = 0;
		int operatorsCount = 0;
		int operatorsInvalidCount = 0;
		int operatorsIsNotANumberCount = 0;
		for (int i=0; i<infixExpressions.length; i++)
		{
            if (infixExpressions[i].matches("[0-9]*"))
            	operandsCount++;
            else if (infixExpressions[i].toString().matches(operators))
            	operatorsCount++;
            else if (infixExpressions[i].toString().matches("[a-zA-Z]*"))
            	operatorsIsNotANumberCount++;            
            else operatorsInvalidCount++;
		}
		if (operatorsIsNotANumberCount > 0)
			throw new NotANumberException ("Not a number exception");		
		if (operatorsInvalidCount > 0)
			throw new IllegalOperationException("Illegal Operators provided");
		if (operandsCount != operatorsCount +1)
			throw new NotEnoughNumbersException("Not enough numbers in statement");
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
		return false;
	}		
	boolean isOperator(String ch) throws IllegalOperationException {
		String operators = "*/%+-";
		if (operators.indexOf(ch) != -1)
			return true;
		else
			return false;
	}
	double performOperation(char operation, Double value1, Double value2) throws IllegalArgumentException
	{
		Double result = 0.0;
		switch (operation)
		{
			case '^':
				result = exponent(value1,value2);
				break;		
			case '%':
				result = modulus(value1,value2);
				break;		
			case '/':
				result = divide(value1,value2);
				break;
			case '*':
				result = multiply(value1,value2);
				break;
			case '+':
				result = add(value1,value2);
				break;
			case '-':
				result = subtract(value1,value2);
				break;
			default:
				throw new IllegalOperationException();
		}
		return result;
	}		
	
	// Handle parentheses first
	double parentheses (double value1, double value2)
	{
		return value1 + value2;
	}

	
	// Handle exponential power and root functions
	double modulus (double value1, double value2)
	{
		return value1 % value2;
	}
	// Handle exponential power and root functions
	double exponent (double value1, double value2)
	{
		return Math.pow(value1, value2);
	}
	double root (double value1, double value2)
	{
		return Math.sqrt(value1);//value1 + value2;
	}
	// Handle division and multiplication
	double divide (double value1, double value2) throws ArithmeticException
	{
		if (value2 == 0)
			throw new ArithmeticException("Can't divide by zero");
		return value1 / value2;
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
		return value1 - value2;
	}


}
