package com.algo.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arumugv on 5/3/17.
 */
class SpiralMatrix {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] values = firstLine.split(",");
        int rows = Integer.valueOf(values[0]);
        int columns = Integer.valueOf(values[1]);
        int[][] arr = new int[rows][columns];
        for(int i=0; i < rows; i++){
            String line = scanner.nextLine();
            String[] valus = line.split(",");
            for(int j=0; j < valus.length; j++){
                arr[i][j] = Integer.valueOf(valus[j]);
            }
        }

        List<Integer> sprialLst = SpiralMatrix.option1(rows, columns, arr);

        for (Integer x : sprialLst) {
            System.out.print( x + " ");
        }

    }

    public static List<Integer> option1(int rows, int columns, int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
        int left=0;
        int right=columns-1;
        int top = 0;
        int bottom = rows-1;

        while(result.size()<rows*columns){
            for(int j=left; j<=right; j++){
                result.add(matrix[top][j]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //prevent duplicate row
            if(bottom<top)
                break;

            for(int j=right; j>=left; j--){
                result.add(matrix[bottom][j]);
            }
            bottom--;

            // prevent duplicate column
            if(right<left)
                break;

            for(int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }



}
