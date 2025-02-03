package 자바_알고리즘_문제풀이_입문.sort_search.중복_확인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제 링크
 * https://cote.inflearn.com/contest/10/problem/06-05
 *
 * 문제 접근 방법
 * Set 자료구조를 이용해 문제를 푼다.
 * Set 자료구조로 생성했을 때의 사이즈와 기존의 사이즈를 비교해서 결과값을 출력한다
 */
public class Main250203 {
	public static void main(String[] args) throws IOException {
		Main250203 main = new Main250203();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}

		System.out.println(main.solution(n, arr));
	}

	private char solution(int n, int[] arr) {
		Set<Integer> dataSet = Arrays.stream(arr)
			.boxed()
			.collect(Collectors.toSet());

		return dataSet.size() == arr.length ? 'U' : 'D';
	}
}
