package 자바_알고리즘_문제풀이_입문.array.임시반장_정하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-11
 *
 * 한 번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 선출
 * 학생 수: 3 ~ 1000이하
 * 반 수: 1 ~ 9
 * 동일한 학생이 여러 명인 경우 가장 작은 번호만 출력한다.
 *
 * 문제 접근 방법
 * n번 학생이 n번 학생과 같은 반이 었던 적이 있는지를 찾는다.
 *
 * 시간 복잡도: O(5 * n^2) -> O(n^2)
 * 공간 복잡도: O(1)
 */
import java.io.*;
import java.util.*;

public class Main250422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int studentNum = Integer.parseInt(br.readLine());
		final int[][] board = new int[studentNum + 1][6];
		for(int row = 1; row <= studentNum; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= 5; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}


		Main250422 main = new Main250422();
		System.out.println(main.solution(studentNum, board));

	}

	private int solution(int studentNum, int[][] board) {
		int answerStudent = 0;
		int maxMatchingCount = 0;

		for(int student = 1; student <= studentNum; student++){
			int matchingCount = 0;
			for(int compareStudent = 1; compareStudent <= studentNum; compareStudent++) {
				boolean isMatched = false;
				for(int grade = 1; grade <= 5; grade++) {
					if(board[student][grade] == board[compareStudent][grade]) {
						isMatched = true;
						break;
					}
				}
				if(isMatched){
					matchingCount++;
				}
			}
			if(matchingCount > maxMatchingCount) {
				maxMatchingCount = matchingCount;
				answerStudent = student;
			}
		}
		return answerStudent;
	}
}
