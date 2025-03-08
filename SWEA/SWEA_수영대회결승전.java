package algorithm;

import java.io.*;
import java.util.*;

public class SWEA_수영대회결승전 {
	static int N;
	static int[][] sea;
	static boolean[][] visited;
	static int startX, startY;
	static int endX, endY;
	static int time;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sea = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			int time = bfs(startX, startY);
			sb.append("#").append(t).append(" ").append(time).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static int bfs(int x, int y) {
//		Queue<int[]> q = new ArrayDeque<int[]>();
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[2]-o2[2]); // 최단시간 보장 
		q.offer(new int[] { x, y, 0 });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int time = curr[2];
			
			if(cx == endX && cy == endY) {
				return time;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && sea[nx][ny] != 1) {
					int nextTime = time+1;
					
					if(sea[nx][ny] == 2) { // 소용돌이 
						while(nextTime % 3 != 0) {
							nextTime++;
						}
					}
					
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny, nextTime });
				}
			}
		}
		
		return -1;
	}
}
 
