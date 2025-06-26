package algorithm.string.숫자만_추출;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-09
 *
 * 요약
 * 문자열 중 숫자만 추출해서 자연수! 만들기
 * 앞이 0일 경우 주의 필요
 *
 * 문제 접근 방법
 * StringBuilder를 이용해서 숫자만 추출
 * 해당 문자열을 Integer.valueOf()로 변환
 */
public class Main241121 {
	public static void main(String[] args) {
		Main241121 main = new Main241121();
		System.out.println(main.solution(new Scanner(System.in).nextLine()));
	}

	private Integer solution(String s ){
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < s.length(); index++) {
			if(Character.isDigit(s.charAt(index))) {
				sb.append(s.charAt(index));
			}
		}

		return Integer.valueOf(sb.toString());
	}

	private int lectureSolution(String s) {
		int answer = 0;
		for(char x : s.toCharArray()) {
			if(x >= 48 && x <= 57) {
				answer = answer * 10 + (x - 48);
			}
		}
		return answer;
	}
}
