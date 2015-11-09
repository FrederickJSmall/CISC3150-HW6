package pemdas;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
 
public class Postfix {
	
	private Calculator calculator;
	
	public Postfix()
	{
		this.calculator = new Calculator();
	}
	
    public String calculate(String input) throws IllegalArgumentException{
        List<String> processedList = new ArrayList<String>();
        if (!input.isEmpty()) 
        {
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                processedList.add(st.nextToken());
            }
        } 
        else {
            return null;
        }
        Stack<String> operands = new Stack<String>();
        Iterator<String> tokens = processedList.iterator();
        while (tokens.hasNext()) {
            String expression = tokens.next();
            //System.out.print(expression);
            if (expression.matches("[0-9]*")) {
                operands.push(expression);
            } else if (expression.matches("[*-/+%]")) {
            	//Pop the last two operands off the stack and run calculation
            	double rightOperand = 0;
            	double leftOperand = 0;
            	double result = 0;
                if (expression.equals("*")) {
                    rightOperand = pop(operands);//Double.parseDouble(operands.pop());
                    leftOperand = pop(operands);//Double.parseDouble(operands.pop());
                    result = calculator.performOperation('*',leftOperand ,rightOperand);// leftOperand * rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("-")) {
                    rightOperand = pop(operands);//Double.parseDouble(operands.pop());
                    leftOperand = pop(operands);//Double.parseDouble(operands.pop());
                    result = calculator.performOperation('-',leftOperand ,rightOperand);//leftOperand - rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("/")) {
                    rightOperand = pop(operands);//Double.parseDouble(operands.pop());
                    leftOperand = pop(operands);//Double.parseDouble(operands.pop());
                    result = calculator.performOperation('/',leftOperand ,rightOperand);//leftOperand / rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("+")) {
                    rightOperand = pop(operands);//Double.parseDouble(operands.pop());
                    leftOperand = pop(operands);//Double.parseDouble(operands.pop());
                    result = calculator.performOperation('+',leftOperand ,rightOperand);//leftOperand + rightOperand;
                    operands.push(result+"");
	            } else if (expression.equals("%")) {
	                rightOperand = pop(operands);//Double.parseDouble(operands.pop());
	                leftOperand = pop(operands);//Double.parseDouble(operands.pop());
	                result = calculator.performOperation('%',leftOperand ,rightOperand);//leftOperand + rightOperand;
	                operands.push(result+"");
	            }else {
	            	throw new IllegalOperationException();
	            }
            } 
            else {
            	throw new IllegalOperationException("Invalid value in expression:" + expression);//return null;
            }
        }
        calculator = null;
        return operands.pop();
    }
    private Double pop(Stack<String> operands)
    {
    	if (operands.isEmpty())
    		throw new NotEnoughNumbersException();
    	return Double.parseDouble(operands.pop());
    	
    }
   
}