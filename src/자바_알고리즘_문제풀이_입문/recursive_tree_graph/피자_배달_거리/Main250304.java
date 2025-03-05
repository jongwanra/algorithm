package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.피자_배달_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-14
 *
 * 0: 빈칸, 1: 집, 2: 피자집
 * 행/열 번호: 1 ~ N 번호
 * 피자배달거리: 집과 도시의 존재하는 피자집들과의 거리 중 최소 값
 * 피자집 M개 선택 기준: 피자배달거리가 최소가 되는 M개의 피자집
 * 도시의 피자 배달 거리: 각 집들의 피자 배달 거리를 합한 것
 *
 * 문제 접근 방법
 * 피자집 M개를 선택하고 그 안에서의 최소 거리를 구하자.
 * DFS를 사용하여 접근한다.
 *
 */
public class Main250304 {
	private static int n;
	private static int m;
	private static int[][] board;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		Main250304 main = new Main250304();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		for(int row = 0; row < n; row++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++) {
				board[row][col] = Integer.parseInt(stArr.nextToken());
			}
		}

		main.dfs(0, 0, 0, 0);
		System.out.println(answer);

	}

	private void dfs(int currentRow, int currentCol, int depth, int sum) {
		if(answer <= sum) {
			return;
		}
		if(m == depth) {
			answer = Math.min(sum, answer);
			return;
		}

		for(int row = currentRow; row < n; row++) {
			if(row == currentRow) {
				for(int col = currentCol; col < n; col++) {

				}
			}else {
				for(int col = 0; col < n; col++) {

				}
			}
		}


	}
}
