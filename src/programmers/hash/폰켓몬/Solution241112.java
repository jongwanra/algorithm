package programmers.hash.폰켓몬;

import java.util.HashMap;

/**
 * Map을 사용해서 풀면 된다.
 * key: 포켓몬 종류 / value: 포캣몬 수
 * 총 결괏값: n/2 개의 종류를 초과하면 n/2 그 외에는 개수를 판단해서 제공하면 됨.
 */
public class Solution241112 {
	public int solution(int[] nums) {
		HashMap<Integer, Integer> pokemonToCountMap = new HashMap<>();
		final int maxCount = nums.length / 2;
		for (int num : nums) {
			pokemonToCountMap.put(num, pokemonToCountMap.getOrDefault(num, 0) + 1);
		}

		if(pokemonToCountMap.size()  < maxCount){
			return pokemonToCountMap.size();
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Solution241112 solution = new Solution241112();
		System.out.println(solution.solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution.solution(new int[]{3,3,3,2,2,4}));
		System.out.println(solution.solution(new int[]{3,3,3,2,2,2}));

	}
}
