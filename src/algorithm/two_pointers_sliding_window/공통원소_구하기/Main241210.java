package algorithm.two_pointers_sliding_window.공통원소_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://cote.inflearn.com/contest/10/problem/03-02
 *
 * 집합의 교집합을 구하고 오름차순으로 정렬하여 출력한다.
 *
 * 접근 방법
 * 1. A 배열과 B 배열을 Set으로 변환한다.
 * 2. Set을 이용해 교집합을 구한다.
 * 3. 오름차순으로 정렬한다.
 *
 */
public class Main241210 {
	public static void main(String[] args) throws IOException {
		Main241210 main = new Main241210();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] aArr = new int[n];

		StringTokenizer aSt = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			aArr[index] = Integer.parseInt(aSt.nextToken());
		}

		final int m = Integer.parseInt(br.readLine());
		int[] bArr = new int[m];

		StringTokenizer bSt = new StringTokenizer(br.readLine());
		for(int index = 0; index < m; index++) {
			bArr[index] = Integer.parseInt(bSt.nextToken());
		}

		List<Integer> answer = main.lectureSolution(aArr, bArr);
		for (Integer ans : answer) {
			System.out.print(ans + " ");
		}
	}


	// Time Limit 발생
	private List<Integer> solution(int[] aArr, int[] bArr) {
		Set<Integer> answer = Arrays.stream(aArr).boxed().collect(Collectors.toCollection(TreeSet::new));
		answer.retainAll(Arrays.stream(bArr).boxed().collect(Collectors.toList()));

		return new ArrayList<>(answer);
	}



	// 1. 한 배열을 오름차순 정렬한다.
	// 2. 한 배열을 Set으로 만든다.
	// 3. 반복문을 돌면서 존재하는 경우 추가한다.
	private List<Integer> solution2(int[] aArr, int[] bArr) {
		// 오름 차순 정렬
		Arrays.sort(aArr);
		Set<Integer> bSet = Arrays.stream(bArr).boxed().collect(Collectors.toSet());

		return Arrays.stream(aArr)
			.boxed()
			.filter(bSet::contains)
			.collect(Collectors.toList());
	}

	private List<Integer> lectureSolution(int[] a, int[] b) {
		List<Integer> answer = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		final int n = a.length;
		final int m = b.length;
		int pa = 0;
		int pb = 0;

		while(pa < n && pb < m){
			if(a[pa] == b[pb]) {
				answer.add(a[pa]);
				pa++;
				pb++;
				continue;
			}

			if(a[pa] < b[pb]) {
				pa++;
			}else {
				pb++;
			}
		}

		return answer;
	}
}
