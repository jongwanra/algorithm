package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.조합수_메모이제이션;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
 * 문제 접근 방법
 * 재귀를 이용해 조합의 경우의 수를 구한다.
 *
 * 시간 복잡도 : O(n * r)
 * 공간 복잡도: O(n * r)
 */

import java.util.*;
import java.io.*;
public class Main250514 {
	private static int[][] cache;
	public static void main(String[] args) throws IOException {
		Main250514 main = new Main250514();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs  = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int r = Integer.parseInt(inputs[1]);

		cache = new int[n + 1][r + 1];
		System.out.println(main.solution(n, r));

		for(int[] rows: cache) {
			System.out.println(Arrays.toString(rows));
		}

	}

	private int solution(int n, int r) {
		// System.out.println("call dfs(" + n + ", " + r + ")");
		if(r == 1 || n - r == 1) {
			return n;
		}
		if(r == 0 || n == r) {
			return 1;
		}

		if(cache[n][r] > 0) {
			return cache[n][r];
		}

		return cache[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
	}
}
