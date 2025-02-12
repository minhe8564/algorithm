import java.io.*;
import java.util.*;

public class BOJ17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 입력 받기
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. BFS로 섬 구분
		boolean[][] visited = new boolean[N][M];
		int land = 1;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 1 && !visited[n][m]) {
					bfs(map, visited, n, m, land++);
				}
			}
		}

		// 2. 모든 섬 간 다리 찾기 - 4방향 탐색
		List<int[]> edge = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] > 0) { // 땅인 경우
					int landNum = map[n][m];
					for (int d = 0; d < 4; d++) {
						int nx = n;
						int ny = m;
						int length = 0;

						while (true) {
							nx += dx[d];
							ny += dy[d];
							if (nx < 0 || ny < 0 || nx >= N || ny >= M)
								break;
							if (map[nx][ny] == landNum)
								break;
							if (map[nx][ny] > 0) {
								if (length >= 2)
									edge.add(new int[] { landNum, map[nx][ny], length });
								break;
							}
							length++;
						}
					}
				}
			}
		}

		// 간선 정렬 - 가중치 기준 오름차순
		Collections.sort(edge, Comparator.comparingInt(a -> a[2]));
		
		// 부모 배열 초기화
		int[] parent = new int[land]; 
		for (int i = 0; i < land; i++) {
			parent[i] = i;
		}

		// 3. MST - 크루스칼 알고리즘
		int minCost = 0;
		int count = 0; // 연결된 간선 개수

		for (int i = 0; i < edge.size(); i++) {
			int u = edge.get(i)[0]; // landNum
			int v = edge.get(i)[1]; // map[nx][ny]
			int weight = edge.get(i)[2]; // length

			if (find(parent, u) != find(parent, v)) {
				union(parent, u, v);
				minCost += weight;
				count++;
			}
		}

		if(count == land-2)
			System.out.println(minCost);
		else
			System.out.println(-1);
		br.close();
	}

	private static void bfs(int[][] map, boolean[][] visited, int x, int y, int land) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		map[x][y] = land;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i]; 
				int ny = cy + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = land;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	private static int find(int[] parent, int x) {
		if (parent[x] == x) 
			return x;
		return parent[x] = find(parent, parent[x]);
	}

	private static void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		if (x < y) 
			parent[y] = x;
		else 
			parent[x] = y;
	}
}
