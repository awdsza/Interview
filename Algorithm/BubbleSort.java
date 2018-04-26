package javatest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSort {

    @Test
    public void test() {
        int[] arr2 = {6,4,1,8,9,2,7,5,3};
        int[] sortedArr2 = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(bubbleSort(arr2),sortedArr2);
        
    }
    public int[] bubbleSort(int[] arr) {
        if (arr == null) return null;
        int[] result = arr;
       
        for(int i=0;i<=arr.length-1;i++){
        	for(int j=(i+1);j<arr.length;j++){
        		if(arr[i] > arr[j]){
        			int _tmp = arr[i];
        			arr[i] = arr[j];
        			arr[j] = _tmp;
        		}
        	}
        }
        return result;
    }
    
}
