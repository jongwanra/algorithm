package 자바_알고리즘_문제풀이_입문.array.소수_에라토스테네스_체;
import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

/**
 * https://cote.inflearn.com/contest/10/problem/02-05
 *
 * 문제 접근 방법
 * 1. 입력한 n 만큼의 boolean[]를 둔다.
 * 2. boolean[]를 0과 1을 제외하고 전부 true로 초기화
 * 3. 에라토스테네스 체를 통해 소수와 소수가 아닌 수를 판별
 * 4. 반복문을 돌면서 소수 count
 */

public class Main241201 {
	public static void main(String[] args) throws IOException {
		Main241201 main = new Main241201();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		System.out.println(main.solution2(n));

	}

	private int solution(int n) {
		// 1 ~ n 까지이기 때문에 n을 포함 안함.
		boolean[] cache = new boolean[n];
		for(int index = 2; index < n; index++ ){
			cache[index] = true;
		}

		for(int num = 2; num < Math.sqrt(n); num++) {
			if(cache[num]) {
				for(int jNum = num + num; jNum < n; jNum += num){
					cache[jNum] = false;
				}
			}
		}

		int answer = 0;
		for(int index = 2; index < n; index++) {
			if(cache[index]) {
				answer++;
			}
		}
		return answer;
	}

	// List로 풀어보자.
	private int solution2(int n) {
		// 1 ~ n 까지이기 때문에 n을 포함 안함.
		List<Boolean> cache = new ArrayList<>(n);
		cache.add(false);
		cache.add(false);

		IntStream.range(2, n)
			.forEach((index) -> cache.add(index, true));

		IntStream.range(2, (int)Math.sqrt(n))
			.filter((num) -> cache.get(num).equals(true))
			.forEach(num -> {
				for(int jNum = num + num; jNum < n; jNum += num){
					cache.set(jNum, false);
				}
			});

		return (int)cache.stream()
			.filter(num -> num.equals(true))
			.count();
	}
}
