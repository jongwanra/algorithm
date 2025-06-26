package algorithm.hash.의상;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
 *
 * 종류별로 한 번에 최대 한 가지만 착용 가능
 * 의상의 수: 1 <= n <= 30
 * 같은 이름 가진 의상 존재 x
 * 문자열의 길이: 1 <= m <= 20
 * 알파벳 소문자와 '_'로만 모든 문자가 이루어져 있음.
 *
 * 문제 접근 방법
 * 이건 조합의 문제이다.
 *
 * 종류 별로 조합 수를 구한다.
 *
 * 시간 초과 나왔다.
 * 의상의 종류(K)가 전혀 곂치지 않는 경우 30개이다.
 * 시간 복잡도: O(2^K * K) -> 해당 의상의 종류를 선택한 경우와 안 선택한 경우 * 각 조합 마다 categories.size()로 순회
 * 2^30 * 30 => 굉장히 비효율 적임
 *
 * 수학 조합의 원리를 이해하지 못함.
 *
 */
import java.util.*;
public class FailedSolution250620 {
	private int answer = 0;
	private List<String> categories;
	private Map<String, Integer> categoryToCountMap;
	private boolean[] visited;

	public int solution(String[][] clothes) {
		categoryToCountMap = new HashMap<>();
		for(String[] c: clothes) {
			final String category = c[1];
			categoryToCountMap.put(category, categoryToCountMap.getOrDefault(category, 0) + 1);
		}

		categories = new ArrayList<>(categoryToCountMap.keySet());
		visited = new boolean[categories.size()];

		dfs(0, 0);

		return answer;
	}

	private void dfs(int depth, int start) {
		if(depth == categories.size()) {
			int sum = 1;
			boolean flag = false;
			for(int index = 0; index < categories.size(); index++) {
				if(visited[index]) {
					// System.out.print(index + " ");
					sum *= categoryToCountMap.get(categories.get(index));
					flag = true;
				}
			}
			// System.out.println("sum = " + sum);
			if(flag) {
				answer += sum;
			}

			return;
		}

		for(int index = start; index < categories.size(); index++) {
			visited[index] = true;
			dfs(depth + 1, index + 1);
			visited[index] = false;
			dfs(depth + 1, index + 1);
		}
	}

	public static void main(String[] args) {
		FailedSolution250620 solution = new FailedSolution250620();
		System.out.println(solution.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}
}
