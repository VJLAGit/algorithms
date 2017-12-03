package com.algo.tries;


import java.util.*;

public class WordSearch2 {
	
   public List<String> findWords(char[][] board, String[] words) {
	   List<String> resList = new ArrayList<String>();
	   int m = board.length;
	   int n = board[0].length;
	   TrieNode root = buildTrie(words);
	   for(int i=0; i<m; i++){
		   for(int j=0; j<n; j++){
			   search(board, root, i, j, resList);
		   }
	   }
	   
	   
	   return resList;
        
    }
   
   
   public void search(char[][] board, TrieNode node, int x, int y, List<String> resList){
	   char c = board[x][y];
	   if(c == '?' || node.child[c-'a'] == null){
		   return;
	   }
	   
	   TrieNode curr = node.child[c-'a'];
	   if(curr.word != null){
		   resList.add(curr.word);
		   curr.word = null;
	   }
	   board[x][y] = '?';
	   if(x > 0 )
		   search(board, curr, x-1, y, resList);
	   if(y > 0)
		   search(board, curr, x, y-1, resList);
	   if(x < board.length -1 )
		   search(board, curr, x+1, y, resList);
	   if(y < board[0].length -1 )
		   search(board, curr, x, y+1, resList);
	   
	   board[x][y] = c;
   }
   
   public TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String word : words){
			TrieNode curr = root;
			for(char c: word.toCharArray()){
				if(curr.child[c-'a'] == null){
					curr.child[c-'a'] = new TrieNode();
					
				}
				curr = curr.child[c-'a'];
			}
			curr.word = word;
			
		}
		
		return root;
		
	}
	
	class TrieNode{
		TrieNode[] child = new TrieNode[26];
		String word;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch2 obj = new WordSearch2();
		/*char[][] mat = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
				
		};
		String[] words = {"oath","pea","eat","rain"};
		List<String> res = obj.findWords(mat,  words);
		System.out.print(res);
		*/
		char[][] mat2 = {
				{'a', 'b'},
				{'c','d'}
				
		};
		String[] words2 = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
		List<String> res2 = obj.findWords(mat2,  words2);
		System.out.print(res2);
	}
	
	
	

}
