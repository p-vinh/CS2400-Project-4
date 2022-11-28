import java.util.Iterator;
// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Tree iterator interface to traverse the tree in any order


public interface TreeIteratorInterface<T> {
	
	/**
	 * Preorder Iterator
	 * 
	 * @return iterator
	 */
	public Iterator<T> getPreorderIterator();

	/**
	 * Postorder Iterator
	 * 
	 * @return iterator
	 */
	public Iterator<T> getPostorderIterator();

	/**
	 * Inorder Iterator
	 * 
	 * @return iterator
	 */
	public Iterator<T> getInorderIterator();

	/**
	 * Level Order Iterator
	 * 
	 * @return iterator
	 */
	public Iterator<T> getLevelOrderIterator();
}
