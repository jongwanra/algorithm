package 자바_알고리즘_문제풀이_입문.dynamic_programming.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-01
 *
 * 문제 접근 방법
 * 문제에는 규칙이 있다.
 *
 * i 번째 계단의 경우의 수 = i - 1 번째 계단 경우의 수 + i - 2 번째 계단 경우의 수이다.
 * 이걸 이용해서 풀어보자.
 */
public class Main250320 {
	private static int[] cache;
	public static void main(String[] args) throws IOException {
		Main250320 main = new Main250320();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		cache = new int[n + 1];
		System.out.println(main.solutionBottomToTop(n));
	}

	private int solutionTopToBottom(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}

		if(cache[n] != 0) {
			return cache[n];
		}

		return cache[n] = solutionTopToBottom(n - 1) + solutionTopToBottom(n - 2);
	}

	private int solutionBottomToTop(int n) {
		int[] cache = new int[n + 1];
		cache[1] = 1;
		cache[2] = 2;
		for(int index = 3; index <= n; index++) {
			cache[index] = cache[index - 1] + cache[index - 2];
		}

		return cache[n];
	}

}
