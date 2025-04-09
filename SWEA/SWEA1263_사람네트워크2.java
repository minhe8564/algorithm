/*
 * SWEA 1263번 : 사람 네트워크2
 * 메모리 : 103,060kb
 * 시간 : 1,598ms
 */

import java.io.*;
import java.util.*;

public class SWEA1263_사람네트워크2 {
	static int N;
	static int[][] dist;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dist = new int[N+1][N+1];
			for(int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], (int)1e9);
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num!=0) dist[i][j]=num;
					if(i==j) dist[i][j]=0;
				}
			}
			
			for(int v = 1; v <= N; v++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][v]+dist[v][j]);
					}
				}
			}
			
			min = (int)1e9;
			
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum); // i에서 다른 사람까지 가는 거리 합
			}
			
			sb.append(min).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
