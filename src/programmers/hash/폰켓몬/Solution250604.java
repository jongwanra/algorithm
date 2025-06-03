package programmers.hash.폰켓몬;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * 문제 접근 방법
 * HashSet을 이용해서 종류의 수를 구한다.
 * 종류의 수 <= n/2 종류의 수 return;
 * 그렇지 않은 경우 n/2 return;
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(n)
 */
import java.util.*;
import java.util.stream.*;
public class Solution250604 {
	public int solution(int[] nums) {
		Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		final int limit = nums.length / 2;

		return numSet.size() <= limit ? numSet.size() : limit;
	}
}
