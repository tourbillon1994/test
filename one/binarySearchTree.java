package one;

import javax.jws.WebParam.Mode;
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
		} else if (node.right != null) {
			return findMax(node.right);
		} else  
			return node;
	}
	public binaryNode<T> findMin(binaryNode<T> node) {  // another way 
		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node;
		} else
			return findMin(node.left);
	}
	public binaryNode<T> insert(T element, binaryNode<T> node) {
		if (node == null) {
			return new binaryNode<T>(element, null, null);
		}
		int compareR = element.compareTo(node.element);
		if (compareR > 0 ) {
			node.right = insert(element, node.right);
		} else if (compareR < 0 ) {
			node.left =  insert(element, node.left);
		} else {
			;
		}
		return node;
	}
	public binaryNode<T> remove(T element, binaryNode<T> node) {   // very complex
		if (node == null) {
			return node;
		}
		int compareR = element.compareTo(node.element);
		if (compareR > 0) {
			node.right = remove(element, node.right);
		} else if (compareR < 0) {
			node.left = remove(element, node.left);
		} else if (node.left != null && node.right != null) {
			node.element = findMin(node.right).element;
			node.right = remove(node.element, node.right);
		} else {
			node = (node.left != null) ? node.left :node.right;
		}
		return node;
	}
	
	
	 
}
