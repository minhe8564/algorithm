/*
 * BOJ 1991번 : 트리순회
 * 메모리 : 11,584kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1991_트리순회 {
	static int N;
	static Node[] tree;
	static class Node {
		char value;
		Node left, right;
		public Node(char value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parentNode = st.nextToken().charAt(0);
			char leftNode = st.nextToken().charAt(0);
			char rightNode = st.nextToken().charAt(0);
			
			if(tree[parentNode-'A'] == null) { // 부모노드가 아직 없는 경우
				tree[parentNode-'A'] = new Node(parentNode); // 부모노드 생성
			}
			if(leftNode != '.') { // 왼쪽자식이 있는 경우
				tree[leftNode-'A'] = new Node(leftNode); // 왼쪽자식 생성
				tree[parentNode-'A'].left = tree[leftNode-'A']; // 부모노드와 왼쪽자식 연결
			}
			if(rightNode != '.') { // 오른쪽자식이 있는 경우
				tree[rightNode-'A'] = new Node(rightNode); // 오른쪽자식 생성
				tree[parentNode-'A'].right = tree[rightNode-'A']; // 부모노드와 오른쪽자식 연결
			}
		}
		
		preorder(tree[0]);
		sb.append("\n");
		
		inorder(tree[0]);
		sb.append("\n");
		
		postorder(tree[0]);
		sb.append("\n");
		
		System.out.print(sb);
		br.close();
	}
	
	private static void preorder(Node tree) {
		if(tree==null) return;
		sb.append(tree.value);
		preorder(tree.left);
		preorder(tree.right);
	}
	
	private static void inorder(Node tree) {
		if(tree==null) return;
		inorder(tree.left);
		sb.append(tree.value);
		inorder(tree.right);
	}
	
	private static void postorder(Node tree) {
		if(tree==null) return;
		postorder(tree.left);
		postorder(tree.right);
		sb.append(tree.value);
	}

}
