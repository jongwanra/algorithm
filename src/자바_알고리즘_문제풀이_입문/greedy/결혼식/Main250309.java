package 자바_알고리즘_문제풀이_입문.greedy.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-03
 *
 * 피로연 장소에 동시에 존재하는 최대 인원수
 * 13, 15일 경우 13시에는 존재하고 15시 정각에는 존재하지 않는 것으로 가정
 *
 *
 * 문제 접근 방법
 * 우선순위 큐로 넣는다.
 * 피로연에 들어오는 순서로 정렬을 한다.
 * 0 ~ 72까지 순차적으로 돌면서 아래를 체크한다.
 * 반복문이 돌 때 마다
 * 1. 피로연에 들어온 사람이 있는지 확인
 * 2. 피로연에서 나간 사람이 있는지 확인
 * 3. 들어온 사람의 max count 체크

 */
public class Main250309 {
	static class Time implements Comparable<Time> {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Time{" +
				"start=" + start +
				", end=" + end +
				'}';
		}
	}
	public static void main(String[] args) throws IOException {
		Main250309 main = new Main250309();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		Time[] times = new Time[n];

		for(int index = 0; index< n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[index] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		System.out.println(main.solution(n, times));
	}

	private int solution(int n, Time[] times) {
		int answer = Integer.MIN_VALUE;
		PriorityQueue<Integer> partyRoom = new PriorityQueue<>();

		List<Time> sortedTimes = Arrays.stream(times)
			.sorted()
			.collect(Collectors.toList());

		int timePos = 0;

		for(int currentTime = 0; currentTime <= 72; currentTime++) {
			while(timePos < n && sortedTimes.get(timePos).start == currentTime) {
				partyRoom.offer(sortedTimes.get(timePos).end - 1);
				timePos++;
			}

			answer = Math.max(partyRoom.size(), answer);
			while(!partyRoom.isEmpty() && partyRoom.peek() ==  currentTime) {
				partyRoom.poll();
			}
			// System.out.println("currentTime: " + currentTime + " / partyRoom.size() : " + partyRoom.size());


		}


		return answer;
	}

}
