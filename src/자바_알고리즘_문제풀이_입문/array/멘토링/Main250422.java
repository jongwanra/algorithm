package 자바_알고리즘_문제풀이_입문.array.멘토링;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-12
 *
 * 멘토 멘티의 조건: 멘토는 M번의 수학테스트에서 모두 멘티보다 등수가 앞서야 함.
 *
 * M번의 수학성적이 주어지면 멘토/멘티 짝 만들 수 있는 경우의 수
 *
 * 학생 수: n
 * 시험 수: m
 *
 * 문제 접근 방법
 * 학생 수에 맞춰서 이 중 포문을 만든다.
 * 시험 문제 만큼 반복문을 돌린다.
 *
 * 반 학생 수(20) * 반 학생 수(20) * 시험 횟수(10)
 * 3중 포문으로도 접근 가능하다.
 *
 * 시간 복잡도: O(n^3 * m)
 * 공간 복잡도: O(1)
 */
import java.util.*;
import java.io.*;
public class Main250422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int studentNum = Integer.parseInt(st.nextToken());
		final int testNum = Integer.parseInt(st.nextToken());
		int[][] board = new int[testNum][studentNum];

		for(int row = 0; row < testNum; row++ ){
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int col = 0; col < studentNum; col++) {
				board[row][col] = Integer.parseInt(stArr.nextToken());
			}
		}

		Main250422 main = new Main250422();
		System.out.println(main.solution(studentNum, testNum, board));
	}

	private int solution(int studentNum, int testNum, int[][] board) {
		int answer = 0;

		for(int mentor = 1; mentor <= studentNum; mentor++) {
			for(int mentee = 1; mentee <= studentNum; mentee++) {
				if(mentor == mentee) {
					continue;
				}
				boolean isMatched = true;
				for(int test = 0; test < testNum; test++) {
					final int mentorRank = findRank(board, test, mentor);
					final int menteeRank = findRank(board, test, mentee);
					if(mentorRank > menteeRank) {
						isMatched = false;
						break;
					}
				}
				if(isMatched) {
					answer++;
				}
			}
		}

		return answer;
	}

	private int findRank(int[][] board, int test, int target) {
		for(int index = 0; index < board[0].length; index++)  {
			if(board[test][index] == target) {
				return index + 1;
			}
		}

		return 0;
	}

}
