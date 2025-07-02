package algorithm.exhaustive_search.모의고사;

/**
 문제
 https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java

 시험문제: n <= 10,000
 반환값: 오름차순 정렬
---
 문제 접근 방법
 3명의 수포자의 배열을 반복 주기인 10까지 생성한다.
 answers를 1번 반복하며 맞은 문제를 카운팅한다.
 배열을 순회하며, 오름차순 출력한다.
 ---
 시간 복잡도: O(N)
 공간 복잡도: O(1)
---
 30분 문제 풀이 시간 초과
 시간 초과 이유
 1. 반복 주기가 전부 10으로 동일하다고 생각했다. 따라서 adjustedIndex를 구하는데, IndexOutOfBound Exception 발생
 2. answer.stream().mapToInt(Integer::intValue).toArray(); 로직을 잘못 사용. Integer::intValue임을 명심하자.
 3. 간단한 정렬해서 출력하는 것을 구하는 것이었는데, maxScore를 구하는데 2분 정도 고민한 것 같다.

 */

import java.util.*;
class Solution250703 {
	public int[] solution(int[] answers) {
		int[][] persons = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		int[] scores = new int[3];
		int[] schedules = {5, 8, 10};

		// O(N * 3) -> O(N)
		for(int index = 0; index < answers.length; index++) {
			for(int personIndex = 0; personIndex < 3; personIndex++) {
				int[] person = persons[personIndex];
				int adjustedIndex = index % schedules[personIndex];
				if(person[adjustedIndex] == answers[index]) {
					scores[personIndex]++;
				}

			}
		}

		int maxScore = Integer.MIN_VALUE;
		for(int score: scores) {
			maxScore = Math.max(score, maxScore);
		}
		List<Integer> answer = new ArrayList<>();
		for(int index = 0; index < 3; index++) {
			if(scores[index] == maxScore) {
				answer.add(index + 1);
			}
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}




	public static void main(String[] args) {
		Solution250703 solution = new Solution250703();
		System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5})));
	}
}
