package 자바_알고리즘_문제풀이_입문.dynamic_programming.최대_부분_증가수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-03
 *
 * 문제 접근 방법
 * 최대 부분 증가수열
 * 1. dy 배열을 하나 더 생성한다.
 * 2. dy 배열의 i번째 요소의 의미는 arr의 i번째 숫자를 마지막으로 했을 때의 최대 길이다.
 * 3. 현재 요소가 이번 요소보다 큰 경우를 찾으면서 비교해서 제일 큰 값을 넣는다.
 * 4. 가장 길이간 긴 케이스도 같이 기록해둔다.
 */
public class Main250325 {
	public static void main(String[] args) throws IOException {
		Main250325 main = new Main250325();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		System.out.println(main.solution(n, arr));
	}

	private int solution(int n, int[] arr) {
		int[] dy = new int[n];
		int answer = 1;
		dy[0] = 1;

		for(int index = 1; index < n; index++) {
			int maxLength = 1;
			for(int comparePos = 0; comparePos < index; comparePos++) {
				if(arr[index] > arr[comparePos]) {
					maxLength = Math.max(maxLength, dy[comparePos] + 1);
				}
			}
			dy[index] = maxLength;
			answer = Math.max(answer, maxLength);
		}

		return answer;
	}
}
