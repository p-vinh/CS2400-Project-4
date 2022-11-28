// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Expression tree interface that extends binary tree interface
//    to add evaluate method
// 

public interface ExpressionTreeInterface extends BinaryTreeInterface<String> {
	/**
	 * Computes the value of the expression in this tree.
	 * 
	 * @return The value of the expression.
	 */
	public double evaluate();
}
