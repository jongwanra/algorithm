package algorithm.greedy.친구인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-06
 *
 * 문제 접근 방법
 * Union & Find로 문제 풀기
 */
public class Main250314 {
	private static int[] arrSet;

	private static int find(int v) {
		if(arrSet[v] == v) {
			return v;
		}

		return arrSet[v] = find(arrSet[v]);
	}

	private static void union(int numA, int numB) {
		final int foundA = find(numA);
		final int foundB = find(numB);

		if(foundA == foundB) {
			return;
		}

		arrSet[foundB] = foundA;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		arrSet = new int[n + 1];
		for(int index = 1; index <= n; index++) {
			arrSet[index] = index;
		}

		for(int index = 0; index < m; index++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			final int numA = Integer.parseInt(stArr.nextToken());
			final int numB = Integer.parseInt(stArr.nextToken());
			union(numA, numB);

			// System.out.println(Arrays.toString(unf));
		}

		StringTokenizer stQ = new StringTokenizer(br.readLine());
		final int questionA = Integer.parseInt(stQ.nextToken());
		final int questionB = Integer.parseInt(stQ.nextToken());

		if(find(questionA) == find(questionB)) {
			System.out.println("YES");
			return;
		}

		System.out.println("NO");
	}
}
