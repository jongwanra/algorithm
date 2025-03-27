package 자바_알고리즘_문제풀이_입문.dynamic_programming.가장_높은_탑_쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-04
 *
 * 문제 접근 방법
 * 최대 부분 증가 수열의 응용 문제.
 *
 * 1. 벽돌에 대한 밑면의 넓이, 높이, 무게를 차례로 입력 받는다.
 * 2. 벽돌들의 밑면의 넓이를 가지고 마지막 항의 최대 높이를 저장한다.
 */
public class Main250327 {
	static class Brick implements Comparable<Brick> {
		int baseArea;
		int height;
		int weight;

		public Brick(int baseArea, int height, int weight) {
			this.baseArea = baseArea;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Brick{" +
				"baseArea=" + baseArea +
				", height=" + height +
				", weight=" + weight +
				'}';
		}

		@Override
		public int compareTo(Brick o) {
			return o.baseArea - this.baseArea;
		}
	}
	public static void main(String[] args) throws IOException {
		Main250327 main = new Main250327();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		Brick[] bricks = new Brick[n];
		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int baseArea = Integer.parseInt(st.nextToken());
			final int height = Integer.parseInt(st.nextToken());
			final int weight = Integer.parseInt(st.nextToken());
			bricks[index] = new Brick(baseArea, height, weight);
		}

		System.out.println(main.solution(n, bricks));

	}

	private int solution(int n, Brick[] bricks) {

		Arrays.sort(bricks);
		int[] dy = new int[n];
		int answer = bricks[0].height;
		dy[0] = bricks[0].height; // 0번쨰 항까지의 최대 높이

		for(int index = 1; index < n; index++) {
			Brick currentBrick = bricks[index];
			int maxHeight = 0;

			for(int targetIndex = index - 1; targetIndex >= 0; targetIndex--) {
				Brick targetBrick = bricks[targetIndex];

				if(currentBrick.weight > targetBrick.weight) {
					// 무게가 더 무거울 경우 못 올림.
					continue;
				}
				maxHeight = Math.max(maxHeight, dy[targetIndex]);
			}
			dy[index] = currentBrick.height + maxHeight;
			answer = Math.max(answer, dy[index]);
		}

		// System.out.println(Arrays.toString(dy));

		return answer;
	}



}
