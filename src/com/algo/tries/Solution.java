package com.algo.tries;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
     static class Node{
         Map<Character, Node> charMap = new HashMap<Character, Node>();
         boolean isCompleteWord=false;
         int wordCount = 0;
        public Node add(Character c, boolean complete){
           Node node = null;
           if(charMap.containsKey(c)){
        	   node = charMap.get(c);
           }else{
               node = new Node();
               charMap.put(c, node);
           }
           if(complete){
        	  node.isCompleteWord = true; 
           }
           node.wordCount++;
           return node;
        }
        
        public void add(String contact){
	    	 char[] contactArr = contact.toCharArray();
	    	 Node current = this;
	         for(int i=0; i< contactArr.length; i++){
	         	if(i == contactArr.length - 1){
	         		current = current.add(contactArr[i], true);
	         	}else{
	         		current = current.add(contactArr[i], false);
	         	}
	         	
             }
        }
        
        public Node find(Character c){
        	if(charMap.containsKey(c)){
        		return charMap.get(c);
        	}
        	return null;
        }
        
        public int find(String contact){
        	char[] contactArr = contact.toCharArray();
        	Node curr = this;
            for(int i=0; i< contactArr.length; i++){
            	 curr = curr.find(contactArr[i]);
            	if(curr == null){
            		return 0;
            	}
            
            }
            return curr.wordCount;
        }
        
        
    }
    
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = new Node();
       
        for(int a0 = 0; a0 < n; a0++){
        	Node current = root;
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
               root.add(contact);
            }else if(op.equals("find")){
            	System.out.println(root.find(contact));
            }
        }
    }
}
