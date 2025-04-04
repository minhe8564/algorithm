/*
 * SWEA 1949번 : 등산로 조성
 * 메모리 : 30,708kb
 * 시간 : 161ms
 */

import java.io.*;
import java.util.*;

public class SWEA1949_등산로조성 {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int maxLength;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			maxLength = Integer.MIN_VALUE;
			
			int[][] tempMap = new int[N][N];
			for(int l = 0; l < N; l++) {
				tempMap[l] = map[l].clone();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 1; k <= K; k++) {
						if(map[i][j]-k >= 0) {
							map[i][j] -= k;
							start(tempMap); // 기존 맵에서 시작탐색지 찾기
							map[i][j] = tempMap[i][j];
						}
					}
				}
			}
			
			sb.append(maxLength).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void start(int[][] tempMap) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(tempMap[i][j] == max) {
					visited = new boolean[N][N];
					visited[i][j] = true;
					dfs(i, j, 1);
				}
			}
		}
	}
	
	private static void dfs(int x, int y, int length) {
		maxLength = Math.max(maxLength, length);
		
		for(int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N 
					&& !visited[nx][ny] && map[x][y] > map[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, length+1);
					visited[nx][ny] = false;
			}
		}
	}
}
