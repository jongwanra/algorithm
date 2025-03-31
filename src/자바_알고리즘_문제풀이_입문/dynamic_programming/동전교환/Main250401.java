package 자바_알고리즘_문제풀이_입문.dynamic_programming.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-05
 *
 * 시간 제한: 1000ms
 * 문제 접근 방법
 * 거스름돈을 가장 적은 수의 동전으로 교환해줘야함.
 * 시간 제한이 1초이기 때문에, 완전 탐색으로는 불가능하다.
 *
 * 각 동전의 종류 마다 반복문을 돌면서 최소 동전의 개수를 판단한다.
 */
public class Main250401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int coinNum = Integer.parseInt(br.readLine());
		int[] coins = new int[coinNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < coinNum; index++) {
			coins[index] = Integer.parseInt(st.nextToken());
		}
		final int money = Integer.parseInt(br.readLine());

		Main250401 main = new Main250401();
		System.out.println(main.solution(coins, money));
	}

	private int solution(int[] coins, int money) {
		// dy[index] => dy[index]를 거슬러 줄 최소 동전의 개수
		int[] dy = new int[money + 1];
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int coin: coins) {
			for(int index = coin; index <= money; index++) {
				dy[index] = Math.min(dy[index - coin] + 1, dy[index]);
			}
		}

		return dy[money];
	}
}
