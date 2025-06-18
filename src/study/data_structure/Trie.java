package study.data_structure;

import java.util.*;

public class Trie {
	private final Node root;

	public Trie() {
		this.root = new Node( false);
	}



	private void insert(String word) {
		Node current = root;
		for(int index = 0; index < word.length(); index++) {
			boolean endOfWord = index == word.length() - 1;
			Node addNode = new Node(endOfWord);

			current.child.putIfAbsent(word.charAt(index), addNode);
			current = current.child.get(word.charAt(index));
		}
	}

	private boolean search(String word) {
		Node current = root;
		for(int index = 0; index < word.length(); index++) {
			if(!current.child.containsKey(word.charAt(index))) {
				return false;
			}

			current = current.child.get(word.charAt(index));
		}

		return current.endOfWord;
	}


	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("car");
		trie.insert("caa");
		System.out.println(trie.search("car"));
		System.out.println(trie.search("caa"));
		System.out.println(trie.search("cab"));
		System.out.println(trie.search("aaaaaa"));


	}



	static class Node {
		boolean endOfWord;
		Map<Character, Node> child = new HashMap<>();

		public Node(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}
}
