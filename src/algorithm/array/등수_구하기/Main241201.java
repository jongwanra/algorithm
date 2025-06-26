package algorithm.array.등수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * https://cote.inflearn.com/contest/10/problem/02-08
 *
 * 문제 접근 방법
 * 1. 내림차순 정렬
 * 2. Map 자료구조를 이용해서 key: score, value: rank로 저장
 * 3. 입력된 점수에 따라 등수 반환
 */
public class Main241201 {
	public static void main(String[] args) throws IOException {
		Main241201 main = new Main241201();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[n];
		for(int index = 0; index <n ;index++){
			scores[index] = Integer.parseInt(st.nextToken());
		}

		int[] answer = main.solution2(n, scores);

		for (int ans : answer) {
			System.out.print(ans + " ");
		}

	}

	private int[] solution(int n, int[] scores) {
		List<Integer> scoresToSort = new ArrayList<>(n);
		for (int score : scores) {
			scoresToSort.add(score);
		}

		// 내림차순 정렬
		scoresToSort.sort(Integer::compareTo);
		Collections.reverse(scoresToSort);

		Map<Integer, Integer> scoreToRankMap = new HashMap<>();
		int rank = 1;
		scoreToRankMap.put(scoresToSort.get(0), rank);
		for(int index = 1; index < n; index++){
			if(scoresToSort.get(index).equals(scoresToSort.get(index -1 ))){
				rank++;
			}else {
				scoreToRankMap.put(scoresToSort.get(index), ++rank);
			}
		}

		int[] answer = new int[n];
		for(int index = 0; index < n; index++) {
			answer[index] = scoreToRankMap.get(scores[index]);
		}
		return answer;
	}


	// Stream을 이용해서 배열을 내림차순 정렬 해보기.
	private int[] solution2(int n, int[] scores) {
		List<Integer> sortedScores = Arrays.stream(scores)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.toList();


		Map<Integer, Integer> scoreToRankMap = new HashMap<>();
		int rank = 1;
		scoreToRankMap.put(sortedScores.get(0), rank);
		for(int index = 1; index < n; index++){
			if(sortedScores.get(index).equals(sortedScores.get(index -1 ))){
				rank++;
			}else {
				scoreToRankMap.put(sortedScores.get(index), ++rank);
			}
		}

		return Arrays.stream(scores)
			.boxed()
			.mapToInt(scoreToRankMap::get)
			.toArray();
	}
}
