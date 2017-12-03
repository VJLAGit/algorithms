package com.algo.test;

import java.util.Random;

public class GenerateRandomNbrs {
	
	public static Integer[] generate(int count, int range){
		Random randomGenerator = new Random();
		Integer[] list = new Integer[count];
	    for (int idx = 0; idx < count; ++idx){
	      int randomInt = randomGenerator.nextInt(range);
	      //log("Generated : " + randomInt);
	      list[idx] = randomInt;
	    }
	   
	    return list;
	}
	
	public static void main (String[] args){
		 System.out.print(bit(0));
	}

	
	
	static int bit(int n)
	{
	return ( + (n|~n));
	}
}
