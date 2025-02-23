package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.수열_추측하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-08
 *
 * 문제 접근 방법
 * 가장 윗줄에 있는 숫자를 구하기
 */
public class Main250223 {
	private static int n;
	private static int sum;
	private static int[] cases;
	private static int[] answers;
	private static boolean[] visited;
	private static boolean foundAnswer = false;

	public static void main(String[] args) throws IOException {
		Main250223 main = new Main250223();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		cases = new int[n];
		answers = new int[n];
		visited = new boolean[n + 1];
		for(int index = 0; index < n; index++) {
			cases[index] = main.calculateCombination(n - 1, index);
		}

		main.dfs(0);

	}

	private int calculateCombination(int n, int r) {
		// n!/(n-r)! * r!
		return factorial(n) / (factorial(n-r) * factorial(r));
	}

	private int factorial(int n) {
		int sum = 1;
		for(int index = 2; index <= n; index++) {
			sum *= index;
		}

		return sum;
	}

	private void dfs(int depth) {
		if(foundAnswer) {
			return;
		}
		// 종료 조건
		if(n == depth) {
			int total = 0;
			for(int index = 0; index < n; index++) {
				total += (cases[index] * answers[index]);
			}
			if(sum == total){
				foundAnswer = true;
				for(int index = 0; index < n; index++) {
					System.out.print(answers[index] + " ");
				}
				return;
			}

			return;
		}

		for(int num = 1; num <= n; num++) {
			if(!visited[num]) {
				visited[num] = true;
				answers[depth] = num;
				dfs(depth + 1);
				visited[num] = false;
			}

		}
	}
}
