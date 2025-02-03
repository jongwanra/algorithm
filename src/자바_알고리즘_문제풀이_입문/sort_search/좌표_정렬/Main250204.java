package 자바_알고리즘_문제풀이_입문.sort_search.좌표_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-07
 *
 * 문제 접근 방법
 * 먼저 x의 값으로 정렬하고 x 값이 같을 경우 y값에 의해 정렬 한다.
 */

class Coordinate implements Comparable<Coordinate> {
	public int x;
	public int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}


	// 오름차순으로 정렬하려고 한다면 음수가 return 되어야 한다.
	@Override
	public int compareTo(Coordinate coordinate) {
		if (this.x == coordinate.x) {
			return this.y - coordinate.y;
		}

		return this.x - coordinate.x;

	}
}
public class Main250204 {

	public static void main(String[] args) throws IOException {
		Main250204 main = new Main250204();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		List<Coordinate> coordinates = new ArrayList<>();
		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int x = Integer.parseInt(st.nextToken());
			final int y = Integer.parseInt(st.nextToken());
			coordinates.add(new Coordinate(x, y));
		}

		main.solution(n, coordinates)
			.forEach(coordinate -> System.out.println(coordinate.x + " " + coordinate.y));

	}

	private List<Coordinate> solution(int n, List<Coordinate> coordinates) {
		return coordinates
			.stream()
			.sorted()
			.collect(Collectors.toList());
	}
}

