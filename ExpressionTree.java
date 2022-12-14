// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Expression tree class creates a tree with a given postfix expression.
//    It is able to postorder traverse to print the contents and compute the given postfix expression
// 

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {

	public ExpressionTree(String[] prefix) {
		LinkedStack<BinaryTree<String>> stack = new LinkedStack<>();

		for (int i = prefix.length - 1; i >= 0; i--) {
			if (!isOperator(prefix[i])) {
				stack.push(new BinaryTree<String>(prefix[i]));
			} else {
				BinaryTree<String> lhs = stack.pop();
				BinaryTree<String> rhs = stack.pop();
				stack.push(new BinaryTree<String>(prefix[i], lhs, rhs));
			}
		}

		this.setRootNode(stack.pop().getRootNode());
	}

	// public ExpressionTree(String[] postfix) {
	// LinkedStack<BinaryTree<String>> stack = new LinkedStack<>();

	// for (String str : postfix) {
	// if (!isOperator(str)) {
	// stack.push(new BinaryTree<String>(str));
	// } else {
	// BinaryTree<String> rhs = stack.pop();
	// BinaryTree<String> lhs = stack.pop();
	// stack.push(new BinaryTree<>(str, lhs, rhs));
	// }
	// }

	// this.setRootNode(stack.pop().getRootNode());
	// }

	public void postorder() {
		postorder(getRootNode());
	}

	private void postorder(BinaryNode<String> rootNode) {

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

	public void preorder() {
		preorder(getRootNode());
	}

	// its wrong
	private void preorder(BinaryNode<String> rootNode) {
		if (!rootNode.isLeaf())
			System.out.println(rootNode.getData());

		if (!rootNode.getLeftChild().isLeaf())
			preorder(rootNode.getLeftChild());
		else
			System.out.println(rootNode.getLeftChild().getData());
		System.out.println(rootNode.getLeftChild().getData() + " : " +
				rootNode.getData() + " : "
				+ rootNode.getRightChild().getData());
		if (!rootNode.getRightChild().isLeaf())
			preorder(rootNode.getRightChild());
		else
			System.out.println(rootNode.getRightChild().getData());

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
