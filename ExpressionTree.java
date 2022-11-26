
public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {
	private BinaryTree<String> tree;

	public ExpressionTree(String[] postfix){
		tree = new BinaryTree<>();
		LinkedStack<BinaryTree<String>> stack = new LinkedStack<>();

		for (String str : postfix) {
			if (isOperator(str)) {
				stack.push(new BinaryTree<String>(str));
			}
			else {
				BinaryTree<String> rhs = stack.pop();
				BinaryTree<String> lhs = stack.pop();
				stack.push(new BinaryTree<>(str, lhs, rhs));
			}
		}
		
		tree.setRootNode(stack.pop().getRootNode());
	}

	public void postorder() {

	}

	public double evaluate() {
		return evaluate(getRootNode());
	}

	private double evaluate(BinaryNode<String> rootNode) {
		double result;
		if (rootNode == null)
			result = 0;
		else if(rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else {
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
		switch(str) {
			case "+": case "-": case "*": case "/":
				return true;
			default:
				return false;
		}
	}



}
