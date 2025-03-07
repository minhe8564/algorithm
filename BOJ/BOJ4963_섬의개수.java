import java.io.*;
import java.util.*;

public class BOJ4963_섬의개수 {
	static int W, H;
	static int[][] island;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0 && H==0) break;
			island = new int[H][W];
			visited = new boolean[H][W];
			for(int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < W; w++) {
					island[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					if(island[h][w] == 1 && !visited[h][w]) {
						bfs(h, w);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void bfs(int h, int w) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { h, w });
		visited[h][w] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int ch = curr[0];
			int cw = curr[1];
			
			for(int d = 0; d < 8; d++) {
				int nh = ch + dx[d];
				int nw = cw + dy[d];
				
				if(nh >= 0 && nw >= 0 && nh < H && nw < W && !visited[nh][nw] && island[nh][nw] == 1) {
					visited[nh][nw] = true;
					q.offer(new int[] { nh, nw });
				}
			}
		}
	}
}
