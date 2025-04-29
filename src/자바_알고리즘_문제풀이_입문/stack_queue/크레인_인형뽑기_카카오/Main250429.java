package 자바_알고리즘_문제풀이_입문.stack_queue.크레인_인형뽑기_카카오;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/05-03
 *
 * n * n 크기의 board
 * 격자 가장 아래 칸부터 쌓여 있음
 * 인형이 없는 곳에서 작동시킬 경우 아무일 없음
 *
 * 터트려져 사라진 인형의 개수를 구하자.
 * 문제 접근 방법
 * stack 자료구조를 이용해서 접근한다.
 *
 * n: boardNum, m: movesNum
 * 시간 복잡도: O(n * m)
 * 공간 복잡도: O(m)
 */
import java.util.*;
import java.io.*;

public class Main250429 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int boardNum = Integer.parseInt(br.readLine());
		// index 1번 부터 시작
		int[][] board = new int[boardNum + 1][boardNum + 1];

		for(int row = 1; row <= boardNum; row++ ){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= boardNum; col++){
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		final int movesNum = Integer.parseInt(br.readLine());
		StringTokenizer stMoves = new StringTokenizer(br.readLine());
		int[] moves = new int[movesNum];
		for(int index = 0; index < movesNum; index++) {
			moves[index] = Integer.parseInt(stMoves.nextToken());
		}

		Main250429 main = new Main250429();
		System.out.println(main.solution(boardNum, board, moves));
	}

	private int solution(int boardNum, int[][] board, int[] moves) {
		int answer = 0;
		Deque<Integer> basketStack = new ArrayDeque<>();

		for(int move: moves) {
			for(int row = 1; row <= boardNum; row++) {
				if(board[row][move] == 0) {
					continue;
				}

				final int target = board[row][move];

				if(!basketStack.isEmpty() && basketStack.peek() == target) {
					basketStack.pop();
					answer += 2;
				}else {
					basketStack.push(target);
				}
				board[row][move] = 0;
				break;
			}

		}

		return answer;
	}
}
