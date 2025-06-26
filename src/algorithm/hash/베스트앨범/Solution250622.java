package algorithm.hash.베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 *
 * 장르별 가장 많이 재생된 노래 두 개씩 모아 앨범 출시.
 * 정렬 기준
 * 1.가장 많은 재생 수를 기록한 장르의 노래 2개
 * 2.장르 내에서 많이 재생된 노래를 먼저 수록
 * 3. 재생 횟수가 같으면 고유 번호 기준으로 정렬
 *
 * 앨범에 들어갈 노래의 고유 번호를 순서대로 출력
 * 문제 접근 방법
 * 1. Genre, Play 설계 및 Comparable 구현
 * 2. 이후 PlayList Sorting
 * 3. PriorityQueue를 이용한 Genre poll()
 *
 *
 * 문제에서 본 내가 부족한 부분.
 * 1. 문제를 구현하기 이전에는 HashMap을 통해서 단순 접근을 하려고 했다는 점이 패인 포인트이다.
 *    객체를 활용하여 문제를 접근할 생각을 못했음.
 * 2. PriorityQueue, Sort, EqualsAndHashCode
 *    항상 Editor에 의존하다 보니, IDE를 사용하지 않고 풀었을 때 익숙하지 않고, 작성에 굉장히 느림.
 *    Equals, HashCode, Sort, PriorityQueue에 대해서 암기 필요.
 * 3. List<Integer> -> int[]로 변환하는 방법 숙지 필요하다.
 */
public class Solution250622 {
	static class Play implements Comparable<Play>{
		int id;
		int playCount;

		public Play(int id, int playCount) {
			this.id = id;
			this.playCount = playCount;
		}

		@Override
		public String toString() {
			return "Play{" +
				"id=" + id +
				", playCount=" + playCount +
				'}';
		}

		@Override
		public int compareTo(Play o) {
			if(this.playCount == o.playCount) {
				return this.id - o.id;
			}

			return o.playCount - this.playCount;
		}
	}
	static class Genre implements Comparable<Genre> {
		String name;
		List<Play> playList;
		int totalPlayCount;

		public Genre(String name) {
			this.name = name;
			this.playList = new ArrayList<>();
			this.totalPlayCount = 0;
		}

		@Override
		public String toString() {
			return "Genre{" +
				"name='" + name + '\'' +
				", playList=" + playList +
				", totalPlayCount=" + totalPlayCount +
				'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Genre genre = (Genre)o;
			return Objects.equals(name, genre.name);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name);
		}

		public void addPlay(int playId, int playCount) {
			this.playList.add(new Play(playId, playCount));
			this.totalPlayCount += playCount;
		}

		public void sortPlayList() {
			Collections.sort(this.playList);
		}

		@Override
		public int compareTo(Genre o) {
			return o.totalPlayCount - this.totalPlayCount;
		}
	}



	public int[] solution(String[] genres, int[] plays) {
		Map<String, Genre> nameToGenreMap = new HashMap<>();

		for(int index = 0; index < genres.length; index++) {
			nameToGenreMap
				// computeIfAbsent 활용
				.computeIfAbsent(genres[index], Genre::new)
				.addPlay(index, plays[index]);
		}

		for(Genre genre: nameToGenreMap.values()) {
			genre.sortPlayList();
		}

		PriorityQueue<Genre> genrePQ = new PriorityQueue<>(nameToGenreMap.values());

		List<Integer> answer = new ArrayList<>();
		while(!genrePQ.isEmpty()) {
			Genre genre = genrePQ.poll();
			List<Play> limittedPlayList = genre.playList
				.stream()
				.limit(2)
				.collect(Collectors.toList());

			for(Play p: limittedPlayList) {
				answer.add(p.id);
			}
		}


		// 이거 무조건 기억하자..
		return answer.stream().mapToInt(Integer::intValue)
			.toArray();

	}

	public static void main(String[] args) {
		int[] answer = new Solution250622().solution(new String[] {"classic", "pop", "classic", "classic", "pop"},
			new int[] {500, 600, 150, 800, 2500});

		System.out.println(Arrays.toString(answer));
	}
}
