package com.algo.hashtable;

import java.util.HashMap;
import java.util.*;

public class GroupShiftedStrings {
	
	public List<List<String>> groupStrings(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    //Arrays.sort(strs);    	
		for (String s : strs) {
			String key = "";
			for (int i = 1; i < s.length(); i++){
				int c = s.charAt(i) - s.charAt(i-1);
				c = c + 26;
				c = c % 26 ;
				String ft = String.format("%2d", c);
				key += String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26);//Difference from the previous char.
			}
			if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(s);    		
		} 
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GroupShiftedStrings obj = new GroupShiftedStrings();
		String[] st = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(obj.groupStrings(st));

	}

}
