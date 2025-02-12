package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2178_미로탐색 {
	static int N, M, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m) - '0';
			}
		}
		System.out.println(bfs(0, 0));
		br.close();
	}
	
	private static int bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = map[cx][cy] + 1; // 거리 업데이트
					q.offer(new int[] { nx, ny} );
				}
			}
		}
		
		return map[N-1][M-1];
	}

}
