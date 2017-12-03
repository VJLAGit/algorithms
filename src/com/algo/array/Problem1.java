package com.algo.array;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

import java.util.*;

/**
 * map  =  [['o' 'o' 'o' 'o'],
 *          ['o' 'o' 'o' 'o'],
 *          ['o' 'u' 'o' 'u'],
 *          ['o' 'o' 'u' 'o']]
 *
 * result: [['3' '2' '3' '2'],
 *          ['2' '1' '2' '1'],
 *          ['1' 'u' '1' 'u'],
 *          ['2' '1' 'u' '1']]
 *
 *
 * 00 = O
 *
 * queue - 00
 *
 * , 10 02, 11
 *
 *
 *
 */




public class Problem1 {
    public static void main(String[] args) {
        int[][] map = {{0,  0,  0,  0},
                {0,  0,  0,  0},
                {0, -1,  0, -1},
                {0,  0, -1,  0}};
        //int[][] result = distance(map);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                String start = i + "" + j;
                int[] startArr = new int[2];
                startArr[0] = i;
                startArr[1] = j;
                Queue<int[]> nodes = new LinkedList<int[]>();
                nodes.add(startArr);
                Set<int[]> visited = new HashSet<int[]>();
                visited.add(startArr);
                Map<int[], int[]> parent = new HashMap<int[], int[]>();
                int[] dest = null;
                while(!nodes.isEmpty()){
                    int[] curr = nodes.poll();
                    List<int[]> edges = Problem1.getNeighbours(curr, map.length, map[0].length);
                    for(int[] n :  edges){
                        if(visited.contains(n)){
                            continue;
                        }else{
                            visited.add(n);
                        }
                        parent.put(n, curr);
                        if(map[n[0]][n[1]] == -1){
                            dest = n;
                            break;
                        }else{
                            nodes.add(n);
                        }

                    }

                    if(dest != null){
                        break;
                    }

                }

                int hop = 0;
                int[] currParent = dest;
                while(currParent != startArr){
                    hop++;
                    currParent = parent.get(currParent);

                }
                System.out.println(i + "" + j + "-> " + hop);
            }
            System.out.println();
        }
    }


    public static List<int[]> getNeighbours(int[] node, int xSize, int ySize){
        int x= node[0];

        int y = node[1];

        List<int[]> edges = new ArrayList<int[]>();

        if (x+1 < xSize ){
            int arr[] = new int[2];
            arr[0] = x+1;
            arr[1] = y;
            edges.add(arr);
        }

        if (x-1 >= 0 && x-1 <  xSize){
            int arr1[] = new int[2];
            arr1[0] = x-1;
            arr1[1] = y;
            edges.add(arr1);
        }


        if (y+1 < ySize ){
            int arr2[] = new int[2];
            arr2[0] = x;
            arr2[1] = y+1;
            edges.add(arr2);
        }

        if (y-1 >= 0 && y-1 <  ySize){
            int arr3[] = new int[2];
            arr3[0] = x;
            arr3[1] = y-1;
            edges.add(arr3);
        }

        return edges;

    }

}
