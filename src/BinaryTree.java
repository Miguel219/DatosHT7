import java.util.Iterator;

public class BinaryTree<E>{
	
	protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	
	public BinaryTree()
	// post: constructor that generates an empty node
	{
		val = null;
		parent = null; 
		left = right = this;
	}
	
	public BinaryTree(E value)
	// post: returns a tree referencing value and two empty subtrees
	{
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		if (left == null) { 
			left = new BinaryTree<E>(); 
		}
		setLeft(left);
		if (right == null) { 
			right = new BinaryTree<E>(); 
		}
		setRight(right);
	}
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	public BinaryTree<E> right()
	// post: returns reference to (possibly empty) left subtree
	// post: returns reference to (possibly empty) left subtree
	{
		return right;
	}
	public BinaryTree<E> parent(){
	// post: returns reference to parent node, or null
	return parent;
	}
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty(newLeft)) {
			return;
		}
		if (left != null && left.parent() == this) {
			left.setParent(null);
		}
		left = newLeft;
		left.setParent(this);
		}
	
public void setRight(BinaryTree<E> newRight)
// post: sets left subtree to newLeft
// re-parents newLeft if not null
{
	if (isEmpty(newRight)) { 
		return;
	}
	if (right != null && right.parent() == this) {
		right.setParent(null);
	}
	right = newRight;
	right.setParent(this);
	}

	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty(newParent)) {
			parent = newParent;
		}
	}
	
	public void inOrder() {
	    inOrder(parent);
	  }
	private void inOrder(BinaryTree<E> tree) { 
		if (tree == null) 
			{ return; } 
		inOrder(tree.left);  
		inOrder(tree.right);
		}

	//Referencia Read more: http://www.java67.com/2016/08/binary-tree-inorder-traversal-in-java.html#ixzz5ilhPBTlX
	// post: returns an in-order iterator of the elements
	
	// post: returns true if this is a left child of parent
	public boolean isLeftChild() {
		if(parent==null) {
			return false;
		}else if(parent.left()==this){
			 return true;
		}else {
			return false;
		}
	}
	// post: returns true if this is a right child of parent
		public boolean isRightChild() {
			if(parent==null) {
				return false;
			}else if(parent.right()==this){
				 return true;
			}else {
				return false;
			}
		}
	//To check if it doesn't have child
	 public boolean isLeaf() {
	        return left == null && right == null;
	    }
	 
	//To check if it is a root
		 public boolean isRoot() {
		        return parent == null;
		    }
	public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
	
	public boolean isEmpty(BinaryTree<E> tree)
	// post: sets the value associated with this node
	{
		return tree==null;
	}
}
