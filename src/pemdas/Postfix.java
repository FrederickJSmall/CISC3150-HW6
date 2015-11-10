package pemdas;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

//import postfix.IllegalOperationException;

import java.util.List;
import java.util.ArrayList;
 
public class Postfix {
	
	private Calculator calculator;
	//private String infixString;
	
	public Postfix()
	{
		this.calculator = new Calculator();
	}
	public String calculate(String statement)
	{
		String value;
		value = calculatePostFix(statement);
		return calculateTotal(value);
	}
    private String calculateTotal(String input) throws IllegalArgumentException{
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
                    rightOperand = pop(operands);
                    leftOperand = pop(operands);
                    result = calculator.performOperation('*',leftOperand ,rightOperand);
                    operands.push(result+"");
                } else if (expression.equals("-")) {
                    rightOperand = pop(operands);
                    leftOperand = pop(operands);
                    result = calculator.performOperation('-',leftOperand ,rightOperand);
                    operands.push(result+"");
                } else if (expression.equals("/")) {
                    rightOperand = pop(operands);
                    leftOperand = pop(operands);
                    result = calculator.performOperation('/',leftOperand ,rightOperand);
                    operands.push(result+"");
                } else if (expression.equals("+")) {
                    rightOperand = pop(operands);
                    leftOperand = pop(operands);
                    result = calculator.performOperation('+',leftOperand ,rightOperand);
                    operands.push(result+"");
	            } else if (expression.equals("%")) {
	                rightOperand = pop(operands);
	                leftOperand = pop(operands);
	                result = calculator.performOperation('%',leftOperand ,rightOperand);
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
    public String calculatePostFix(String calculation){
    	String expression = "";
    	String postfixString = "";
    	//String infixString = calculation;
    	Stack<String> opStack = new Stack<String>();

    	String[] infixExpressions = calculation.split(" ");
    	
    	//for(int i = 0; i < infix.length(); i++){
    	for(int i = 0; i < infixExpressions.length; i++){
    		//str = infix.substring(i,i+1);
    		expression = infixExpressions[i];
    		System.out.print(expression);
    		//if(str.matches("[a-zA-Z]|\\d*"))
    		if(expression.matches("\\d*"))
    			postfixString += expression + " ";
    		else if (isOperator(expression)){
    			if (opStack.isEmpty()){ // if no operators are on the stack then add
    				opStack.push(expression);
    			}
    			else{ 
    				// Since there is an operator on the stack
    				// Will need to pop the operator off the stack in order to check 
    				// the current operator against the one on the stack.
    				// Run a check to see which operator has the highest priority and place the lower priority
    				// operator onto the stack
    				String stackTop = opStack.peek();
    				while (evaluateOperators(stackTop,expression).equals(stackTop)&& !(opStack.isEmpty())){
    					postfixString += opStack.pop() + " ";
    					if (!(opStack.isEmpty()))
    						stackTop = opStack.peek();
    				}
    				opStack.push(expression);
    		}
    	}
    }
    //Remove any remaining operators to the stack
    while(!(opStack.isEmpty()))
    {
    	postfixString += opStack.pop() + " ";
    }
    System.out.println("\nPostfix of the expression is: " + postfixString);
    return postfixString;
    }
	private String evaluateOperators(String operator1, String operator2) throws IllegalOperationException {
		String pemdasOpsLevel1 = "*/%";
		String pemdasOpsLevel2 = "+-";
		
		if ((pemdasOpsLevel1.indexOf(operator1) != -1) && (pemdasOpsLevel2.indexOf(operator2) != -1))
			return operator1; 
		else if ((pemdasOpsLevel1.indexOf(operator2) != -1) && (pemdasOpsLevel2.indexOf(operator1) != -1))
			return operator2; 
		else if((pemdasOpsLevel1.indexOf(operator1) != -1) && (pemdasOpsLevel1.indexOf(operator2) != -1))
			return operator1; 
		else
			return operator1;
	}
	private boolean isOperator(String ch) throws IllegalOperationException {
		String operators = "*/%+-";
		if (operators.indexOf(ch) != -1)
			return true;
		else
			return false;
	}
}