package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.피자_배달_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-14
 *
 * 0: 빈칸, 1: 잡, 2: 피자집
 * 피자배달거리: 집 <-> 피자집들과의 거리 중 최소값
 * 도시의 피자배달거리: 각 집들의 피자배달거리를 합한 것
 * 도시의 피자배달거리가 최소가 되도록 구해야함.
 *
 * 문제 접근 방법
 * 조합으로 문제에 접근한다.
 * houses, pizzaStores를 리스트로 둔다.
 * 조합을 이용해서 피자집을 선택하고
 * M개의 피자집을 선택한 이후에 각 집들의 피자배달거리를 구한다.
 */
public class Main250306 {
	private static List<Point> houses = new ArrayList<>();
	private static List<Point> pizzaStores = new ArrayList<>();
	private static int[] combinations;
	private static int answer = Integer.MAX_VALUE;
	private static int n;
	private static int r;

	public static void main(String[] args) throws IOException {
		Main250306 main = new Main250306();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		combinations = new int[n];
		for(int row = 0; row < n; row++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; col++){
				Point point = new Point(row, col);
				final int type = Integer.parseInt(stArr.nextToken());

				if(type == 1) {
					// 집
					houses.add(point);
				}else if(type == 2) {
					// 피자집
					pizzaStores.add(point);
				}

			}
		}

		main.dfs(0, 0);
		System.out.println(answer);
	}

	private void dfs(int depth, int startPos) {
		if(r == depth) {
			// 각 집들에 대한 피자배달거리를 전부 더한다.
			int sum = 0;
			for(Point house: houses) {
				int minDistance = Integer.MAX_VALUE;
				for(int pizzaStoreIndex: combinations) {
					Point pizzaStore =  pizzaStores.get(pizzaStoreIndex);
					final int distance = Math.abs(pizzaStore.row - house.row) + Math.abs(pizzaStore.col - house.col);
					minDistance = Math.min(minDistance, distance);
				}
				sum += minDistance;
			}
			answer = Math.min(sum, answer);
			return;
		}

		for(int index = startPos; index < pizzaStores.size(); index++) {
			combinations[depth] = index;
			dfs(depth + 1, index + 1);
		}
	}

	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
