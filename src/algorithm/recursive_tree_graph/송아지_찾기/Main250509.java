package algorithm.recursive_tree_graph.송아지_찾기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/07-08
 *
 * 송아지: 목표지점
 * 현수 이동 경우의 수: +1, -1, +5
 * 최소 점프로 가는 경우의 수
 * 문제 접근 방법
 * 최소 몇번으로 갈 수 있는지 경우의 수를 구하는 것이기 때문에 BFS가 적절하다.
 *
 * 시간 복잡도: O(V + E) => O(N + 3N) => O(N)
 * 공간 복잡도: O(N)
 *
 */

import java.util.*;
import java.io.*;
public class Main250509 {
	private static int[] cases;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int startPos = Integer.parseInt(inputs[0]);
		final int endPos = Integer.parseInt(inputs[1]);

		cases = new int[3];
		cases[0] = -1;
		cases[1] = 1;
		cases[2] = 5;

		Main250509 main = new Main250509();
		System.out.println(main.solution(startPos, endPos));
	}

	private int solution(int startPos, int endPos) {
		boolean[] visited = new boolean[10_001];
		int depth = 0;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(startPos);
		visited[startPos] = true;

		while(!queue.isEmpty()) {
			final int size = queue.size();
			depth++;
			for(int index = 0; index < size; index++) {
				final int currentPos = queue.poll();

				for(int x: cases) {
					int nextPos = currentPos + x;
					if(nextPos < 1 || nextPos > 10_000) {
						continue;
					}
					if(visited[nextPos]) {
						continue;
					}

					if(nextPos == endPos) {
						return depth;
					}
					visited[nextPos] = true;
					queue.offer(nextPos);
				}
			}
		}
		return depth;
	}

}
