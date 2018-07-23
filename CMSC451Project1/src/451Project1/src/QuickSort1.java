//File name: QuickSort1.java
//Author: Paul Minniti
//Date: 18 June 2017
// Iterative APPROACH of the Quick Sort
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class QuickSort1 {
	
       public static void main(String[] args)
        {
           int[] arr = { 41, 99, 12, 33, 99, 10,1000,
        	199,200,11,22,33,44,55,66,788,89,9,32,34,
        	35,46,56,7,8,90,12,2,1,23,45,6,7,77,78,
        	98,90,97,43,23,25,23,334,55,443,45,456,
        	674,1235,454};
           
           System.out.println("Unorded List:");      
            for(int i=0;i < 50;i++){ 
            	System.out.println(arr[i]);
               }  

            System.out.println("Orded List:");
            QuickSort1(arr);
            for(int i=0;i < 50;i++){ 
            	System.out.println(arr[i]);
               }
            
        }
       
        public static void QuickSort1(int[] input)
        {
        	Stack<Integer> stack =new Stack<Integer>();
            int pivot;
            int pivotIndex = 0;
            int lefIn = pivotIndex + 1;
            int rigtIn = input.length - 1;

            stack.push(pivotIndex);
            stack.push(rigtIn);

            int leftIndexOfSubSet, rightIndexOfSubset;

            while (stack.size() > 0)
            {
                rightIndexOfSubset = (int)stack.pop();
                leftIndexOfSubSet = (int)stack.pop();

                lefIn = leftIndexOfSubSet + 1;
                pivotIndex = leftIndexOfSubSet;
                rigtIn = rightIndexOfSubset;

                pivot = input[pivotIndex];

                if (lefIn > rigtIn)
                    continue;

                while (lefIn < rigtIn)
                {
                    while ((lefIn <= rigtIn) && (input[lefIn] <= pivot))
                        lefIn++;
                    while ((lefIn <= rigtIn) && (input[rigtIn] >= pivot))
                        rigtIn--;
                    if (rigtIn >= lefIn)   	
                    	SwapElement(input, lefIn, rigtIn);
                }

                if (pivotIndex <= rigtIn)
                    if( input[pivotIndex] > input[rigtIn])
                        SwapElement(input, pivotIndex, rigtIn);
               
                if (leftIndexOfSubSet < rigtIn)
                {
                    stack.push(leftIndexOfSubSet);
                    stack.push(rigtIn - 1);
                }

                if(rightIndexOfSubset > rigtIn)
                {
                    stack.push(rigtIn + 1);
                    stack.push(rightIndexOfSubset);
                }
                
                }
            }

        private static void SwapElement(int[] arr, int lft, int rigt)
        {
            int tmp = arr[lft];
            arr[lft] = arr[rigt];
            arr[rigt] = tmp;
        }
 }
  