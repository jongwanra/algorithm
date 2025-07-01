package algorithm.exhaustive_search.최소직사각형;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 *
 * 문제 접근 방법
 * 가로 * 세로의 명함이 주어졌을 때, 가로 길이가 더 짧은 경우 회전시킨다.
 * 그 이후의 결과 값을 구한다.
 */

public class Solution250702 {
	static class BusinessCard {
		int width;
		int length;

		public BusinessCard(int width, int length) {
			this.width = width;
			this.length = length;
		}

		public void rotate(){
			if(width < length) {
				int temp = width;
				width = length;
				length = temp;
			}
		}

	}

	public int solution(int[][] sizes) {
		int maxWidth = Integer.MIN_VALUE;
		int maxLength = Integer.MIN_VALUE;
		for(int[] size: sizes) {
			BusinessCard newCard = new BusinessCard(size[0], size[1]);
			newCard.rotate();
			maxWidth = Math.max(newCard.width, maxWidth);
			maxLength = Math.max(newCard.length, maxLength);
		}

		return maxWidth * maxLength;
	}

	public static void main(String[] args) {
		Solution250702 solution = new Solution250702();
		solution.solution(new int[][] {});
	}
}
