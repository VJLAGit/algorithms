package com.algo.test;

import com.algo.sort.QuickSort;

public class QuickSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] list = GenerateRandomNbrs.generate(10, 10);
		System.out.print("Before :" );
		print(list);
		//StopWatch timer = new Stopwatch().start();
		QuickSort.sort(list);
		System.out.print("After :" );
		print(list);
	}
	
    static void print (Integer[] list){
    	System.out.print("[");
    	if(list.length >0){
    		System.out.print(list[0]);	
    	}
    	for(int j=1; j<list.length; j++){
    		System.out.print("," + list[j]);
    	}
    	System.out.println("]");
    }
	

}
