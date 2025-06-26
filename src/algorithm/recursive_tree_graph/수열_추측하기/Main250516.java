package algorithm.recursive_tree_graph.수열_추측하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-08
 *
 * 가장 위의 수 N과 가장 밑에 숫자가 주어져 있을 때 가장 윗줄의 숫자를 구하기
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력
 *
 * 순열과 조합 응용 문제였다.
 *
 * 문제 접근 방법
 * 1. 조합의 경우의 수를 구한다.
 * 2. 나머지 n개의 요소를 찾는 재귀를 돌린다.
 *
 * 시간 복잡도: O(n!)
 * 공간 복잡도: O(n^2)
 */

import java.io.*;
public class Main250516 {
	private static int n;
	private static int f;
	private static int[][] cache;
	private static int[] combi;
	private static int[] answers;
	private static boolean[] visited;
	private static boolean doesFindAnswer = false;

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		f = Integer.parseInt(inputs[1]);
		cache = new int[n][n];
		combi = new int[n];
		answers = new int[n];
		visited = new boolean[n + 1];

		Main250516 main = new Main250516();
		main.solution();

	}

	private void solution() {
		// 1. 조합 구하기
		// O(n^2)
		for(int index = 0; index < n; index++) {
			final int num = n - 1;
			combi[index] = calculateCombination(num , index);
		}

		// 2. 나머지 N개 요소를 찾는 DFS
		// O(n!)
		dfs(0);
	}

	// O(n!)
	// visited를 통해 중복호출 방지를 하고 있기 떄문에 O(n!)이다.
	// visited가 없었다면, 모든 num의 개수만큼 포문을 돌아야 했다. 그 경우 O(n^n)이 된다.
	private void dfs(int depth) {
		 if(doesFindAnswer) {
			return;
		 }
		if(depth == n) {
			int sum = 0;
			for(int index = 0; index < n; index++) {
				sum += (combi[index] * answers[index]);
			}

			if(sum == f) {
				doesFindAnswer = true;
				for(int answer: answers) {
					System.out.print(answer + " ");
				}
				return;
			}
		}

		for(int num = 1; num <= n; num++) {
			if(visited[num]) {
				continue;
			}

			visited[num] = true;
			answers[depth] = num;
			dfs(depth + 1);
			visited[num] = false;
		}


	}

	// O(n * r)
	private int calculateCombination(int n, int r) {
		if(cache[n][r] > 0) {
			return cache[n][r];
		}

		if(n == r || r == 0) {
			return 1;
		}

		return cache[n][r] = calculateCombination(n - 1, r - 1) + calculateCombination(n - 1, r);
	}
}
