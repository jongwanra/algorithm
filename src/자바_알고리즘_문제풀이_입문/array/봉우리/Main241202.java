package 자바_알고리즘_문제풀이_입문.array.봉우리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-10
 *
 * 문제 접근 방법
 *
 * 1. 입력 받기
 * 2. 왼쪽 오른쪽, 위, 아래에 대한 x, y좌표 만들기
 * 3. 전체 반복문을 돌면서 봉우리 개수 구한다.
 */
public class Main241202 {
	private final int[] dRow = { -1, 0, 1, 0}; // left, top, right, bottom
	private final int[] dCol = { 0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		Main241202 main = new Main241202();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];

		for(int row = 0; row < n; row++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int col = 0; col < n; col++){
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.solution(n, matrix));
	}

	private int solution(int n, int[][] matrix) {
		int answer = 0;
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(isPeak(matrix, row, col, n)){
					answer++;
				}
			}
		}
		return answer;
	}

	private boolean isPeak(int[][] matrix, int row, int col, int n) {
		final int peak = matrix[row][col];
		for(int index = 0 ; index < 4; index++){
			final int nextRow = row + dRow[index];
			final int nextCol = col + dCol[index];
			final int side = (nextCol < 0 || nextCol >= n || nextRow < 0 || nextRow >= n) ? 0 : matrix[nextRow][nextCol];
			// System.out.println("matrix[" + row + "][" + col + "] = " + peak + " / side: " + side);
			if(peak <= side) {
				// System.out.println("=== isNotPeak ===");
				return false;
			}
		}
		// System.out.println("=== " + matrix[row][col] + " isPeak ===");
		return true;
	}
}
