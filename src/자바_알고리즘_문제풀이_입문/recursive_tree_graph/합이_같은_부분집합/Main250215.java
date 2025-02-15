package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.합이_같은_부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-01
 *
 * 문제 접근 방법
 * DFS로 접근
 * 원소를 돌면서 원소가 A집합으로 가는 경우, B집합으로 가능 경우 2개의 경우의 수로 합을 구한다.
 * 마지막 원소까지 갔을 때 합이 동일한지 여부를 통해 값을 판단한다.
 */
public class Main250215 {
	private static int aSum = 0;
	private static int bSum = 0;
	private static int[] arr;
	private static int n;
	private static String answer = "NO";
	public static void main(String[] args) throws IOException {
		Main250215 main = new Main250215();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}
		main.dfs(0);
		System.out.println(answer);
	}

	private void dfs(int depth) {
		if(answer.equals("YES")) {
			return;
		}

		if(depth == n) {
			if (aSum == bSum) {
				answer = "YES";
				return;
			}
			return;
		}

		aSum = aSum + arr[depth];
		dfs(depth + 1);
		aSum = aSum - arr[depth];

		bSum = bSum + arr[depth];
		dfs(depth + 1);
		bSum= bSum - arr[depth];
	}
}
