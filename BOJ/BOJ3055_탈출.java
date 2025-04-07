/*
 * BOJ 3055번 : 탈출
 * 메모리 : 11,788kb
 * 시간 : 76ms
 */

import java.io.*;
import java.util.*;

public class BOJ3055_탈출 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> waterQ;
	static Queue<int[]> hedgeHogQ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		waterQ = new ArrayDeque<int[]>();
		hedgeHogQ = new ArrayDeque<int[]>();
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == '*') {
					waterQ.offer(new int[] { r, c });
				} else if(map[r][c] == 'S') {
					hedgeHogQ.offer(new int[] { r, c, 0 }); // x, y, time
					visited[r][c] = true;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		bfs();
		
		sb.append(answer==Integer.MAX_VALUE ? "KAKTUS" : answer);
		System.out.print(sb);
		br.close();
	}

	public static void bfs() {
		while(!hedgeHogQ.isEmpty()) {
			// 물 먼저 확장
			int waterSize = waterQ.size();
			for(int i = 0; i < waterSize; i++) {
				int[] water = waterQ.poll();
				int wx = water[0];
				int wy = water[1];
				for(int d = 0; d < 4; d++) {
					int nx = wx+dx[d];
					int ny = wy+dy[d];
					if(nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.') {
						map[nx][ny] = '*';
						waterQ.offer(new int[] { nx, ny });
					}
				}
			}
			
			// 고슴도치 이동
			int hedgeHogSize = hedgeHogQ.size();
			for(int i = 0; i < hedgeHogSize; i++) {
				int[] hedegeHog = hedgeHogQ.poll();
				int hx = hedegeHog[0];
				int hy = hedegeHog[1];
				int time = hedegeHog[2];
				for(int d = 0; d < 4; d++) {
					int nx = hx+dx[d];
					int ny = hy+dy[d];
					if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]) {
						if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
						if(map[nx][ny] == 'D') {
							answer = time+1;
							return;
						}
						visited[nx][ny] = true;
						hedgeHogQ.offer(new int[] { nx, ny, time+1 });
					}
				}
			}
		}
	}
}
