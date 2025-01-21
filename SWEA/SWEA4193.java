package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4193 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] pool;
	static boolean[][] visit;
	
	static int N;
	static int count;	
	static int startX, startY, endX, endY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t < T; t++) {
			StringTokenizer stN = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stN.nextToken());
			
			pool = new int[N][N];
			visit = new boolean[N][N];
			
			count = N*N;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer stI = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					pool[i][j] = Integer.parseInt(stI.nextToken());
				}
			}
			
			StringTokenizer stS = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(stS.nextToken());
			startY = Integer.parseInt(stS.nextToken());
			StringTokenizer stE = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(stE.nextToken());
			endY = Integer.parseInt(stE.nextToken());
			
			visit[startX][startY] = true;
			
			int time = bfs();
			StringBuilder sb = new StringBuilder();
			sb.append("#");			
			sb.append(t);			
			sb.append(" ");			
			sb.append(time == -1 ? -1 : time);
			System.out.print(sb);
		}
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList();
		q.add(new int[] {startY, startX, 0}); // Y(행) X(열)
		visit[startY][startX] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int y = current[0], x = current[1], t = current[2];
			
			if(y == endY && x == endX) {
				return t;
			}
			
			for(int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx]) continue;
				
				if(pool[ny][nx] == 1) continue;
				
				visit[ny][nx] = true;
				
				if(pool[ny][nx] == 3) {
					if(t % 3 == 2) {
						q.add(new int[] {ny, nx, t+1});
					} else {
						q.add(new int[] {y, x, t+1});
					}
				} else {
					q.add(new int[] {ny, nx, t+1});
				}
			}
		}
		
		return -1;
	}
}
		// 섬 = 1, 소용돌이 = 2(2초유지 1초정지)
		// 한번 통과한 소용돌이 위에 머무르기 가능
		
