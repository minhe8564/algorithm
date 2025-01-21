package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA12712 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			// + 스프레이
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = map[i][j];
					for (int k = 1; k < M; k++) {
                        if (i - k >= 0) sum += map[i - k][j];	// 상
                        if (i + k < N) sum += map[i + k][j];	// 하
                        if (j - k >= 0) sum += map[i][j - k];	// 좌
                        if (j + k < N) sum += map[i][j + k];	// 우
                    }
					max = Math.max(max, sum);
				}
			}

			// * 스프레이
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = map[i][j];
					for (int k = 1; k < M; k++) {
                        if (i - k >= 0 && j - k >= 0) sum += map[i - k][j - k];	// 좌상
                        if (i + k < N && j - k >= 0) sum += map[i + k][j - k];	// 좌하
                        if (i - k >= 0 && j + k < N) sum += map[i - k][j + k];	// 우상
                        if (i + k < N && j + k < N) sum += map[i + k][j + k];	// 우하
                    }
					max = Math.max(max, sum);
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " " + max);
			System.out.println(sb);
		}
	}
}
