package algorithm.recursive_tree_graph.경로탐색_DFS;

/**
 *  문제
 *  방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 *
 */
public class Main250213 {
	private static boolean[] visited;
	private static int answer = 0;
	public static void main(String[] args) {
		Main250213 main = new Main250213();
		final int n = 5; // 정점의 수
		final int m = 9; // 간선의 수
		int[][] matrix = new int[n + 1][n + 1]; // 0번 인덱스 사용 x
		String[] inputs = {"1 2", "1 3", "1 4", "2 1", "2 3", "2 5", "3 4", "4 2", "4 5"};

		for(String input: inputs) {
			String[] vertices = input.split(" ");
			final int fromVertex = Integer.parseInt(vertices[0]);
			final int toVertex = Integer.parseInt(vertices[1]);
			matrix[fromVertex][toVertex] = 1;
		}
		visited = new boolean[n + 1]; // 0번 인덱스 사용 x
		visited[1] = true;
		main.dfs(n, matrix, 1);
		System.out.println(answer);
	}

	private void dfs(int n, int[][] matrix, int vertex) {
		// 종료 조건
		if(vertex == n) {
			answer++;
			return;
		}

		int[] toVertices = matrix[vertex];
		for(int index = 1; index <= n; index++) {
			if(toVertices[index] == 1 && !visited[index]) {
				// 간선으로 연결되어 있는 경우 dfs를 태운다.
				visited[index] = true;
				dfs(n, matrix, index);
				visited[index] = false;
			}
		}

	}
}
