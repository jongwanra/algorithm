package algorithm.two_pointers_sliding_window.최대_길이_연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/03-06
 *
 * 문제 해결 방법
 * 최대 0 -> 1로 변경할 수 있는 n + 0 이전 혹은 배열 마지막 요소 까지 윈도우 크기를 늘린다.
 * 크기를 체크한다. 크기가 더 큰 윈도우라면 갱신
 * 처음 0의 다음 포인터로 옮긴다.
 * 반복한다.
 *
 */
public class Main250409 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken()); // 0 -> 1 변경 가능한 개수
		int[] arr = new int[n];

		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		Main250409 main = new Main250409();
		System.out.println(main.solution2(n, k, arr));

	}

	private int solution(int n, int k, int[] arr) {
		int answer = Integer.MIN_VALUE;
		int count = 0;
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				count++;
			}
			if(count == k && (rt + 1 < n && arr[rt + 1] == 1)) {
				continue;
			}

			answer = Math.max(answer, rt - lt + 1);
			while(count == k) {
				if(arr[lt] == 0) {
					count--;
				}
				lt++;
			}


		}

		return answer;
	}

	private int solution2(int n, int k, int[] arr) {
		int answer = Integer.MIN_VALUE;
		int count = 0;
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				count++;
			}
			while(count > k) {
				if(arr[lt] == 0) {
					count--;
				}
				lt++;
			}

			answer = Math.max(answer, rt - lt + 1);

		}

		return answer;
	}
}
