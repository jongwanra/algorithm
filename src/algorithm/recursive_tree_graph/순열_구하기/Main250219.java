package algorithm.recursive_tree_graph.순열_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 * N: (3 <= N <= 10)
 * M: (2 <= M <= N)
 *
 * 문제 접근 방법
 * 완전 탐색 DFS로 접근한다. (반복문으로 접근 불가)
 *
 */
public class Main250219 {
	private static boolean[] visited;
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] answer;
	public static void main(String[] args) throws IOException {
		Main250219 main = new Main250219();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[11];
		arr = new int[n + 1];
		answer = new int[m];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		main.dfs(0);


	}

	private void dfs(int depth) {
		if(depth == m) {
			for(int index = 0; index < m; index++) {
				System.out.print(answer[index] + " ");
			}
			System.out.println();
			return;
		}

		for(int index = 0; index < n; index++) {
			if(!visited[arr[index]]) {
				visited[arr[index]] = true;
				answer[depth] = arr[index];
				dfs(depth + 1);
				visited[arr[index]] = false;
				answer[depth] = 0;

			}
		}
	}
}
