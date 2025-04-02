/*
 * SWEA 1953번 : 탈주범 검거
 * 메모리 : 30,592kb
 * 시간 : 107ms
 */

import java.io.*;
import java.util.*;

public class SWEA1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int cnt;
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
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 1;
			bfs();
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void bfs() {
		q = new ArrayDeque<int[]>();
		q.offer(new int[] { R, C, 1 });
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int depth = curr[2];
			
			if(depth==L) break;
			
			switch(map[cx][cy]) {
			case 1 : // 상, 하, 좌, 우
				for(int d = 0; d < 4; d++) {
					offer(cx, cy, d, depth);
				}
				break;
			case 2 : // 상, 하
				for(int d = 0; d < 2; d++) {
					offer(cx, cy, d, depth);
				}
				break;
			case 3 : // 좌, 우
				for(int d = 2; d < 4; d++) {
					offer(cx, cy, d, depth);
				}
				break;
			case 4 : // 상, 우
				offer(cx, cy, 0, depth);
				offer(cx, cy, 3, depth);
				break;
			case 5 : // 하, 우
				offer(cx, cy, 1, depth);
				offer(cx, cy, 3, depth);
				break;
			case 6 : // 하, 좌
				for(int d = 1; d < 3; d++) {
					offer(cx, cy, d, depth);
				}
				break;
			case 7 : // 상, 좌
				offer(cx, cy, 0, depth);
				offer(cx, cy, 2, depth);
				break;
			}
		}
	}

	private static void offer(int cx, int cy, int d, int depth) {
		int nx = cx+dx[d];
		int ny = cy+dy[d];
		if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
			int nextPipe = map[nx][ny];
			
			// 현재 방향의 반대 방향
			int diffDir = d==0 ? 1 : d==1 ? 0 : d==2 ? 3 : 2; 
			
			// 다음 파이프가 diffDir에서 들어올 수 있는지 확인
			if (
				(nextPipe == 1) ||
				(nextPipe == 2 && (diffDir == 0 || diffDir == 1)) ||
				(nextPipe == 3 && (diffDir == 2 || diffDir == 3)) ||
				(nextPipe == 4 && (diffDir == 0 || diffDir == 3)) ||
				(nextPipe == 5 && (diffDir == 1 || diffDir == 3)) ||
				(nextPipe == 6 && (diffDir == 1 || diffDir == 2)) ||
				(nextPipe == 7 && (diffDir == 0 || diffDir == 2))
			) {
				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny, depth+1 });
				cnt++; 
			}
		}
	}
}
