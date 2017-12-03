package com.algo.sort;

public class QuickSortMiddlePivot {
	
	
	public static void sort(int start, int end, int[] arr){
		
		int x = start;
		int y = end;
		 int pivot = start + ((end -start)/2);
		 
		 while (x<=y){
			 
			 while(arr[x] < arr[pivot]){
				 x++;
			 }
			 
			 while(arr[y] > arr[pivot]){
				 y--;
			 }
			 
			 if(x<=y){
				 exchange(x,y, arr);
				 x++;
				 y--;
			 }
			 
		 }
		 
		 if(start<y){
			 sort(start, y, arr);
		 }
		 
		 if(x<end){
			 sort(x, end, arr);
		 }
		
	}
	
	private static void exchange(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {34, 3, 1, 23, 56, 4, 0};
		QuickSortMiddlePivot.sort(0, arr.length-1, arr);
		for(int z: arr){
			System.out.println(z);
		}

	}

}
