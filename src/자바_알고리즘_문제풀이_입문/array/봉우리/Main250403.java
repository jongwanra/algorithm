package 자바_알고리즘_문제풀이_입문.array.봉우리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-10
 * 봉우리: 자신의 상하좌우 숫자보다 큰 숫자
 * 봉우리가 몇 개인지 알아보자.
 *
 * 문제 접근 방법
 * 2차원 배열 board를 만들고 반복문을 돌면서 봉우리 여부를 체크한다.
 */
public class Main250403 {
	private static int[] dr = { -1, 0, 1, 0};
	private static int[] dc = { 0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int row = 0; row < n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		Main250403 main = new Main250403();
		System.out.println(main.solution(n, board));
	}

	private int solution(int n, int[][] board) {
		int answer = 0;

		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(isPeaks(row, col, n, board)) {
					answer++;
				}
			}

		}
		return answer;
	}

	private boolean isPeaks(int row, int col, int n, int[][] board) {
		int target = board[row][col];
		for(int index = 0; index < 4; index++) {
			final int nr = row + dr[index];
			final int nc = col + dc[index];

			if(nr < 0 || nr >= n || nc < 0 || nc >= n) {
				continue;
			}
			if(board[nr][nc] >= target) {
				return false;
			}
		}
		return true;
	}
}
