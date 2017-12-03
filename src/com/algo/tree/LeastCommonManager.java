//<editor-fold desc="Description">
/*
package com.algo.tree;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;

public class Solution
{ 
	public static class EmployeeHierNode{
	    private Org_Employee  self;
	    private EmployeeHierNode parent;
	    private int level;
	    
	    public EmployeeHierNode(Org_Employee self, EmployeeHierNode parent, int level){
	        this.self = self;
	        this.parent = parent;
	        this.level = level;
	    }
	    
	    public Org_Employee getSelf(){
	        return self;
	    }
	    
	    public EmployeeHierNode getParent(){
	        return parent;
	    }
	    
	    public int getLevel(){
	        return level;
	    }
	}
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN "null" IF THERE IS NO CLOSEST COMMON MANAGER OR THE GIVEN EMPLOYEES ARE NOT THE PART OF THE COMPANY
	public Org_Employee closestCommonManager(Org_Employee ceo, Org_Employee employee1, Org_Employee employee2)
	{
		// WRITE YOUR CODE HERE
	    EmployeeHierNode  firstEmployee = null;
	    EmployeeHierNode secondEmployee = null;
	    
	    int level = 0;
	    Stack<EmployeeHierNode> stack = new Stack<EmployeeHierNode>();
	    stack.add(new EmployeeHierNode(ceo, null, level));
	    do{
	        EmployeeHierNode parent = stack.pop();
	        level++;
	        for(Org_Employee employee : parent.getSelf().getReports() ){
	            EmployeeHierNode node = new EmployeeHierNode(employee, parent, level);
	            stack.add(node);
	            if(node.getSelf().getId() == employee1.getId()){
	                firstEmployee = node;
	            }else if(node.getSelf().getId() == employee2.getId()){
	                secondEmployee = node;
	            }
	            
	        }
	        
	    }while(!stack.isEmpty());
	    
	    
	    if(firstEmployee.getSelf().getId() == secondEmployee.getParent().getSelf().getId()){
	        return firstEmployee.getSelf();
	    }else if(secondEmployee.getSelf().getId() == firstEmployee.getParent().getSelf().getId()){
	        return secondEmployee.getSelf();
	    }
	    
	    
	    EmployeeHierNode firstParent = firstEmployee.getParent();
	    EmployeeHierNode secondParent = secondEmployee.getParent();
	    
	    while(firstParent.getSelf().getId() != secondParent.getSelf().getId()){
	        
	        if(firstParent.getLevel() > secondParent.getLevel()){
	            firstParent = firstParent.getParent();
	        }else{
	            secondParent = secondParent.getParent();
	        }
	        
	    }
	    
	    return firstParent.getSelf();
		
		
	}
	// METHOD SIGNATURE ENDS
}
//</editor-fold>
*/