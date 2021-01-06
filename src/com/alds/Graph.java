package com.alds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	
	private Map<T, List<T>> graph = new HashMap<>();
	
	public void addVertex(T source) {
		graph.put(source, new LinkedList<T>());
	}
	
	public void addEdge(T source, T destination, boolean isBiDirectional) {
		
		if(!graph.containsKey(source))
			addVertex(source);
		
		if(!graph.containsKey(destination))
			addVertex(source);
		
		graph.get(source).add(destination);
		
		if(isBiDirectional)
			graph.get(destination).add(source);
	}
	
	public int getVertexCount() {
		return graph.keySet().size();
	}
	
	public int getEdgeCount(boolean isBiDirectional) {
		int count = 0; 
        for (T v : graph.keySet()) { 
            count += graph.get(v).size(); 
        } 
        if (isBiDirectional) { 
            count = count / 2; 
        } 
        
        return count;
	}
	
	public boolean hasVertex(T key) {
		if(graph.containsKey(key))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (T v : graph.keySet()) { 
            sb.append(v.toString() + ": "); 
            for (T w : graph.get(v)) { 
                sb.append(w.toString() + " "); 
            } 
            sb.append("\n"); 
        } 
  
        return (sb.toString()); 
		
	}

}
