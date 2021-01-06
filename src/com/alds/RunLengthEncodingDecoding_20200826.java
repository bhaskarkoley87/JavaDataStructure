package com.alds;

public class RunLengthEncodingDecoding_20200826 {

	public static void main(String[] args) {
		String encodedMessage = encode("AAAABBBCCDAA");
		System.out.println(encodedMessage);		
		System.out.println(decode(encodedMessage));
	}
	
	public static String encode(String message) {
		StringBuffer encodedMessage = new StringBuffer();
		String crntChar = "";
		int noOfRep = 0;
		for(int i = 0; i < message.length(); i++) {
			if(crntChar.equals(String.valueOf(message.charAt(i)))) {
				noOfRep = noOfRep + 1;
			}else {				
				if(crntChar.length() > 0) {
					encodedMessage.append(noOfRep+crntChar);
					noOfRep = 0;
				}
				crntChar = String.valueOf(message.charAt(i));
				noOfRep = noOfRep + 1;
			}
		}
		encodedMessage.append(noOfRep+crntChar);
		return encodedMessage.toString();
	}
	
	public static String decode(String message) {
		StringBuffer encodedMessage = new StringBuffer();
		String crntChar = "";
		int noOfRep = 0;
		for(int i = 0; i < message.length() - 1; i = i + 2) {
			noOfRep = Integer.parseInt(String.valueOf(message.charAt(i)));
			crntChar = String.valueOf(message.charAt(i + 1));
			for(int x = 0; x < noOfRep; x++) {
				encodedMessage.append(crntChar);
			}
		}		
		return encodedMessage.toString();
	}

}
