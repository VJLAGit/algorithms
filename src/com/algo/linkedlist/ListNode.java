package com.algo.linkedlist;

public class ListNode {
	
	public int value;
	
	public ListNode next;
	
	public ListNode (int val){
		this.value = val;
	}
	
	public ListNode setnext(ListNode nxt){
		this.next = nxt;
		return this;
	}

}
