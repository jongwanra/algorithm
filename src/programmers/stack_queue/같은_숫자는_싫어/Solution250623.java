package programmers.stack_queue.같은_숫자는_싫어;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *
 * 문제 접근 방법
 * 스택을 이용해서 문제를 해결한다.
 * 1. 숫자를 전부 Stack에 넣는다.
 * 2. 숫자를 pop 하면서 새로 List에 넣는다. 이때, 연속된 숫자일 경우 넣지 않는다.
 */
import java.util.*;
import java.util.stream.*;
public class Solution250623 {
	// 한 항목에서 시간 초과 뜬 풀이
	public int[] solutionWithFail(int[] arr) {
		List<Integer> answer = new ArrayList<>();
		Deque<Integer> stack = new ArrayDeque<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));

		while(!stack.isEmpty()) {
			Integer popped = stack.pop();
			if(answer.isEmpty() || !answer.get(answer.size() - 1).equals(popped)) {
				answer.add(popped);
			}
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] solution(int[] arr) {
		List<Integer> answer = new ArrayList<>();

		answer.add(arr[0]);
		for(int index = 1; index < arr.length; index++) {
			if(arr[index] == answer.get(answer.size() - 1)) {
				continue;
			}
			answer.add(arr[index]);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Solution250623 solution = new Solution250623();
		System.out.println(Arrays.toString(solution.solution(new int[] { 1, 1, 3, 3, 0, 1, 1})));
		System.out.println(Arrays.toString(solution.solution(new int[] { 4,4,4,3,3})));
	}
}
