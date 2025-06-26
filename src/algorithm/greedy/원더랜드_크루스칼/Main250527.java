package algorithm.greedy.원더랜드_크루스칼;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-07
 *
 * 문제 접근 방법
 * 1. Edge class를 만든다.
 * 2. cost 오름차순으로 정렬한다.
 * 3. 반복문을 돌면서 circle이 발생했는지 판별한다. (발생할 경우 포함 x, 발생안할 경우 포함 및 union)
 */

import java.util.*;
import java.io.*;

public class Main250527 {
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int cost;

		public Edge(int v1, int v2, int cost){
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

		public boolean isCircular() {
			return find(v1) == find(v2);
		}
	}

	private static int[] unf;
	private static List<Edge> edges;

	private static int find(int num) {
		if(unf[num] == num) {
			return num;
		}

		return unf[num] = find(unf[num]);
	}

	private static void union(int a, int b) {
		int foundA = find(a);
		int foundB = find(b);

		if(foundA == foundB) {
			return;
		}

		unf[foundA] = foundB;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]); // 정점 개수
		final int m = Integer.parseInt(inputs[1]); // 간선 개수

		unf = new int[n + 1];
		edges = new ArrayList<>();
		for(int index = 1; index <= n; index++) {
			unf[index] = index;
		}

		for(int index = 0; index < m; index++) {
			String[] elements = br.readLine().split(" ");
			edges.add(new Edge(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]) , Integer.parseInt(elements[2])));
		}

		Main250527 main = new Main250527();
		System.out.println(main.solution());


	}

	private int solution() {
		int answer = 0;

		Collections.sort(edges);

		for(Edge edge: edges) {
			if(edge.isCircular()) {
				continue;
			}

			union(edge.v1, edge.v2);
			answer += edge.cost;
		}

		return answer;
	}
}
