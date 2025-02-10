package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.이진트리_순회_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	int data;
	Node lt;
	Node rt;

	public Node(int data) {
		this.data = data;
	}
}

public class Main250211 {


	Node root;
	private void bfs(Node node) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(node);
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.println("level: " + level);
			final int len = queue.size();
			for(int index = 0; index < len; index++) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data + " ");
				if(currentNode.lt != null){
					queue.offer(currentNode.lt);
				}
				if(currentNode.rt != null) {
					queue.offer(currentNode.rt);
				}

			}
			System.out.println();
			level++;
		}
	}
	public static void main(String[] args) {
		Main250211 tree = new Main250211();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);

		tree.bfs(tree.root);

	}
}
