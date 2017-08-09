/* Binary Search
Searches for the binary
Date: 09/28/16
Author: Nada Al-Thawr
 */

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args)
	{ 
    	//call our oddtester method
		oddTester();

	}

/** 
	 * Searches the sorted array for the test int. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
public static int binarySearch( int[] sorted, int test )
{
		// start the recursion between first and last indices
	return binarySearch( sorted, test, 0, sorted.length -1 );
}

	/** 
	 * Searches the sorted array for the test number between loIndex and hiIndex, inclusive. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	private static int binarySearch( int[] sorted, int test, int loIndex, int hiIndex ){
		//we initialize our mid value to be in the middle exactly
		int mid = (loIndex+hiIndex)/2; 
		/**
		* if our hi is smaller than our low, return -1
		* because that means that the value we're looking for is not in the array
		**/
		if (hiIndex < loIndex) {
			return -1;
		}

		else { 

			//if our test value equals our sorted mid value
			if (test ==sorted[mid] ) 
			{
				//then return mid, because that's the value we're looking for
				return mid;
			}

			/**
			*if our test value is smaller than our mid
			*then run the binary search again while going on the left direction
			**/
			else if (test < sorted[mid]) {
				return binarySearch (sorted, test,loIndex, mid -1);
			}
			/**
			*if our test value is bigger than our mid
			*then run the binary search again while going on the right direction
			**/
			else {

				return binarySearch ( sorted, test,mid+1, hiIndex);
			}
		}
	}

	public static void oddTester()

	{
		//create a new array of the first 100 odd numbers
		int [] oddArray = new int [100];
		//initialize our odd number variable
		int oddNum;

    //for loop to find all the odd numbers
		for(int i=0; i < oddArray.length; i++){   
    	//set odd number as any multiple of 2+1 which returns an odd number and set it to the array             
			oddNum = (i*2) +1 ; 
			oddArray[i] = oddNum;
			
   	 //this was me testing my odd array
     //System.out.print(oddArray[i] + ", "); 

		}

	//create a new tester array
		int [] testerArray = new int[] {26,78,100,186,13,99,101,177};
		//run the loop through it and run the binary search on these values from our odd array
		for ( int i=0; i<testerArray.length; i++) {
			//run the binary search
			binarySearch (oddArray, testerArray[i]);

			
		//print the results
			System.out.println("searching for " + testerArray[i] + ": " + binarySearch(oddArray,testerArray[i]));

		}	
	}
}


