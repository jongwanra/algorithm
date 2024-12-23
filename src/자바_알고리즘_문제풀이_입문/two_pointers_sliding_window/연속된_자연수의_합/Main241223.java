package 자바_알고리즘_문제풀이_입문.two_pointers_sliding_window.연속된_자연수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://cote.inflearn.com/contest/10/problem/03-05
 *
 * 문제 접근 방법
 * 투 포인터 알고리즘을 사용해서 문제를 접근한다.
 * n 보다 작은 경우 total 에 추가하면서 rp++
 * n과 같은 경우 answer++, total에서 빼면서 lp++
 * n보다 작은 경우 total에서 빼면서 lp++
 */
public class Main241223 {

	public static void main(String[] args) throws IOException {
		Main241223 main = new Main241223();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		System.out.println(main.solution(n));
	}
	private int solution(int n) {
		int answer = 0;
		int total = 0;
		int lp = 1;

		for(int rp = 1; rp < n; rp++) {
			total += rp;

			while(total >= n) {
				if(n == total) {
					answer++;
				}
				total -= lp;
				lp++;
			}
		}

		return answer;
	}

	// 수학 공식으로 문제 풀기
	// m개의 연속된 자연수를 구할 때,
	// n에서 (1 ~ m) 까지의 수를 뺀 이후에 m으로 나눴을 때 나머지가 없는 경우,
	// 연속된 자연수로 판단한다.
	private int solution2(final int n) {
		int answer = 0;
		int cnt = 1;

		return answer;
	}


}
