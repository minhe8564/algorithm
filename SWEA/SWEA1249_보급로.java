import java.io.*;
import java.util.*;

public class SWEA1249_보급로 {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static class Node implements Comparable<Node>{
		int x, y, cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			dikstra(0, 0);
			
			sb.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dikstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int cx = curr.x;
			int cy = curr.y;
			
			if(curr.cost > dist[cx][cy]) {
				continue;
			}
				
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					int nextCost = curr.cost + map[nx][ny];
					if(dist[nx][ny] > nextCost) {
						dist[nx][ny] = nextCost;
						pq.offer(new Node(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
		
		return;
	}

}
