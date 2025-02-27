package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.토마토_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-12
 * 인접한 토마토: 좌, 오, 앞, 뒤를 의미 (대각선 x)
 * 혼자 저절로 익는 경우 x
 *
 * 며칠이 지나면 다 익는지 최소일수를 구해야 함.
 * m은 가로 n은 세로
 * 1: 익음
 * 0: 익지 않음
 * -1: 없음
 * 문제 접근 방법
 * BFS로 문제 접근
 * 1이 저장된 위치를 전부 찾아 Queue에 넣는다.
 * 이후에 Queue가 비어질 때까지 돈다.
 * 값 출력
 *
 */
public class Main250228 {
	static class Chart {
		public int row;
		public int col;

		Chart(int row, int col) {
			this.row = row;
			this.col = col;
		}


	}
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int col = Integer.parseInt(st.nextToken());
		final int row = Integer.parseInt(st.nextToken());
		int[][] board = new int[row][col];

		for(int rowIndex = 0; rowIndex < row; rowIndex++){
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int colIndex = 0; colIndex < col; colIndex++) {
				board[rowIndex][colIndex] = Integer.parseInt(stArr.nextToken());
			}
		}

		Main250228 main = new Main250228();
		System.out.println(main.bfs(row, col, board));

	}

	private int bfs(int row, int col, int[][] board) {
		int answer = 0;
		Queue<Chart> queue = new ArrayDeque<>();

		// 익은 토마토가 있는 위치 전부 찾아서 우선 넣음.
		for(int rowIndex = 0; rowIndex < row; rowIndex++) {
			for(int colIndex = 0; colIndex < col; colIndex++) {
				if(board[rowIndex][colIndex] == 1) {
					queue.offer(new Chart(rowIndex, colIndex));
				}
			}
		}



		while (!queue.isEmpty()) {
			final int size = queue.size();
			boolean answerFlag = false;
			for(int same = 0; same < size; same++) {
				Chart curChart = queue.poll();
				for(int index = 0; index < 4; index++) {
					final int nextRow = curChart.row + dr[index];
					final int nextCol = curChart.col + dc[index];

					if(nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
						continue;
					}

					final int target = board[nextRow][nextCol];
					if(target == -1 || target == 1) {
						continue;
					}

					board[nextRow][nextCol] = 1;
					queue.offer(new Chart(nextRow, nextCol));
					answerFlag = true;
				}
			}
			if(answerFlag) {
				answer++;
			}

		}

		for(int rowIndex = 0; rowIndex < row; rowIndex++) {
			for(int colIndex = 0; colIndex < col; colIndex++) {
				if(board[rowIndex][colIndex] == 0) {
					return -1;
				}
			}
		}
		return answer;
	}
}
