package 자바_알고리즘_문제풀이_입문.string.암호;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/01-12
 *
 *  알파벳 대문자로 구성된 편지
 *  #은 1, *은 0 7자리 이진수로 변환
 *
 * 문제 접근 방법
 *
 * 문자열을 7자리마다 자른다.
 * 이진수로 변환한다.
 * 10진수로 변환한다.
 * 문자로 변경한다.
 *
 */

import java.io.*;
public class Main250416 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		Main250416 main = new Main250416();
		System.out.println(main.solution(n, s));
	}

	private String solution(int n, String s) {
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < n; index++) {
			String target = s.substring(0, 7);
			sb.append((char)convertBinaryToDecimal(convertToBinary(target)));
			s = s.substring(7);
		}
		return sb.toString();
	}

	private int convertBinaryToDecimal(String binaryCode) {
		return Integer.parseInt(binaryCode, 2);
	}

	private String convertToBinary(String encrypted) {
		StringBuilder binary = new StringBuilder();
		for(int index = 0; index < encrypted.length(); index++) {
			binary.append(encrypted.charAt(index) == '#' ? "1" : "0");
		}
		return binary.toString();
	}
}
