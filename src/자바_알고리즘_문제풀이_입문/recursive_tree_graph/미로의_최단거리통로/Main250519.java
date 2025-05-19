package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.미로의_최단거리통로;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-11
 *
 * 경로의 길이: 출벌점 -> 도착점까지 이동한 횟수
 * 문제 접근 방법
 * 최단 거리 경로 문제 -> BFS로 접근한다.
 *
 * 시간 복잡도: O(N^2)
 * 공간 복잡도 O(N^2)
 */
import java.io.*;
import java.util.*;


public class Main250519 {
	static class Chart {
		int row;
		int col;

		public Chart(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static int[][] board;
	private static int n = 7;
	private static int[] dr = new int[] { -1, 0, 1, 0};
	private static int[] dc = new int[] { 0, 1, 0, -1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[n][n];
		visited = new boolean[n][n];

		for(int row = 0; row < n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		Main250519 main = new Main250519();
		Chart startPos = new Chart(0, 0);
		Chart endPos = new Chart(6, 6);
		System.out.println(main.solution(startPos, endPos));

	}

	private int solution(Chart startPos, Chart endPos) {
		int answer = 0;
		Queue<Chart> queue = new ArrayDeque<>();
		queue.offer(new Chart(startPos.row, startPos.col));

		while(!queue.isEmpty()) {
			final int size = queue.size();

			for(int index = 0; index < size; index++) {
				Chart current = queue.poll();
				if(current.row == endPos.row && current.col == endPos.col) {
					return answer;
				}

				for(int x = 0; x < 4; x++) {
					final int nextRow = dr[x] + current.row;
					final int nextCol = dc[x] + current.col;

					if(nextRow < 0 || nextRow >= n  || nextCol < 0 || nextCol >= n) {
						continue;
					}
					if(board[nextRow][nextCol] == 1) {
						continue;
					}
					if(visited[nextRow][nextCol]) {
						continue;
					}
					visited[nextRow][nextCol] = true;
					queue.offer(new Chart(nextRow, nextCol));

				}
			}
			answer++;
		}

		return -1;
	}

}
