package algorithm.string.암호;

import java.util.Scanner;

import javax.lang.model.element.NestingKind;

/**
 * https://cote.inflearn.com/contest/10/problem/01-12
 *
 * 요약
 * 디코드 방법
 * 1. 일곱자리의 이진수로 바꿈
 * #은 이진수의 1
 * *은 이진수의 0
 * 2. 2진수를 10진수화 한다.
 *
 * 접근 방법
 * 1. 반복문을 들어간다. 7자리 씩 substring한다.
 * 2. 모스부호 -> 2진수 -> 10진수로 decode한다. (decode function)
 * 3. 모은 문자들 출력한다.
 */
public class Main241125 {
	public static void main(String[] args) {
		Main241125 main = new Main241125();
		Scanner scanner = new Scanner(System.in);
		System.out.println(main.solution(Integer.valueOf(scanner.nextLine()), scanner.nextLine()));
	}
	private String solution(int n, String encodedStr) {
		StringBuilder answerStringBuilder = new StringBuilder();
		for(int index = 0; index < n; index++) {
			String target = encodedStr.substring(0, 7);
			answerStringBuilder.append(decode(target));
			encodedStr = encodedStr.substring(7);
		}

		return answerStringBuilder.toString();
	}
	private char decode(String encodedStr) {
		StringBuilder binaryCodeStringBuilder = new StringBuilder();
		// 1. 2진수로 바꿈
		for(char encodedCh: encodedStr.toCharArray()){
			binaryCodeStringBuilder.append(encodedCh == '#' ? '1' : '0');
		}
		final String binaryCode = binaryCodeStringBuilder.toString();
		// 2. 2진수를 10진수로 바꿈
		return (char)convertBinaryToDecimal(binaryCode);
	}

	private int convertBinaryToDecimal(String binaryCode) {
		int result = 0;
		for(int index = 0; index < binaryCode.length(); index++) {
			double digits = Math.pow(2, index);
			int targetIndex = binaryCode.length() - index - 1;
			int targetBinary = binaryCode.charAt(targetIndex) - '0';
			result += targetBinary * digits;
		}
		return result;
	}

	// 배운점. 10진수를 2진수로 바꿀 때 메서드가 존재한다. Integer.parseInt(String str, 2);
	// replace method를 사용해서 문자열 안의 특정 문자를 변경할 수 있다.
	private String lectureSolution(int n, String str) {
		String answer = "";
		for(int i = 0; i < n; i++) {
			String tmp = str.substring(0, 7)
				.replace('#', '1')
				.replace('*', '0');

			final int binaryCode = Integer.parseInt(tmp, 2);
			answer += (char) binaryCode;
			str = str.substring(7);
		}

		return answer;
	}


}
