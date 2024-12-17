package leet_code.remove_element;

import java.util.Arrays;

/**
 * Given an Integer array nums and an integer val, remove all occurrences of val in nums in-place.
 *
 * 문제 상황
 * Integer Array에 포함된 val 요소들을 전부 제거한다.
 * 남겨진 요소의 수를 반환한다.(k)
 *
 * 제약 조건
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 *
 * 접근 방법
 * 1. for 문 -> 동일한 요소 count 세고, -1로 변환
 */
public class Solution241114 {
	// FAIL
	public int removeElement(int[] nums, int val) {
		int[] result = new int[51];
		int count = 0;
		for(int index = 0; index < nums.length; index++) {
			if(nums[index] == val) {
				count++;
			}else {
				result[nums[index]]++;
			}
		}

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(result));

		int numsIndex = 0;
		for(int index = 0; index < 51; index++) {
			if(result[index] == 0) {
				continue;
			}
			final int sameNumCount = result[index];
			for(int j = 0; j < sameNumCount; j++){
				nums[numsIndex++] = index;
			}

		}

		while(nums.length > numsIndex) {
			nums[numsIndex++] = 0;
		}

		return count;
	}

	public int removeElement2(int[] nums, int val) {
		int targetIndex = 0;

		for(int index = 0; index < nums.length; index++) {
			if(nums[index] == val) {
				continue;
			}

			nums[targetIndex++] = nums[index];
		}

		return targetIndex;

	}

	public static void main(String[] args) {
		Solution241114 solution = new Solution241114();
		System.out.println(solution.removeElement2(new int[]{0,1,2,2,3,0,4,2}, 2));
	}
}
