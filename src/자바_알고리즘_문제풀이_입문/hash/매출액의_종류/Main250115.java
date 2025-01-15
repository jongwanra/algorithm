package 자바_알고리즘_문제풀이_입문.hash.매출액의_종류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제: https://cote.inflearn.com/contest/10/problem/04-03
 * 문제 접근 방법
 * 1. lt, rt를 두고 k구간을 유지한다.
 * 2. HashMap을 생성하고 각 k구간 동안의 개수를 카운팅한다.
 */
public class Main250115 {
	private List<Integer> solution(int n, int k, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> store = new HashMap<>();
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			final int distance = rt - lt + 1;
			Integer value = store.getOrDefault(arr[rt], 0);
			store.put(arr[rt], value + 1);
			// 거리가 같아진 경우
			if(distance == k) {
				answer.add(store.values().size());
				store.put(arr[lt], store.getOrDefault(arr[lt], 0) - 1);
				if(store.get(arr[lt]) <= 0) {
					store.remove(arr[lt]);
				}
				lt++;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		Main250115 main = new Main250115();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String[] splitLine = br.readLine().split(" ");
		final int n = Integer.parseInt(splitLine[0]);
		final int k = Integer.parseInt(splitLine[1]);
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		for (Integer v : main.solution(n, k, arr)){
			System.out.print(v + " ");
		}

	}
}
