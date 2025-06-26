package algorithm.recursive_tree_graph.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-05
 *
 * 문제 접근 방법
 * 가장 적은 수의 동전 개수를 구하는 문제
 * BFS를 이용해서 문제를 해결한다.
 *
 */
public class Main250219 {
	private static int n;
	private static Integer[] coins;
	private static int targetAmount;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		Main250219 main = new Main250219();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		coins = new Integer[n];
		StringTokenizer stCoins = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			coins[index] = Integer.parseInt(stCoins.nextToken());
		}
		targetAmount = Integer.parseInt(br.readLine());
		Arrays.sort(coins, Comparator.reverseOrder());
		System.out.println(main.bfs(0));

	}

	private int bfs(int level) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);

		while (!queue.isEmpty()) {
			final int size = queue.size();
			for(int index = 0; index < size; index++) {
				Integer polled = queue.poll();
				for(int coin: coins) {
					if(polled + coin > targetAmount) {
						continue;
					}
					if(polled + coin == targetAmount) {
						return level + 1;
					}

					queue.offer(polled + coin);
				}
			}

			level++;
		}

		return level;
	}

	private void dfs(int refundedSum, int depth) {
		if(refundedSum > targetAmount || answer <= depth){
			return;
		}
		if(refundedSum == targetAmount) {
			answer = Math.min(answer, depth);
			return;
		}

		for(int index = 0; index < n; index++) {
			dfs(refundedSum + coins[index], depth + 1);
		}
	}
}
