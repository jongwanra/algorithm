package algorithm.recursive_tree_graph.합이_같은_부분집합;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-01
 *
 * 두 부분집합의 원소의 합이 서로 같은 경우 YES 아니면 NO 출력
 * 문제 접근 방법
 * DFS를 통해 접근한다.
 * 각 원소가 A에 포함하는 경우 B에 포함하는 경우로 경우의 수를 나눈다.
 * 깊이가 n + 1일 경우 같은지 여부를 확인한다.
 *
 * 시간 복잡도: O(2^n)
 * 공간 복잡도: O(N)
 */

import java.util.*;
import java.io.*;
public class Main250511 {
	private static int n;
	private static int[] arr;
	private static String answer = "NO";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		Main250511 main = new Main250511();
		main.dfs(0, 0, 0);

		System.out.println(answer);
	}

	private void dfs(int sumA, int sumB, int depth) {
		if(answer.equals("YES")) {
			return;
		}
		if(depth == n) {
			if(sumA == sumB) {
				answer = "YES";
			}
			return;
		}

		dfs(sumA + arr[depth], sumB, depth + 1);
		dfs(sumA , sumB + arr[depth], depth + 1);
	}
}
