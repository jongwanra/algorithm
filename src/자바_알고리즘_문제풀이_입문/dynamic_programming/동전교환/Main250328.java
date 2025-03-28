package 자바_알고리즘_문제풀이_입문.dynamic_programming.동전교환;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-05
 *
 * 가장 적은 수의 동전으로 교환해 주려면?
 * 문제 접근 방법
 * 완전 탐색으로 거스름 돈 종류의 최소를 구한다.
 *
 * 완전탐색으로 갔을 때, 타임 리미트 나옴
 */

public class Main250328 {
	private static int[] cache;
	private static int answer = Integer.MAX_VALUE;
	private static int[] coins;
	private static int money;
	private static int coinNum;
	public static void main(String[] args) throws IOException {
		Main250328 main = new Main250328();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		coinNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		coins  = new int[coinNum];
		for(int index = 0; index < coinNum; index++) {
			coins[index] = Integer.parseInt(st.nextToken());
		}

		money = Integer.parseInt(br.readLine());
		cache = new int[money + 1];
		Arrays.fill(cache, Integer.MAX_VALUE);
		main.solution(0, money);

		System.out.println(answer);
	}

	private void solution(int depth, int money) {
		if(money == 0) {
			answer = Math.min(answer, depth);
			return;
		}
		if(money < 0) {
			return;
		}

		for(int coin: coins) {
			if(depth >= answer) {
				continue;
			}
			solution(depth + 1, money - coin);
		}

	}
}
