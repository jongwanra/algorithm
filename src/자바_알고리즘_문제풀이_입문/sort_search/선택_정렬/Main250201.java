package 자바_알고리즘_문제풀이_입문.sort_search.선택_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/06-01
 * 문제 접근 방법
 * 오름차순 정렬.
 * 이중 포문을 돈다.
 * 포문을 돌면서 선택한 index와 가장 최소값을 비교해서 swaping한다.
 *
 * 선택 정렬 참고 링크
 * https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
 */
public class Main250201 {
	public static void main(String[] args) throws IOException {
		Main250201 main = new Main250201();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int[] arr = new int[n];
		for(int index = 0 ; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}
		int[] answer = main.solution(n, arr);

		for(int ans: answer) {
			System.out.print(ans + " ");
		}
	}

	private int[] solution(int n, int[] arr) {
		for(int targetIndex = 0; targetIndex < n; targetIndex++){
			final int minIndex = findMinIndex(n, arr, targetIndex);
			swap(arr, targetIndex, minIndex);
		}
		return arr;
	}

	private void swap(int[] arr, int targetIndex, int minIndex) {
		int tmp = arr[targetIndex];
		arr[targetIndex] = arr[minIndex];
		arr[minIndex] = tmp;
	}

	private int findMinIndex(int n, int[] arr, int targetIndex) {
		int minIndex = targetIndex;

		for(int index = targetIndex + 1; index < n; index++){
			if(arr[minIndex] > arr[index]) {
				minIndex = index;
			}
		}
		return minIndex;
	}
}
