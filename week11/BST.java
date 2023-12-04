package week11;

import java.util.*;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Task 1
	// add e to BST
	public void add(E e) {
		root = add(root, e);
	}

	// add a collection of element to BST
	public void add(Collection<E> coll) {
		for (E e : coll) {
			add(e);
		}
	}

	// recursive adding method
	private BNode<E> add(BNode<E> node, E e) {
		if (node == null) {
			return new BNode<>(e);
		}
		if (e.compareTo(node.getData()) < 0) {
			node.setLeft(add(node.getLeft(), e));
		} else if (e.compareTo(node.getData()) > 0) {
			node.setRight(add(node.getRight(), e));
		}
		return node;
	}

	// calculate the depth of a node in BST
	public int depth(E data) {
		return depth(root, data, 0);
	}

	// recursive method to calculate depth
	private int depth(BNode<E> node, E data, int depth) {
		if (node == null) {
			return -1;
		}
		if (data.equals(node.getData())) {
			return depth;
		} else if (data.compareTo(node.getData()) < 0) {
			return depth(node.getLeft(), data, depth + 1);
		} else {
			return depth(node.getRight(), data, depth + 1);
		}
	}

	// compute the height of BST
	public int height() {
		return height(root);
	}

	// recursive method to calculate height
	private int height(BNode<E> node) {
		if (node == null) {
			return -1;
		}
		int leftHeight = height(node.getLeft());
		int rightHeigh = height(node.getRight());
		return Math.max(leftHeight, rightHeigh) + 1;
	}

	// compute total nodes in BST
	public int size() {
		return size(root);
	}

	// recursive method to calculate total nodes
	private int size(BNode<E> node) {
		if (node == null) {
			return 0;
		}
		return size(node.getLeft()) + size(node.getRight()) + 1;
	}

	// check whether e is in BST
	public boolean contains(E e) {
		return contains(root, e);
	}

	// recursive method to check if e is in BST
	private boolean contains(BNode<E> node, E e) {
		if (node == null) {
			return false;
		}
		if (e.equals(node.getData())) {
			return true;
		} else if (e.compareTo(node.getData()) < 0) {
			return contains(node.getLeft(), e);
		} else {
			return contains(node.getRight(), e);
		}
	}

	// find the minimum e in BST
	public E findMin() {
		return findMin(root);
	}

	// recursive method to find minimum e in BST
	private E findMin(BNode<E> node) {
		if (node == null) {
			return null;
		}
		if (node.getLeft() == null) {
			return node.getData();
		} else {
			return findMin(node.getLeft());
		}
	}

	// find the maximum e in BST
	public E findMax() {
		return findMax(root);
	}

	// recursive method to find minimum e in BST
	private E findMax(BNode<E> node) {
		if (node == null) {
			return null;
		}
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return findMax(node.getRight());
		}
	}

	// Task 2
	// Display BST using inorder transverse
	public void inorder() {
		inorder(root);
	}

	private void inorder(BNode<E> node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.println(node.getData() + " ");
			inorder(node.getRight());
		}
	}

	// Display BST using preorder transverse
	public void preorder() {
		preorder(root);
	}

	private void preorder(BNode<E> node) {
		if (node != null) {
			System.out.println(node.getData() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}

	// Display BST using postorder transverse
	public void postorder() {
		postorder(root);
	}

	private void postorder(BNode<E> node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.println(node.getData() + " ");
		}
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(25);
		bst.add(15);
		bst.add(10);
		bst.add(22);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(50);
		bst.add(35);
		bst.add(70);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);
		System.out.println("------------------------");
		System.out.println("Print the BST in inorder transverse: ");
		bst.inorder();
		System.out.println("------------------------");
		System.out.println("Print the BST in preorder transverse: ");
		bst.preorder();
		System.out.println("------------------------");
		System.out.println("Print the BST in postorder transverse: ");
		bst.postorder();
		System.out.println("------------------------");
		System.out.println("Is the BST contain 4?: " + bst.contains(4));
		System.out.println("Is the BST contain 9?: " + bst.contains(9));
		System.out.println("------------------------");
		System.out.println("Max value: " + bst.findMax());
		System.out.println("Min value: " + bst.findMin());
		System.out.println("------------------------");
		System.out.println("Size of the tree: " + bst.size());
		System.err.println("Depth of 44: " + bst.depth(44));
		System.out.println("Height of the tree: " + bst.height());
		System.out.println("------------------------");
	}
}
