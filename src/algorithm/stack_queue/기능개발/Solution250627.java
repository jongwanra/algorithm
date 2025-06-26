package algorithm.stack_queue.기능개발;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *
 * 배포는 순서가 정해져 있다. 앞의 기능이 배포되어야 뒤에 기능도 배포 가능하다.
 *
 * 문제 접근 방법
 * Queue 자료구조를 이용한다.
 * Task 클래스를 구현한다. (progress, speed)
 * 하루가 지날 때마다, 작업들에 progress를 채운다.
 * 100이 되었을 경우 answer에 추가한다.
 *
 * 시간 복잡도: O(n^2) -> n은 progresses.length
 * 공간 복잡도: O(n)
 */
import java.util.*;
public class Solution250627 {
	static class Task {
		int progress;
		int speed;

		public Task(int progress, int speed) {
			this.progress = progress;
			this.speed = speed;
		}

		public void renew() {
			progress += speed;
		}

		public boolean isCompleted() {
			return progress >= 100;
		}
	}

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();

		Queue<Task> queue = new ArrayDeque<>();

		for(int index = 0; index < progresses.length; index++) {
			queue.offer(new Task(progresses[index], speeds[index]));
		}

		while(!queue.isEmpty()) {
			// 하루가 지나서, 진행 상태 업데이트 한다.
			for(Task task: queue) {
				task.renew();
			}

			// 완료된 업무들이 있다면 종료시키고 갯수를 반환한다.
			int completedCount = 0;
			while(!queue.isEmpty() && queue.peek().isCompleted()) {
				completedCount++;
				queue.poll();
			}

			if(completedCount > 0) {
				answer.add(completedCount);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}


	public static void main(String[] args) {
		Solution250627 solution = new Solution250627();
		System.out.println(Arrays.toString(solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
		System.out.println(Arrays.toString(solution.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
	}
}
