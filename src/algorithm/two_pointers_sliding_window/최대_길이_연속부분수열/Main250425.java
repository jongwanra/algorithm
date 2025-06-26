
package algorithm.two_pointers_sliding_window.최대_길이_연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/03-06
 *
 * 최대 k번을 0 -> 1로 변경할 수 있다.
 * 1로만 구성된 최대 길이의 연속부분수열을 찾자.
 *
 * 문제 접근 방법
 * two pointer 알고리즘을 사용한다.
 * 반복문을 돌린다.
 * 1. arr[rt] == 0, count++
 * 2. count > k 경우에 반복문을 돌면서 arr[lt] == 0인 경우 count--
 * 3. 매번 최대 거리를 계산한다.
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(1)
 *
 */
public class Main250425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		Main250425 main = new Main250425();
		System.out.println(main.solution(n, k, arr));
	}

	private int solution(int n, int k, int[] arr) {
		int answer = Integer.MIN_VALUE;
		int lt = 0;
		int count = 0;

		for (int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				count++;
			}

			while(count > k) {
				if(arr[lt] == 0) {
					count--;
				}
				lt++;
			}

			final int distance = rt - lt + 1;
			answer = Math.max(answer, distance);
		}

		return answer;
	}

}
