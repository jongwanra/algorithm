package 자바_알고리즘_문제풀이_입문.array.봉우리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-10
 *
 * 문제 접근 방법
 * 1. dr, dc 구현
 * 2. 격자판을 2중 포문으로 돌면서 봉우리인지를 체크
 */
public class Main241204 {
	private int[] dr = { 0, -1, 0, 1}; // distance row
	private int[] dc = { -1, 0, 1, 0}; // distance col
	public static void main(String[] args) throws IOException {
		Main241204 main = new Main241204();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		int[][] matrix = new int[n][n];
		for(int row = 0; row < n; row++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.solution(n, matrix));

	}

	private int solution(int n, int[][] matrix) {
		int answer = 0;
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++) {
				if(isPeak(matrix, row, col, n)) {
					answer++;
				}
			}
		}
		return answer;
	}

	private boolean isPeak(int[][] matrix, int row, int col, int n) {
		final int currentPeak = matrix[row][col];
		for(int index = 0; index < 4; index++) {
			final int nr = row + dr[index];
			final int nc = col + dc[index];

			if(nr < 0 || nr >= n || nc < 0 || nc >= n) {
				continue;
			}

			if(currentPeak <= matrix[nr][nc]){
				return false;
			}
		}
		return true;
	}
}
