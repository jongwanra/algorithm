package algorithm.sort_search.이분_검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-08
 *
 * 문제 접근 방법
 * 1. 오름 차순 정렬
 * 2. M이 정렬된 상태에서 몇 번쨰 있는지 이분 탐색으로 접근
 *
 */
public class Main250205 {
	public static void main(String[] args) throws IOException {
		Main250205 main = new Main250205();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int targetNum = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < n; index++) {
			arr[index]= Integer.parseInt(arrSt.nextToken());
		}
		System.out.println(main.solution(n, targetNum, arr));
	}

	private int solution(int n, int targetNum, int[] arr) {
		// 오름차순 정렬
		Arrays.sort(arr);
		int leftPos = 0;
		int rightPos = n - 1;

		while(leftPos <= rightPos) {
			final int middlePos = (rightPos + leftPos) / 2;
			final int middleNum = arr[middlePos];

			if(middleNum == targetNum) {
				return middlePos + 1;
			}

			if(middleNum < targetNum) {
				leftPos = middlePos + 1;
				continue;
			}

			rightPos = middlePos - 1;
		}

		return 0;
	}
}
