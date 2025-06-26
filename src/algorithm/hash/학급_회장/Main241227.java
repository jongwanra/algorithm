package algorithm.hash.학급_회장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://cote.inflearn.com/contest/10/problem/04-01
 *
 * 문제 접근 방법
 * HashMap을 이용해서 풀면 접근하기 용이하겠지만, 다른 방법으로 해보자.
 * A, B, C, D, E를 5개의 크기를 가진 배열에 카운팅을 하자.
 * x - 'A'를 이용해서 index를 구할 수 있다.
 */
public class Main241227 {
	// Map을 사용해서도 풀어보자.
	private char solution2(int n, char[] arr) {
		Map<Character, Integer> cache = new HashMap<>(5);

		for(char c: arr){
			cache.put(c, cache.getOrDefault(c, 0) + 1);
		}

		// 가장 큰 걸 반환하자.
		char answer = 'A';
		int max = Integer.MIN_VALUE;

		for (Character c : cache.keySet()) {
			if(cache.get(c) > max) {
				max = cache.get(c);
				answer = c;
			}
		}

		return answer;
	}
	private char solution(int n, char[] arr) {
		int max = Integer.MIN_VALUE;
		char answer = 'A';
		int[] cache = new int[5];

		for(char c: arr){
			++cache[c - 'A'];
		}

		for(int index = 0; index < 5; index++) {
			if(cache[index] > max) {
				max = cache[index];
				answer = (char) (index + 'A');
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		Main241227 main = new Main241227();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		final String line = br.readLine();
		System.out.println(main.solution2(n, line.toCharArray()));


	}
}
