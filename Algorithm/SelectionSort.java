package javatest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSort {

    @Test
    public void test() {
        int[] arr2 = {6,4,1,8,9,2,7,5,3};
        int[] sortedArr2 = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(selectionSort(arr2),sortedArr2);
        
    }
    public int[] selectionSort(int[] arr){
		if (arr == null) return null;
        int[] result = arr;
        int min;
        for(int i=0;i<result.length;i++){
        	 min = i;
        	for(int j=i+1;j<result.length;j++){
        		min = result[min] > result[j] ? j : min;
        	}
        	int _tmp = result[min];
        	result[min] = result[i];
        	result[i] = _tmp;
        }
        return result;
	}
    
}