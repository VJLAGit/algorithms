package com.algo.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedRecursiveMS {
	
	
	public static ListNode divide(List<ListNode> ls, int start, int end){
		if(start == end){
			return ls.get(start);
		}
		if(start < end){
			int middle = start + ((end-start)/2);
			ListNode l1 = divide(ls, start, middle);
			ListNode l2 = divide(ls, middle+1, end);
			return merge(l1, l2);
			
		}
		
		return null;
		
	}
	
	
	
	public static ListNode merge(ListNode l1, ListNode l2){
		
		if(l1 == null){
			return l2;
		}
		
		if(l2 == null){
			return l1;
		}
		
		if(l1.value < l2.value){
			l1.next = merge(l1.next, l2);
			return l1;
		}else{
			l2.next = merge(l1, l2.next);
			return l2;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode nodeA = new ListNode(3).setnext(new ListNode(5).setnext(new ListNode(7)));
		ListNode nodeB = new ListNode(1).setnext(new ListNode(8).setnext(new ListNode(12)));
		ListNode nodec = new ListNode(0).setnext(new ListNode(1).setnext(new ListNode(2).setnext((new ListNode(4)))));
		
		List<ListNode> nodeList = new ArrayList<ListNode>();
		nodeList.add(nodeA);
		nodeList.add(nodeB);
		nodeList.add(nodec);
		
		ListNode resNode = MergeKSortedRecursiveMS.divide(nodeList, 0, nodeList.size()-1);
		
		while(resNode != null){
			System.out.println(resNode.value);
			resNode = resNode.next;
			
		}
		
		
		ListNode nodee = null;
		ListNode nodef = new ListNode(1);
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(nodee);
		list.add(nodef);
		
        resNode = MergeKSortedRecursiveMS.divide(list, 0, list.size()-1);
		
		while(resNode != null){
			System.out.println(resNode.value);
			resNode = resNode.next;
			
		}
		
	}

}
