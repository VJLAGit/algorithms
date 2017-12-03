package com.algo.array;

public class MaximumSquare {
	
	public static int maxSquare(char[][] matrix){
		int result =0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] maxMatrix = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(matrix[i-1][j-1] == '1'){
					maxMatrix[i][j] = Math.min(Math.min(maxMatrix[i-1][j-1], maxMatrix[i-1][j]), maxMatrix[i][j-1])+1;
				  result = Math.max(maxMatrix[i][j], result);
				}
				
			}
			
		}
		
		
		
		return result*result;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] mat = {
				{'1','1','1'},
				{'1','1', '1'},
				{'1','1', '1'}
		};
		
		System.out.println(MaximumSquare.maxSquare(mat));

	}

}
