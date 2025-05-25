package 자바_알고리즘_문제풀이_입문.greedy.씨름_선수;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-01
 *
 * 특정 지원자와 비교했을 때 키와 몸무게 모두 특정 지원자 보다 높으면 특정 지원자 탈락
 * 아니면 선발
 *
 * 문제 접근 방법
 * n^2으로는 문제 해결 불가
 *
 * 170 72 -> 탈락
 * 172 67
 * 180 70
 * 181 60
 * 183 65
 *
 * 키를 이용해 오름차순 정렬을 한다. O(n * log n)
 * 비교하면서 키 몸무게가 둘다 큰 경우 탈락시킨다. O(n!)
 *
 * 시간 복잡도: O(n^2)
 * 공간 복잡도: O(n)
 */
import java.io.*;
import java.util.*;
public class Main250525 {
	static class Player implements Comparable<Player> {
		int height;
		int weight;

		public Player(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Player o) {
			return this.height - o.height;
		}

		public boolean isBiggerThan(Player cur) {
			return this.height > cur.height && this.weight > cur.weight;
		}
	}
	public static void main(String[] args ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		Player[] players = new Player[n];
		for(int index = 0; index < n; index++) {
			String[] inputs = br.readLine().split(" ");
			final int height = Integer.parseInt(inputs[0]);
			final int weight = Integer.parseInt(inputs[1]);

			players[index] = new Player(height, weight);
		}

		Main250525 main = new Main250525();
		System.out.println(main.solution(n, players));
	}

	private int solution(int n, Player[] players) {
		int dropPlayerCount = 0;
		Arrays.sort(players); // O(n log n)

		// O(n^2)
		for(int index = 0; index < n; index++) {
			Player cur = players[index];
			for(int targetIndex = index + 1; targetIndex < n; targetIndex++) {
				Player target = players[targetIndex];
				if(target.isBiggerThan(cur)) {
					dropPlayerCount++;
					break;
				}
			}

		}
		return players.length - dropPlayerCount;
	}

}
