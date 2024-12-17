package 자바_알고리즘_문제풀이_입문.array.피보나치_수열;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-04
 *
 * 요약
 * 3 <= n <= 45
 * 시간 제한 1s
 * 메모리 제한 256mb
 *
 * 문제 접근 방법
 * 45까지 이기 때문에 46개 크기의 배열을 두고 값을 캐시해두자.
 *
 */
public class Main241126 {
	public static void main(String[] args) {
		Main241126 main = new Main241126();
		Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();

		// int[] answer = main.solution(n);
		main.lectureSolution(n);
		/*for(int index = 1; index <= n; index++) {
			System.out.print(answer[index] + " ");
		}*/

	}

	private int[] solution(int n) {
		int[] answer = new int[n + 1];
		answer[1] = 1;
		answer[2] = 1;

		for(int index = 3; index <= n; index++) {
			answer[index] = answer[index - 1] + answer[index - 2];
		}
		return answer;
	}

	// 배열을 사용하지 않는다는 조건이 있다면?
	private void lectureSolution(int n) {
		int a=1;
		int b=1;
		int c;
		System.out.print(a + " " + b + " ");
		for(int index = 2; index < n; index++) {
			c =  a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}


}
