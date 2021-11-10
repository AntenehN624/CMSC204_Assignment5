import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;

	/*
	 * This constructor calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}

	/**
	 * This method returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() 
	{
		return root;
	}
	
	/**
	 * This method sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		root = new TreeNode<String>(newNode);
	}

	/**
	 * This method Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) 
	{
		addNode(root, code, result);
		return this;
	}
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		if(code.length() == 1)
		{
			if(code.charAt(0) == '-')
			{
				root.right = new TreeNode<String>(letter);
			}
			else if(code.charAt(0) == '.')
			{
				root.left = new TreeNode<String>(letter);
			}
		}
		else
		{
			if(code.charAt(0) == '-')
			{
				addNode(root.right, code.substring(1), letter);
			}
			else if(code.charAt(0) == '.')
			{
				addNode(root.left, code.substring(1), letter);
			}
		}
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) 
	{
		String s = fetchNode(root, code);
		return s;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) 
	{
		if(code.length() == 1)
		{
			if(code.charAt(0) == '-')
			{
				return root.right.data;
			}
			else if(code.charAt(0) == '.')
			{
				return root.left.data;
			}
		}
		else
		{
			if(code.charAt(0) == '-')
			{
				return fetchNode(root.right, code.substring(1));
			}
			else if(code.charAt(0) == '.')
			{
				return fetchNode(root.left, code.substring(1));
			}
		}
		return null;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations.
	 */
	@Override
	public void buildTree() 
	{
		root = new TreeNode<String>("");
		
		//Level 1 inserts
		insert(".","e");
		insert("-","t");
		
		//Level 2 inserts
		insert("..", "i"); 
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//Level 3 inserts
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//Level 4 inserts
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * This method returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> arrlist = new ArrayList<>();
		LNRoutputTraversal(root, arrlist);
		return arrlist;
	}
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		if(root == null)
		{
			return;
		}
		
		if(root.left != null)
		{
			LNRoutputTraversal(root.left, list);
		}
		list.add(root.data);
		
		if(root.right != null)
		{
			LNRoutputTraversal(root.right, list);
		}
	}
	
	
	
}
