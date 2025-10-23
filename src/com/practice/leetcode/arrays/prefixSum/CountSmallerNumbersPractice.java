package com.practice.leetcode.arrays.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersPractice {
	
	public static void main(String[] args) {
		CountSmallerNumbersPractice count = new CountSmallerNumbersPractice();
		
		System.out.println(Arrays.toString(count.countSmallerNumbers(new int[] {5,2,6,1})));
	}
	
	
	private int[] countSmallerNumbers(int arr[]) {
		
		Pair[]pArr = new Pair[arr.length];
		int count[] = new int[arr.length];
		
		int i=0;
		for (int val : arr) {
			pArr[i] = new Pair(val, i);
			i++;
		}
		
		mergeSort(pArr, 0 , arr.length-1, count);
		
		return count;
		
	}
	
	
	
	private void mergeSort(Pair[] pArr, int l, int r, int count[]) {
		 if (l >=r) {
			 return;
		 }
		 
		 int mid = l+(r-l)/2;
		 
		 mergeSort(pArr, l, mid, count);
		 mergeSort(pArr, mid+1, r, count);
		 
		 merge(pArr, l, mid, r, count);
		
	}



	private void merge(Pair[] pArr, int l, int mid, int r, int[] count) {
		
		List<Pair> temp = new ArrayList<>();
		
		int i = l;
		int j = mid+1;
		int k = l;
		
		int rightCount =0;
		
		while (i <=mid && j <=r) {
			if (pArr[j].value < pArr[i].value) {
				rightCount++;
				temp.add(pArr[j]);
				j++;
			} else {
				temp.add(pArr[i]);
				count[pArr[i].index]+=rightCount;
				i++;
			}
		}
		
		while (i <=mid) {
			temp.add(pArr[i]);
			count[pArr[i].index]+=rightCount;
			i++;
		}
		
		while (j<=r) {
			temp.add(pArr[j]);
			j++;
		}
		
		for (k=l;k<=r;k++) {
			pArr[k]=temp.get(k-l);
		}
		
	}



	private class Pair{
		int value;
		int index;
		
		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
