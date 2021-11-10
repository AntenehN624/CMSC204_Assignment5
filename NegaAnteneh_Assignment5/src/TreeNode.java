
public class TreeNode <T>{

	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	/*
	 * Constructor that sets left and right nodes to null
	 */
	public TreeNode(T dataNode)
	{
		this.data = dataNode;
		this.left = null;
		this.right = null;
	}
	
	/*
	 * Constructor that uses node to set the TreeNode fields
	 */
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
	/*
	 * This method will return the data
	 * @returns data
	 */
	public T getData()
	{
		return data;
	}
}
