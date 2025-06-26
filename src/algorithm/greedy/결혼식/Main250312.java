package algorithm.greedy.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-03
 * 피로연 장소에 동시에 존재하는 최대 인원수를 구함.
 *
 * 문제 접근 방법
 * 몇시에 들어오고 몇시에 나가는지를 각각 객체로 List에 집어 넣는다
 * 시간순 오름차순으로 정렬
 * 같은 시간대에 나가는 사람은 그 인원수를 포함하지 않는 걸로 가정하기 떄문에
 * 먼저 카운팅 이후에 카운팅 비교 필요
 */
public class Main250312 {
	static class Time implements Comparable<Time> {
		static final int ENTERED = 1;
		static final int LEFT = 0;

		int time;
		int status;

		public Time(int time, int status) {
			this.time = time;
			this.status = status;
		}

		@Override
		public int compareTo(Time o) {
			if(this.time == o.time) {
				return this.status - o.status;
			}

			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Time{" +
				"time=" + time +
				", status=" + status +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {
		Main250312 main = new Main250312();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>(n * 2);

		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int enteredTime = Integer.parseInt(st.nextToken());
			final int leftTime = Integer.parseInt(st.nextToken());
			times.add(new Time(enteredTime, Time.ENTERED));
			times.add(new Time(leftTime, Time.LEFT));
		}

		System.out.println(main.solution(times));
	}

	private int solution(List<Time> times) {
		int answer = Integer.MIN_VALUE;
		Collections.sort(times);
		int count = 0;

		for(Time time: times){
			if(time.status == Time.ENTERED) {
				count++;
			}else {
				count--;
			}
			answer = Math.max(count, answer);
		}


		return answer;
	}
}
