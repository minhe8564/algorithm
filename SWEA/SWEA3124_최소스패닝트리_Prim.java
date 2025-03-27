/*
 * SWEA 3124번 : 최소 스패닝 트리
 * 메모리 : 201,588kb
 * 시간 : 2,512ms
 */

import java.io.*;
import java.util.*;

public class SWEA3124_최소스패닝트리_Prim {
	static int V, E;
	static List<Node>[] list;
	static boolean[] visited;
	static long sum;
	static class Node {
		int to, cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
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
			list = new ArrayList[V+1];
			for(int v = 1; v <= V; v++) {
				list[v] = new ArrayList<>();
			}
			for(int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to, cost));
				list[to].add(new Node(from, cost));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost-o2.cost);
			pq.offer(new Node(1,0));
			visited = new boolean[V+1];
			
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
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
