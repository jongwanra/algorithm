package algorithm.array.임시반장_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-11
 *
 * 문제 접근 방법
 * 0. 입력을 받을 때, 구현에 용이하도록 인덱스를 1번 부터 시작한다. (학생 번호 / 학년)
 * 1. 학생 마다를 기준으로 비교를 해야 하기 떄문에 3중 포문이 필요하다.
 * 2. student, another, grade로 3중 포문을 돌면서 비교한다.
 * 3. 비교시에 동일한 학년이 있을 경우 바로 포문을 빠져 나온다.
 */
public class Main241204 {
	public static void main(String[] args) throws IOException {
		Main241204 main = new Main241204();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		int[][] matrix = new int[n + 1][6];

		for(int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= 5; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}

		}

		System.out.println(main.solution(n, matrix));

	}

	private int solution(int n, int[][] matrix) {
		int answerStudent = 0;
		int max = Integer.MIN_VALUE;

		for(int student = 1; student <= n; student++) {
			int cnt = 0;
			for(int another = 1; another <= n; another++) {
				for(int grade = 1; grade <= 5; grade++) {
					if(matrix[student][grade] == matrix[another][grade]) {
						cnt++;
						break;
					}
				}
			}

			if(max < cnt) {
				max = cnt;
				answerStudent = student;
			}
		}
		return answerStudent;
	}
}
