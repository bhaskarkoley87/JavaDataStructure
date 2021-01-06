package com.alds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.List;

public class GetLongestAbsolutePath_20200814 {
	
	public static TreeNode rootNode = new TreeNode();
	public static String strLongestPath = "";

	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.getTime());
		getPaths("dir\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2yext\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1");
		Date dt2 = new Date();
		System.out.println(dt2.getTime());
		
		System.out.println(lengthLongestPath("dir\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2yext\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1"));
		Date dt3 = new Date();
		System.out.println(dt3.getTime());
	}

	public static void getPaths(String data) {
		GetLongestAbsolutePath_20200814 obj = new GetLongestAbsolutePath_20200814();
		String[] strArray = data.split("\n");
		
		
		for (int x = 0; x < strArray.length; x++) {
			obj.addNodeToTree(strArray[x], rootNode);
		}

		preOrder(rootNode, "");
		
		System.out.println(strLongestPath.contains(".") ? strLongestPath.length() - 1 : strLongestPath.length());
	}
	
	/*
	 * Solution - 1 with Tree with O(2n) Time
	 */
	public void addNodeToTree(String data, TreeNode node) {
		//System.out.println(data);
		if(data.startsWith("\t")) {
			data = data.replaceFirst("\\t", "");
			int count = data.indexOf("\t");
			//System.out.println(count+"----->"+data);
			if(count < 0) {
				TreeNode nd = new TreeNode();
				nd.data = data;
				List<TreeNode> chldNode = node.childNode;
				chldNode.add(nd);
			}else {
				addNodeToTree(data, node.getChildNode());
			}
		}else {
			rootNode.data = data;
			
		}
	}	
	
	/*
	 * Solution - 1 with Tree with O(2n) Time
	 */
	public static void preOrder(TreeNode node, String path) {
		if(node != null) {			
			path += node.toString()+"/";
			if(node.childNode.size() <= 0) {
				if(strLongestPath.length() < path.length())
					strLongestPath = path;
			}
			for(TreeNode tnd : node.childNode) {
				preOrder(tnd, path);
			}
		}
	}
	
	/*
	 * Solution - 2 with Stack with O(n)
	 */
	public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            System.out.println(s+" | "+lev+" | "+stack.size());
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) 
            	maxLen = Math.max(maxLen, len-1);
            else
            	maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
	

}

class TreeNode{
	List<TreeNode> childNode = new ArrayList<TreeNode>();
	String data;
	
	public String toString() {
		return data;			
	}
	
	public TreeNode getChildNode() {
		return childNode.size() > 0 ? childNode.get(childNode.size()-1) : null;
	}
}
