package 자바_알고리즘_문제풀이_입문.hash.K번째_큰_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/04-05
 * 문제 접근 방법
 * 1. 3중 포문을 통해 모든 경우에수를 넣는다.
 * 2. 최대힙에서 K번째 큰 수를 추출한다. (중복 제거 필요)
 * 3. 없다면 -1을 출력한다.
 */
public class Main250122 {
	private int solution(int n, int k, int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int l = j + 1; l < n; l++) {
					final int sum = arr[i] + arr[j] + arr[l];
					heap.offer(sum);
				}
			}
		}

		for (int index = 1; index <= k; index++) {
			if (heap.isEmpty()) {
				return -1;
			}

			Integer answer = heap.poll();
			if (index == k) {
				return answer;
			}
			while (answer.equals(heap.peek())) {
				heap.poll();
			}

		}
		return -1;
	}

	// 정렬 순서 보장해주는 TreeSet을 이용하면 더 쉽게 풀 수 있을 것 같다.
	private int solution2(int n, int k, int[] arr) {
		TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int l = j + 1; l < n; l++) {
					final int sum = arr[i] + arr[j] + arr[l];
					treeSet.add(sum);
				}
			}
		}

		int count = 0;
		for (Integer value : treeSet) {
			count++;
			if (count == k) {
				return value;
			}
		}

		return -1;

	}

	public static void main(String[] args) throws IOException {
		Main250122 main = new Main250122();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitLine = br.readLine().split(" ");
		final int n = Integer.parseInt(splitLine[0]);
		final int k = Integer.parseInt(splitLine[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		System.out.println(main.solution2(n, k, arr));
	}
}
