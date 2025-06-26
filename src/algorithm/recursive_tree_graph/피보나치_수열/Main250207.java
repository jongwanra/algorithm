package algorithm.recursive_tree_graph.피보나치_수열;

import java.util.Arrays;

/**
 * 문제
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 문제 접근 방법
 * 재귀를 이용해 문제를 해결한다.
 *
 */
public class Main250207 {
	private int[] cache;

	public static void main(String[] args) {
		Main250207 main = new Main250207();
		System.out.println(Arrays.toString(main.solution(45)));
	}

	private int[] solution(int n){
		cache = new int[n + 1];
		for(int num = 1; num <= n; num++) {
			cache[num] = fibonacci(num);
		}

		return cache;
	}


	private int fibonacci(int num) {
		if(cache[num] != 0) {
			return cache[num];
		}
		if(num == 1 || num == 2) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}
}
