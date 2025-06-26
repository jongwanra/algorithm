package algorithm.two_pointers_sliding_window.연속_부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/03-04
 *
 * 문제 접근 방법
 * Sliding Window 알고리즘으로 접근한다.
 * for문을 돌면서 부분 수열의 합이 일치하는 갯수를 카운트한다.
 */
public class Main241211 {
	public static void main(String[] args) throws IOException {
		Main241211 main = new Main241211();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitLine = br.readLine().split(" ");
		final int n = Integer.parseInt(splitLine[0]);
		final int m = Integer.parseInt(splitLine[1]);
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		System.out.println(main.solution(n, m , arr));
	}

	private int solution(int n, int m, int[] arr) {
		int cnt = 0;
		int lp = 0;
		int window = 0;

		for(int rp = 0; rp < n; rp++) {
			window += arr[rp];
			while (window >= m) {
				if(window == m ){
					cnt++;
				}
				window -= arr[lp++];
			}
		}
		return cnt;
	}

	private int lectureSolution(int n, int m, int[] arr) {
		int cnt = 0;
		int lp = 0;
		int window = 0;

		for(int rp = 0; rp < n; rp++) {
			window += arr[rp];
			if(window == m) {
				cnt++;
			}

			while (window >= m) {
				window -= arr[lp++];

				if(window == m ){
					cnt++;
				}

			}
		}
		return cnt;
	}
}
