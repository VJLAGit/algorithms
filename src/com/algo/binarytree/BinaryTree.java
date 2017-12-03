package com.algo.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	static class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	
	/*root
	 * left
	 * rightt
	 */
	
	void PreOrderRecursive(Node node){
		if(node != null){
			System.out.print(node.value + " ");
			PreOrderRecursive(node.left);
			PreOrderRecursive(node.right);
		}
		
	}
	
	/*
	 * left,
	 * root
	 * right
	 */
	void inOrderRecursive(Node node){
		if(node != null){
			inOrderRecursive(node.left);
			System.out.print(node.value + " ");
			inOrderRecursive(node.right);
		}
		
	}
	
	
	/*
	 * left,
	 * right
	 * root
	 */
	void postOrderRecursive(Node node){
		if(node != null){
			postOrderRecursive(node.left);
			
			postOrderRecursive(node.right);
			System.out.print(node.value + " ");
		}
		
	}
	
	void preOrderIterative(Node node){
		if(node == null){
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(true){
			while(node != null){
				System.out.print(node.value + " ");
				st.push(node);
				node = node.left;
			}
			if(st.empty()){
				break;
			}
			node = st.pop();
			node = node.right;
		}
	}
	
	void inOrderIterative(Node node){
		if(node == null){
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(true){
			while(node != null){
				st.push(node);
				node = node.left;
			}
			if(st.empty()){
				break;
			}
			node = st.pop();
			System.out.print(node.value + " ");
			
			node = node.right;
		}
	}
	

	
	public List<Integer> postorderTraversal(Node root) {
	    List<Integer> res = new ArrayList<Integer>();
	 
	    if(root==null) {
	        return res;
	    }
	 
	    Stack<Node> stack = new Stack<Node>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()) {
	        Node temp = stack.peek();
	        if((temp.left==null && temp.right==null)) {
	            Node pop = stack.pop();
	            res.add(pop.value);
	        }
	        else {
	            if(temp.right!=null) {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	 
	            if(temp.left!=null) {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	        }
	    }
	   System.out.println(res);
	    return res;
	}
	/*void postOrderIterative(Node node){
		if(node == null){
			return;
		}
		Stack<Node> st = new Stack<Node>();
		while(true){
			while(node != null){
				
				st.push(node);
				if(node.right != null){
					st.push(node.right);
				}
				node = node.left;
			}
			if(st.empty()){
				break;
			}
			node = st.pop();
			System.out.print(node.value + " ");
			node = null;
			
			
		}
	}*/
	
	void levelWithMarkerTraversal(Node node){
		if(node == null){
			return;
		}
		Queue<Node> nodeQ = new LinkedList<Node>();
		nodeQ.offer(node);
		nodeQ.offer(null);
		//nodeQ.add(new Node(-1));
		int height =0;
		int maxSum = node.value;
		int sum = 0;
		int maxLvl = 0;
		while(!nodeQ.isEmpty()){
			Node curr = nodeQ.poll();
			if(null == curr){
				height++;
				System.out.print("\n");
				if(sum >= maxSum){
					maxSum = sum;
					maxLvl = height;
				}
				sum = 0;
				if (!nodeQ.isEmpty()) {
					nodeQ.offer(null);
				}
				
			}else{
				System.out.print(curr.value +  " ");
				sum = sum + curr.value;
				if(curr.left != null){
					nodeQ.offer(curr.left);
				}
				if(curr.right != null){
					nodeQ.offer(curr.right);
				}
			}
			
		}
		System.out.print( "Height is -> " + height);
		System.out.print( "MaxlevlSum is -> " + maxSum);
		System.out.print( "maxLvl is -> " + maxLvl);
	}
	
	
	
  //using deque and for loop instead of adding null for separtion	
	void zigzagLevelOrderTraversal(Node node){
		if(node == null){
			return;
		}
		
		Deque<Node> dqCollection = new LinkedList<Node>();
		
		dqCollection.offerFirst(node);
		
		boolean zigzag = true;
		
		while(!dqCollection.isEmpty()){
			int size = dqCollection.size();
			for(int i=0; i < size; i++){
				Node curr = null;
				
				if(zigzag){
					 curr = dqCollection.pollLast();
					if(curr.left != null)
						dqCollection.offerFirst(curr.left);
					if(curr.right != null)
						dqCollection.offerFirst(curr.right);
				}else{
					curr = dqCollection.pollFirst();
					if(curr.right != null)
						dqCollection.offerLast(curr.right);
					if(curr.left != null)
						dqCollection.offerLast(curr.left);
					
				}
				System.out.print(" " + curr.value);
			}
		    if(zigzag )
		    	zigzag = false;
		    else
		    	zigzag = true;
		}
		
	}
	
	public static void main(String[] args){
		Node root = new Node(4);
		
		Node firstChild = new Node(5);
		Node secondChild = new Node(9);
		
		root.left = firstChild;
		
		root.right = secondChild;
			
		firstChild.left = new Node(13);
		firstChild.right = new Node(19);
		
		Node lvl31 = new Node(43);
		secondChild.left =lvl31;
		secondChild.right = new Node(76);
		
		lvl31.left = new Node(88);
		lvl31.right = new Node(56);
		
		
		BinaryTree tree = new BinaryTree();
		System.out.println("\n");
		System.out.println("pre order  ");
		System.out.println("-----");
		tree.PreOrderRecursive(root);
		System.out.println("\n");
		System.out.println("In order  ");
		System.out.println("-----");
		tree.inOrderRecursive(root);
		System.out.println("\n");
		System.out.println("Post order  ");
		System.out.println("-----");
		tree.postOrderRecursive(root);
		System.out.println("\n");
		System.out.println("Pre order Iterative ");
		System.out.println("-----");
		tree.preOrderIterative(root);
		System.out.println("\n");
		System.out.println("In order Iterative ");
		System.out.println("-----");
		tree.inOrderIterative(root);
		
		System.out.println("\n");
		System.out.println("Post order Iterative ");
		System.out.println("-----");
		//tree.postorderTraversal(root);
		//tree.postorderTraversal(root);
		
		System.out.println("\n");
		System.out.println("Level order Iterative ");
		System.out.println("-----");
		tree.levelWithMarkerTraversal(root);
		
		System.out.println("\n");
		System.out.println("Level order zig zag  ");
		System.out.println("-----");
		tree.zigzagLevelOrderTraversal(root);
		
		
		//tree.postorderTraversal(root);
	}

}
