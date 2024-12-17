package programmers.hash.폰켓몬;

import java.util.HashSet;
import java.util.Set;

/**
 * Map의 값은 요구되지 않기 때문에 Set을 이용하여 풀어본다.
 * 총 결괏값: n/2 개의 종류를 초과하면 n/2 그 외에는 개수를 판단해서 제공하면 됨.
 */
public class Solution241113 {
	public int solution(int[] nums) {
		Set<Integer> poketmonSet = new HashSet<>();
		final int maxCount = nums.length / 2;
		for (int num : nums) {
			poketmonSet.add(num);
		}

		if (poketmonSet.size()  < maxCount){
			return poketmonSet.size();
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Solution241113 solution = new Solution241113();
		System.out.println(solution.solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution.solution(new int[]{3,3,3,2,2,4}));
		System.out.println(solution.solution(new int[]{3,3,3,2,2,2}));

	}
}
