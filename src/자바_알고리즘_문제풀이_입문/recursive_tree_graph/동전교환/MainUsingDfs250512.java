package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.동전교환;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-05
 *
 * 거스름돈을 가장 적은 수의 동전으로 교환해주기.
 * 문제 접근 방법
 * 최소 개수의 동전을 찾는 것이기 때문에 BFS 접근한다
 * 하지만 DFS로도 풀어보자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class MainUsingDfs250512 {
	private static int[] visited;
	private static int[] coins;
	private static int total;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int coinNum = Integer.parseInt(br.readLine());
		coins = new int[coinNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < coinNum; index++) {
			coins[index] = Integer.parseInt(st.nextToken());
		}
		total = Integer.parseInt(br.readLine());
		visited = new int[total + 1];
		MainUsingDfs250512 main = new MainUsingDfs250512();

		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[0] = 0;
		main.solution(0, 0);
		System.out.println(answer);
	}

	private void solution(int level, int sum) {
		// System.out.println("call dfs(" + level + ", " + sum + ")");
		if(sum == total) {
			answer = Math.min(answer, level);
			return;
		}

		for(int index = coins.length - 1; index >= 0; index--) {
			final int nextSum = coins[index] + sum;

			if(nextSum > total) {
				continue;
			}
			if(visited[nextSum] < level) {
				continue;
			}

			visited[nextSum] = level;
			solution(level + 1, nextSum);

		}


	}

}
