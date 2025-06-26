package algorithm.greedy.친구인가;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-06
 *
 * 문제 접근 방법
 * union & find로 친구관계를 찾는다.
 */
import java.io.*;

public class Main250527 {
	private static int find(int n) {
		if(n == unf[n]) {
			return n;
		}

		return unf[n] = find(unf[n]);
	}

	private static void union(int a, int b) {
		int foundA = find(a);
		int foundB = find(b);
		if(foundA == foundB) {
			return;
		}

		unf[foundA] = foundB;
	}
	private static int[] unf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int m = Integer.parseInt(inputs[1]);

		unf = new int[n + 1];
		for(int index = 1; index <= n; index++) {
			unf[index] = index;
		}

		for(int index = 0; index < m; index++) {
			String[] relationships = br.readLine().split(" ");
			final int personA = Integer.parseInt(relationships[0]);
			final int personB = Integer.parseInt(relationships[1]);
			union(personA, personB);
			// System.out.println(Arrays.toString(arr));
		}

		String[] relationships = br.readLine().split(" ");
		final int personA = Integer.parseInt(relationships[0]);
		final int personB = Integer.parseInt(relationships[1]);
		if(find(personA) == find(personB)) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");

	}
}
