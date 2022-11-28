// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Contains all the methods of the BinaryTree
//    Initializes the tree in the constructor
// 


import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	} // end setTree

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	public void setRootData(T rootData) {
		root.setData(rootData);;
	}

	public T getRootData() {
		return root.getData();
	}

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}

	protected BinaryNode<T> getRootNode() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}


	public Iterator<T> getPreorderIterator() {
		throw new UnsupportedOperationException("getPreorderIterator");
	}

	public Iterator<T> getPostorderIterator() {
		throw new UnsupportedOperationException("getPostorderIterator");
	}

	public Iterator<T> getInorderIterator() {
		throw new UnsupportedOperationException("getInorderIterator");
	}

	public Iterator<T> getLevelOrderIterator() {
		throw new UnsupportedOperationException("getLevelOrderIterator");
	}

	

}
