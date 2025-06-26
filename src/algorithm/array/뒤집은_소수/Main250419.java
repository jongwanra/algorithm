package algorithm.array.뒤집은_소수;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-06
 *
 * 숫자를 뒤집어서 소수임을 판별하는 문제이다.
 *
 * 문제 접근 방법
 * 1. 주어진 요소를 뒤집어서 배열에 저장 및 maximum을 확인한다.
 * 2. 에라토스테네스의 체로 maximum까지 구한다.
 * 3. 소수인 수를 저장 및 출력한다.
 *
 * 시간 복잡도: O(n + m(log(log(m)))
 * 공간 복잡도: O(n + m)
 */

import java.io.*;
import java.util.*;

public class Main250419 {
	public static void main(String[] args) throws IOException {
		Main250419 main = new Main250419();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			String element = st.nextToken();

			arr[index] = Integer.parseInt(new StringBuilder(element)
				.reverse()
				.toString()
			);
		}

		List<Integer> answers = main.solution(n, arr);
		for(int answer: answers){
			System.out.print(answer + " ");
		}
	}

	// 시간 복잡도: O(n + (m log log m))
	private List<Integer> solution(int n, int[] arr) {
		int maxValue = Integer.MIN_VALUE;

		// O(n)
		for(int index = 0; index < n; index++) {
			if(maxValue < arr[index]) {
				maxValue = arr[index];
			}
		}

		// O(m log log m)
		boolean[] isPrimes  = new boolean[maxValue + 1];
		Arrays.fill(isPrimes, true);
		isPrimes[0] = false;
		isPrimes[1] = false;

		for(int num = 2; num <= Math.sqrt(maxValue); num++) {
			if(isPrimes[num]) {
				for(int nextNum = num + num; nextNum <= maxValue; nextNum += num) {
					isPrimes[nextNum] = false;
				}
			}
		}
		List<Integer> answers = new ArrayList<>();

		for(int index = 0; index < n; index++) {
			if(isPrimes[arr[index]]) {
				answers.add(arr[index]);
			}
		}
		return answers;
	}

}
