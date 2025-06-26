package algorithm.array.소수_에라토스테네스_체;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-05
 * 자연수 n이 입력되면 1 부터 N 까지의 소수의 개수를 출력한다.
 *
 * 문제 접근 방법
 * 자연수의 개수는 200,000까지이다.
 * 에라토스테네스의 체를 사용해서 문제를 접근하면되는데, 200,000 까지는 어느 정도의 시간 복잡도를 예상해야 가능할까?
 *
 * 시간 복잡도: O(n * log(log n))
 * 공간 복잡도: O(n)
 */
import java.io.*;
import java.util.*;
public class Main250418 {

	public static void main(String[] args) throws IOException {
		Main250418 main = new Main250418();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());

		System.out.println(main.solution(n));
	}

	private int solution(int n) {
		int answer = 0;
		boolean[] isPrimes = new boolean[n]; // n까지이기 떄문에 n을 포함하지 않는다.
		Arrays.fill(isPrimes, true);
		isPrimes[0] = false;
		isPrimes[1] = false;

		for(int num = 2; num < Math.sqrt(n); num++) {
			if(isPrimes[num]) {
				for(int nextNum = num + num; nextNum < n; nextNum += num) {
					isPrimes[nextNum] = false;
				}
			}
		}

		for(int num = 2; num < n; num++) {
			if(isPrimes[num]) {
				answer++;
			}
		}

		return answer;
	}


}
