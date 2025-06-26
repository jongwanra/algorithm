package algorithm.recursive_tree_graph.수열_추측하기;

import java.util.Scanner;

public class LectureMain {
	private static int n;
	private static int f;
	private static int[] b;
	private static int[] p;
	private static int[] ch;
	private static int[][] dy = new int[35][35];
	private static boolean flag = false;

	public static void main(String[] args) {
		LectureMain T = new LectureMain();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		f = kb.nextInt();
		b= new int[n];
		p = new int[n];
		ch = new int[n + 1];

		for(int i = 0; i < n; i++) {
			b[i] = T.combi(n -1, i);
		}
		T.DFS(0, 0);
	}

	private int combi(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		}
		else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}

	private void DFS(int L, int sum) {
		if(flag) {
			return;
		}
		if(L == n) {
			if(sum == f) {
				for(int x:p) System.out.print(x + " ");
				flag= true;
			}
		}else {
			for(int i = 1; i <= n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					p[L] = i;
					DFS(L +1 , sum + (p[L] * b[L]));
					ch[i] = 0;
				}
			}
		}
	}
}
