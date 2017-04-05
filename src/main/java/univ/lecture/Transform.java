package univ.lecture;

import java.util.Stack;

public class Transform {
	private int index = 0;

	public String[] infixToPostfix(String[] args) {
		// 중위식을 후위식으로 변환한 결과를 String 배열로 반환하는 코드를 작성하고,
		// 마지막에 변환된 후위식을 출력함.
		String[] postfix = new String[args.length];
		Stack stack = new Stack<String>();
		for (int i = 0; i < args.length; i++) {

			if (precedence(args[i]) == 0 || precedence(args[i]) == 2 || precedence(args[i]) == 4
					|| precedence(args[i]) == 9) {/* ()ASMD가 나왔을 때 */
				if (stack.isEmpty()) {
					stack.push(args[i]);
				}

				else if (precedence(args[i]) == 0) {/* ( 일때 */
					stack.push(args[i]);
				}

				else if (precedence(args[i]) == 2) {/* A+ S- 일때 */
					while (!stack.isEmpty() && precedence(args[i]) <= precedence((String) stack.peek())) {
						if (precedence((String) stack.peek()) == 2 || precedence((String) stack.peek()) == 4) {
							postfix[index++] = (String) stack.pop();
						} else if (precedence((String) stack.peek()) == 0) {
							stack.push(args[i]);
						}
					}
					stack.push(args[i]);
				} else if (precedence(args[i]) == 4) {/* D/ M* 일때 */
					while (!stack.isEmpty() && precedence(args[i]) <= precedence((String) stack.peek())) {
						if (precedence((String) stack.peek()) == 2) {
							stack.push(args[i]);
						} else if (precedence((String) stack.peek()) == 4) {
							postfix[index++] = (String) stack.pop();
							stack.push(args[i]);
						}
					}
					if (precedence((String) stack.peek()) == 2 || precedence((String) stack.peek()) == 0) {
						stack.push(args[i]);
					}
				}

				else if (precedence(args[i]) == 9) {/* )나왔을때 */
					while (!stack.peek().equals("(")) {
						postfix[index++] = (String) stack.pop();
					}
					stack.pop();/* "(" pop시킴 */
				}
			} else
				/* 문자가 아닌 숫자일 경우 a배열에 저장 */
				postfix[index++] = args[i];

		}
		while (!stack.isEmpty()) {
			postfix[index++] = (String) stack.pop();
		}

		String[] temppostfix = postfix;
		postfix = new String[index];
		System.arraycopy(temppostfix, 0, postfix, 0, index);
		for (int k = 0; k < postfix.length; k++) {
			System.out.print(postfix[k] + " ");
		}
		System.out.println();
		return postfix;
	}

	public int precedence(String token) {
		// 연산자의 우선 순위를 반환하는 함수 작성
		// 연산자 우선 순위 *,/ > +,- > (,)
		if (token.equals("(")) {
			return 0;
		} else if (token.equals("A") || token.equals("S")) {
			return 2;
		} else if (token.equals("M") || token.equals("D")) {
			return 4;
		} else if (token.equals(")")) {
			return 9;
		}
		return -1;
	}
}
