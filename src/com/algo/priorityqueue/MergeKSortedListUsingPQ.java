package com.algo.priorityqueue;

import com.algo.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListUsingPQ {
	
	public static ListNode mergeSortedList(List<ListNode> ls){
		
		if(ls == null || ls.size() == 0){
			return null;
		}
		
		Queue<ListNode> qu = new PriorityQueue<ListNode>(new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.value < o2.value){
					return -1;
				}else if(o1.value == o2.value){
					return 0;
				}else{
					return 1;
				}
				
				//return 1;
			}
			
		});
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		for(ListNode node : ls){
			qu.add(node);
		}
		
		while(!qu.isEmpty()){
			tail.next = qu.poll();
			tail = tail.next;
			if(tail.next != null){
				qu.add(tail.next);
			}
		}
		
		
		return head.next;
		
		
		
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
		
		ListNode resNode = MergeKSortedListUsingPQ.mergeSortedList(nodeList);
		
		while(resNode != null){
			System.out.println(resNode.value);
			resNode = resNode.next;
			
		}
		
		
		
		
	}

}
