public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {

	public ExpressionTree(String[] postfix) {
		LinkedStack<BinaryTree<String>> stack = new LinkedStack<>();

		for (String str : postfix) {
			if (!isOperator(str)) {
				stack.push(new BinaryTree<String>(str));
			} else {
				BinaryTree<String> rhs = stack.pop();
				BinaryTree<String> lhs = stack.pop();
				stack.push(new BinaryTree<>(str, lhs, rhs));
			}
		}

		this.setRootNode(stack.pop().getRootNode());
	}

	public void postorder() {
		postorder(getRootNode());
	}

	private void postorder(BinaryNode<String> rootNode) {
		// int height = rootNode.getHeight();

		// for (int i = 1; i <= height; i++) {
		// for (int j = height; j <= 0; j--) {
		// System.out.print("\t");
		// }
		// if(!rootNode.isLeaf()) {
		// System.out.println(rootNode.getData());
		// if (!rootNode.getLeftChild().isLeaf()) {
		// System.out.println(rootNode.getLeftChild().getData());
		// }
		// if (!rootNode.getRightChild().isLeaf()) {
		// System.out.println(rootNode.getRightChild().getData());
		// }
		// }
		// }
		if (!rootNode.isLeaf()) {
			if (!rootNode.getLeftChild().isLeaf())
				postorder(rootNode.getLeftChild());
			else
				System.out.println(rootNode.getLeftChild().getData());

			if (!rootNode.getRightChild().isLeaf())
				postorder(rootNode.getRightChild());
			else
				System.out.println(rootNode.getRightChild().getData());

		}
		System.out.println(rootNode.getLeftChild().getData() + " : " + rootNode.getData() + " : "
				+ rootNode.getRightChild().getData());
	}

	public double evaluate() {
		return evaluate(getRootNode());
	}

	private double evaluate(BinaryNode<String> rootNode) {
		double result;

		if (rootNode == null)
			result = 0;
		else if (rootNode.isLeaf()) {
			result = getValueOf(rootNode.getData());
		} else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		}

		return result;
	}

	private double getValueOf(String variable) {
		try {
			double ret = Double.parseDouble(variable);
			return ret;
		} catch (NumberFormatException ne) {
			throw new NumberFormatException();
		}
	}

	private double compute(String operator, double firstOperand, double secondOperand) {
		switch (operator) {
			case "+":
				return firstOperand + secondOperand;
			case "-":
				return firstOperand - secondOperand;
			case "*":
				return firstOperand * secondOperand;
			case "/":
				return firstOperand / secondOperand;
			default:
				return 0.0;
		}
	}

	private boolean isOperator(String str) {
		switch (str) {
			case "+":
			case "-":
			case "*":
			case "/":
				return true;
			default:
				return false;
		}
	}

}
