package 자바_알고리즘_문제풀이_입문.array.멘토링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-12
 *
 *  m번의 수학 테스트
 *  m번의 수학 테스트에서 등수가 모두 앞서야 멘토-멘티 관계가 가능하다.
 *  문제 접근 방법
 *  1. 총 3중 포문을 돈다.
 *  * mento, test, mentee
 *  * test에서 해당 mento를 찾고 그 이후의 값을 전부 cache에 기록 시킨다.
 *  * 반복문을 전부 돈 다음에 해당 캐시와 m번의 테스트의 크기가 같은지 비교해서 경우의 수를 찾는다.
 */
public class Main241205 {
	private int lectureSolution(int[][] matrix, int studentCount, int testCount) {
		int answer = 0;
		for(int mentor = 1; mentor <= studentCount; mentor++) {
			for(int mentee = 1; mentee <= studentCount; mentee++) {
				int count = 0;
				for(int test = 1; test <= testCount; test++) {
					int mentorRank = 0;
					int menteeRank = 0;
					for(int index = 1; index <= studentCount; index++) {
						if(mentor == matrix[test][index]) {
							mentorRank = index;
						}
						if(mentee == matrix[test][index]){
							menteeRank = index;
						}
					}
					if(mentorRank < menteeRank) {
						count++;
					}
				}

				if(count == testCount) {
					answer++;
				}
			}
		}
		return  answer;
	}
	private int solution(int[][] matrix, int studentCount, int testCount) {
		int answer = 0;
		for(int mentor = 1; mentor <= studentCount; mentor++) {
			int[] cache = new int[studentCount + 1];
			for(int test = 1; test <= testCount; test++) {
				 int mentorIndex = fetchIndexOf(mentor, matrix[test]);
				 for(int index = mentorIndex + 1; index <=  studentCount; index++) {
					 final int menteeCandidate = matrix[test][index];
					 cache[menteeCandidate]++;
				 }
			}

			for(int index = 1; index <= studentCount; index++) {
				if(cache[index] == testCount) {
					answer++;
				}
			}
		}
		return answer;
	}

	private int fetchIndexOf(int mentor, int[] arr) {
		for(int index = 1; index <= arr.length; index++) {
			if(arr[index] == mentor) {
				return index;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		Main241205 main = new Main241205();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer firstSt = new StringTokenizer(br.readLine());
		final int studentCount = Integer.parseInt(firstSt.nextToken());
		final int testCount = Integer.parseInt(firstSt.nextToken());

		int[][] matrix = new int[testCount + 1][studentCount + 1];

		for(int row = 1; row <= testCount; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= studentCount; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(main.lectureSolution(matrix, studentCount, testCount));

	}



}
