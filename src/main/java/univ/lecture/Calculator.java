package univ.lecture;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	public int calculate(String exp) {

		StringTokenizer token = new StringTokenizer(exp, "+-*/()", true);
		String[] expToArray = new String[exp.length()-1];

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

			System.out.print(input + " ");

			if (isAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x, y, input);
				result = (int)z;
				stack.push("" + z);
			} else
				stack.push(input);
		}
		System.out.println("결과값은 : " + result + "입니다.");
		return result;
	}
	
	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "+*-/".indexOf(s) >= 0);
	}

	private double evaluate(double x, double y, String op) {
		double z = 0;

		return z;
	}

}
