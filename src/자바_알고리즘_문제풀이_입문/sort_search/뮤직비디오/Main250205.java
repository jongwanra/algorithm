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
 * 결정 알고리즘.
 * DVD의 최소 용량 크기를 찾는다.
 */
public class Main250205 {
	public static void main(String[] args) throws IOException {
		Main250205 main = new Main250205();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int minNum = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < n; index++) {
			arr[index]= Integer.parseInt(arrSt.nextToken());
		}
		System.out.println(main.solution(n, minNum, arr));
	}

	private int solution(int n, int givenDvdNum, int[] arr) {
		int leftNum = 1;
		int rightNum = Arrays.stream(arr).sum();
		int answer = Integer.MAX_VALUE;
		while(leftNum <= rightNum) {
			final int middleNum = (leftNum + rightNum) / 2;
			if(isPossible(arr, givenDvdNum, middleNum)){
				answer = Math.min(answer, middleNum);
				rightNum = middleNum - 1;
				continue;
			}

			leftNum = middleNum + 1;

		}

		return answer;
	}

	private boolean isPossible(int[] arr, int givenDvdNum, int dvdSize) {
		int count = 1;
		int sum = 0;
		for(int index = 0; index < arr.length; index++) {
			if(sum + arr[index] <= dvdSize) {
				sum = sum + arr[index];
				continue;
			}
			count++;
			sum = arr[index];
		}

		return count <= givenDvdNum;
	}

	public int lectureSolution(int n, int m, int[] arr) {
		int answer = 0;
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();

		while(lt <= rt) {
			final int mid = (lt + rt) / 2;
			if(count(arr, mid) <= m){
				answer = mid;
				rt = mid - 1;
			}else {
				lt = mid + 1;
			}
		}

		return answer;
	}

	private int count(int[] arr, int capacity) {
		int count = 1;
		int sum = 0;
		for(int x: arr) {
			if(sum + x > capacity){
				count++;
				sum = x;
			} else sum += x;
		}

		return count;
	}
}
