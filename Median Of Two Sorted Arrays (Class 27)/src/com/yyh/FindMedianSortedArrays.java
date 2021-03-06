package com.yyh;
/*
 * Given two sorted arrays of integers in ascending order, find the median value.
 */

public class FindMedianSortedArrays {
	
	public static void main(String[] args){
		FindMedianSortedArrays my = new FindMedianSortedArrays();
		int[] nums1 = new int[]{};
		int[] nums2 = new int[]{3, 4};
		System.out.println(my.findMedianSortedArrays(nums1, nums2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if (len % 2 == 0){
			int[] res = new int[2];
			findEven(nums1, 0, nums2, 0, len / 2, res);
			return (res[0] + res[1] + 0.0) / 2;
		} else {
			return findOdd(nums1, 0, nums2, 0, len / 2 + 1) + 0.0;
		}
	}
	
	private int findOdd(int[] nums1, int i, int[] nums2, int j, int t){
		if (i >= nums1.length){
			return nums2[j + t - 1];
		}
		if (j >= nums2.length){
			return nums1[i + t - 1];
		}
		if (t == 1){
			return Math.min(nums1[i], nums2[j]);
		}
		int mid1 = i + t / 2 - 1;
		int mid2 = j + t / 2 - 1;
		int val1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
		int val2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
		return val1 <= val2 ? findOdd(nums1, mid1 + 1, nums2, j, t - t / 2): findOdd(nums1, i, nums2, mid2 + 1, t - t / 2);
	}
	
	private void findEven(int[] nums1, int i, int[] nums2, int j, int t, int[] res){
		if (i >= nums1.length){
			res[0] = nums2[j + t - 1];
			res[1] = nums2[j + t];
			return;
		}
		if (j >= nums2.length){
			res[0] = nums1[i + t - 1];
			res[1] = nums1[i + t];
			return;
		}
		if (t == 1){
			if (nums1[i] <= nums2[j]){
				res[0] = nums1[i++];
				if (i < nums1.length){
					res[1] = Math.min(nums1[i], nums2[j]);
				} else {
					res[1] = nums2[j];
				}
			} else {
				res[0] = nums2[j++];
				if (j < nums2.length){
					res[1] = Math.min(nums1[i], nums2[j]);
				} else {
					res[1] = nums1[i];
				}
			}
			return;
		}
		
		int mid1 = i + t / 2 - 1;
		int mid2 = j + t / 2 - 1;
		int val1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
		int val2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
		if (val1 <= val2){
			findEven(nums1, mid1 + 1, nums2, j, t - t / 2, res);
		} else {
			findEven(nums1, i, nums2, mid2 + 1, t - t / 2, res);
		}
	}
}
