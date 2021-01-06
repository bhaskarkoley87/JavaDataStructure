package com.alds;
/*
 * Algorithm :
 * -----------------------
 * 1. Create a variable to store the max no. of classes required.
 * 2. Create a blank array for max no. classes required with the size of total time intervals
 * 3. Run the loop from 0 to no. of time intervals provided.
 * 4. Run the another internal loop till the blank class room found for the current interval.
 * 5. Check the last end time present in the classRoom array, if it is less then the start time of new class interval, than replace the end time with the end time of current class
 * 	  interval, and than break the internal loop. 
 * 6. Other wise go to the next new class room and enter the end time of current class interval, and than break the internal loop. And increase the maxClass variable with 1.
 * 7. When the all the loop ends. Print the maxClass variable.
 * 
 */
public class FindTheRequiredNoOfClassRooms_20200818 {

	public static void main(String[] args) {
		Class times[] = {new Class(30, 75), new Class(0, 60), new Class(60, 150)};
		System.out.println(findTheMaxClassRooms(times));
	}
	
	public static int findTheMaxClassRooms(Class times[]) {
		int maxClass = 0;
		int classRoomArray[] = new int[times.length];
		for(int i = 0; i < times.length ; i++) {
			for(int y = 0; y < classRoomArray.length; y++) {
				if(classRoomArray[y] != 0 && classRoomArray[y] < times[i].startTime) {
					classRoomArray[y] = times[i].endTime;
					break;
				}else {
					classRoomArray[y] = times[i].endTime;
					maxClass++;
					break;
				}
			}
		}
		return maxClass;
	}

}

class Class{
	public int startTime;
	public int endTime;
	
	public Class(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
}
