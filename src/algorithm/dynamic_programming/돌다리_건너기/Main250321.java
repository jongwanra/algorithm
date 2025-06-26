package algorithm.dynamic_programming.돌다리_건너기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-02
 *
 * 문제 접근 방법
 * 1 -> 2
 * 2 -> 3
 * ...
 * n = (n-1) + (n-2) 이다.
 *
 * Dynamic Programming Bottom Up 방식으로 접근한다.
 */
public class Main250321 {
	public static void main(String[] args) throws IOException {
		Main250321 main = new Main250321();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		System.out.println(main.solution(n));
	}

	private int solution(int n) {
		int[] cache = new int[n + 1];
		cache[1] = 2;
		cache[2] = 3;

		for(int index = 3; index <= n; index++) {
			cache[index] = cache[index - 1] + cache[index - 2];
		}

		return cache[n];
	}
}
