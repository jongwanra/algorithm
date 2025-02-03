package 자바_알고리즘_문제풀이_입문.sort_search.장난꾸러기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-06
 *
 * 문제 접근 방법
 * 철수네 반에는 N명의 학생들이 존재
 * 작은 순으로 일렬로 세움
 * 철수가 앞 번호를 받고싶어서 자리를 바꿈. (철수 > 짝꿍)
 * 철수 반번호, 짝꿍 반 번호 차례대로 출력
 * ---
 * arr 복사
 * 복산한 arr를 오름차순 정렬
 * 두개의 arr을 비교하며 다른 두 개 요소의 인덱스를 뽑는다.
 */
public class Main250204 {
	private List<Integer> solution(int n, int[] arr) {
		List<Integer> originList = Arrays.stream(arr)
			.boxed()
			.collect(Collectors.toList());


		List<Integer> sortedList = Arrays.stream(arr)
			.boxed()
			.sorted()
			.collect(Collectors.toList());

		List<Integer> answer = new ArrayList<>();

		for(int index = 0; index < n; index++) {
			if(!originList.get(index).equals(sortedList.get(index))) {
				answer.add(index + 1);
			}
		}
		return answer;
	}

	// arr.clone() 을 통해서 깊은 복사 진행
	// Arrays.sort()를 통해 정렬 진행
	private List<Integer> lectureSolution(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		int[] tmp = arr.clone();
		Arrays.sort(tmp);

		for(int index = 0; index < n; index++) {
			if(arr[index] != tmp[index]){
				answer.add(index + 1);
			}
		}
		return answer;
	}


	public static void main(String[] args) throws IOException {
		Main250204 main = new Main250204();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}
		main.solution(n, arr)
			.forEach(element -> System.out.print(element + " "));
	}
}
