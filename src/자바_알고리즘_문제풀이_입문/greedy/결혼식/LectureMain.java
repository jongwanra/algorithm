package 자바_알고리즘_문제풀이_입문.greedy.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LectureMain {


	static class Time implements Comparable<Time> {
		int time;
		char timeStatus; // s: 피로연 입장 / e: 피로연 나감

		public Time(int time, char timeStatus) {
			this.time = time;
			this.timeStatus = timeStatus;
		}

		@Override
		public int compareTo(Time o) {
			if(this.time == o.time) {
				return this.timeStatus - o.timeStatus;
			}
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Time{" +
				"time=" + time +
				", timeStatus=" + timeStatus +
				'}';
		}
	}
	public static void main(String[] args) throws IOException {
		LectureMain main = new LectureMain();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>();

		for(int index =0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times.add(new Time(Integer.parseInt(st.nextToken()), 's'));
			times.add(new Time(Integer.parseInt(st.nextToken()), 'e'));
		}

		System.out.println(main.solution(n, times));
	}

	private int solution(int n, List<Time> times) {
		int answer = Integer.MIN_VALUE;
		Collections.sort(times);

		int count = 0;
		for(Time time: times) {
			if(time.timeStatus == 's') {
				count++;
			} else{
				count--;
			}

			answer = Math.max(count, answer);
		}
		return answer;
	}
}
