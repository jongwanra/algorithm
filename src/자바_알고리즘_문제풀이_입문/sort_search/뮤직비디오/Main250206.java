package 자바_알고리즘_문제풀이_입문.sort_search.뮤직비디오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-09
 *
 * 문제 접근 방법
 * DVD의 최소 용량 크기를 구하는 문제.
 * DVD m개가 주어졌을 떄 들어갈 수 있는 최소 용량.
 * Binary Search를 최소 용량을 찾는 것에 초점을 둔다.
 * DVD의 최소 용량은 주어진 배열 요소 중 가장 최대값
 * DVD의 최대 용량은 주어진 요소를 전부 더한 합계 값.
 *
 */
public class Main250206 {

	public static void main(String[] args) throws IOException {
		Main250206 main = new Main250206();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer arrSt = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}

		System.out.println(main.solution(n, m, arr));
	}

	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		int leftCapacity = Arrays.stream(arr).max().getAsInt();
		int rightCapacity = Arrays.stream(arr).sum();

		while(leftCapacity <= rightCapacity) {
			final int dvdCapacity = (leftCapacity + rightCapacity) / 2;

			if(isPossibleDvdCapacity(arr, m, dvdCapacity)) {
				// 가능하다면 최소 용량을 찾아야 하기 때문에 왼쪽만 살린다.
				rightCapacity = dvdCapacity - 1;
				answer = dvdCapacity;
				continue;
			}

			leftCapacity = dvdCapacity + 1;
		}
		return answer;
	}

	private boolean isPossibleDvdCapacity(int[] arr, int dvdCount, int dvdCapacity) {
		int usedDvdCount = 1;
		int sum = 0;

		for(int x: arr) {
			if(sum + x <= dvdCapacity) {
				sum = sum + x;
				continue;
			}
			usedDvdCount++;
			sum = x;
		}

		return usedDvdCount <= dvdCount;
	}
}
