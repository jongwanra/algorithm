package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.수열_추측하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-08
 *
 * 가장 위의 수 N과 가장 밑에 숫자가 주어져 있을 때 가장 윗줄의 숫자를 구하기
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력
 *
 * 문제 접근 방법
 * 1. 조합의 경우의 수를 구한다.
 * 2. 나머지 n개의 요소를 찾는 재귀를 돌린다.
 */

import java.io.*;

public class Main250515 {
	private static int[] combi;
	private static int[] answer;
	private static boolean[] checked;
	private static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int f = Integer.parseInt(inputs[1]);

		combi = new int[n];
		answer = new int[n];
		checked = new boolean[n + 1];
		for(int index = 0; index < n; index++) {
			final int currentN = n - 1;
			if(index == 0 || currentN - index == 0) {
				combi[index] = 1;
				continue;
			}
			combi[index] = factorial(currentN) / (factorial(index) * factorial(currentN - index));
		}

		Main250515 main = new Main250515();
		main.solution(n, f, 0);

	}

	private void solution(int n, int f, int depth) {
		if(found) {
			return;
		}
		if(depth == n) {
			int sum = 0;
			for(int index = 0; index < n; index++) {
				sum += combi[index] * answer[index];
			}

			if(sum == f) {
				found = true;
				for(int ans: answer) {
					System.out.print(ans + " ");
				}
			}
			return;
		}

		for(int index = 1; index <= n; index++) {
			if(checked[index]) {
				continue;
			}
			checked[index] = true;
			answer[depth] = index;
			solution(n, f, depth + 1);
			checked[index] = false;
		}

	}

	private static int factorial(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}

		return n * factorial(n- 1);
	}

}
