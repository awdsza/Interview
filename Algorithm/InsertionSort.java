package javatest;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSort {

    @Test
    public void test() {
        int[] arr2 = {6,4,1,8,9,2,7,5,3};
        int[] sortedArr2 = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(insertionSort(arr2),sortedArr2);
    }
    public int[] insertionSort(int[] arr){
		if (arr == null) return null;
        int[] result = arr;
        int min;
        for(int i=0;i<result.length;i++){
        	min = i;
        	for(int j=i+1;j<result.length;j++){
        		if(result[min] > result[j] && min <= j){
        			int _tmp = result[j];
        			result[j] = result[min];
        			result[min] = _tmp;
        		}
        	}
        }
        return result;
	}
    
}