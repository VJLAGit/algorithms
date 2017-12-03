package com.algo.sort;

public class MergeSort {
	
	
	public static void split(int start, int end, int[] arr, int[] tempArr){
		
		if(start < end){
			int middle = start + ((end -start)/2);
			split(start, middle, arr, tempArr);
			
			split(middle+1, end, arr, tempArr);
			
			merge(start, middle, end, arr, tempArr);
			
			
		}
		
	}
	
	public static void merge(int start, int middle, int end, int[] arr, int[] tempArr){
		
		for(int x= start; x<= end; x++){
			tempArr[x] = arr[x];
		}
		
		int i = start;
		int j = middle +1;
		//int k = start;
		
		while(i <= middle && j <= end){
			if(tempArr[i] <= tempArr[j]){
				arr[start] = tempArr[i];
				i++;
			}else{
				arr[start] = tempArr[j];
				j++;
			}
			start++;
			
		}
		
		while(i<= middle){
			arr[start] = tempArr[i];
			i++;
			start++;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {34, 3, 1, 23, 56, 4};
		int[] tempArr = new int[6];
		
		MergeSort.split(0, arr.length-1 , arr, tempArr);
		
		for(int z: arr){
			System.out.println(z);
		}
		
	}

}
