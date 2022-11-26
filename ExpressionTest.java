public class ExpressionTest {
	public static void main(String[] args) {
		String[] postfix = args[0].split(" ");
		ExpressionTree tree = new ExpressionTree(postfix);

		System.out.println("Expression Tree by V. Pham\n");
		System.out.print("Input: ");
		for (String str : postfix) {
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println(tree.evaluate() + "\n");
		System.out.println("Postorder Traversal:");
		tree.postorder();
	}
}