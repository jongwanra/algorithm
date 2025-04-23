package 자바_알고리즘_문제풀이_입문.two_pointers_sliding_window.공통원소_구하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/03-02
 * 두 배열의 공통 원소를 오름차순으로 출력해야 한다.
 * 시간 제한: 1000ms
 * 문제 접근 방법
 * 정렬을 할 수 있는 TreeMap 이용해서 count가 2개 이상인 경우를 오름차순 출력한다.
 *
 * 시간 복잡도: O(n + m)
 * 공간 복잡도: O(n + m)
 */

import java.util.*;
import java.io.*;
public class Main250423 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arrA[index] = Integer.parseInt(stA.nextToken());
		}
		final int m = Integer.parseInt(br.readLine());
		int[] arrB = new int[m];
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int index = 0; index < m; index++) {
			arrB[index] = Integer.parseInt(stB.nextToken());
		}

		Main250423 main = new Main250423();
		List<Integer> answers  = main.solution(n, arrA, m, arrB);
		for(int answer: answers){
			System.out.print(answer + " ");
		}
	}


	private List<Integer> solution(int n, int[] arrA, int m, int[] arrB) {
		List<Integer> answers = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		// O(n)
		for(int index = 0; index < n; index++) {
			int value = map.getOrDefault(arrA[index], 0) + 1;
			map.put(arrA[index], value);
		}

		// O(m)
		for(int index = 0; index < m; index++) {
			int value = map.getOrDefault(arrB[index], 0) + 1;
			map.put(arrB[index], value);
		}

		// O(n + m)
		for(int key: map.keySet()){
			if(map.get(key) > 1) {
				answers.add(key);
			}
		}

		return answers;
	}

}
