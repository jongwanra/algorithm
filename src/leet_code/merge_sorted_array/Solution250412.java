package leet_code.merge_sorted_array;

import java.util.Arrays;

/**
 * 문제
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 오름차순으로 두 배열 nums1, nums2가 주어진다.
 * m, n은 각각 nums1과 nums2의 크기를 나타낸다.
 * 오름차순으로 nums1과 nums2를 합쳐라.
 * 반환하지 말고 nums1에 합쳐라.
 *
 * 문제 접근 방법
 * O(n)으로 문제를 해결 할 수 있어야 함.
 * 하나의 배열을 m+n 크기로 생성한다.
 * 각 배열을 가리키는 point들을 지정한다.
 * while문을 통해 작은 값을 먼저 넣는다.
 * poiter가 남은 경우 나머지 처리를 한다.
 * 마지막에 nums1에 매핑한다.
 */

public class Solution250412 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] mergedNums = new int[m + n];
		int nums1Pos = 0;
		int nums2Pos = 0;
		int mergedNumsPos = 0;

		while (nums1Pos < m && nums2Pos < n) {
			if(nums1[nums1Pos] < nums2[nums2Pos]) {
				mergedNums[mergedNumsPos++] = nums1[nums1Pos];
				nums1Pos++;
				continue;
			}

			mergedNums[mergedNumsPos++] = nums2[nums2Pos];
			nums2Pos++;
		}

		while(nums1Pos < m) {
			mergedNums[mergedNumsPos++] = nums1[nums1Pos++];
		}

		while(nums2Pos < n) {
			mergedNums[mergedNumsPos++] = nums2[nums2Pos++];
		}

		for(int index = 0; index < m + n; index++) {
			nums1[index] = mergedNums[index];
		}
	}

	public static void main(String[] args) {
		Solution250412 solution = new Solution250412();
		// int[] nums1 = {1, 2, 3, 0, 0, 0};
		// solution.merge(nums1, 3, new int[]{2,5,6}, 3 );
		// System.out.println(Arrays.toString(nums1));

		int[] nums1 = {1};
		int[] nums2 = {};
		solution.merge(nums1, 1, nums2, 0 );
		System.out.println(Arrays.toString(nums1));


	}
}
