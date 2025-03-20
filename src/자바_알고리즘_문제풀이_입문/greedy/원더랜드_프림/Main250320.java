package 자바_알고리즘_문제풀이_입문.greedy.원더랜드_프림;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-07
 *
 * 문제 접근 방법
 * 프림 알고리즘
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main250320 {
	static class Edge implements Comparable<Edge> {
		int vertex;
		int cost;

		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		Main250320 main = new Main250320();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int vertexNum = Integer.parseInt(st.nextToken());
		final int edgeNum = Integer.parseInt(st.nextToken());

		List<List<Edge>> graph = new ArrayList<>();
		boolean[] visited = new boolean[vertexNum + 1];
		for(int index = 0; index <= vertexNum; index++) {
			graph.add(new ArrayList<>());
		}

		for(int index = 0; index < edgeNum; index++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			final int v1 = Integer.parseInt(stArr.nextToken());
			final int v2 = Integer.parseInt(stArr.nextToken());
			final int cost = Integer.parseInt(stArr.nextToken());

			graph.get(v1).add(new Edge(v2, cost));
			graph.get(v2).add(new Edge(v1, cost));
		}

		System.out.println(main.solution(visited, graph));



	}

	private int solution(boolean[] visited, List<List<Edge>> graph) {
		int answer = 0;
		Queue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));

		while (!pQ.isEmpty()) {
			Edge edge = pQ.poll();
			if(visited[edge.vertex]){
				continue;
			}
			visited[edge.vertex] = true;
			answer += edge.cost;
			for(Edge injectiveEdge: graph.get(edge.vertex)) {
				if(visited[injectiveEdge.vertex]){
					continue;
				}

				pQ.offer(new Edge(injectiveEdge.vertex, injectiveEdge.cost));

			}
		}

		return answer;
	}
}
