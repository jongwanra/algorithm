package algorithm.recursive_tree_graph.그래프_최단거리_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
 *
 */
public class Main250215 {
	private static boolean[] visited;
	private static int[] distances;
	private static List<List<Integer>> graph = new ArrayList<>();
	private static int n;

	public static void main(String[] args) {
		Main250215 main = new Main250215();
		n = 6;
		for(int vertex = 0; vertex <= n; vertex++) {
			graph.add(new ArrayList<>());
		}

		String[] inputs = {"1 4", "1 3", "2 1", "2 5", "3 4", "4 5", "4 6", "6 2", "6 5"};

		for(String input: inputs){
			StringTokenizer st = new StringTokenizer(input);
			final int fromVertex = Integer.parseInt(st.nextToken());
			final int toVertex = Integer.parseInt(st.nextToken());
			graph.get(fromVertex).add(toVertex);
		}
		visited = new boolean[n +1];
		distances = new int[n + 1];
		main.bfs();
		System.out.println(Arrays.toString(distances));
	}

	private void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(1);
		visited[1] = true;

		while(!queue.isEmpty()) {
			Integer currentVertex = queue.poll();
			List<Integer> adjacentVertices = graph.get(currentVertex);
			for(Integer adjacentVertex: adjacentVertices) {
				if(visited[adjacentVertex]) {
					continue;
				}
				visited[adjacentVertex] = true;
				distances[adjacentVertex] = distances[currentVertex] + 1;
				queue.offer(adjacentVertex);
			}
		}
	}
}
