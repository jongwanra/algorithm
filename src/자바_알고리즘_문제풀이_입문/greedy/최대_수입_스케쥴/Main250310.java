package 자바_알고리즘_문제풀이_입문.greedy.최대_수입_스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-04
 *
 * D일 안에 와서 강의를 하면 M 만큼의 강연료를 준다.
 * 가장 많은 돈을 벌 수 있게끔 일정 관리 필요
 * 하루에 하나의 기업 강연만 가능.
 *
 * 문제 접근 방법
 * n^2로는 접근 불가.
 * PriorityQueue로 접근
 * D가 가장 크고, 비용이 비싼걸 우선적으로 뽑아 낸다.
 */
public class Main250310 {
	static class LectureOrder implements Comparable<LectureOrder> {
		int cost;
		int dDay;

		public LectureOrder(int cost, int dDay) {
			this.cost = cost;
			this.dDay = dDay;
		}

		@Override
		public int compareTo(LectureOrder o) {
			if(this.dDay == o.dDay){
				return o.cost - this.cost;
			}
			return o.dDay - this.dDay;
		}

		@Override
		public String toString() {
			return "LectureOrder{" +
				"cost=" + cost +
				", dDay=" + dDay +
				'}';
		}
	}
	public static void main(String[] args) throws IOException {
		Main250310 main = new Main250310();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int maxDDay = Integer.MIN_VALUE;
		List<LectureOrder> lectureOrders = new ArrayList<>();
		for(int index = 0; index < n; index++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int cost = Integer.parseInt(st.nextToken());
			final int dDay = Integer.parseInt(st.nextToken());
			maxDDay = Math.max(dDay, maxDDay);
			lectureOrders.add(new LectureOrder(cost, dDay));
		}

		System.out.println(main.solution(lectureOrders));
	}

	private int solution(List<LectureOrder> lectureOrders) {
		int answer = 0;
		Queue<LectureOrder> queue = new PriorityQueue<>(lectureOrders);
		int currentDay = 1;
		while(!queue.isEmpty()) {
			LectureOrder lectureOrder = queue.poll();
			if(currentDay > lectureOrder.dDay ) {
				continue;
			}
			System.out.println("lectureOrder = " + lectureOrder + " currentDay : " + currentDay);
			answer += lectureOrder.cost;
			currentDay++;

		}
		return answer;
	}
}
