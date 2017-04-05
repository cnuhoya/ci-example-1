package univ.lecture;

import java.util.Stack;

public class Transform {
	private int index = 0;

	/* 구현에 필요한 변수는 임의로 선언할 것 */
	public String[] infixToPostfix(String[] args) {
		// 중위식을 후위식으로 변환한 결과를 String 배열로 반환하는 코드를 작성하고,
		// 마지막에 변환된 후위식을 출력함.
		Stack stack = new Stack<String>();
		String[] post = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			if (precedence(args[i]) == 0 || precedence(args[i]) == 2 || precedence(args[i]) == 4
					|| precedence(args[i]) == 9) {/* ()ASMD가 나왔을 때 */
			} else
				/* 문자가 아닌 숫자일 경우 post배열에 저장 */
				post[index++] = args[i];
		}
		return args;
	}

	public int precedence(String token) {
		if (token.equals("A") || token.equals("S")) {
			return 2;
		} else if (token.equals("M") || token.equals("D")) {
			return 4;
		}
		return -1;
	}
}
