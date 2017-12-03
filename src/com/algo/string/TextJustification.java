package com.algo.string;

import java.util.*;
public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultLst = new ArrayList<String>();
        int start = 0;
        while(start < words.length){
        	int end = start;
        	int count = 0;
        	while(end < words.length){
        		if(count + words[end].length() + 1 > maxWidth){
        			break;
        		}
        		count = count + words[end].length() + 1;
        		end++;
        	}
        	StringBuilder builder = new StringBuilder();
        	int noOfSpaces = end - start -1;
        	
        	if(end == words.length || noOfSpaces ==0){
        		builder.append(words[start]);
        		for(int k = start+1;k<end; k++){
        			builder.append(" ");
        			builder.append(words[k]);
        		}
        		for(int z=builder.length(); z < maxWidth; z++){
        			builder.append(" ");
        		}
        		
        	}else{
        		int spaces = maxWidth - count;
        		int spaceSize = spaces/noOfSpaces;
        		int remSpaces = spaces % noOfSpaces;
        		
        		builder.append(words[start]);
        		for(int k = start+1;k<end; k++){
        			for(int z=spaceSize; z>0; z--){
        				builder.append(" ");
        			}
        			if(remSpaces > 0){
        				builder.append(" ");
        				remSpaces--;
        			}
        			builder.append(" ");
        			builder.append(words[k]);
        		}
        		
        	}
        	resultLst.add(builder.toString());
        	start = end;
        }
        
        return resultLst;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		TextJustification obj = new TextJustification();
		List<String> res = obj.fullJustify(words, 16);
		for(String str : res){
			System.out.println(str);
		}
	}

}
