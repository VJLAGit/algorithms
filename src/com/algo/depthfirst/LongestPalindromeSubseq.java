package com.algo.depthfirst;

/**
 * Created by arumugv on 7/15/17.
 */
public class LongestPalindromeSubseq {


    public static void main(String[] args){
        LongestPalindromeSubseq obj = new LongestPalindromeSubseq();
       /* System.out.println(obj.longestPalindromeSubseq("a"));
        System.out.println(obj.longestPalindromeSubseq("aa"));
        System.out.println(obj.longestPalindromeSubseq("bab"));
*/
        System.out.println(obj.longestPalindromeSubseq("bbbab"));
    }


    public int longestPalindromeSubseq(String s) {
        int[][] matchMatrix = new int[s.length()][s.length()];

        for(int i = s.length()-1; i >=0; i--){
            matchMatrix[i][i] = 1;
            for(int j = i +1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    matchMatrix[i][j] = matchMatrix[i + 1][j-1] + 2;
                }else{
                    matchMatrix[i][j] = Math.max(matchMatrix[i][j-1], matchMatrix[i+1][j]);
                }
            }

        }

        return matchMatrix[0][s.length()-1];

    }
}
