package 자바_알고리즘_문제풀이_입문.hash.매출액의_종류;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/04-03
 *
 * 매출액의 종류를 출력한다.
 * 문제 접근 방법
 * HashMap을 통해서 구간별 매출액의 종류를 구한다.
 * count == 0이 될경우에는 삭제한다.
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(n)
 */

import java.util.*;
import java.io.*;
public class Main250428 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		Main250428 main = new Main250428();

		for(int answer:main.solution(n, k, arr)){
			System.out.print(answer + " ");
		}

	}


	private List<Integer> solution(int n, int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> answers = new ArrayList<>();

		for(int index = 0; index < k - 1; index++) {
			map.put(arr[index], map.getOrDefault(arr[index], 0) + 1);
		}


		int lt = 0;
		for(int rt = k - 1; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

			answers.add(map.size());

			Integer value = map.get(arr[lt]);
			if(value == 1) {
				map.remove(arr[lt]);
			}else {
				map.put(arr[lt], value - 1);
			}
			lt++;
		}

		return answers;
	}

}
