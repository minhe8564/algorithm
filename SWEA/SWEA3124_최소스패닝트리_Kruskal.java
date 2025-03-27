/*
 * SWEA 3124번 : 최소 스패닝 트리
 * 메모리 : 121,816kb
 * 시간 : 1,875ms
 */

import java.io.*;
import java.util.*;

public class SWEA3124_최소스패닝트리_Kruskal {
	static int V, E;
	static List<Node> list;
	static int[] parent;
	static int cnt;
	static long sum;
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
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
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
					
					if(cnt==E-1) break;
				}
			}
			sb.append(sum).append("\n");
		}
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
