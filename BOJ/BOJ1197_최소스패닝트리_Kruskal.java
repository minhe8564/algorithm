/*
 * BOJ 1197번 : 최소 스패닝 트리_Kruskal
 * 메모리 : 50,436kb
 * 시간 : 524ms
 * 
 * 간선 가중치의 합이 최솟값이 되도록 모든 노드를 연결 (=간선중심)
 * 
 * 1. 간선 데이터 오름차순 정렬
 * 2. 간선을 확인하면서 지금 현재 간선이 사이클을 발생시키는지 확인
 * 2-1. 발생시키지 않는다면 MST에 포함
 * 3. 모든 간선에 대해 반복
 */

import java.io.*;
import java.util.*;

public class BOJ1197_최소스패닝트리_Kruskal {
	static int V, E;
	static List<Node> list;
	static int[] parent;
	static int cnt, sum;
	static class Node implements Comparable<Node>{
		int from, to, cost;
		
		public Node (int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList<Node>();
		parent = new int[V+1];
		for(int v = 1; v <= V; v++) {
			parent[v] = v;
		}
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(from, to, cost));
		}	
		
		Collections.sort(list);
		
		sum = 0; cnt = 0;
		for(Node n : list) {
			if(union(n.from, n.to)) {
				sum += n.cost;
				cnt++;
				
				// if(cnt==E-1) break;
			}
		}
		
		sb.append(sum);
		System.out.print(sb);
		br.close();
	}
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;
		
		if(x<=y) parent[y]=x;
		else parent[x]=y;
		return true;
	}
	
	private static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]);
	}
}
