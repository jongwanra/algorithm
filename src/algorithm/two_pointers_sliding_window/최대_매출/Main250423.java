package algorithm.two_pointers_sliding_window.최대_매출;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/03-03
 *
 * 연속된 k일 동안의 최대 매출액이 얼마인지 구하자.
 * 문제 접근 방법
 * O(n)으로 문제를 해결하자.
 * Sliding Window 알고리즘을 사용한다.
 * 2개는 초기에 셋팅하고 아래를 반복 하는 반복문을 구현한다.
 * * sum을 구한다.
 * * max를 구한다.
 * * lt를 뺀다.
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(1)
 */
import java.io.*;
import java.util.*;
public class Main250423 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}
		Main250423 main = new Main250423();
		System.out.println(main.solution(n, k, arr));

	}

	private int solution(int n, int k, int[] arr) {
		int answer = Integer.MIN_VALUE;
		int sum = 0;
		for(int index = 0; index < k - 1; index++) {
			sum += arr[index];
		}

		int leftPos = 0;
		for(int rightPos = k - 1; rightPos < n; rightPos++) {
			sum += arr[rightPos];
			answer = Math.max(answer, sum);
			sum -= arr[leftPos++];
		}

		return answer;
	}
}
