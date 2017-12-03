package com.algo.denarytree;

/**
 * Created by arumugv on 7/15/17.
 */
public class KthsmallestLexicographical {

    /**
     *
     * @param args
     *
     * Input:
        n: 13   k: 2

        Output:
        10

        Explanation:
        The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
     */

    public static void main(String[] args){
        System.out.println(KthsmallestLexicographical.findkThsmallestLexi(27, 13));


        System.out.println(KthsmallestLexicographical.findkThsmallestLexi(10000, 10000));



    }

    public static long findkThsmallestLexi(int n, int k){
        long currNode = 1;

        //move is 1 lesser than position
        //in above example  k -2 , to move from 1 to 10 (2nd smallest) it takes 1 step
       long j = k -1;
        //long tot = n;

        while(j > 0){

            long steps = calcSteps(n, currNode , currNode + 1);

            if(steps <= j){
                currNode++;
                j = j - steps;
            }else{
                currNode *= 10;
                j--;
            }

        }

    return currNode;
    }

    public static long calcSteps(long n, long node1, long node2){
        long steps = 0;
        while(node1 <= n){
            steps += Math.min(n+1, node2) - node1;
            node1 *= 10;
            node2 *= 10;
        }
        return steps;
    }
}
