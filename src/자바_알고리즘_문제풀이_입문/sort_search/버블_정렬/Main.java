package 자바_알고리즘_문제풀이_입문.sort_search.버블_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크
 * https://cote.inflearn.com/contest/10/problem/06-02
 *
 * 문제 접근 방법
 * 버블 정렬로 오름차순 정렬한다.
 *
 * 버블 정렬 참고 링크
 * https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
 */

public class Main {
	public static void main(String[] args) throws IOException {
		Main main = new Main();
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
		for(int targetPosition = n - 1; targetPosition > 0; targetPosition--) {
			for(int currentPosition = 0; currentPosition < targetPosition; currentPosition++) {
				final int comparePosition = currentPosition + 1;
				if(arr[currentPosition] > arr[comparePosition]) {
					swap(arr, currentPosition, comparePosition);
				}
			}
		}
		return arr;
	}

	private void swap(int[] arr, int index, int compareIndex) {
		final int tmp = arr[index];
		arr[index] = arr[compareIndex];
		arr[compareIndex] = tmp;
	}
}
