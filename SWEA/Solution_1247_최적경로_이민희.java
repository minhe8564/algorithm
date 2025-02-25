package algorithm;

import java.io.*;
import java.util.*;

/*
 * 메모리 : 26,368kb
 * 실행시간 : 255ms
 */

// nPn = n!
// 10! = 3,628,800 완탐 가능!!!
// 10개 다 도는데 어떤 순서로 갈까 dfs로 탐색
// 가는 길에 최소값을 넘기면 백트레킹 (1,234ms -> 255ms) 단축

public class Solution_1247_최적경로_이민희 {
	static int N;
	static Node office;
	static Node house;
	static Node[] customer;
	static boolean[] visited;
	static int minDis;
	
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			customer = new Node[N];
			visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			office = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer[i] = new Node(x, y);
			}
			
			minDis = Integer.MAX_VALUE;
			dfs(office, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minDis).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// 회사에서 출발, N명의 고객을 모두 방문하고 집으로 돌아가는 경로
	private static void dfs(Node curr, int cnt, int sumDis) {
		if(cnt == N) {
			minDis = Math.min(minDis, sumDis+distance(curr, house));
			return;
		}
		
		// 최소값을 넘기면 리턴
		if(minDis <= sumDis) {
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(customer[i], cnt+1, sumDis+distance(curr, customer[i]));
				visited[i] = false;
			}
		}
	}
	
	private static int distance(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

}
