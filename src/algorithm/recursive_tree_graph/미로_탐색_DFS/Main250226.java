package algorithm.recursive_tree_graph.미로_탐색_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-10
 * 문제 접근 방법
 * DFS로 접근한다.
 * 출발지점 부터 시작하여 도착지점까지 가는 곳마다 방문 표시를 진행한다.
 */
public class Main250226 {
	private static int n;
	private static int[][] board;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		Main250226 main = new Main250226();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 7;
		board = new int[n + 1][n +1];

		for(int row = 1; row <= n; row++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int col = 1; col <= n; col++) {
				board[row][col] = Integer.parseInt(stArr.nextToken());
			}
		}
		board[1][1] = 1;
		main.dfs(1, 1);
		System.out.println(answer);

	}

	private void dfs(int currentRow, int currentCol) {
		if(currentRow == n && currentCol == n) {
			answer++;
			return;
		}

		for(int index = 0; index < 4; index++) {
			final int nextRow = currentRow + dr[index];
			final int nextCol = currentCol + dc[index];

			if(nextRow <= 0 || nextRow > n || nextCol <= 0 || nextCol > n) {
				continue;
			}

			if (board[nextRow][nextCol] == 1) {
				continue;
			}

			board[nextRow][nextCol] = 1;
			dfs(nextRow, nextCol);
			board[nextRow][nextCol] = 0;

		}
	}
}
