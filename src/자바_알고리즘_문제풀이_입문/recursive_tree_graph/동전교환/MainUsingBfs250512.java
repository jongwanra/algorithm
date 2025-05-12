package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.동전교환;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-05
 *
 * 거스름돈을 가장 적은 수의 동전으로 교환해주기.
 * 문제 접근 방법
 * 최소 개수의 동전을 찾는 것이기 때문에 BFS로 접근한다.
 *
 * 동전 종류의 개수: N개
 * 시간 복잡도: O(total * N) -> total마다 n개의 경우로 뻗어나감.
 * 공간 복잡도: O(total)
 */

import java.util.*;
import java.io.*;

public class MainUsingBfs250512 {
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int coinNum = Integer.parseInt(br.readLine());
		int[] coins = new int[coinNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < coinNum; index++) {
			coins[index] = Integer.parseInt(st.nextToken());
		}
		final int total = Integer.parseInt(br.readLine());
		visited = new boolean[total + 1];
		MainUsingBfs250512 main = new MainUsingBfs250512();
		System.out.println(main.solution(total, coins));
	}

	private int solution(int total, int[] coins) {
		int level = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);

		while(!queue.isEmpty()){
			level++;
			final int size = queue.size();
			for(int index = 0; index < size; index++) {
				final int currentTotal = queue.poll();
				for(int coin: coins) {
					final int nextTotal = currentTotal + coin;
					if(nextTotal == total) {
						return level;
					}

					if(nextTotal > total) {
						continue;
					}

					if(visited[nextTotal]) {
						continue;
					}

					visited[nextTotal] = true;
					queue.offer(nextTotal);
				}

			}

		}
		return -1;
	}
}
