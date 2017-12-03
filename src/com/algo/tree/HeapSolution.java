package com.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class HeapSolution {
	
	public static class PizzaCustomer implements Comparable<PizzaCustomer>{
		
		public int pizzaCookTime;
		
		public int arrivalTime;

		@Override
		public int compareTo(PizzaCustomer o) {
			// TODO Auto-generated method stub
			
			if (pizzaCookTime < o.pizzaCookTime){
				return -1;
			}else if(pizzaCookTime > o.pizzaCookTime){
				return 1;
			}
			return 0;
		}
		
	}
    
    public static class MinHeap<T extends Comparable<T>>{
         public List<T> items;
        
        public MinHeap(){
            items = new ArrayList<T>();
        }
        
        private void shitUp(){
            int k = items.size() - 1;
           // int p = k-1/2;
            while(k > 0){
                int p = (k-1)/2;
               // System.out.println("k is " + items.get(k)  + " p is" + items.get(p));
                if(items.get(k).compareTo(items.get(p)) < 0){
                    T temp = items.get(p);
                    items.set(p, items.get(k));
                    items.set(k, temp);
                    k = p;
                }else{
                    break;
                }
            }
        }
        
        private void shitDown(int index){
            int k = index;
            int l = 2*k + 1;
            
            while(l < items.size()){
            	
                int min = l;
                int r = l+1;
                if(r < items.size()){
                	
                    if(items.get(r).compareTo(items.get(l)) < 0){
                        min  = r;
                    }
                }
                
                if(items.get(k).compareTo(items.get(min)) > 0){
                    T temp = items.get(min);
                    items.set(min, items.get(k));
                    items.set(k, temp);
                    k = min;
                    l = 2*k + 1;
                }else{
                    break;
                }
            }
        }
        
        
        public void addElements(T element){
            items.add(element);
            shitUp();
        }
        
         public T deleteMinElements(){
             if(items.size() == 0){
                 return null;
             }
             
             if(items.size() == 1){
            	 return items.remove(0);
             }
            
             T hold = items.get(0);
             
            	 System.out.println(items);
            	 items.set(0, items.remove(items.size() - 1));
            	 System.out.println(items);
                 shitDown(0);
             
             return hold;
        }
         
         
         public T deleteElements(T element){
             if(items.size() == 0){
                 return null;
             }
             if(items.size() == 1){
            	 return items.remove(0);
             }
             for(int j = 0; j < items.size(); j++){
            	 if(items.get(j).compareTo(element) == 0){
            		 T hold = items.get(j);
            		 if(j < items.size() - 1){
            			 items.set(j, items.remove(items.size() - 1));
            		 }else{
            			 items.remove(j);
            		 }
            		
                     shitDown(j);
                     return hold;
            	 }
             }
            
           return null;
        }
         
        public T printMin(){
        	if(items.size() == 0){
        		return null;
        	}
        	//PriorityQueue<E>
        	return items.get(0);
        }
        
    }
    
    
    
    

    public static void main(String[] args) {
    	HeapSolution.MinHeap<Integer> heap = new MinHeap<Integer>();
    	heap.addElements(4);
    	System.out.println(heap.printMin());
    	heap.addElements(2);
    	heap.addElements(1);
    	System.out.println(heap.printMin());
    	System.out.println(heap.items);
    	heap.deleteMinElements();
    	System.out.println(heap.printMin());
    	System.out.println(heap.items);
    	heap.addElements(5);
    	heap.addElements(3);
    	heap.addElements(1);
    	heap.addElements(8);
    	System.out.println(heap.items);
    	heap.deleteElements(2);
    	System.out.println(heap.items);
    	
    	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}