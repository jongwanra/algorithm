package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.피보나치_수열;

/**
 * 문제
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * https://www.inflearn.com/courses/lecture?courseId=326750&type=LECTURE&unitId=72770&subtitleLanguage=ko
 *
 * 문제 접근 방법
 * 재귀를 이용해 문제를 해결한다.
 * f(n) = f(n - 1) + f(n-2)
 *
 */
import java.io.*;
public class Main250508 {
	private static int[] cache;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		cache = new int[n + 1];
		Main250508 main = new Main250508();
		// main.solutionLoop(n);
		main.solutionDfs(n);

	}

	private void solutionDfs(int n) {
		for(int index = 1; index <= n; index++) {
			System.out.print(fibonacci(index) + " ");
		}
	}

	private int fibonacci(int n) {
		if(cache[n] > 0) {
			return cache[n];
		}
		if(n == 1 || n == 2) {
			return 1;
		}

		return cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

	private void solutionLoop(int n) {
		cache[1] = 1;
		cache[2] = 1;
		for(int index = 3; index <= n; index++) {
			cache[index] = cache[index - 1] + cache[index -2];
		}

		for(int index = 1; index <= n; index++) {
			System.out.print(cache[index] + " ");
		}

	}
}
