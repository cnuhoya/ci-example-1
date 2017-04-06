package univ.lecture;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */

/*
 * Practice Coding Team3
 * 201302387 김진혁
 * 201302491 최광호
 * 201302476 전성배
 * 201302467 이충완
 * 
 * */

public class Calculator {
	public int calculate(String exp) {

		StringTokenizer token = new StringTokenizer(exp, "+-*/()", true);
		String[] expToArray = new String[token.countTokens()];

		for(int i = 0; token.hasMoreTokens(); i++){
			expToArray[i] = token.nextToken();
		}
		

		return RPN(new Transform().infixToPostfix(expToArray));
	}
	
	public int RPN(String[] args) {
		int result = 0;
		Stack stack = new Stack();
		
		for (int i = 0; i < args.length; i++) {
			String input = args[i];

			if (isAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x, y, input);
				result = (int)z;
				stack.push("" + z);
			} else
				stack.push(input);
		}
		return result;
	}
	
	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "+*-/".indexOf(s) >= 0);
	}

	private double evaluate(double x, double y, String op) {
		double z = 0;

		if (op.equals("+"))
			z = x + y;
		else if (op.equals("-"))
			z = x - y;	
		else if (op.equals("*"))
			z = x * y;
		else 
			z = x / y;

		
		return z;
	}

}
