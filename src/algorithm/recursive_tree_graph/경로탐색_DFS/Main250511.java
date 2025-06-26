package algorithm.recursive_tree_graph.경로탐색_DFS;

/**
 * 문제
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6가지 입니다.
 *
 * 문제 접근 방법
 * 인접 행렬 DFS로 문제에 접근한다.
 *
 * 시간 복잡도: O(N!) => 순열과 동일
 * 공간 복잡도: O(N^2) => 행렬로 구성됨.
 * 여기서 N은 정점의 개수
 */
import java.io.*;
public class Main250511 {
	private static int[][] matrix;
	private static boolean[] visited;
	private static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int vertexNum = Integer.parseInt(inputs[0]);
		final int edgeNum = Integer.parseInt(inputs[1]);

		matrix = new int[vertexNum + 1][vertexNum + 1];
		visited = new boolean[vertexNum + 1];
		for(int index = 0; index < edgeNum; index++ ){
			String[] inputList = br.readLine().split(" ");
			final int fromVertex = Integer.parseInt(inputList[0]);
			final int toVertex = Integer.parseInt(inputList[1]);
			matrix[fromVertex][toVertex] = 1;
		}

		Main250511 main = new Main250511();
		visited[1] = true;
		main.dfs(1, vertexNum);
		System.out.println(answer);
	}

	private void dfs(int currentVertex, int vertexNum) {
		if(currentVertex == vertexNum) {
			answer++;
			return;
		}

		// O(N)
		for(int v = 1; v <= vertexNum; v++) {
			if(matrix[currentVertex][v] == 1 && !visited[v]) {
				visited[v] = true;
				dfs(v, vertexNum);
				visited[v] = false;
			}
		}
	}

}

/*
입력
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

출력
6
 */
