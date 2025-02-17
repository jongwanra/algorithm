package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.바둑이_승차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-02
 *
 * 문제 접근 방법
 * 가장 무거운 무게를 출력하는 거기 떄문에, 완전 탐색으로 가야함. 그 중에 DFS를 통해서 문제를 해결해보자.
 *
 */
public class Main250218 {
	private static int answer = Integer.MIN_VALUE;
	private static int threshold;
	private static int n;
	private static int[] weights;

	public static void main(String[] args) throws IOException {
		Main250218 main = new Main250218();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		threshold = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		weights = new int[n];
		for(int index = 0; index < n; index++) {
			weights[index] = Integer.parseInt(br.readLine());
		}

		main.dfs(0, 0);


		System.out.println(answer);
	}

	private void dfs(int depth, int sum) {
		if(sum >= threshold) {
			return;
		}

		if(depth == n) {
			answer = Math.max(sum, answer);
			return;
		}

		dfs(depth + 1, sum + weights[depth]);
		dfs(depth + 1, sum);
	}
}
