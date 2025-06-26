package algorithm.recursive_tree_graph.섬나라_아일랜드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-13
 *
 * 섬:1, 바다 0
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구해야 함.
 *
 * 문제 접근 방법
 * 완전 탐색으로 접근하면서 전부 0으로 채운다.
 * BFS를 사용해서 문제를 해결해보자.
 *
 */
public class Main250303 {
	static class Position {
		public int row;
		public int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		Main250303 main = new Main250303();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int row = 0; row < n; row++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++){
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.search(n, board));
	}

	private int search(int n, int[][] board) {
		int answer = 0;
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(board[row][col] == 1) {
					// bfs(n, row, col, board);
					dfs(n, row, col, board);
					answer++;
				}

			}
		}


		return answer;
	}

	private void dfs(int n, int row, int col, int[][] board) {
		for(int index = 0; index < 8; index++) {
			final int nextRow = row + dr[index];
			final int nextCol = col + dc[index];

			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
				continue;
			}

			if(board[nextRow][nextCol] == 0) {
				continue;
			}
			board[nextRow][nextCol]= 0;
			dfs(n, nextRow, nextCol, board);
		}
	}

	private void bfs(int n, int row, int col, int[][] board) {
		Queue<Position> queue = new ArrayDeque<>();
		queue.offer(new Position(row, col));

		while(!queue.isEmpty()) {
			Position position = queue.poll();

			for(int index = 0; index < 8; index++) {
				final int nextRow = position.row + dr[index];
				final int nextCol = position.col + dc[index];
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
					continue;
				}

				if(board[nextRow][nextCol] == 0) {
					continue;
				}

				queue.offer(new Position(nextRow, nextCol));
				board[nextRow][nextCol] = 0;
			}
		}
	}
}
