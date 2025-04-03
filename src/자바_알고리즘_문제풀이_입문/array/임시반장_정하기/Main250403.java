package 자바_알고리즘_문제풀이_입문.array.임시반장_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-11
 *
 * 1 ~ 5학년 동안 한 번이라도 같은 반이었던 사람이 가장 많은 학생 -> 임시 반장
 * 문제 접근 방법
 * 학생이 n번일 경우에 1학년부터 5학년까지 돌면서 같은반이었던 학생을 Set에 넣는다.(본인일 경우 제외)
 */

public class Main250403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		final int grade = 5;
		int[][] board = new int[n + 1][grade + 1];

		for(int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= grade; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		Main250403 main = new Main250403();
		System.out.println(main.solution(n, board));
	}

	private int solution(int n, int[][] board) {
		int answerStudent = 0;
		int maxNum = Integer.MIN_VALUE;

		for(int student = 1; student <= n; student++) {
			HashSet<Integer> sameClassStudentSet = new HashSet<>();
			for(int grade = 1; grade <= 5; grade++){
				final int myClass = board[student][grade];

				for(int compareStudent = 1; compareStudent <= n; compareStudent++) {
					if(student == compareStudent) {
						continue;
					}
					final int compareClass = board[compareStudent][grade];
					if(myClass == compareClass) {
						sameClassStudentSet.add(compareStudent);
					}
				}
			}
			// System.out.println("current student: " + student + " / 같은반이었던 학생의 수 :" + sameClassStudentSet.size());
			if(maxNum < sameClassStudentSet.size()) {
				maxNum = sameClassStudentSet.size();
				answerStudent = student;
			}
		}
		return answerStudent;
	}
}
