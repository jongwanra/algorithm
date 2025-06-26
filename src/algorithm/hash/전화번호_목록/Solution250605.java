package algorithm.hash.전화번호_목록;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java
 * 특정 번호가 다른 번호의 접두어 여부 확인
 * 구조대 -> 지영석 접두사이다.
 *
 * phone_book -> 1_000_000
 * 전화번호의 길이 <= 20
 * 전화번호 중복 x
 *
 * 문제 접근 방법
 * 우선 n^2의 시간 복잡도는 걸리면 시간 제한에 걸리기 때문에 안된다.
 *
 */
public class Solution250605 {
	public boolean anotherSolution(String[] phone_book) {
		Set<String> phoneBookSet = Arrays.stream(phone_book).collect(Collectors.toSet());

		for(String phone: phone_book) {
			// 각 핸드폰 번호를 확인한다.
			for(int index = 1; index < phone.length(); index++) {
				String comparePrefix = phone.substring(0, index);
				if(phoneBookSet.contains(comparePrefix)) {
					return false;
				}
			}
		}

		return true;
	}
	// 실패
	// TODO 시간 복잡도 분석 필요
	public boolean solution(String[] phone_book) {
		for(int index = 0; index < phone_book.length; index++) {
			for(int compareIndex = 0; compareIndex < phone_book.length; compareIndex++) {
				if(index == compareIndex) {
					continue;
				}

				if(isSamePrefix(phone_book[index], phone_book[compareIndex])){
					return false;
				}
			}
		}
		return true;
	}

	private boolean isSamePrefix(String phone, String comparePhone) {
		// System.out.println("phone: " + phone + " comparePhone: " + comparePhone);
		if(phone.length() > comparePhone.length()){
			return false;
		}

		for(int index = 0; index < phone.length(); index++) {
			if(phone.charAt(index) != comparePhone.charAt(index)){
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Solution250605 main = new Solution250605();
		System.out.println(main.anotherSolution(new String[] { "119", "97674223", "1195524421"}));
	}
}
