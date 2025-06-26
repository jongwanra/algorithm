package algorithm.two_pointers_sliding_window.두_배열_합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/03-01
 *
 * 문제 접근 방법
 * 단순 merge sort를 하는 접근 방법으로 접근한다.
 * 이미 정렬이 되어 있기 때문에 두 배열의 크기에 맞춰 합칠 배열을 생성하고
 * 그 값을 포인트를 찍어서 비교한 다음에 우선순위에 맞게 넣어 준다.
 */
public class Main241209 {
	private int[] lectureSolution(int n, int m, int[] a, int[] b){
		List<Integer> answer = new ArrayList<>();
		int p1 = 0, p2=0;
		while(p1 < n && p2< m) {
			if(a[p1] <= b[p2]){
				answer.add(a[p1++]);
			}else {
				answer.add(b[p2++]);
			}
		}

		while(p1 < n) {
			answer.add(a[p1++]);
		}
		while(p2 < m){
			answer.add(b[p2++]);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();

	}
 	private int[] solution(int n, int m, int[] arrA, int[] arrB) {
		int[] answer = new int[n + m];
		int t = 0;
		int at = 0;
		int bt = 0;

		while(at < n && bt < m) {
			if(arrA[at] <= arrB[bt]) {
				answer[t++] = arrA[at++];
			}else {
				answer[t++] = arrB[bt++];
			}
		}


		while(at < n){
			answer[t++] = arrA[at++];
		}

		while(bt < m){
			answer[t++] = arrB[bt++];
		}

		return  answer;
	}

	public static void main(String[] args) throws IOException {
		Main241209 main = new Main241209();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++){
			arrA[index] = Integer.parseInt(stA.nextToken());
		}

		final int m = Integer.parseInt(br.readLine());
		int[] arrB = new int[m];
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int index = 0; index < m; index++){
			arrB[index] = Integer.parseInt(stB.nextToken());
		}

		int[] answer = main.solution(n, m, arrA, arrB);

		for(int ans: answer){
			System.out.print(ans + " ");
		}



	}


}
