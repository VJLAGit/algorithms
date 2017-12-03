package com.algo.string;

import java.util.*;

public class PalindromePairs {
	
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Map<String, Integer> wordMap = new HashMap<String, Integer>();
    	
    	for(int x=0; x< words.length; x++){
    		wordMap.put(words[x], x);
    	}
    	
    	for(int x=0; x< words.length; x++){
    		String curr = words[x];
    		String revStr = reverse(curr);
    		
    		//to match blank one ex: {'a', ''}
    		if(isPlaindrome(curr) && wordMap.containsKey("")){
    			int f = wordMap.get("");
    			if(x != f){
    				//List<Integer> lst = new ArrayList<Integer>();
    				result.add(Arrays.asList(x, f));
    				result.add(Arrays.asList( f, x));
    			}
    		}
    		
    		//to map reverse string ex: ["bat", "tab"]
    		if(wordMap.containsKey(revStr)){
    			int f = wordMap.get(revStr);
    			if(x != f){
    				//List<Integer> lst = new ArrayList<Integer>();
    				result.add(Arrays.asList(x, f));
    			}
    				
    		}
    		
    		
    		for(int y = 1; y< curr.length(); y++){
    			//Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome
    			//ex : ["lls", "s"} => slls
    			if(isPlaindrome(curr.substring(0, y))){
    				String revRstStr = reverse(curr.substring(y));
    				if(wordMap.containsKey(revRstStr)){
    					int f = wordMap.get(revRstStr);
    	    			if(x != f){
    	    				//List<Integer> lst = new ArrayList<Integer>();
    	    				result.add(Arrays.asList(f, x));
    	    			}
    					
    					
    				}
    				
    			}
    			
    			//If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
    			//ex: 	["llsdbbd", "sll"] 
    			if(isPlaindrome(curr.substring(y))){
    				String revRstStr = reverse(curr.substring(0, y));
    				if(wordMap.containsKey(revRstStr)){
    					int f = wordMap.get(revRstStr);
    	    			if(x != f){
    	    				//List<Integer> lst = new ArrayList<Integer>();
    	    				result.add(Arrays.asList( x, f));
    	    			}
    					
    					
    				}
    				
    			}
    			
    			
    		}
    		
    		
    	}
        
    	
    	return result;
        
     }
	
	
	 public static String reverse(String str){
	        if(str == null || str.length() ==0){
	            return str;
	        }
	        
	        char[] arr = str.toCharArray();
	        
	       int i=0;
	       int j = arr.length-1;
	       
	       while(i <= j){
	           char temp = arr[j];
	           arr[j] = arr[i];
	           arr[i] = temp;
	           i++;
	           j--;
	       }
	       
	       return String.valueOf(arr);
	    }
	    
	    public static boolean isPlaindrome(String str){
	        int start = 0;
	        int end = str.length()-1;
	        
	        while(start <= end){
	           if(str.charAt(start) != str.charAt(end)){
	               return false;
	           } 
	            start++;
	            end--;
	            
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"bat", "tab", "cat"};
		String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
		PalindromePairs obj = new PalindromePairs();
		
		List<List<Integer>> rst = obj.palindromePairs(words);
		
		System.out.println(rst);
		
rst = obj.palindromePairs(words2);
		
		System.out.println(rst);

	}

}
