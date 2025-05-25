package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.토마토_BFS;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-12
 *
 * 인접한 토마토: 상하좌우
 * 혼자 저절로 익는 경우는 없음.
 * 토마토가 며칠이 지나면 다 익게 되는지 최소 일수 알고 싶음.
 *
 * 모든 토마토가 익어있는 상태라면, 0을 출력
 * 토마토가 모두 익지 못하는 상황이면 -1 출력
 *
 * 문제 접근 방법
 * 최소 일수를 찾는 문제 -> BFS 접근
 *
 * 시간 복잡도: O(R * C)
 * 공간 복잡도: O(R * C)
 */

import java.util.*;
import java.io.*;

public class Main250519 {
	static class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};
	private static int row;
	private static int col;
	private static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		col = Integer.parseInt(inputs[0]);
		row = Integer.parseInt(inputs[1]);
		board = new int[row][col];

		for(int r = 0; r < row; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int  c = 0; c < col; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Main250519 main = new Main250519();
		System.out.println(main.bfs());

	}

	private int bfs() {
		int answer = -1;
		Queue<Position> queue = new ArrayDeque<>();
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(board[r][c] == 1) {
					queue.offer(new Position(r, c));
				}
			}
		}

		while(!queue.isEmpty()) {
			final int size = queue.size();
			for(int index = 0; index < size; index++){
				Position cur = queue.poll();

				for(int x = 0; x < 4; x++) {
					final int nr = dr[x] + cur.row;
					final int nc = dc[x] + cur.col;

					if(nr < 0 || nr >= row || nc < 0 || nc >= col) {
						continue;
					}

					if(board[nr][nc] == 1 || board[nr][nc] == -1) {
						continue;
					}

					board[nr][nc] = 1;
					queue.offer(new Position(nr, nc));
				}
			}
			answer++;
		}

		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(board[r][c] == 0) {
					return -1;
				}
			}
		}
		return answer;
	}
}
