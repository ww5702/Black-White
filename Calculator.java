import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

	//private String[] code = { "+", "-", "*", "(", ")" };
	private String[] code = { "+", "-", "*"};
	private Stack<String> tokenStack = new Stack<String>();
	private Stack<String> exprStack = new Stack<String>();
	private List<String> postOrderList = new ArrayList<String>();

	private void makeTokens(String s) {
		StringBuffer tokenBuf = new StringBuffer();
		int argSize = s.length();
		String token = null;
		for (int i = 0; i < argSize; i++) {
			token = s.substring(i, i + 1);
			if (!iscode(token)) {
				tokenBuf.append(token);

				if (i == argSize - 1) {
					tokenStack.push(tokenBuf.toString());
				}
			} else {
				if (tokenBuf.length() > 0) {
					tokenStack.push(tokenBuf.toString());
					tokenBuf = new StringBuffer();
				}

				tokenStack.push(token);
			}
		}
	}

	//���������� �˻�
	private boolean iscode(String s) {
		boolean bcode = false;

		int codeSize = code.length;
		for (int i = 0; i < codeSize; i++) {
			if (code[i].equals(s)) {
				bcode = true;
				break;
			}
		}
		return bcode;
	}

	//���������� �˻�
	private boolean isOpcode(String s) {
		boolean opcode = iscode(s);

		if ("(".equals(s) || ")".equals(s)) {
			opcode = false;
		}

		return opcode;
	}

	//PostOrder�� ��ȯ
	private void convertPostOrder(String expr) {
		for (String token : tokenStack) {
			if (iscode(token)) {
				exprAppend(token);
			} else {
				postOrderList.add(token);
			}
		}

		// exprStack�� �ڷᰡ ���� ������ ����Ѵ�
		String item = null;
		while (!exprStack.isEmpty()) {
			item = exprStack.pop();
			postOrderList.add(item);
		}
	}

	//�����ڸ� ���ؼ� postorder��Ŀ� ǥ�� ���� ���ÿ� ������ Ȯ��
	private void exprAppend(String token) {
		// '(' �� ��� ���ÿ� �ִ´�
		if ("(".equals(token)) {
			exprStack.push(token);
			return;
		}

		// ')' �� ��� '('�� ���� �� ���� ����Ѵ�
		if (")".equals(token)) {
			String opcode = null;
			while (true) {
				opcode = exprStack.pop();
				if ("(".equals(opcode)) {
					break;
				}

				postOrderList.add(opcode);
			}

			return;
		}

		// �������� ��� ���ÿ��� pop�Ͽ� ���� �켱������ ������ ���� ����ϰ� �ڽ��� push
		if (isOpcode(token)) {
			String opcode = null;
			while (true) {
				if (exprStack.isEmpty()) {
					exprStack.push(token);
					break;
				}

				opcode = exprStack.pop();
				if (exprOrder(opcode) > exprOrder(token)) {
					postOrderList.add(opcode);
				} else {
					exprStack.push(opcode);
					exprStack.push(token);
					break;
				}
			}

			return;
		}
	}

	//�� ���
	public double calculate(String expr) {
		// ��ū�� �����
		makeTokens(expr);

		// postOrder�� ��ȯ
		convertPostOrder(expr);

		Stack<String> calcStack = new Stack<String>();

		// postOrder ����Ʈ�� ���� calcStack�� ����
		for (String s : postOrderList) {
			calcStack.push(s);
			calcPostOrder(calcStack);
		}

		// ������ ���� ���� ��ȯ�Ѵ�
		double result = Double.parseDouble(calcStack.pop());

		return result;
	}

	//���ÿ��� pop������ �Ͽ� ��� �����ϸ� ��� �� ���� ���ÿ� �ִ´�
	private void calcPostOrder(Stack<String> calcStack) {
		// �����ڰ� �ƴϸ� ����� ���� �ʴ´�
		if (!isOpcode(calcStack.lastElement())) {
			return;
		}

		// 3���� ������ �ϹǷ� 3�� �̻����� �˻�
		String op1 = null;
		String op2 = null;
		String opcode = null;
		if (calcStack.size() >= 3) {
			opcode = calcStack.pop();
			op1 = calcStack.pop();
			op2 = calcStack.pop();

			// ���� ����Ͽ� ���ÿ� �ִ´�
			double result = result(op1, op2, opcode);
			calcStack.push(Double.toString(result));
		}
	}

	private double result(String op1, String op2, String opcode) {
		double d1 = Double.parseDouble(op1);
		double d2 = Double.parseDouble(op2);

		double result = 0.0;
		if ("+".equals(opcode)) {
			result = d2 + d1;
		} else if ("-".equals(opcode)) {
			result = d2 - d1;
		} else if ("*".equals(opcode)) {
			result = d2 * d1;
		}
		return result;
	}

	public int exprOrder(String s) {
		int order = -1;
		if ("-".equals(s) || "+".equals(s)) {
			order = 0;
		} else if ("*".equals(s)) {
			order = 1;
		}

		return order;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}

}