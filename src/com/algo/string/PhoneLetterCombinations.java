package com.algo.string;

import java.util.LinkedList;
import java.util.List;

public class PhoneLetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(	PhoneLetterCombinations.letterCombinations("22"));
	//System.out.println(	PhoneLetterCombinations.letterCombinations2("2"));
		

	}
	
    public static List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
    return ans;
  }
    
    public static List<String> letterCombinations2(String digits) {
    	/*if(digits == null || digits.length() == 0){
            return   new LinkedList<String>();
         }*/
         
          LinkedList<String> res = new LinkedList<String>();
          String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
          res.add("");
          for(int i =0; i < digits.length(); i++){
              int x = Character.getNumericValue(digits.charAt(i));
              while(res.peek().length() == i){
                  String st = res.remove();
                  for (char ch : mapping[i].toCharArray()){
                      res.add(st + ch);
                  }
              }
          }
          
          return res;
  }

}
