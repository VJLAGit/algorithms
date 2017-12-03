package com.algo.depthfirst;

/**
 * Created by arumugv on 7/16/17.
 */
public class DecodeWays {

    /**
     * decode how many different combination of alphabet from input number
     * A- 1
     * B-2
     * ...
     * ..
     * Z= 26
     *
     * For example : 123
     * i) 1 2 3 = ABC
     * 2) 12 3 => LC
     * 3) 1 23 => AW
     * so total 3 ways of decoding
     * @param args
     */

    public static void main(String[] args){
        System.out.println(DecodeWays.numDecodings("125"));

    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
}
