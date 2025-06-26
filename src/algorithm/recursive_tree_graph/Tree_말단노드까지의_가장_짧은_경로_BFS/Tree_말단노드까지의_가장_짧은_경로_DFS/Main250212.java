package algorithm.recursive_tree_graph.Tree_말단노드까지의_가장_짧은_경로_BFS.Tree_말단노드까지의_가장_짧은_경로_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	Node lt, rt;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class Main250212 {
	Node root;
	public static void main(String[] args) {
		Main250212 tree = new Main250212();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.rt.lt = new Node(7);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);

		System.out.println(tree.bfs(tree.root));

	}

	private int bfs(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		int level = 0;
		while(!queue.isEmpty()) {
			final int size = queue.size();
			for(int index = 0; index < size; index++) {
				Node currentNode = queue.poll();
				if(currentNode.lt == null && currentNode.rt == null){
					// 말단 노드
					return level;
				}
				if(currentNode.lt != null) {
					queue.offer(currentNode.lt);
				}
				if(currentNode.rt != null) {
					queue.offer(currentNode.rt);
				}

			}
			level++;
		}
		 return 0;
	}
}
