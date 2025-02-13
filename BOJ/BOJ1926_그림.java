package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1926_그림 {
	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	static int maxCnt = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(paper[i][j] == 1 && !visited[i][j]) {
					bfs(paper, visited, i, j, cnt++);
				}
			}
		}

		sb.append(cnt).append("\n");
		sb.append(maxCnt);
		System.out.println(sb);
		br.close();
		
	}
	
	private static void bfs(int[][] paper, boolean[][] visited, int x, int y, int cnt) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		paper[x][y] = cnt;
		int num = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && paper[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true; 
					paper[nx][ny] = cnt;
					q.offer(new int[] { nx, ny });
					num++;
				}
			}
			
		}
		maxCnt = Math.max(maxCnt, num);

	}

}
