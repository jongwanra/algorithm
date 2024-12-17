package 자바_알고리즘_문제풀이_입문.string.회문_문자열;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-07
 *
 * 요약
 * 앞과 뒤가 거울 처럼 동일한 문자열일 경우 YES, 그렇지 않을 경우 NO 출력(대소문자 구분X)
 *
 * 문제 접근 방법
 * 1. left, right index를 둔다.
 * 2. 문자열을 while문으로 돌면서 동일한지 여부를 판단한다.
 */
public class Main241121 {
	public static void main(String[] args) {
		Main241121 main = new Main241121();
		Scanner scanner = new Scanner(System.in);
		System.out.println(main.solution(scanner.nextLine()));
	}

	private String solution(String str) {
		int lt = 0;
		int rt = str.length() -1;

		while(lt < rt) {
			final char targetLt = str.charAt(lt);
			final char targetRt = str.charAt(rt);
			if(Character.toLowerCase(targetLt) != Character.toLowerCase(targetRt)) {
				return "NO";
			}
			lt++;
			rt--;
		}
		return "YES";
	}

	// StirngBuilder를 통해서 뒤집어서 체크 하는 방법
	private String solution2(String str) {
		str = str.toUpperCase();
		final String reversedStr = new StringBuilder(str).reverse().toString();
		for(int index = 0; index < str.length(); index++) {
			if(str.charAt(index) != reversedStr.charAt(index)) {
				return "NO";
			}
		}
		return "YES";
	}

	private String lectureSolution(String str) {
		return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES": "NO";

	}
}
