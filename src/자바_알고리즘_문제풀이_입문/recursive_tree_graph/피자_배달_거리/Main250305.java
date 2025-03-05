package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.피자_배달_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 재도전
 *
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-14
 * 0: 빈칸, 1: 집, 2: 피자집
 * 피자배달거리: 집 -> 피자집들 거리 중 최소 거리
 * 피자집 M개를 선택하는 기준
 * 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택한다.
 *
 * 문제 접근 방법
 * 조합 문제다.
 * DFS로 접근한다.
 * houses와 pizzaStores를 미리 리스트에 담아두고
 * 도시 피자배달거리의 최소를 구한다.
 */
public class Main250305 {
	static class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row =row;
			this.col = col;
		}

	}

	private static List<Point> houses = new ArrayList<>();
	private static List<Point> pizzaStores = new ArrayList<>();
	private static int[] combinations;

	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		Main250305 main = new Main250305();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());
		combinations = new int[m];
		for(int row = 0; row < n; row++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++) {
				final int num = Integer.parseInt(stArr.nextToken());
				if(num == 1) {
					houses.add(new Point(row, col));
				}else if(num == 2) {
					pizzaStores.add(new Point(row, col));
				}

			}
		}

		main.dfs(m, 0, 0);
		System.out.println(answer);

	}

	private void dfs(int m, int depth, int start) {
		if(m == depth) {
			int sum = 0;
			for(Point house: houses) {
				int minDistance = Integer.MAX_VALUE;
				for(int pizzaStoreIndex: combinations) {
					final Point pizzaStore = pizzaStores.get(pizzaStoreIndex);
					final int distance = Math.abs(house.row - pizzaStore.row) + Math.abs(house.col - pizzaStore.col);
					minDistance = Math.min(minDistance, distance);
				}
				sum += minDistance;

			}
			answer = Math.min(sum, answer);
			return;
		}

		for(int index = start; index < pizzaStores.size(); index++) {
			combinations[depth] = index;
			dfs(m, depth + 1, index +1);
		}
	}
}
