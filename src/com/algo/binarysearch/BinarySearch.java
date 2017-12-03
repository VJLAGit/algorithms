package com.algo.binarysearch;

public class BinarySearch {
	
	public String search(final int input[], int search) {
        int low = 0;
        int high = input.length - 1;
        int mid;
        int timeComplexity = 0;
        while (low <= high) {
        	timeComplexity++;
            mid = low + ((high - low) / 2);
            if (input[mid] == search) {
                return "ArrayIndex = " + mid + ", timecomplexity = " + timeComplexity;
            } else if (input[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1 + ", timecomplexity = " + timeComplexity;
    }


	public static void main(String[] args) {
		 BinarySearch bSearch = new BinarySearch();
	        final int arr1[] = {1, 2, 4, 5, 7, 8,13};
	        System.out.println(bSearch.search(arr1, -1));
	        System.out.println(bSearch.search(arr1, 1));
	        System.out.println(bSearch.search(arr1, 8));
	        System.out.println(bSearch.search(arr1, 2));
	}

}
