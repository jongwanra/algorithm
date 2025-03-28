package 자바_알고리즘_문제풀이_입문.dynamic_programming.가장_높은_탑_쌓기;
import java.util.*;
import java.io.*;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-04
 * 문제 접근 방법
 * 부분 증가 수열 문제 응용이다.
 * 밑면의 넓이와 무게가 큰 걸 제외 하고 비교한 것 중 현재까지 중 가장 높은 넓이를 구한 이후에 더한다.
 *
 */

class Brick implements Comparable<Brick>{
	int baseArea;
	int height;
	int weight;

	public Brick(int baseArea, int height, int weight) {
		this.baseArea = baseArea;
		this.height = height;
		this.weight =weight;
	}

	public boolean isWiderThan(Brick target) {
		return this.baseArea > target.baseArea;
	}

	public boolean isHeavierThan(Brick target) {
		return this.weight > target.weight;
	}

	@Override
	public int compareTo(Brick o) {
		return o.baseArea - this.baseArea;
	}
}
public class Main250328 {
	public static void main(String[] args) throws IOException{
		Main250328 main = new Main250328();
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

	private int solution(int n , Brick[] bricks){
		Arrays.sort(bricks);
		int answer = 0;
		int[] dy = new int[n];
		dy[0] = bricks[0].height;

		for(int index = 1; index < n; index++) {
			Brick currentBrick = bricks[index];
			int maxHeight = 0;
			for(int targetIndex = index - 1; targetIndex >= 0; targetIndex--) {
				Brick targetBrick = bricks[targetIndex];
				if(currentBrick.isHeavierThan(targetBrick)) {
					continue;
				}
				if(currentBrick.isWiderThan(targetBrick)) {
					continue;
				}

				maxHeight = Math.max(maxHeight, dy[targetIndex]);
			}

			dy[index] = maxHeight + currentBrick.height;
			answer = Math.max(answer, dy[index]);
		}

		return answer;
	}
}
