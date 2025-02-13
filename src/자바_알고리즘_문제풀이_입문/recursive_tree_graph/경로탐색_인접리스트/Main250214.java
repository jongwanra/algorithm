package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.경로탐색_인접리스트;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  문제
 *  방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 *  인접 리스트
 *
 */

public class Main250214 {
	private static boolean[] visited;
	private static List<List<Integer>> graph;
	private static int answer = 0;
	public static void main(String[] args) {
		Main250214 main = new Main250214();
		final int n = 5; // 정점의 수
		final int m = 9; // 간선의 수
		String[] inputs = {"1 2", "1 3", "1 4", "2 1", "2 3", "2 5", "3 4", "4 2", "4 5"};
		visited = new boolean[n + 1];
		graph = new ArrayList<>();

		for(int index = 0; index <= n; index++) {
			// 0번 인덱스 사용 x
			graph.add(new ArrayList<>());
		}

		for(String input: inputs) {
			StringTokenizer st = new StringTokenizer(input);
			final int fromVertex = Integer.parseInt(st.nextToken());
			final int toVertex = Integer.parseInt(st.nextToken());

			graph.get(fromVertex).add(toVertex);
		}


		visited[1] = true;
		main.dfs(n, 1);
		System.out.println(answer);



	}

	private void dfs(int n,int currentVertex) {
		if(n == currentVertex) {
			answer++;
			return;
		}

		for (Integer adjacencyVertex : graph.get(currentVertex)) {
			if(!visited[adjacencyVertex]){
				visited[adjacencyVertex] = true;
				dfs(n, adjacencyVertex);
				visited[adjacencyVertex] = false;
			}

		}



	}
}
