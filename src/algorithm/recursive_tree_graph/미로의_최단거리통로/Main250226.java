package algorithm.recursive_tree_graph.미로의_최단거리통로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-11
 *
 * 문제 접근 방법
 * BFS로 접근한다.
 * 출발지점부터 도착지점까지의 최단 경로를 나타내는 것.
 * 출발지점: 1, 1
 * 도착지점: 7, 7
 *
 */
public class Main250226 {
	static class Chart {
		public int row;
		public int col;

		Chart(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static int n;
	private static int[][] board;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		Main250226 main = new Main250226();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = 7;
		board = new int[n + 1][n + 1]; // 0 무시

		for(int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <=n; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.bfs(1, 1));
	}

	private int bfs(int startRow, int startCol) {
		int answer = 0;
		Queue<Chart> queue = new ArrayDeque<>();

		board[startRow][startCol] = 1;
		queue.offer(new Chart(startRow, startCol));

		while(!queue.isEmpty()) {
			final int size = queue.size();

			for(int sameDistance = 0; sameDistance < size; sameDistance++) {
				Chart chart = queue.poll();

				for(int index = 0; index < 4; index++) {
					final int nextRow = chart.row + dr[index];
					final int nextCol = chart.col + dc[index];

					if(nextRow <= 0 || nextRow > n || nextCol <= 0 || nextCol > n) {
						continue;
					}

					if(board[nextRow][nextCol] == 1) {
						continue;
					}

					if(nextRow == n && nextCol == n) {
						return answer + 1;
					}

					board[nextRow][nextCol] = 1;
					queue.offer(new Chart(nextRow, nextCol));
				}
			}
			 answer++;

		}


		return -1;
	}
}
