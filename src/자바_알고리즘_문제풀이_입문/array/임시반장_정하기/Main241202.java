package 자바_알고리즘_문제풀이_입문.array.임시반장_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-11
 *
 * 문제 접근 방법
 * 한번이라도 같은 반이었던 사람이 가장 많은 학셍을 임시 반장으로 선출
 * 동일한 학생 수 일경우 가장 작은 번호를 출력
 *
 * 1. n학년일 때 각 반에 몇 명이 있는지를 배열로 나타낸다.
 * 2. 1번 학생 부터 순차적으로 n학년까지 몇 명과 같은 반이였는지 갯수를 나타내고 클 경우에 교체한다.
 */
public class Main241202 {
	public static void main(String[] args) throws IOException {
		Main241202 main = new Main241202();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		final int grade = 5;
		// 학생 수와 학년을 0을 포함하지 않고 만든다.
		int[][] matrix = new int[n + 1][grade + 1];

		for(int row = 1; row <= n; row++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);

			for(int col = 1; col <= grade; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(main.solution2(n, grade, matrix));
	}

	// 못 풀어서 강의 보고 구현
	private int solution2(int n, int grade, int[][] matrix) {
		int student = 0;
		int maxNum = Integer.MIN_VALUE;
		for(int iStudent = 1; iStudent <= n; iStudent++) {
			int count = 0;
			for(int jStudent = 1; jStudent <=n; jStudent++) {
				for(int kGrade = 1; kGrade <= grade; kGrade++) {
					if(matrix[iStudent][kGrade] == matrix[jStudent][kGrade]) {
						count++;
						break;
					}
				}
			}
			if(count > maxNum) {
				maxNum = count;
				student = iStudent;
			}
		}
		return student;
	}

	private int solution(int n, int grade, int[][] matrix) {
		// n학년마다 각 반에 몇 명이 있었는지 나타내는 배열
		int[][] classesForGrade = new int[grade][9];


		// n = 학생 수
		for(int row = 0; row < n; row++) {
			// grade = 학년
			for(int col = 0; col < grade; col++) {
				final int classNum = matrix[row][col] - 1;
				classesForGrade[col][classNum]++;
			}
		}

		for(int row = 0; row < n; row++) {
			System.out.println(Arrays.toString(classesForGrade[row]));
		}

		int answer = Integer.MIN_VALUE;
		int studentAnswer = 0;

		// 학생별
		for(int row = 0; row < n; row++) {
			int[] studentClasses = matrix[row];
			int sum = 0;
			for(int index = 0; index < grade; index++) {
				int studentClass = studentClasses[index] - 1;
				sum += (classesForGrade[index][studentClass] - 1); // 나를 제외하고
			}
			System.out.println("학생 번호: " + (row + 1) + " / 나를 아는 학생 수: " + sum);
			if(answer < sum){
				answer = sum;
				studentAnswer = row + 1;
			}
		}

		return studentAnswer;
	}



}
