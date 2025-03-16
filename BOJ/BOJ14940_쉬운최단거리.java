/*
 * BOJ 14940번 : 쉬운 최단거리
 * 메모리 : 46,076kb
 * 시간 : 508ms
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14940_쉬운최단거리 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int endX, endY;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 2) {
					endX = n;
					endY = m;
					map[n][m] = 0;
				} else if(map[n][m] != 0) { // 원래 갈 수 없는 땅의 위치는 -1로 출력하기 위해, -1로 초기
					result[n][m] = -1;
				}
			}
		}

		// 목표지점에서 출
		bfs(endX, endY);
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				sb.append(result[n][m]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited = new boolean[N][M];
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					result[nx][ny] = result[cx][cy]+1; // 현재 칸의 최단거리 기록 
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
