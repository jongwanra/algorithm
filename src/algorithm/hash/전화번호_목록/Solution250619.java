package algorithm.hash.전화번호_목록;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 문제 접근 방법
 * Trie 자료 구조를 이용해서 문제를 해결한다.
 *
 * 시간 복잡도: O(N * L) -> phone_book의 길이 * 각 전화번호의 길이 -> 1,000,000 * 20 -> 20,000,000
 * 공간 복잡도: O(N * L)
 */

import java.util.*;
public class Solution250619 {
	static class Trie {
		private Node root;

		public Trie() {
			this.root = new Node();
		}

		public void put(String word) {
			Node current = root;
			for(int index = 0; index < word.length(); index++) {
				final boolean endOfWord = index == word.length() - 1;
				Node addNode = new Node();
				current.child.putIfAbsent(word.charAt(index), addNode);

				Node nextNode = current.child.get(word.charAt(index));
				if(endOfWord) {
					nextNode.updateEndOfWord(true);
				}
				current = nextNode;
			}
		}

		public boolean isPrefix(String word) {
			Node current = root;

			for(int index = 0; index < word.length(); index++) {
				if(!current.child.containsKey(word.charAt(index))) {
					return false;
				}
				current = current.child.get(word.charAt(index));
			}

			// 접두어 인지를 알기 위해서는 endOfWord로는 확인이 어렵다.
			// endOfWord가 true일 경우 자기 자신일 수 있기 떄문
			// endOfWord가 false일 경우는 말이 안된다. 구현이 제대로 안되었을 가능성이 크다.
			// 119일 경우에 9는 무조건 true일 수밖에 없다.
			// 따라서 뒤에 child가 isEmpty()인 경우로 접두어 여부를 확인했다.
			return !current.child.isEmpty();
		}

		static class Node {
			boolean endOfWord;
			Map<Character, Node> child = new HashMap<>();

			public Node() {
			}

			public void updateEndOfWord(boolean endOfWord) {
				this.endOfWord = endOfWord;
			}
		}
	}
	public boolean solution(String[] phoneBook) {
		Trie trie = new Trie();

		// O(N * L)
		for(String phone: phoneBook) {
			trie.put(phone);
		}

		// O(N * L)
		for(String phone: phoneBook) {
			if(trie.isPrefix(phone)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution250619 solution = new Solution250619();
		System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421" }));
		System.out.println(solution.solution(new String[]{"123","456","789" }));
		System.out.println(solution.solution(new String[]{"12","123","1235","567","88" }));
	}
}
