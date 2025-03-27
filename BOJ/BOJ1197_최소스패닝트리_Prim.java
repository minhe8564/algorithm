/*
 * BOJ 1197번 : 최소 스패닝 트리_Prim
 * 메모리 : 62,572kb
 * 시간 : 608ms
 * 
 * 시작 장점을 기준으로 가장 작은 간선과 연결된 정점을 선택하여 모든 정섬을 연결(=정점중심)
 * 
 * 1. 임의의 정점 선택
 * 2. 현재 정점으로부터 가장 낮은 가중치를 갖는 정점 선택
 * 3. 모든 정점에 대해 반복
 */

import java.io.*;
import java.util.*;

public class BOJ1197_최소스패닝트리_Prim {
	static int V, E;
	static List<Node>[] list;
	static boolean[] visited;
	static int sum;
	static class Node {
		int to, cost;
		
		public Node (int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for(int v = 0; v <= V; v++) {
			list[v] = new ArrayList<Node>();
		}
		visited = new boolean[V+1];
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost)); // 무향 그래프
			list[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		pq.offer(new Node(1,0)); // 시작정점, 가중치
		
		sum = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(!visited[curr.to]) {
				visited[curr.to] = true;
				sum += curr.cost;
				
				for(Node next : list[curr.to]) {
					if(!visited[next.to]) {
						pq.offer(new Node(next.to, next.cost));
					}
				}
			}
		}
		
		sb.append(sum);
		System.out.print(sb);
		br.close();
	}
}
