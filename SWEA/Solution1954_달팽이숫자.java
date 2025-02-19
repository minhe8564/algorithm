import java.io.*;
import java.util.*;

public class Solution1954_달팽이숫자 {
	static int N;
	static int[][] map;
	static int[] dx = new int[] { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dy = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			int num = 1;
			int x = 0;
			int y = 0;
			int dir = 0;
			for(int i = 0; i < N*N; i++) {
				map[x][y] = num++;
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0) {
					dir = (dir+1)%4;
					nx = x + dx[dir];
					ny = y + dy[dir];
				}
				
				x = nx;
				y = ny;
			}
			
			sb.append("#").append(t).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}

}
