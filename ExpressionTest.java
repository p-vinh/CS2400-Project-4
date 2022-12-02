// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Expression test class is the driver class to get an postfix expression from the user
//    Then prints the input and the answer of the expression as well as the postorder traversal
// 
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
		System.out.println("Value: " + tree.evaluate() + "\n");
		System.out.println("Postorder Traversal:");
		tree.postorder();
	}
}