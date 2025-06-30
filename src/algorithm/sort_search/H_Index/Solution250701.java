package algorithm.sort_search.H_Index;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 과학자가 발표한 논몬의 수: citations.length -> n
 * 각 논문당 인용 횟수: citations 각 elements -> h
 *
 * [3, 5, 6] -> 3회 이상 인용된 논문이 3편 이상 -> h-index는 3
 * 문제 접근 방법
 *
 * 결정 알고리즘으로 풀자.
 * h-index를 가지고 있는 배열을 둔다.
 * 최소값: 0, 최대값: 논문 n
 *
 * 결과
 * 문제 해결하는데 30분 초과
 * 결정 알고리즘의 left와 right를 잘못 지정했다.
 *
 * 어떤 알고리즘을 선택해서 구현할지는 잘 판단 가능했다.
 *
 */

import java.util.*;
public class Solution250701 {
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int left = 0;
		int right = citations.length;

		int answer = 0;
		while(left <= right) {
			final int m = ((left + right ) / 2);
			if(isPossibleHIndex(citations, m)) {
				answer = Math.max(answer, m);
				left = m + 1;
				continue;
			}

			right = m - 1;
		}

		return answer;
	}

	private boolean isPossibleHIndex(int[] citations, int hIndex) {
		boolean isPossible = false;
		for(int index = 0; index < citations.length; index++) {
			if(citations[index] < hIndex) {
				continue;
			}

			if((citations.length - index) == hIndex) {
				isPossible = true;
				break;
			}
		}
		return isPossible;
	}


	public static void main(String[] args) {
		Solution250701 solution = new Solution250701();
		System.out.println(solution.solution(new int[] { 3, 0, 6, 1, 5}));
		System.out.println(solution.solution(new int[] { 5, 5, 6, 5, 5, 6}));
		System.out.println(solution.solution(new int[] { 2,1,3,3,3}));
	}
}
