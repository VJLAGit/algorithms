package com.algo.string;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(AddBinary.addBinary("11", "11"));
	}
	
	public static String addBinary(String a, String b) {
        StringBuffer bf = new StringBuffer();
        int x = a.length()-1;
        int y = b.length()-1;
        int carry =0;
        int sum = 0;
        while(x>=0 || y >= 0){
            sum = carry;
            if(x >=0){
                sum = sum + Character.getNumericValue(a.charAt(x--));
            }
            if(y >=0){
                sum = sum + Character.getNumericValue(b.charAt(y--));
            }
            
            bf.append((sum % 2));
            carry = sum / 2;
            
        }
        if(carry != 0){
            bf.append(carry);
        }
        return bf.reverse().toString();
        
    }

}
