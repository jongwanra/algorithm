package algorithm.recursive_tree_graph.수열_추측하기;

import java.util.Arrays;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-08
 *
 * 문제 접근 방법
 *
 */
public class Main250220 {
	private static int[] answer;
	private static int n;
	private static int k;
	private static boolean doesFindAnswer;

	public static void main(String[] args) {
		Main250220 main = new Main250220();
		n = 4;
		k = 16;
		answer = new int[n];
		main.dfs(n);


	}

	private void dfs(int depth) {
		if(doesFindAnswer){
			return;
		}

		if(depth == 0) {
			System.out.println(Arrays.toString(answer));
			final int sum = Arrays.stream(answer).sum();
			if(sum == k) {
				doesFindAnswer = true;
				return;
			}
			return;
		}

		for(int index =0; index < depth; index++) {
			for(int num = 1; num < k; num++) {

			}
		}
	}
}
