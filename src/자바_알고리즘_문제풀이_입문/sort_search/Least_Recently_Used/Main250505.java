package 자바_알고리즘_문제풀이_입문.sort_search.Least_Recently_Used;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-04
 *
 * 문제 접근 방법
 * LRU 알고리즘에서 cache Hit cache Miss에 대한 구현을 삽입을 이용해서 처리한다.
 * 단순 구현 문제이다.
 *
 * cacheSize => n
 * taskSize => m
 * 시간 복잡도: O(m * n)
 * 공간 복잡도: O(n)
 */
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main250505 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int cacheSize = Integer.parseInt(inputs[0]);
		final int taskNum = Integer.parseInt(inputs[1]);

		int[] tasks = new int[taskNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < taskNum; index++ ){
			tasks[index] = Integer.parseInt(st.nextToken());
		}

		Main250505 main = new Main250505();
		List<Integer> answers = main.solutionWithQueue(cacheSize, tasks);

		for(int answer: answers) {
			System.out.print(answer + " ");
		}


	}

	private List<Integer> solution(int cacheSize, int[] tasks) {
		List<Integer> cache = new LinkedList<>();

		// O(m)
		for(int task: tasks) {
			final int targetIndex = cache.indexOf(task); // O(n)
			// cache miss
			if(targetIndex == -1) {
				cache.add(0, task);
				if(cache.size() > cacheSize) {
					cache.remove(cacheSize);
				}
				continue;
			}

			// cache hit
			cache.remove(targetIndex);
			cache.add(0, task);
		}

		return cache;
	}

	private List<Integer> solutionWithQueue(int cacheSize, int[] tasks) {
		Queue<Integer> cacheQueue = new ArrayDeque<>();

		for(int task: tasks) {
			// cache hit
			if(cacheQueue.contains(task)) {
				cacheQueue.remove(task);
				cacheQueue.offer(task);
				continue;
			}

			cacheQueue.offer(task);
			if(cacheQueue.size() > cacheSize) {
				cacheQueue.poll();
			}
		}

		List<Integer> answers = cacheQueue.stream().collect(Collectors.toList());
		Collections.reverse(answers);
		return answers;
	}

}
