package sample.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class will remove duplicates in integer array 
 * @author Kiran Kumar
 * Run using JRE 7 and above.
 */

public class DeDup {
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
									20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
									13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	public static void main (String [] args){
		DeDup dd = new DeDup();
		
		// removed duplicates without using java util collection API
		int [] returnInts =  DeDup.removeDuplicates(dd.randomIntegers);
		System.out.println(" Without using collection interface  :");
		printArrays(returnInts);
				
		//removed duplicate using  hash set 
		returnInts =  DeDup.removeDuplicatesUsingHashset(dd.randomIntegers);
		System.out.println(" \n return values where order is not guarantee ");
		printArrays(returnInts);
		
		//removed duplicate using linked hash set and Array copy to retain order
		returnInts =  DeDup.removeDuplicatesUsingLinkedHashset(dd.randomIntegers);
		System.out.println(" \n return ordered values :");
		printArrays(returnInts);
		
		
		
		
	}
	
	/**
	 * printing to console
	 * @param printInts
	 */
	public static void printArrays(int [] printInts) {
		for (int i = 0; i < printInts.length;  i ++){
			System.out.print(printInts[i] + " ");
		}
	}
	/**
	 * This method removed duplicates using hash set 
	 * @param inputArray
	 * @return return array
	 */
	public  static int[] removeDuplicatesUsingHashset(int[] inputArray){
	    Set<Integer> originalSet = new HashSet<Integer>();
	    final int len = inputArray.length;
	    for(int i = 0; i < len; i++){
	    	originalSet.add(inputArray[i]);
	    }

	    int[] returnlist = new int[originalSet.size()];
	    int i = 0;
	    for (Iterator<Integer> it = originalSet.iterator(); it.hasNext();) {
	    	returnlist[i++] = it.next();
	    }
	    return returnlist;
	}
	
	/**
	 * This method remove duplicates using Linked hash set where order is  guarantee 
	 * @param integer array
	 * @return integer array by removing duplicates
	 */
	public static int[] removeDuplicatesUsingLinkedHashset(int[] inputArray) {
	    Set<Integer> initSet = new LinkedHashSet<Integer>();
	    int[] returnArray = new int[inputArray.length];
	    int i = 0;

	    for (int element : inputArray) {
	        if (initSet.add(element)) {
	        	returnArray[i++] = element;
	        }
	    }
	    return Arrays.copyOf(returnArray, i);
	}
	
	
	/**
	 * This method remove duplicates by checking each value array may be time consuming process
	 * @param inputArray
	 * @return integer array 
	 */
	public static int[] removeDuplicates(int[] inputArray) {

	    int end = inputArray.length;

	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (inputArray[i] == inputArray[j]) {                  
	                int shiftLeft = j;
	                for (int k = j+1; k < end; k++, shiftLeft++) {
	                	inputArray[shiftLeft] = inputArray[k];
	                }
	                end--;
	                j--;
	            }
	        }
	    }

	    int[] returnArray = new int[end];
	    for(int i = 0; i < end; i++){
	    	returnArray[i] = inputArray[i];
	    }
	    return returnArray;
	}
}
