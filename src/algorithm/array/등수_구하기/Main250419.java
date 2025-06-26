package algorithm.array.등수_구하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-08
 *
 * 입력된 순서대로 각 학생의 등수를 출력한다.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 문제 접근 방법
 * 1. 새로운 리스트를 내림차순으로 정렬한다.
 * 2. HashTable을 사용하여 등수를 정한다. (중복 주의)
 * 3. HashTable을 이용해서 등수를 출력한다.
 *
 * 시간 복잡도: O(n(log n))
 * 공간 복잡도: O(n)
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main250419 {
	public static void main(String[] args) throws IOException {
		Main250419 main =  new Main250419();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		List<Integer> answers = main.solution(n, arr);

		for(int answer: answers) {
			System.out.print(answer + " ");
		}

	}

	private List<Integer> solution(int n, int[] arr) {
		List<Integer> answers = new ArrayList<>();
		List<Integer> sortedList = Arrays.stream(arr)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());

		Map<Integer, Integer> map = new HashMap<>();
		int rank = 1;
		for(int index = 0; index < n; index++) {
			map.putIfAbsent(sortedList.get(index), rank++);
		}

		for(int index = 0; index < n; index++) {
			answers.add(map.get(arr[index]));
		}

		return answers;
	}
}
