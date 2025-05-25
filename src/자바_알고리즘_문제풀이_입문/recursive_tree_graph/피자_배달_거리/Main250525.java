package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.피자_배달_거리;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-14
 *
 * 0:빈칸
 * 1:집
 * 2:피자집
 *
 * 각 '집'마다 피자배달거리가 존재 한다.
 * 집과 도시의 존재하는 피자집들과의 거리 중 최소값을 해당 집의 "피자배달거리"
 *
 * 도시의 피자 배달 거리 = 각 집들의 피자 배달 거리를 전부 합한 것.
 * 도시의 피자 배달 거리 중 최소 값을 출력한다.
 *
 * 문제 접근 방법
 * 조합을 통해, 피자집을 M개를 선택한다.
 * M개 선택한 이후 도시의 피자 배달 거리를 구하고, answer와 비교했을 때 최솟값일 경우 대체한다.
 * 시간 복잡도: O(C(m,r) * h * r) => O(m!/r!(m-r)! * h * r)
 * 공간 복잡도: O(n^2)
 */

import java.util.*;
import java.io.*;


public class Main250525 {
	static class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static int[][] board;
	private static int n;
	private static int r;
	private static List<Position> pizzaHouses;
	private static List<Position> houses;
	private static Position[] selectedPizzaHouses;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		r = Integer.parseInt(inputs[1]);
		selectedPizzaHouses = new Position[r];
		pizzaHouses = new ArrayList<>();
		houses = new ArrayList<>();
		board = new int[n + 1][n + 1];

		for(int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= n; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
				if(board[row][col] == 2) {
					// 피자집인 경우
					pizzaHouses.add(new Position(row, col));
				}else if(board[row][col] == 1) {
					// 집인 경우
					houses.add(new Position(row, col));
				}
			}
		}

		Main250525 main = new Main250525();
		main.solution(0, 0);
		System.out.println(answer);

	}

	private void solution(int depth, int startPos) {
		// 종료 조건
		if(depth == r) {
			int sum = 0;
			for(Position house: houses) {
				// 집마다 피자 배달 거리
				int minDistance = Integer.MAX_VALUE;
				for(Position selectedPizzaHouse: selectedPizzaHouses) {
					final int distance = Math.abs(selectedPizzaHouse.row  - house.row) + Math.abs(selectedPizzaHouse.col - house.col);
					minDistance = Math.min(minDistance, distance);
				}

				sum += minDistance;
			}
			// 도시의 피자 배달 거리
			answer = Math.min(sum, answer);
			return;
		}

		for(int index = startPos; index < pizzaHouses.size(); index++) {
			selectedPizzaHouses[depth] = pizzaHouses.get(index);
			solution(depth + 1, index + 1);
		}
	}
}

/**
 * 피자집이 6개야
 * 그중에 4개를 골라야해
 *
 * 1 2 3 4
 * 1 2 3 5
 * 1 2 3 6
 * 1 2 4 5
 * 1 2 4 6
 * 피자집 개수 만큼 포문이 돈다. 그게 r 개 만큼 재귀적으로 포문이 생성된다.
 * 피자집 개수 ^ r
 */
