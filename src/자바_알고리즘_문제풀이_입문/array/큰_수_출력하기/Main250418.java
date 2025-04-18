package 자바_알고리즘_문제풀이_입문.array.큰_수_출력하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/02-01
 *
 * 자신의 앞 수 보다 큰 수만 출력한다.
 * 첫 수는 무조건 출력한다.
 * 문제 접근 방법
 *
 * 첫 수는 배열에 저장한다.
 * 첫 번째 index부터 반복하여 앞수 여부를 확인한다.
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(n)
 */
import java.util.*;
import java.io.*;
public class Main250418 {
	public static void main(String[] args) throws IOException {
		Main250418 main = new Main250418();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		List<Integer> answers = main.solution(n, arr);
		for(int answer: answers) {
			System.out.print(answer + " ");
		}
	}

	private List<Integer> solution(int n, int[] arr) {
		List<Integer> answers = new ArrayList<>();
		answers.add(arr[0]);

		for(int index = 1; index < n; index++) {
			if(arr[index - 1] < arr[index]) {
				answers.add(arr[index]);
			}
		}

		return answers;
	}
}
