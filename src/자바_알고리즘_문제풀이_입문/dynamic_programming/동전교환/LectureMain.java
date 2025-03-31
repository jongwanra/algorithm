package 자바_알고리즘_문제풀이_입문.dynamic_programming.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class LectureMain {
	public static void main(String[] args) throws IOException {
		LectureMain main = new LectureMain();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int n = Integer.parseInt(br.readLine());
		int[] coins  = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			coins[index] = Integer.parseInt(st.nextToken());
		}
		final int money = Integer.parseInt(br.readLine());

		System.out.println(main.solution(n, coins, money));
	}

	private int solution(int n, int[] coins, int money) {
		int[] dy = new int[money + 1];
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;

		for (int coin : coins) {
			for(int index = coin; index <= money; index++) {
				dy[index] = Math.min(dy[index], dy[index - coin] + 1);
			}
		}
		return dy[money];
	}
}
