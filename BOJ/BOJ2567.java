package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2567 {
	static int[] dx = new int[] { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	static int[] dy = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[101][101];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i <= x+10; i++) {
				for(int j = y; j <= y+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				if(paper[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(paper[nx][ny] == 0) answer++;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();

	}

}
