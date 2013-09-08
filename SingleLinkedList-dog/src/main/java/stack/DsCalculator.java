package stack;

/**
 * 스택을 이용한 계산기.
 * 
 * @author 두석
 * 
 */
public class DsCalculator {

	final static char PLUS = '+';
	final static char MINUS = '-';
	final static char MULTIPLE = '*';
	final static char DIVIDE = '/';
	final static char LEFT_PARENTHESIS = '(';
	final static char RIGHT_PARENTHESIS = ')';
	final static char DOT = '.';
	final static char SPACE = ' ';

	public int Priority(Character operator, boolean isLeftParenthesis) {
		int priority = -1;
		switch (operator) {
			case DIVIDE:
			case MULTIPLE:
				priority = 1;
				break;
			case PLUS:
			case MINUS:
				priority = 2;
				break;
			case LEFT_PARENTHESIS:
				if (isLeftParenthesis) {
					priority = 3;
				} else {
					priority = 0;
				}
				break;

		}

		return priority;
	}

	public boolean isNumber(Character character) {
		boolean isNumber = true;
		try {
			Integer.parseInt(character.toString());
		} catch (NumberFormatException nfe) {
			isNumber = false;
		}
		return isNumber;

	}

	// test1
	public String toPostFix(String infix) {

		int length = infix.length();

		StringBuffer sb = new StringBuffer();

		boolean isEndNumber = false;
		DsLinkedListStack<Character> stack = new DsLinkedListStack<>();
		for (int i = 0; i < length; i++) {
			isEndNumber = false;
			Character token = infix.charAt(i);
			// 숫자이면 더하기
			if (isNumber(token) || DOT == token) {
				sb.append(token);
				continue;
			} else {
				switch (token) {
					case MINUS:
					case PLUS:
					case DIVIDE:
					case MULTIPLE:
					case LEFT_PARENTHESIS:

						
						if(LEFT_PARENTHESIS != token){
							isEndNumber = true;
						}
						
						/**
						 * 토큰이 연산자(괄호 포함)인 경우, 스택의 최상위 노드에 담겨있는 연산자가 토큰보다 우선순위가
						 * 높은지를 검사한다.
						 * 
						 * 검사 결과가 참이면 최상위 노드를 스택에서 꺼내 결과에 출력하며, 이 검사 작업을 반복해서
						 * 수행하되 그 결과가 거짓이거나 스택이 비게 되면 작업을 중단한다.
						 * 
						 * 검사 작업이 끝난 후에는 토큰을 스택에 삽입한다. ( 이로 인해 스택에는 최상위 노드보다
						 * 우선순위가 높은 연산자는 존재하지 않게 된다.)
						 */
						while (!stack.isEmpty()) {

							Character poppedOperator = stack.pop();

							int tokenPriority = -1;
							int poppedPriority = -1;
							if (poppedOperator != null) {
								tokenPriority = Priority(token, true);
								poppedPriority = Priority(token, false);
							} else {
								tokenPriority = Priority(token, false);
								poppedPriority = Priority(token, false);
							}

							if (tokenPriority < poppedPriority) {
								sb.append(SPACE);
								sb.append(poppedOperator);
							}else{
								stack.push(poppedOperator);
								break;
							}

						}
						stack.push(token);

						break;
					case RIGHT_PARENTHESIS:

						while (!stack.isEmpty()) {
							Character popOperator = stack.pop();
							if (LEFT_PARENTHESIS == popOperator) {
								break;
							} else {
								sb.append(SPACE);
								sb.append(popOperator);
							}
						}

						break;
					default:
						break;
				}
				
				if(isEndNumber){
					sb.append(SPACE);
				}

			}

		}
		
		while(!stack.isEmpty()){
			sb.append(SPACE);
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	// test2

	// test3

	// test4

}
