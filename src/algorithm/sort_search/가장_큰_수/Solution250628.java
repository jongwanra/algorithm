package algorithm.sort_search.가장_큰_수;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
 * 문제 접근 방법
 * numbers 가 100,000 길이를 가질 수 있다 보니, O(N^2) 밑으로 접근해야 한다.
 *
 * 결과: 30분 초과
 * compareTo에 대한 구현 방법을 자릿수 비교로 밖에 생각이 안갔음.
 * 다른 사람의 풀이를 보고 compareTo를 다른 방식으로 비교하는 걸 알 수 있었음.
 */

import java.util.*;
import java.util.stream.*;
public class Solution250628 {
	static class IntegerWrapper implements Comparable<IntegerWrapper> {
		int value;
		public IntegerWrapper(int number) {
			this.value = number;
		}


		@Override
		public int compareTo(IntegerWrapper o) {
			int mergedAB= Integer.valueOf(String.valueOf(this.value) + String.valueOf(o.value));
			int mergedBA = Integer.valueOf(String.valueOf(o.value) + String.valueOf(this.value));
			return mergedBA - mergedAB;
		}


	}
	public String solution(int[] numbers) {
		List<IntegerWrapper> numberList = new ArrayList<>();
		for(int number: numbers) {
			numberList.add(new IntegerWrapper(number));
		}

		Collections.sort(numberList);

		StringBuilder sb = new StringBuilder();
		for(IntegerWrapper number: numberList) {
			sb.append(number.value);
		}

		String result = sb.toString();
		if(result.charAt(0) == '0') {
			return "0";
		}

		return result;
	}

	public String anotherSolution(int[] numbers) {
		List<String> strList = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());

		Collections.sort(strList, (origin, target) ->
			Integer.valueOf(target + origin) - Integer.valueOf(origin + target));

		StringBuilder sb = new StringBuilder();
		for(String str: strList) {
			sb.append(str);
		}

		final String answer = sb.toString();
		return answer.charAt(0) == '0' ? "0": answer;
	}

	public static void main(String[] args) {
		Solution250628 solution = new Solution250628();
		System.out.println(solution.solution(new int[] {0, 0}));
		System.out.println(solution.solution(new int[] {3, 30, 34, 5, 9}));
	}
}
