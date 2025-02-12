package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		int num = 1;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int houseCount = bfs(i, j, num++);
					list.add(houseCount);
				}
			}
		}
		
		
		Collections.sort(list);
		
		sb.append(num-1).append("\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int bfs(int x, int y, int num) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = num;
		int houseCount = 1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = num;
					q.offer(new int[] { nx, ny });
					houseCount++;
				}
			}
		}
		return houseCount; 
	}
}
