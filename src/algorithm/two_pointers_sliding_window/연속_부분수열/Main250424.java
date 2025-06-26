package algorithm.two_pointers_sliding_window.연속_부분수열;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/03-04
 *
 * 연속 부분수열의 합이 m이 되는 경우가 몇 번 있는지 출력해야 함.
 *
 * 문제 접근 방법
 * O(n^2) 미만의 시간 복잡도 알고리즘으로 풀어야 한다.
 * Two Pointer 알고리즘으로 접근한다.
 *
 * leftPos와 rightPos를 두고
 * m보다 작을 경우 rightPos++
 * m보다 클 경우 leftPos++
 * 같을 경우 count++ & leftPos++
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(1)
 */
import java.io.*;
import java.util.*;
public class Main250424 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		Main250424 main = new Main250424();
		System.out.println(main.solution(n, m, arr));
	}

	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		int lt = 0;
		int sum = 0;
		for(int rt = 0; rt < n; rt++) {
			sum += arr[rt];

			while(sum >= m){
				if(sum == m) {
					answer++;
				}
				sum -= arr[lt];
				lt++;
			}
		}

		return answer;
	}

}
