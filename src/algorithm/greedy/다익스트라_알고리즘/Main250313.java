package algorithm.greedy.다익스트라_알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.*;

/**
 * 문제
 * 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로 최소 거리비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 impossible를 출력한다)
 *
 *
 * 문제 접근 방법
 * 다익스트라 알고리즘으로 접근
 */
public class Main250313 {
	static class Edge implements Comparable<Edge>{
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
		Main250313 main = new Main250313();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt(st.nextToken()); // 정점 개수
		final int m = Integer.parseInt(st.nextToken()); // 간선 개수

		List<List<Edge>> graph = new ArrayList<>();

		for(int index = 0; index <= n; index++) {
			graph.add(new ArrayList<>());
		}

		for(int index = 0; index < m; index++){
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			final int fromVertex = Integer.parseInt(stArr.nextToken());
			final int toVertex = Integer.parseInt(stArr.nextToken());
			final int cost = Integer.parseInt(stArr.nextToken());

			graph.get(fromVertex).add(new Edge(toVertex, cost));
		}

		int[] distances = main.solution(graph);
		for(int index = 2; index <= n; index++) {
			String answer = distances[index] == Integer.MAX_VALUE ? "impossible" : String.valueOf(distances[index]);
			System.out.println(index + " : " + answer);
		}
	}

	private int[] solution(List<List<Edge>> graph) {
		int[] distances = new int[graph.size()];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[1] = 0;

		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(1, 0));

		while(!queue.isEmpty()){
			Edge nowEdge = queue.poll();
			int nowCost = nowEdge.cost;
			int nowVertex = nowEdge.vertex;
			if(nowCost > distances[nowVertex]) {
				continue;
			}
			for(Edge edge: graph.get(nowVertex)){
				if(distances[edge.vertex] > nowCost + edge.cost) {
					distances[edge.vertex] = nowCost + edge.cost;
					queue.offer(new Edge(edge.vertex, nowCost + edge.cost));
				}
			}
		}
		return distances;
	}
}


/*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */
