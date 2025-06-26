package algorithm.array.큰_수_출력하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-01
 *
 * 요약
 * 자신의 바로 전의 숫자보다 큰 숫자만 출력
 * 첫 번째 수는 무조건 출력
 * input: 7 3 9 5 6 12
 * output: 7 9 6 12
 *
 * 문제 접근
 * 반복문을 돌면서 자신의 전 수와 비교 이후에 큰 수면 배열에 넣는다.
 * index가 0일 경우는 바로 넣는다.
 */
public class Main241125 {
	private List<Integer> solution(int n, int[] numbers) {
		List<Integer> answer = new ArrayList<>();

		for(int index = 0; index < n; index++) {
			if(index == 0) {
				answer.add(numbers[index]);
				continue;
			}

			if(numbers[index] > numbers[index - 1]) {
				answer.add(numbers[index]);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Main241125 main = new Main241125();
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for(int index = 0; index < n; index++) {
			numbers[index] = scanner.nextInt();
		}

		List<Integer> result = main.solution(n, numbers);
		for (Integer num : result) {
			System.out.print(num + " ");
		}
	}
}
