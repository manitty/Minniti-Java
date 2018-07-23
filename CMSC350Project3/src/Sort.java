//File name: Sort.java
//Author: Paul Minniti
//Date: 23 April 2017
/*This programming project involves writing a program that performs a sort by using a
 *  binary search tree. The program should be able to sort lists of integers or lists 
 *  of fractions in either ascending or descending order. One set of radio buttons should
 *   be used to determine whether the lists contain integers or fractions and a second set 
 *   should be used to specify the sort order.
*/
public class Sort<T> {

	T data;
	Sort parent;
	Sort left;
	Sort right;
	String text;

	public Sort() {
	}

	Sort<T> createBSTNode(T data) {
		Sort<T> newNode = new Sort<T>();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		newNode.parent = null;
		return newNode;
	}

	Sort<T> bstInsert(Sort<T> tree, Sort<T> node) {

		Sort<T> prev = null;
		Sort<T> iter = tree;
		while (iter != null) {
			prev = iter;
			if (tree.data instanceof Integer) {
				if ((Integer) node.data < (Integer) iter.data)
					iter = iter.left;
				else
					iter = iter.right;
			}
			else{
				if(((Fraction)node.data).compareTo(((Fraction)iter.data)) >0){
					iter = iter.left;
				}
				else{
					iter = iter.right;
				}
			}
		}
		// found node is parent to our node
		node.parent = prev;

		// if prev is NULL
		// then this is the first node
		// change the root NODE
		if (prev == null)
			tree = node;
		else {
			// now we need to decide where the node
			// should go: left or right
			if (tree.data instanceof Integer) {
			if ((Integer) node.data < (Integer) prev.data)
				prev.left = node;
			else
				prev.right = node;
			}
			else{
				if(((Fraction)node.data).compareTo(((Fraction)prev.data)) >0){
					prev.left = node;
				}
				else{
					prev.right = node;
				}
			}
			
		}
		return tree;

	}

	Sort<T> convertArrBst(T arr[], int size) {
		Sort<T> tree = null;
		for (int i = 0; i < size; i++) {
			tree = bstInsert(tree, createBSTNode(arr[i]));
		}
		return tree;
	}

	String ascending(Sort root) {

		if (root == null)
			return text;
		ascending(root.left);
	//	System.out.print(root.data + " ");
		text += String.valueOf(root.data + " ");
		ascending(root.right);
		return text;
	}

	String descending(Sort root) {

		if (root == null)
			return text;
		descending(root.right);
	//	System.out.print(root.data + " ");
		text += String.valueOf(root.data + " ");
		descending(root.left);
		return text;
	}
}