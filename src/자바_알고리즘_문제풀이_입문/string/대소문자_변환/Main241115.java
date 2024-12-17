package 자바_알고리즘_문제풀이_입문.string.대소문자_변환;

import java.util.Scanner;

import com.sun.tools.javac.Main;

/**
 * https://cote.inflearn.com/contest/10/problem/01-02
 * 접근 방법
 * 1. 문자열을 반복문을 돌면서 대문자면 소문자로, 소문자면 대문자로 변환하여 출력한다.
 */
public class Main241115 {
	private String solution(String str) {
		StringBuilder sb = new StringBuilder();
		for(char ch: str.toCharArray()){
			if(ch >= 'A' && ch <= 'Z') {
				sb.append(Character.toLowerCase(ch));
			}else {
				sb.append(Character.toUpperCase(ch));
			}
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Main241115 main = new Main241115();
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		System.out.println(main.solution(str));


	}
}
