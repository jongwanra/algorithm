package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.조합수_메모이제이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
 * 문제 접근 방법
 *
 * nCr = (n-1)C(r-1) + (n-1)C(r) 공식을 이용해서 접근한다.
 * r == 0일 경우에는 하나의 경우의 수를 나타내므로 1을 반환한다.
 */

public class Main250220 {
	private static int[][] cache;
	public static void main(String[] args) throws IOException {
		Main250220 main = new Main250220();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt( st.nextToken());
		final int r = Integer.parseInt( st.nextToken());

		cache = new int[n + 1][r + 1];
		System.out.println(main.dfs(n, r));
	}

	private int dfs(int n, int r) {
		if(r == 0 || n == r){
			return 1;
		}

		if(cache[n][r] > 0) {
			return cache[n][r];
		}

		return cache[n][r] = dfs(n-1, r-1) + dfs(n -1, r);
	}
}
