package com.algo.logicalopr;

/**
 * Created by arumugv on 8/4/17.
 */
public class SumofTwoNbr {

    public static void main (String[] args){
        SumofTwoNbr.getSum(3, 3);
    }


    public static int getSum(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;

        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
