package 자바_알고리즘_문제풀이_입문.stack_queue.공주_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-06
 * 문제 접근 방법
 * Queue에 전부 삽입한다 (1 ~ n)
 * Queue의 크기가 1이 될 때까지 k 번 때 빼고 넣기를 반복한다.
 */
public class Main250129 {
	private int solution(int n, int k) {
		Queue<Integer> queue = new ArrayDeque<>();

		for(int num = 1; num <= n; num++){
			queue.offer(num);
		}
		while(queue.size() > 1) {
			for(int index = 1; index < k; index++){
				queue.offer(queue.poll());
			}

			queue.poll();

		}

		return queue.poll();
	}
	public static void main(String[] args) throws IOException {
		Main250129 main = new Main250129();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken());
		System.out.println(main.solution(n, k));
	}
}
