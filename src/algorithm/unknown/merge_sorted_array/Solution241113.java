package algorithm.unknown.merge_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 문제 설명
 * 두 배열 nums1, num2가 주어진다.
 * 두 배열은 오름차순으로 정렬된 배열이다.
 * m, n 각각 nums1, nums2 배열의 크기를 나타낸다.
 * 정렬한 결과는 nums1에 대입한다.
 *
 * 문제 해결 방법 (1)
 * 1. nums1, nums2를 하나의 리스트로 만든다.
 * 2. list를 정렬한다.
 * 3. 배열로 다시 만든다.
 *
 * 문제 해결 방법(2)
 * 1. mergeSort를 구현한다.
 * ---
 */
public class Solution241113 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> mergedList = new ArrayList<>(Arrays.stream(nums1, 0, m).boxed().toList());
		mergedList.addAll(Arrays.stream(nums2).boxed().toList());

		mergedList.sort(null);
		for(int index = 0; index < m + n; index++) {
			nums1[index] = mergedList.get(index);
		}

	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] mergedNums = new int[m + n];

		// 작은 배열 크기 만큼 for문을 돌면서 비교를 하여 mergedNums에 넣는다.
		int index1 = 0;
		int index2 = 0;
		int mergedIndex = 0;
		while(index1 < m && index2 < n) {
			if(nums1[index1] >= nums2[index2]) {
				mergedNums[mergedIndex++] = nums2[index2++];
				continue;
			}
			mergedNums[mergedIndex++] = nums1[index1++];
		}

		while(index1 < m) {
			mergedNums[mergedIndex++] = nums1[index1++];
		}

		while (index2 < n) {
			mergedNums[mergedIndex++] = nums2[index2++];
		}

		for(int index = 0; index < m +n; index++) {
			nums1[index] = mergedNums[index];
		}
	}

	public static void main(String[] args) {
		Solution241113 solution = new Solution241113();
		solution.merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
		solution.merge2(new int[]{0}, 0, new int[]{1}, 1);
	}
}
