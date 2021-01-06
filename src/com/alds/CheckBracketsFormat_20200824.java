package com.alds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CheckBracketsFormat_20200824 {

	public static void main(String[] args) {
		System.out.println(checkFormat("((()"));
		
	}
	
	public static boolean checkFormat(String data) {
		char[] dataArray = data.toCharArray();
		
		Deque<String> brkQueqe = new ArrayDeque<>();
		 
		
		
		for(int x = 0; x < data.length(); x++) {
			if(!brkQueqe.isEmpty()) {
				String crtBrk = brkQueqe.peek();
				if(data.charAt(x) == ')' && crtBrk.equals("(")) {
					brkQueqe.pop();
				}else if(data.charAt(x) == ']' && crtBrk.equals("[")) {
					brkQueqe.remove();
				}else if(data.charAt(x) == '}' && crtBrk.equals("{")) {
					brkQueqe.remove();
				}else {
					brkQueqe.push(String.valueOf(data.charAt(x)));
				}
			}else {
				brkQueqe.push(String.valueOf(data.charAt(x)));
			}
			System.out.println(brkQueqe);
		}

		if(brkQueqe.isEmpty())
			return true;
		else
			return false;
	}
	
	public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        System.out.println(skillLevel);
        System.out.println(minDiff);
        List<Integer> alPaired = new ArrayList<>();
        int maxPrs = 0 ;
        for(int x = 0; x < skillLevel.size() - 1 ; x++){
            if(alPaired.contains(x)){
                break;
            }
            for(int y = x + 1; y < skillLevel.size(); y++){
                if(!alPaired.contains(y) && (diff(skillLevel.get(y),skillLevel.get(x)) == minDiff )){
                	System.out.println(skillLevel.get(y)  + "  :  "+ skillLevel.get(x) + "  =  " +diff(skillLevel.get(y),skillLevel.get(x)));
                  maxPrs = maxPrs + 1;
                  alPaired.add(y);
                  break;
                }
            }
        }

        return maxPrs;

    }

    public static int diff(Integer x, Integer y){
        if(x > y){
            return (x - y);
        }else{
            return (y - x);
        }
    }


}
