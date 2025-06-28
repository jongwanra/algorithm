package algorithm.sort_search.K번째수;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 주의 사항: 모든 파라미터는 1부터 시작
 *
 * 문제 접근 방법
 * 단순 구현 문제.
 * 1. 자른다.
 * 2. 정렬한다.
 * 3. K번째 수를 구한다.
 * 4. 반복
 *
 * 시간 복잡도
 * commands.length -> L
 * array.length -> N
 *
 * => O(L * N Log N)
 *
 * 공간 복잡도
 * => O(L + N)
 *
 */
import java.util.*;
public class Solution250628 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		int answerIndex = 0;
		// O(L)
		for(int[] command: commands) {
			final int fromIndex = command[0] - 1;
			final int toIndex = command[1] - 1;
			final int kIndex = command[2] - 1;

			// 자르기. O(N)
			List<Integer> targets = new ArrayList<>();
			for(int index = fromIndex; index <= toIndex; index++) {
				targets.add(array[index]);
			}

			// 정렬 O(N log N)
			Collections.sort(targets);

			// 고르기 O(1)
			answer[answerIndex++] = targets.get(kIndex);

		}
		return answer;
	}

	public static void main(String[] args) {
		Solution250628 solution = new Solution250628();
		System.out.println(Arrays.toString(solution.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
	}
}
