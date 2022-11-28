// 
//  Name:		Pham, Vinh 
//  Project:	4
//  Due:		21 Novmeber 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Tree interface for general trees
//    
// 
public interface TreeInterface<T> {
    /**
	 * Gets the data in the root of this tree.
     * 
     * @return data that is in the root
	 */
	public T getRootData();

    /**
     * Retrieves the height of the tree
     * 
     * @return height of the tree
     */
    public int getHeight();

    /**
     * Count the number of nodes in a tree
     * 
     * @return number of nodes
     */
    public int getNumberOfNodes();

    /**
     * Checks if the tree is empty
     * 
     * @return true if the tree is empty, false if not
     */
    public boolean isEmpty();

    /**
     * Clears the tree
     */
    public void clear();
}
