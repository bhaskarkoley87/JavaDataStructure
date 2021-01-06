package com.alds;

public class TestCode {
	

	public static void main(String[] args) {
		int[][] costs = {	{2,4,5,5,5}, 
							{2,5,6,5,7},
							{2,3,1,2,4},
							{1,2,1,3,2},
							{3,5,1,6,7},
							{4,3,1,2,5},
							{2,2,4,3,5},
							{2,5,6,5,7},
							{2,3,1,2,4},
							{1,2,1,3,2},
							{3,5,1,6,7},
							{4,3,1,2,5}};
		/*
		 * int[][] costs = {{3,1,2},
				{4,2,4},
				{3,2,6},
				{5,3,4},
				};
		 */
		System.out.println(minCostII(costs));
	}
	
	public static int minCostII(int[][] costs) {
	    if(costs==null || costs.length==0)
	        return 0;
	 
	    int preMin=0;
	    int preSecond=0;
	    int preIndex=-1; 
	 
	    for(int i=0; i<costs.length; i++){
	        int currMin=Integer.MAX_VALUE;
	        int currSecond = Integer.MAX_VALUE;
	        int currIndex = 0;
	        
	       // System.out.println("currMin : "+currMin+"  ||  currSecond : "+currSecond+ "  || currIndex : "+currIndex);
	 
	        for(int j=0; j<costs[0].length; j++){
	        	
	        	//System.out.println("1> preIndex : "+preIndex+"  ||  preSecond : "+preSecond+ "  || preMin : "+preMin);
	            if(preIndex==j){
	                costs[i][j] += preSecond;
	            }else{
	                costs[i][j] += preMin;
	            }
	 
	           // System.out.println("currMin : "+currMin+"  ||  costs[i][j] : "+costs[i][j]+ "  || currSecond : "+currSecond);
	            if(currMin>costs[i][j]){
	                currSecond = currMin;
	                currMin=costs[i][j];
	                currIndex = j;
	            } else if(currSecond>costs[i][j] ){
	                currSecond = costs[i][j];
	            }
	        }
	 
	        preMin=currMin;
	        preSecond=currSecond;
	        preIndex =currIndex;
	       // System.out.println("2> preIndex : "+preIndex+"  ||  preSecond : "+preSecond+ "  || preMin : "+preMin);
	    }
	 
	    int result = Integer.MAX_VALUE;
	    for(int j=0; j<costs.length; j++){
	    	for(int i=0; i<costs[j].length; i++){
	    		System.out.print(costs[j][i]+" , ");
	    	}
	    	System.out.println("");
	    }
	    
	    for(int j=0; j<costs[0].length; j++){
	        if(result>costs[costs.length-1][j]){
	            result = costs[costs.length-1][j];
	            System.out.println("result :: "+result);
	        }
	    }
	    return result;
	}

}


