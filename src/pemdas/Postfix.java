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
	
    public String calculate(String input) {
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
            if (expression.matches("[0-9]*")) {
                operands.push(expression);
            } else if (expression.matches("[*-/+]")) {
            	//Pop the last two operands off the stack and run calculation
            	double rightOperand = 0;
            	double leftOperand = 0;
            	double result = 0;
                if (expression.equals("*")) {
                    rightOperand = Double.parseDouble(operands.pop());
                    leftOperand = Double.parseDouble(operands.pop());
                    result = calculator.performOperation('*',leftOperand ,rightOperand);// leftOperand * rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("-")) {
                    rightOperand = Double.parseDouble(operands.pop());
                    leftOperand = Double.parseDouble(operands.pop());
                    result = calculator.performOperation('-',leftOperand ,rightOperand);//leftOperand - rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("/")) {
                    rightOperand = Double.parseDouble(operands.pop());
                    leftOperand = Double.parseDouble(operands.pop());
                    result = calculator.performOperation('/',leftOperand ,rightOperand);//leftOperand / rightOperand;
                    operands.push(result+"");
                } else if (expression.equals("+")) {
                    rightOperand = Double.parseDouble(operands.pop());
                    leftOperand = Double.parseDouble(operands.pop());
                    result = calculator.performOperation('+',leftOperand ,rightOperand);//leftOperand + rightOperand;
                    operands.push(result+"");
                }
            } else {
                return null;
            }
        }
        return operands.pop();
    }
}