package algorithm.sort_search.뮤직비디오;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-09
 *
 * DVD의 크기를 최소로 하려고함.
 * DVD M개에 모든 동영상을 녹화해야 함.
 * M개의 DVD 크기는 모두 같은 크기
 *
 * 문제 접근 방법
 * 변하는 요소는 DVD의 크기이다.
 * DVD의 최소 크기는 주어진 노래 중 가장 긴 노래
 * DVD의 최대 크기는 주어진 노래 전체 합이다.
 *
 * 시간 복잡도: O(n log(n))
 * 공간 복잡도: O(1)
 *
 *
 * 기억하면 좋을 부분.
 * Arrays.stream(int[]).sum();
 * Arrays.stream(int[]).max().getAsInt();
 * isPossibleDvdSize()에서 for-each문을 통해 song을 대입하는 부분
 */
import java.util.*;
import java.io.*;
public class Main250506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int dvdNum = Integer.parseInt(inputs[1]);
		int[] songs = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++ ){
			songs[index] = Integer.parseInt(st.nextToken());
		}

		Main250506 main = new Main250506();
		System.out.println(main.solution2(n, dvdNum, songs));
	}

	private int solution(int n, int dvdNum, int[] songs) {
		int answer = Integer.MAX_VALUE;
		int minDvdSize = 0;
		int maxDvdSize = 0;
		for(int song: songs) {
			if(minDvdSize < song) {
				minDvdSize = song;
			}
			maxDvdSize += song;
		}

		while(minDvdSize <= maxDvdSize) {
			final int currentDvdSize = (minDvdSize + maxDvdSize) / 2;
			if(isPossible(currentDvdSize, n, songs, dvdNum)) {
				answer = Math.min(answer, currentDvdSize);
				maxDvdSize = currentDvdSize - 1;
				continue;
			}
			minDvdSize = currentDvdSize + 1;

		}
		return answer;
	}

	private int solution2(int n, int dvdNum, int[] songs) {
		int answer = 0;
		int minDvdSize = Arrays.stream(songs).max().orElse(0);
		int maxDvdSize = Arrays.stream(songs).sum();

		while(minDvdSize <= maxDvdSize) {
			final int currentDvdSize = (minDvdSize + maxDvdSize) / 2;
			if(isPossibleDvdSize(currentDvdSize, dvdNum, songs)){
				answer = currentDvdSize;
				maxDvdSize = currentDvdSize - 1;
				continue;
			}
			minDvdSize = currentDvdSize + 1;
		}

		return answer;
	}

	private boolean isPossibleDvdSize(int dvdSize, int dvdNum, int[] songs) {
		int usedDvdCount = 1;
		int sum = 0;
		for(int song: songs) {
			if(sum + song > dvdSize) {
				usedDvdCount++;
				sum = song;
				continue;
			}
			sum += song;
		}
		return usedDvdCount <= dvdNum;
	}

	private boolean isPossible(int currentDvdSize, int n, int[] song, int dvdNum) {
		int currentDvdNum = 1;
		int sum = 0;
		for(int index = 0; index < n; index++) {
			sum += song[index];
			if(sum > currentDvdSize) {
				sum = 0;
				currentDvdNum++;
				index--;
			}
		}

		return currentDvdNum <= dvdNum;
	}

}
