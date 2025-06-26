package algorithm.array.뒤집은_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-06
 *
 * 문제 접근 방법
 * 1. int[]를 String[]로 받고 문자열을 뒤집고, Integer.valueOf()를 한다.
 * 2. 그 중 가장 큰 수를 구한다.
 * 3. 가장 큰 수 만큼 에라토스테네스의 체로 소수를 구한다.
 * 4. 배열 조회를 통해 찾는다.
 */
public class Main241127 {
	public static void main(String[] args) throws IOException {
		Main241127 main = new Main241127();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		List<Integer> answer = main.lectureSolution(n, arr);

		for (Integer num : answer) {
			System.out.print(num + " ");
		}

	}

	private List<Integer> solution(int n, int[] arr) {
		int[] reversedArr = new int[n];
		int maxNum = 0;
		for(int index = 0; index < n; index++) {
			reversedArr[index] = Integer.parseInt(new StringBuilder(String.valueOf(arr[index])).reverse().toString());
			maxNum = Math.max(reversedArr[index], maxNum);
		}

		boolean[] cache = new boolean[maxNum + 1];
		for(int index = 2; index < maxNum + 1; index++) {
			cache[index] = true;
		}

		for(int num = 2; num < maxNum + 1; num++) {
			if(cache[num]) {
				for(int jNum = num + num; jNum < maxNum + 1; jNum += num){
					cache[jNum] = false;
				}
			}
		}
		List<Integer> answer = new ArrayList<>();
		for(int reversedNum: reversedArr) {
			if(cache[reversedNum]) {
				answer.add(reversedNum);
			}
		}
		return answer;
	}

	private List<Integer> lectureSolution(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i <n; i++) {
			int tmp = arr[i];
			int res = 0;
			while(tmp > 0) {
				int t = tmp % 10;
				res = res * 10 + t;
				tmp = tmp/10;
			}
			if(isPrime(res))  {
				answer.add(res);
			}

		}
		return answer;
	}

	private boolean isPrime(int num) {
		if(num == 1) return false;

		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
