package algorithm;

import java.io.*;
import java.util.*;

public class SWEA1861_정사각형방 {
	static int N;
	static int[][] room;
	static boolean[][] visited;
	static int start, maxRoom;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			start = 0;
			maxRoom = 0;
			
			// 1. 처음에 출발해야하는 방 번호 (모든 방 번호에 대해서 탐색)
			// 2. 방 이동 bfs
			// 3. 최대 몇개의 방을 이동할 수 있는지?
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						int count = bfs(i, j);
						
						if(count > maxRoom) {
							maxRoom = count;
							start = room[i][j];
						} else if(count == maxRoom) {
							start = Math.min(start, room[i][j]);
						}
					}
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(start).append(" ").append(maxRoom).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// 선택한 start 방 부터 bfs 돌리기
	private static int bfs(int x, int y) {
		visited = new boolean[N][N]; // bfs 안에서 visited 초기화 해주기!!!
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		int count = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && 
						room[nx][ny] == room[cx][cy] + 1 && !visited[nx][ny]) {
					q.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}
