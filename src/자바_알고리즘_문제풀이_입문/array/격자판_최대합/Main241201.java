package 자바_알고리즘_문제풀이_입문.array.격자판_최대합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-09
 *
 * 문제 접근 방법
 * 1. 입력을 받는다.
 * 2. 반복문을 통해서 각 행의 합 중에 가장 큰 값을 구한다.
 * 3. 반복문을 통해서 각 열의 합 중에 가장 큰 값을 구한다.
 * 4. 반복문을 통해서 두 대각선의 합 중 가장 큰 합을 구한다.
 * 5. 위 3개의 값 중 가장 큰 값을 출력한다.
 */
public class Main241201 {
	public static void main(String[] args) throws IOException {
		Main241201 main = new Main241201();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];
		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				matrix[index][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.lectureSolution(n, matrix));
	}

	private int solution(int n, int[][] matrix) {
		int answer = Integer.MIN_VALUE;
		// 각 행의 합 중 가장 큰 값.
		for(int row = 0; row < n; row++) {
			int sum = 0;
			for(int col = 0; col < n; col++) {
				sum += matrix[row][col];
			}
			answer = Math.max(answer, sum);
		}
		// 각 열의 합 중 가장 큰 값
		for(int col = 0; col < n; col++) {
			int sum = 0;
			for(int row = 0; row < n; row++) {
				sum += matrix[row][col];
			}
			answer = Math.max(answer, sum);
		}
		// 대각선 중 가장 큰 값.
		int sum = 0;
		for(int row = 0; row < n; row++) {
			sum += matrix[row][row];
		}
		answer = Math.max(answer, sum);

		sum = 0;
		for(int row = n - 1; row >= 0; row--){
			sum += matrix[row][row];
		}

		answer = Math.max(answer, sum);
		return answer;
	}

	private int lectureSolution(int n, int[][] matrix) {
		int answer = Integer.MIN_VALUE;
		// 각 행의 합 중 가장 큰 값.
		// 각 열의 합 중 가장 큰 값
		for(int row = 0; row < n; row++) {
			int sumCol = 0;
			int sumRow = 0;
			for(int col = 0; col < n; col++) {
				sumCol += matrix[row][col];
				sumRow += matrix[col][row];
			}
			answer = Math.max(answer, sumCol);
			answer = Math.max(answer, sumRow);
		}

		// 대각선 중 가장 큰 값.
		int sumLeftToRight = 0;
		int sumRightToLeft = 0;
		for(int row = 0; row < n; row++) {
			sumLeftToRight += matrix[row][row];
			sumRightToLeft += matrix[row][n - row - 1];
		}
		answer = Math.max(answer, sumLeftToRight);
		answer = Math.max(answer, sumRightToLeft);
		return answer;
	}
}
