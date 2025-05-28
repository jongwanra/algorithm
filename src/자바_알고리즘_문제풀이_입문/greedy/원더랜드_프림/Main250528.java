package 자바_알고리즘_문제풀이_입문.greedy.원더랜드_프림;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-07
 *
 * 문제 접근 방법
 * 1. 인접 리스트로 구성한다.
 * 2. PriorityQueue를 구성한다.
 * 3. visited 배열을 구성한다.
 * 4. 방문하지 않는 인접한 노드들을 pQ에 추가한다.
 * 5. poll한다 방문하지 않은 경우에 인접 노드를 추가하고 위를 반복한다.
 *
 * 시간 복잡도: O(E log V)
 * E개의 간선을 PriorityQueue에 넣고 뺄 수 있다.
 * offer() / poll()이 O(log V)이다.
 *
 * 공간 복잡도: O(V + E)
 */


import java.util.*;
import java.io.*;
public class Main250528 {
	static class Edge implements Comparable<Edge> {
		int v;
		int cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int vn = Integer.parseInt(inputs[0]);
		final int en = Integer.parseInt(inputs[1]);

		visited = new boolean[vn + 1];
		List<List<Edge>> edges = new ArrayList<>();
		for(int index = 0; index <= vn; index++) {
			edges.add(new ArrayList<>());
		}

		for(int index = 0; index < en; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int v1 = Integer.parseInt(st.nextToken());
			final int v2 = Integer.parseInt(st.nextToken());
			final int cost = Integer.parseInt(st.nextToken());

			edges.get(v1).add(new Edge(v2, cost));
			edges.get(v2).add(new Edge(v1, cost));
		}

		Main250528 main = new Main250528();
		System.out.println(main.solution(edges));

	}

	private int solution(List<List<Edge>> edges) {
		int answer = 0;
		Queue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0));

		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll(); // O(log n)
			if(visited[cur.v]) {
				continue;
			}

			visited[cur.v] = true;
			answer += cur.cost;
			for(Edge ie: edges.get(cur.v)) {
				if(visited[ie.v]) {
					continue;
				}

				pQ.offer(ie);
			}
		}
		return answer;
	}

}
