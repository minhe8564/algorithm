package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14503_로봇청소기 {
	static int N, M;
	static int r, c, d;
	static int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] room;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		visited = new boolean[N][M];
		
		// 로봇 청소기 좌표, 방향
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 북(0), 동(1), 남(2), 서(3)
		
		// 장소의 상태
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken()); // 빈칸(0), 벽(0)
			}
		}

		int cnt = 0;
		while (true) {
			// 1. 현재 칸 청소
			if(!visited[r][c]) {
				visited[r][c] = true;
				cnt++;
			}
			
			boolean moved = false;
			
			// 2. 주변 4방 탐색
			for(int i = 0; i < 4; i++) {
				d = (d+3) % 4; // 반시계 90도 회전
				int nx = r + dx[d];
				int ny = c + dy[d];
				
				// 청소되지 않은 빈 칸이 있으면, 한칸 전진 후 청소
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && room[nx][ny] == 0) {
					r = nx;
					c = ny;
					moved = true;
					break;
				}
			}
			
			// 3. 4방 모두 청소가 되어 있거나, 벽이면 한칸 후진
			if(!moved) {
				int backX = r - dx[d];
				int backY = c - dy[d];
				
				// 후진 불가능, 벽이면 자동 종료
				if(backX < 0 || backY < 0 || backX >= N || backY >= M || room[backX][backY] == 1) {
					break;
				}
				
				// 후진 가능하면 후진
				r = backX;
				c = backY;
			}
			
		}
		
		System.out.println(cnt);
		br.close();
	}

}
