package 자바_알고리즘_문제풀이_입문.hash.K번째_큰_수;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/04-05
 * n개의 카드는 같은 카드 여러장이 있을 수 있다.
 * 이 중에 3장을 뽑는다.
 * 1000ms안에 풀어야 함.
 *
 * 문제 접근 방법
 * 조합을 이용해서 3개의 수를 선택한다.
 * 내림차순으로 정렬한다.
 * k번째수를 출력한다. 없으면 -1을 출력한다.
 *
 * O(n^3)인데, 100 * 100 * 100이기 때문에 충분히 사용 가능하다.
 *
 * 시간 복잡도: O(n^3)
 * 공간 복잡도: O(n^3)
 */
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main250428 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++){
			arr[index] = Integer.parseInt(stArr.nextToken());
		}


		Main250428 main = new Main250428();
		System.out.println(main.solution(n, k, arr));


	}

	private int solution(int n, int k, int[] arr) {
		Set<Integer> sumSet = new HashSet<>();

		for(int s1 = 0; s1 < n; s1++) {
			for(int s2 = s1 + 1; s2 < n; s2++) {
				for(int s3 = s2 + 1; s3 < n; s3++) {
					sumSet.add(arr[s1] + arr[s2] + arr[s3]);
				}
			}
		}
		if(sumSet.size() < k - 1) {
			return -1;
		}

		List<Integer> sortedList = sumSet
			.stream()
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());



		return sortedList.get(k - 1);
	}

}
