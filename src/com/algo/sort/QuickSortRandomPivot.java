package com.algo.sort;

import java.util.Random;

public class QuickSortRandomPivot {
	
static int comparison = 0;

   private static int randomPivot(int low, int high){
	   
	   Random rand = new Random();
       int pivotIndex = low + rand.nextInt(high - low + 1);
	   
	   return pivotIndex;
   }
	
	private static <T extends Comparable<T>> int split(T[] list, int low, int high){
		int pivotIndex = randomPivot(low, high);
		int left = low;
		int right = high;
		T pivot = list[pivotIndex];
		
		
		while(true){
		
			while (left < pivotIndex){
				if (list[left].compareTo(pivot) <= 0){
					left++;
					comparison++;
				}else{
					break;
				}
			}
			
			while (right > pivotIndex){
				if(list[right].compareTo(pivot) >= 0){
					right--;
					comparison++;
				}else{
					break;
				}
				
			}
			
			if(left >= right){
				break;
			}
			
			//swap left n right elemnents
			T temp = list[left];
			list[left]= list[right];
			list[right]= temp;
				//advance left n rght
			left++; right--;
		
		}
		
		list[low] = list[left-1];
		list[left-1]= pivot;
		
		return left-1;
		
	}
	
	
	private static <T extends Comparable<T>> void sort(T[] list, int low, int high){
		
		if (high - low <= 0){
			return;
		}
		int splitPoint = split(list, low, high);
		sort(list, low, splitPoint-1);// sort the leftside of splitpoint
		sort(list, splitPoint+1, high);
		
	}
	
	public static <T extends Comparable<T>> void sort(T[] list){
			if (list.length <=1){
				return;
			}
			
		sort (list, 0, list.length-1);
		System.out.println("Number of comparison = " + comparison);
	}


}
