package com.learning.DS;
import java.util.HashSet;
import java.util.Set;

public class BinarySearch {

	private Node root;

	private static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public BinarySearch() {
		root = null;
	}

	public void insert(int val) {
		root = insert(root, val);
	}

	private Node insert(Node node, int val) {
		if (node == null) {
			// root node
			return new Node(val);
		}
		if (val < node.val) {
			node.left = insert(node.left, val);
		}
		if (val > node.val) {
			node.right = insert(node.right, val);
		}
		return node;
	}
	
	public boolean findPairWithSum(int sum) {
		Set<Integer> set = new HashSet<>();
		return findPairWithSum(root,sum, set);
	}
	
	

	private boolean findPairWithSum(Node node, int sum, Set<Integer> set) {
		if(node == null) {
			return false;
		}
		if(findPairWithSum(node.left, sum, set)) {
			return true;
		}
		if(set.contains(sum - node.val)) {
			System.out.println("Pair found :: "+ (sum - node.val) + " , "+ node.val);
			return true;
		}
		set.add(node.val);
		return findPairWithSum(node.right, sum, set);
	}

	public static void main(String[] args) {
		BinarySearch tree = new BinarySearch();
		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		tree.insert(1);
		tree.insert(6);
		tree.insert(14);
		tree.insert(4);
		tree.insert(7);
		tree.insert(13);
		
		int sum1 = 14;
		
		if(!tree.findPairWithSum(sum1)) {
			System.out.println("Nodes not found for sum " + sum1);
		}
		
		int sum2 = 20;
		
		if(!tree.findPairWithSum(sum2)) {
			System.out.println("Nodes not found for sum " + sum1);
		}
	}
}
