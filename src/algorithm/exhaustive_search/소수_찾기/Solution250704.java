package algorithm.exhaustive_search.소수_찾기;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 소수 찾기.
 * 각 숫자들을 조합해서 생길 수 있는 소수를 카운트하여 반환하자.
 * 1 <= numbers <= 7
 *
 * 문제 접근 방법
 * 완전 탐색으로 조합을 풀 경우 시간 복잡도 => 2^7 => 128번 연산.
 * DFS로 접근하자.
 *
 * 조합의 문제가 아니라 순열의 문제 였구나..
 *
 * 시간 초과: 30분 이상 소요
 * 구현을 하기 이전에 문제를 접근할 때, 순열이 아닌 조합으로 접근했음.
 * 중복이 발생할 수 있는 가능성을 배제하지 못함.
 * 소수를 찾을 때, Math.sqrt(num)에 포함 범위를 잘못 설정함.
 * -> index <= Math.sqrt(num)이 맞다.
 * -> ex) index < Math.sqrt(num)일 경우, num이 9라면 소수에 포함된다.
 *
 *
 * 시간 복잡도 분석
 * O(n * n! * root k)
 * n: numbers.length();
 * k: 숫자 최댓값
 *
 */
import java.util.*;
public class Solution250704 {
	private int[] combi;
	private boolean[] visited;
	private Set<Integer> cache = new HashSet<>();
	private int answer = 0;

	public int solution(String numbers) {
		combi = new int[numbers.length()];
		Arrays.fill(combi, Integer.MIN_VALUE);
		visited = new boolean[numbers.length()];
		for(int r = 1; r <= numbers.length(); r++) {
			dfs(numbers, 0, r);
		}

		return answer;
	}

	private void dfs(String numbers, int depth, int r) {
		if(depth == r) {
			StringBuilder sb = new StringBuilder();
			for(int c: combi) {
				if(c == Integer.MIN_VALUE) {
					continue;
				}
				sb.append(c);
			}

			String numStr = sb.toString();
			if(numStr.isBlank()) {
				return;
			}

			int num = Integer.parseInt(numStr);
			if(cache.contains(num)) {
				return;
			}
			cache.add(num);
			if(isPrimeNumber(num)) {
				answer++;
			}
			return;
		}

		for(int index = 0; index < numbers.length(); index++) {
			if(visited[index]) {
				continue;
			}
			visited[index] = true;
			combi[depth] = numbers.charAt(index) - '0';
			dfs(numbers, depth + 1, r);
			visited[index] = false;


		}
	}

	private boolean isPrimeNumber(Integer num) {
		if(num == 1 || num == 0) {
			return false;
		}
		for(int index = 2; index <= Math.sqrt(num); index++) {
			if(num % index == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		Solution250704 solution = new Solution250704();
		System.out.println(solution.solution("999111"));
		// System.out.println(solution.solution("011"));
	}
}
