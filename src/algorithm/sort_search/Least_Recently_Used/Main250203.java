package algorithm.sort_search.Least_Recently_Used;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제 링크
 * https://cote.inflearn.com/contest/10/problem/06-04
 *
 * 문제 접근 방법
 * LRU는 캐시 메모리 중 가장 오랫동안 사용하지 않는 요소를 제거하는 알고리즘을 의미한다.
 * Queue 자료구조를 사용해서 문제 접근한다.
 * 삽입할 경우에는 offer를 사용한다.
 * Cache Hit일 경우에는 요소를 중간에서 빼내고 가장 앞에 추가한다.
 */
public class Main250203 {
	public static void main(String[] args) throws IOException {
		Main250203 main = new Main250203();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int cacheSize = Integer.parseInt(st.nextToken());
		final int n = Integer.parseInt(st.nextToken());
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}
		List<Integer> answer = main.solution(cacheSize, n, arr);

		for (Integer ans : answer) {
			System.out.print(ans + " ");
		}
	}

	private List<Integer> solution(int cacheSize, int n, int[] arr) {
		Queue<Integer> cacheQueue = new ArrayDeque<>();

		for (int element: arr) {
			if(!cacheQueue.contains(element)) {
				cacheQueue.offer(element);
				if(cacheQueue.size() > cacheSize) {
					cacheQueue.poll();
				}
				continue;
			}

			cacheQueue.remove(element);
			cacheQueue.offer(element);
		}

		List<Integer> answer = cacheQueue.stream().collect(Collectors.toList());
		Collections.reverse(answer);
		return answer;
	}
}
