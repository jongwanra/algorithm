package 자바_알고리즘_문제풀이_입문.string.유효한_팰린드롬;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/01-08
 *
 * 앞으로 읽거나 뒤로 읽거나 같은 문자열을 팰린드롬이라고 한다.
 * 팰린드롬이면 YES 아니면 NO 출력
 *
 * 알파벳만이며, 대소문자 구분을 하지 않는다.(알파벳 이외의 문자 무시)
 *
 * 문제 접근 방법
 * 왼쪽과 오른쪽에 위치를 가리키는 pos를 둔다.
 * 알파벳인 경우에만 돌고 나머진 무시한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: 1
 */

import java.io.*;

public class Main250415 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Main250415 main = new Main250415();
		System.out.println(main.solution(str));
	}

	private String solution(String originStr) {
		String str = originStr.toUpperCase();
		int rightPos = str.length() - 1;
		int leftPos = 0;

		while(leftPos < rightPos) {
			while(!Character.isAlphabetic(str.charAt(leftPos))) {
				leftPos++;
			}

			while(!Character.isAlphabetic(str.charAt(rightPos))) {
				rightPos--;
			}

			if(str.charAt(leftPos++) != str.charAt(rightPos--)) {
				return "NO";
			}

		}
		return "YES";
	}
}
