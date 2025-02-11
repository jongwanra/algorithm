package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.송아지_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/07-08
 *
 * 문제 접근 방법
 * 현수의 점프 경우의 수: +1, -1, +5
 * 최소 몇번의 점프로 송아지한테 갈 수 있는지를 찾는다.
 * BFS로 최단 거리를 구하면 됨.
 */
public class Main250211 {
	private static int[] dx  = new int[]{ 1, -1, 5};
	public static void main(String[] args) throws IOException {
		Main250211 main = new Main250211();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int personPos = Integer.parseInt(st.nextToken());
		final int animalPos = Integer.parseInt(st.nextToken());
		System.out.println(main.solution(personPos, animalPos));
	}

	private int solution(int personPos, int animalPos) {
		return bfs(personPos, animalPos);
	}

	private int bfs(int personPos, int animalPos) {
		boolean[] visited = new boolean[10_000];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(personPos);
		int tryCount = 0;
		while(!queue.isEmpty()){
			final int size = queue.size();
			for(int index = 0; index < size; index++) {
				Integer currentPos = queue.poll();
				if(currentPos == animalPos) {
					return tryCount;
				}
				for(int x:dx) {
					final int nextMovePos = currentPos + x;
					if(nextMovePos < 1 || nextMovePos > 10_000) {
						continue;
					}
					if(visited[nextMovePos]) {
						continue;
					}
					queue.offer(nextMovePos);
					visited[nextMovePos] = true;
				}




			}
			tryCount++;
		}

		return -1;
	}
}
