/*
 * SWEA 1251번 : 하나로
 * 메모리 : 156,300kb
 * 시간 : 607ms
 */

import java.io.*;
import java.util.*;

public class SWEA1251_하나로 {
	static int N;
	static double E;
	static List<Node>[] node;
	static boolean[] visited;
	static Island[] islands;
	static class Island {
		int x, y;
		public Island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Node {
		int to;
		double dis;
		public Node(int to, double dis) {
			this.to = to;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			islands = new Island[N];
			int[] arrX = new int[N];
			int[] arrY = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrX[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrY[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
			    islands[i] = new Island(arrX[i], arrY[i]);
			}
			E = Double.parseDouble(br.readLine());
			node = new ArrayList[N];
			visited = new boolean[N];
			for (int n = 0; n < N; n++) {
				node[n] = new ArrayList<Node>();
			}
			for(int n = 0; n < N-1; n++) {
				for(int m = n; m < N; m++) {
					double dis = Math.pow(Math.abs(islands[n].x-islands[m].x), 2)+Math.pow(Math.abs(islands[n].y-islands[m].y), 2);
					node[n].add(new Node(m, dis));
					node[m].add(new Node(n, dis));
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.dis, o2.dis));
			pq.offer(new Node(0, 0)); 

			double L = 0;
			int cnt = 0;
			while (!pq.isEmpty()) {
				Node curr = pq.poll();
				if (!visited[curr.to]) {
					visited[curr.to] = true;
					L += curr.dis;

					cnt++;
					if(cnt==N) break;
					
					for (Node next : node[curr.to]) {
						if (!visited[next.to]) {
							pq.offer(new Node(next.to, next.dis));
						}
					}
				}
			}

			long answer = Math.round(E*L);
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
