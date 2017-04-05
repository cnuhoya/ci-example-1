package univ.lecture;

import java.util.Stack;

public class Transform {
	private int index = 0;

	/* 구현에 필요한 변수는 임의로 선언할 것 */
	public String[] infixToPostfix(String[] args) {
		// 중위식을 후위식으로 변환한 결과를 String 배열로 반환하는 코드를 작성하고,
		// 마지막에 변환된 후위식을 출력함.
		Stack stack = new Stack<>();
		String[] post = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			if (precedence(args[i]) == 0 || precedence(args[i]) == 2 || precedence(args[i]) == 4
					|| precedence(args[i]) == 9) {/* ()ASMD가 나왔을 때 */
				if (stack.isEmpty()) {
					stack.push(args[i]);
				} else if (precedence(args[i]) == 0) {/* ( 일때 */
					stack.push(args[i]);
				} else if (precedence(args[i]) == 2) {/* A+ S- 일때 */
					while (!stack.isEmpty() && precedence(args[i]) <= precedence((String) stack.peek())) {
						if (precedence((String) stack.peek()) == 2 || precedence((String) stack.peek()) == 4) {
							post[index++] = (String) stack.pop();
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
							post[index++] = (String) stack.pop();
							stack.push(args[i]);
						}
					}
					if (precedence((String) stack.peek()) == 2 || precedence((String) stack.peek()) == 0) {
						stack.push(args[i]);
					}
				}

				else if (precedence(args[i]) == 9) {/* )나왔을때 */
					while (!stack.peek().equals("(")) {
						post[index++] = (String) stack.pop();
					}
					stack.pop();/* "(" pop시킴 */
				}
			} else
				/* 문자가 아닌 숫자일 경우 a배열에 저장 */
				post[index++] = args[i];
		}
		while (!stack.isEmpty()) {
			post[index++] = (String) stack.pop();
		}

		String[] postfix = post;
		post = new String[index];
		System.arraycopy(postfix, 0, post, 0, index);
		for (int k = 0; k < post.length; k++) {
			System.out.print(post[k] + " ");
		}
		System.out.println();
		return postfix;
	}

	public int precedence(String token) {
		return 0;
	}
}
