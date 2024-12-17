package 자바_알고리즘_문제풀이_입문.two_pointers_sliding_window.최대_매출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/03-03
 *
 * 문제 접근 방법
 *
 * 슬라이딩 윈도우 알고리즘을 이용해서 구한다.
 * lp, rp 변수를 두고 for문을 돌면서
 * 진입 시, rp는 nextIndex의 값을 더하고, lp는 현재의 값을 감소하고 다음으로 옮긴다.
 */
public class Main241211 {
	public static void main(String[] args) throws IOException {
		Main241211 main = new Main241211();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitLine = br.readLine().split(" ");
		final int n = Integer.parseInt(splitLine[0]);
		final int k = Integer.parseInt(splitLine[1]);

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++){
			arr[index] = Integer.parseInt(st.nextToken());
		}

		System.out.println(main.solution2(n, k, arr));
	}

	private int solution(int n, int k, int[] arr) {
		int lp = 0;
		int rp = k - 1;
		int currentWindow = 0;

		// 초기 window 구하기
		for(int index = lp; index <= rp; index++) {
			currentWindow += arr[index];
		}

		int answer = currentWindow;


		while(rp < n - 1) {
			currentWindow += arr[++rp];
			currentWindow -= arr[lp++];
			// System.out.println("currentWindow: " +  currentWindow + " lp: " + lp + " rp: " + rp);
			answer = Math.max(answer, currentWindow);
		}
		return answer;
	}

	private int solution2(int n, int k, int[] arr) {
		int lp = 0;
		int currentWindow = 0;

		// 초기 window 구하기
		for(int index = lp; index <= k - 1; index++) {
			currentWindow += arr[index];
		}

		int answer = currentWindow;


		for(int rp = k; rp < n; rp++) {
			currentWindow += arr[rp];
			currentWindow -= arr[lp++];
			answer = Math.max(answer, currentWindow);
		}
		return answer;
	}

	private int lectureSolution(int n, int k, int[] arr) {
		int sum = 0;

		// 초기 window 구하기
		for(int index = 0; index <= k - 1; index++) {
			sum += arr[index];
		}

		int answer = sum;

		for(int rp = k; rp < n; rp++) {
			sum += arr[rp];
			sum -= arr[rp - k];
			answer = Math.max(answer, sum);
		}
		return answer;
	}
}
