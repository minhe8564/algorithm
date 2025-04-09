/*
 * BOJ 18352번 : 특정 거리의 도시 찾기
 * 메모리 : 266,572kb
 * 시간 : 1,172ms
 * 
 * 우선순위 큐 정렬 -> 시간초과 발생
 */

import java.io.*;
import java.util.*;

public class BOJ18352_특정거리의도시찾기 {
	static int N, M, K, X;
	static List<Node>[] edges;
	static class Node {
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		for(int n = 0; n <= N; n++) {
			edges[n] = new ArrayList<Node>();
		}
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			edges[from].add(new Node (to, 1));
		}
		
		Dijkstra();
		
		boolean flag = true;
		for(int n = 1; n <= N; n++) {
			if(K == dist[n]) {
				sb.append(n).append("\n");
				flag = false;
			}
		}
		
		if(flag) sb.append(-1);
		
		System.out.print(sb);
		br.close();
	}	
	
	private static void Dijkstra() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(X, 0));
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		while(!q.isEmpty()) {
			Node currNode = q.poll();
			
			for(int i = 0; i < edges[currNode.to].size(); i++) {
				Node nextNode = edges[currNode.to].get(i);				
				
				if(dist[nextNode.to] > dist[currNode.to]+nextNode.cost) {
					dist[nextNode.to] = dist[currNode.to]+nextNode.cost;
					q.offer(new Node(nextNode.to, dist[nextNode.cost]));
				}
			}
		}
	}
}
