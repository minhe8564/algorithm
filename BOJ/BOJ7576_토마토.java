package algorithm;

import java.io.*;
import java.util.*;

public class BOJ7576_토마토 {
	static int M, N;
	static int[][] box;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		int noTomato = 0; // 안익은 토마토

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (box[n][m] == 1) {
					q.offer(new int[] { n, m, 0 });
				} else if (box[n][m] == 0) {
					noTomato++;
				}
			}
		}
		
		int days = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int day = curr[2];
			days = Math.max(days, day);
			
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					q.offer(new int[] { nx, ny, day+1 });
					noTomato--;
				}
			}
		}
		
		if(noTomato == 0) {
			sb.append(days);
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
		br.close();
	}

}
