package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.미로_탐색_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-10
 *
 * 문제 접근 방법
 * 출발점 -> 도착점까지 갈 수 있는 방법의 수를 출력한다.
 * DFS를 이용해서 문제를 풀기 때문에 도착했을 경우 answer++를 한다.
 * 그리고 다시 방문했던 경로로 돌아가지 못하게 하기 위해서 visited 배열을 둔다.
 *
 */
public class Main250225 {
	private static int[] dRow = new int[] { -1, 0, 1, 0};
	private static int[] dCol = new int[] {0, 1, 0, -1};
	private static int answer = 0;
	private static int n = 7;
	private static int[][] matrix = new int[n + 1][n + 1]; // 0은 무시한다.
	private static boolean[][] visited = new boolean[n + 1][n + 1];

	public static void main(String[] args) throws IOException {

		Main250225 main = new Main250225();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int row = 1; row <= n; row++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= n; col++) {
				matrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// matrix[1][1] = 1;
		main.search(1, 1);
		System.out.println(answer);

	}

	private void search(int row, int col) {
		if(row == n && col == n) {
			answer++;
			return;
		}

		for(int index = 0; index < 4; index++) {
			final int nextRow = row + dRow[index];
			final int nextCol = col + dCol[index];

			if(nextRow <= 0 || nextRow > n || nextCol <= 0 || nextCol > n) {
				continue;
			}

			if(matrix[nextRow][nextCol] == 1) {
				continue;
			}

			if(matrix[nextRow][nextCol] >= 1){
				continue;
			}

			matrix[nextRow][nextCol] = 1;
			search(nextRow, nextCol);
			matrix[nextRow][nextCol] = 0;
		}
	}
}
