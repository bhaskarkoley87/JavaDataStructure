package com.alds;

import java.util.ArrayList;
import java.util.List;

public class JustifyTest_20200825 {

	public static void main(String[] args) {
		String[] data = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
		justifyText(data, 20);
		
		//["My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."]
		//		20	
	}
	
	public static void justifyText(String[] data, int k) {			
		List<Integer> listExtraSpace = new ArrayList<Integer>();
		List<String> lines = new ArrayList<String>();
		List<String> finelLines = new ArrayList<String>();
		String currentLine = "";
		for(int i = 0; i < data.length; i++) {			
			int oldlng = currentLine.length();
			currentLine = currentLine.length() > 0 ? currentLine + " " +data[i] : data[i];
			if(currentLine.length() > k) {
				currentLine = currentLine.substring(0, oldlng);					
				listExtraSpace.add(k - currentLine.length());
				lines.add(currentLine);
				currentLine =  data[i];
			}
			
		}		
		
		lines.add(currentLine.trim());
		listExtraSpace.add(k - currentLine.trim().length());
		System.out.println(listExtraSpace);
		int crntLine = 0;
		for(String s : lines) {
			String[] crntLn = s.split(" ");
			
			int cntSp = listExtraSpace.get(crntLine);
			int noOfSpace = 0;
			int noOfLoops = (crntLn.length-1);
			int noOfRemainingLoop = 0;
			int noOfRemainingSpace = 1;
			if(crntLn.length <= 1){
                noOfLoops = 1;
                noOfSpace = cntSp;
            }else if(cntSp < (crntLn.length-1)) {
				noOfLoops = cntSp;
				noOfSpace = cntSp == 0 ? 0 : 1;
			}else {
				noOfRemainingLoop = cntSp % (crntLn.length-1);
				noOfSpace = cntSp / (crntLn.length-1);				
			}
			
			
			
			String strSpace = "";
			for(int y = 0; y < noOfSpace; y++)
				strSpace = strSpace + " ";
			
			if(crntLine == lines.size() - 1) {
				
				for(int y = 0; y < cntSp; y++)
					strSpace = strSpace + " ";
				
				finelLines.add(s+strSpace);
				break;
			}
			
			for(int i = 0; i < noOfLoops; i++) {				
				if(cntSp > 0) {
					crntLn[i] = crntLn[i] + strSpace;						
				}				
			}
			
			for(int i = 0; i < noOfRemainingLoop; i++) {				
				if(cntSp > 0) {
					crntLn[i] = crntLn[i] + " ";					
				}				
			}
			crntLine++;
			String strJoinString = "";
			for(String s1 : crntLn) {
				strJoinString = strJoinString.length() > 0 ? strJoinString + " " + s1 : s1;
			}
			finelLines.add(strJoinString);
		}
		
		System.out.println(finelLines);
		//System.out.println(lines);
		//System.out.println(listExtraSpace);
	}

}
