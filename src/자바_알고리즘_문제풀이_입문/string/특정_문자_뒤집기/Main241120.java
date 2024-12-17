package 자바_알고리즘_문제풀이_입문.string.특정_문자_뒤집기;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-05
 * 요약
 * 알파벳, 특수문자로 구성된 문자열 중 알파벳만 뒤집는다.
 *
 * 문제 접근 방법
 * 1. lt, rt를 둔다.
 * 2. lt와 rt를 각각 왼쪽 끝, 오른쪽 끝에서 부터 접근해오면서 영어인 경우에 swap을 한다.
 */
public class Main241120 {
	public static void main(String[] args) {
		Main241120 main = new Main241120();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println(main.solution(input));
	}

	private String solution(String input) {
		char[] chars = input.toCharArray();
		int lt = 0;
		int rt = chars.length - 1;

		while(lt < rt) {
			if(!Character.isAlphabetic(chars[lt])) {
				lt++;
				continue;
			}

			if(!Character.isAlphabetic(chars[rt])) {
				rt--;
				continue;
			}

			// swap
			char tmp = chars[lt];
			chars[lt] = chars[rt];
			chars[rt] = tmp;

			lt++;
			rt--;
		}

		return String.valueOf(chars);
	}
}
