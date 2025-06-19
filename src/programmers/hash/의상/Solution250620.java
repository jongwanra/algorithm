package programmers.hash.의상;

/**
 * 다른 사람의 풀이를 보고난 이후 다시 구현해 본 문제.
 * 조합의 원리를 이용해서 O(K)로 문제 해결 가능.
 *
 * 의상의 종류 마다 경우의 수 아래와 같다.
 * 특정 종류의 의상을 고른 경우의 수 + 종류의 의상을 안 고른 경우
 * = 종류의 옷 갯수 + 1
 *
 * 조합의 원리 = 각 의상별 (종류의 옷 갯수 + 1) - 아무 것도 선택하지 않은 경우(1)
 */

import java.util.*;
public class Solution250620 {
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> categoryToCountMap = new HashMap<>();
		for(String[] cloth: clothes) {
			final String category = cloth[1];
			categoryToCountMap.put(category, categoryToCountMap.getOrDefault(category, 0) + 1);
		}

		for(String category: categoryToCountMap.keySet()) {
			answer *= categoryToCountMap.get(category) + 1; // 종류별 의상의 갯수 만큼 선택한 경우 + 해당 종류 의상을 고르지 않는 경우
		}

		// 전체를 선택하지 않는 경우는 제외하기 때문에 - 1
		return answer - 1;
	}
}
