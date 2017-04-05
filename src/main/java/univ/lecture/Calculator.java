package univ.lecture;

import java.util.ArrayList;
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
		return 0;
	}
	
	private boolean isAnOperator(String s) {
		return false;
	}

	private double evaluate(double x, double y, String op) {
		double z = 0;

		return z;
	}

}
