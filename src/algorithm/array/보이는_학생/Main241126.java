package algorithm.array.보이는_학생;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-02
 *
 * 요약
 * 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 선생님이 볼 수 있는 학생의 수를 구하자.
 * 조건 1. 작거나 같으면 보이지 않음.
 * 조건 2. 5 <= n <= 100_000
 *
 * 문제 접근
 * 1. for 문을 돌면서 제일 큰 키를 담는다.
 * 2. 키가 크면, 담고 count++
 */
public class Main241126 {
	public static void main(String[] args) {
		Main241126 main = new Main241126();
		Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();
		int[] students = new int[n];

		for(int index = 0; index < n; index++) {
			students[index] = scanner.nextInt();
		}

		System.out.println(main.solution(n, students));

	}

	private int solution(int n, int[] students) {
		int biggest = students[0];
		int answer = 1;

		for(int index = 1; index < n; index++) {
			if(biggest < students[index]) {
				biggest = students[index];
				answer++;
			}
		}

		return answer;
	}
}
