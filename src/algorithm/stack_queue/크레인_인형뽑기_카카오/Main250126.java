package algorithm.stack_queue.크레인_인형뽑기_카카오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-03
 *
 * 문제 조건
 * 바구니에 같은 모양이 두 개 연속으로 쌓일 경우 제거됨.
 * 아무 것도 없는 col에 시도할 경우 아무일도 발생 하지 않음.
 * moves의 각 원소들의 값은 1 이상이다.
 *
 * 문제 접근 방법
 * 구현 문제 + Stack을 이용하는 문제로 보인다.
 * 우선 입력을 전부 받자.
 * board의 값이 0이 아닌 경우 pop하여 바구니에 집어넣는다.
 * * 바구니도 조건에 맞춰서 동일한 원소인지를 체크한다.
 * * 동일한 원소인 경우 사라진 개수를 체크한다.(출력값)
 */
public class Main250126 {
	public static void main(String[] args) throws IOException {
		Main250126 main = new Main250126();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		// 전부 처음 시작을 1로 맞추기.
		int[][] board = new int[n + 1][n + 1];

		for (int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int col = 1; col <= n; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}

		}

		final int movesSize = Integer.parseInt(br.readLine());
		int[] moves = new int[movesSize];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int index = 0; index < movesSize; index++) {
			moves[index] = Integer.parseInt(st.nextToken());
		}

		System.out.println(main.solution(n, board, moves));

	}

	private int solution(int n, int[][] board, int[] moves) {
		Deque<Integer> bucket = new ArrayDeque<>();
		int answer = 0;

		for (int col : moves) {
			for (int row = 1; row <= n; row++) {
				if (board[row][col] == 0) {
					continue;
				}

				if (!bucket.isEmpty() && bucket.peek() == board[row][col]) {
					bucket.pop();
					answer += 2;
				} else {
					bucket.push(board[row][col]);
				}

				board[row][col] = 0;
				break;
			}
		}

		return answer;
	}
}
