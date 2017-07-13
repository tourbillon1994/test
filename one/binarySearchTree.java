package one;

import javax.lang.model.element.Element;
import javax.swing.text.TabableView;

public class binarySearchTree <T extends Comparable< ? super T>> {
	
	private binaryNode<T> root ;
	
	private static class binaryNode<T>{
		 T element;
		 binaryNode<T> left; 
		 binaryNode<T> right;
		 public binaryNode(T element) {
			 this(element, null, null);
		}	
		 public binaryNode(T element,  binaryNode<T> left , binaryNode<T> right) {
			 this.element = element;
			 this.left = left;
			 this.right = right;
		}
	 }
	 
	public binarySearchTree() {
		root = null;
	}
	public void makeEmpty() {
		root = null ;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public boolean contains(T element) {
		return contains(element, root);
	}
	public T findMax(){
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMax(root).element;
	}
	
	public T findMin(){
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMin(root).element;
	}
	
	private boolean contains(T element, binaryNode<T> node) {
		if (node == null) {
			return false;
		}  
		int compareR = element.compareTo(node.element);
		if (compareR > 0) {
			return contains(element, node.right); // return 
		} else if (compareR < 0) {
			return contains(element, node.left);
		} else
			return true;
	}
	public binaryNode<T> findMax(binaryNode<T> node) {
		if (node == null) {  // node cheak is repeated in findMax() --> iseEmpty
			return null;
		} else if (node.left != null) {
			return findMax(node.left);
		} else  
			return node;
	}
	public binaryNode<T> findMin(binaryNode<T> node) {  // another way 
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node;
		} else
			return findMin(node.right);
	}
	public binaryNode<T> insert(T element, binaryNode<T> node) {
		
	}
	public binaryNode<T> remove(T element, binaryNode<T> node) {
		
	}
	
	
	 
}
