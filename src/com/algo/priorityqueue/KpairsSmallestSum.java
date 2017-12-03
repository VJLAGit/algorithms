package com.algo.priorityqueue;

import java.util.*;

/**
 * Created by arumugv on 7/15/17.
 */
public class KpairsSmallestSum {

    class Pair{
        int index;
        int[] num;
        long sum;

        Pair(int idx, int x, int y){
            index = idx;
            num = new int[]{x, y};
            sum = num[0] + num[1];

        }
    }

    public static void main(String[] args){
        KpairsSmallestSum obj = new KpairsSmallestSum();

        List<int[]>  res = obj.findkPairs(new int[] {1, 7,11}, new int[]{2, 4 , 6}, 3);
        for(int[] x : res){
            System.out.println(x[0] + " " + x[1]);
        }
        System.out.println(res);
    }

    public  List<int[]> findkPairs(int[] arr1, int[] arr2, int k){
        List<int[]> result = new ArrayList<int[]>();

        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return result;
        }

        PriorityQueue<Pair> queList = new PriorityQueue<Pair>(k, new Comparator<Pair>(){

            @Override
            public int compare(Pair p1, Pair p2) {
                return Long.compare(p1.sum, p2.sum);
            }
        });

        for(int i =0; i < arr1.length && i < k; i++){

            queList.offer(new Pair(0, arr1[i], arr2[0]));

        }

        while(!queList.isEmpty() && result.size() <= k){
            Pair p = queList.poll();
            result.add(p.num);
            if(p.index < arr2.length - 1){
                int nxt = p.index + 1;
                queList.offer(new Pair(nxt, p.num[0], arr2[nxt]));
            }
        }


        return result;

    }

}
