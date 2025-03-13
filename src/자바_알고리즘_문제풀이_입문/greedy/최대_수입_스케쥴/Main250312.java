package 자바_알고리즘_문제풀이_입문.greedy.최대_수입_스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-04
 *
 * 문제 접근 방법
 * PriorityQueue로 문제를 접근한다.
 * 시간 순으로 내림차순 정렬을 한다.
 * 이후에 뒤에 날짜부터 채워 나갈 건데, maxDDay가 필요.
 * 선택 가능한 경우를 PriorityQueue에 계속 넣어주고 그 안에서 값을 꺼낸다.
 */
public class Main250312 {
	static class Lecture implements Comparable<Lecture>{
		int cost;
		int day;

		public Lecture(int cost, int day) {
			this.cost = cost;
			this.day = day;
		}

		@Override
		public int compareTo(Lecture o) {
			// 시간 내림차순
			return o.day - this.day;
		}

		@Override
		public String toString() {
			return "Lecture{" +
				"cost=" + cost +
				", day=" + day +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {
		Main250312 main = new Main250312();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int maxDay= Integer.MIN_VALUE;
		List<Lecture> lectures = new ArrayList<>(n);
		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int cost = Integer.parseInt(st.nextToken());
			final int day = Integer.parseInt(st.nextToken());
			maxDay = Math.max(maxDay, day);
			lectures.add(new Lecture(cost, day));
		}

		System.out.println(main.solution(lectures, maxDay));
	}

	private int solution(List<Lecture> lectures, int maxDay) {
		int answer = 0;
		Collections.sort(lectures);
		Queue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
		int lastLectureIndex = 0;
		for(int currentDay = maxDay; currentDay > 0; currentDay--) {
			while(lastLectureIndex < lectures.size()){
				Lecture lecture = lectures.get(lastLectureIndex);

				if(lecture.day != currentDay){
					break;
				}

				pQ.offer(lecture.cost);
				lastLectureIndex++;
			}

			if(!pQ.isEmpty()){
				answer += pQ.poll();
			}

		}
		return answer;
	}
}
