package com.algo.depthfirst;

import java.util.*;

/**
 * Created by arumugv on 7/15/17.
 */

/**
 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].


 */
public class WordBreak2 {

    public static void main(String[] args){
        String s = "catsanddog";
        Set<String> wordDict = new HashSet();
        wordDict.add("sam");
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        System.out.println(DFS(s, wordDict, new HashMap<String, LinkedList<String>>()));
    }


    // DFS function returns an array including all substrings derived from s.
    public static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
