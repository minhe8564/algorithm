/*
 * SWEA 2117번 : 홈 방범 서비스
 * 메모리 : 94,452kb
 * 시간 : 356ms
 * 
 * 문제 풀이
 * 1. N인 도시의 정보가 주어진다.
 * 	   집이 위치한 곳은 1이고, 나머지는 0이다.
 * 2. 서비스 영역의 크기 K가 커질수록 운영 비용이 커진다.
 *    운영비용 = K*K + (K-1)*(K-1) 1, 5, 13, 25 
 * 3. 서비스 영역에 속하는 집이 존재한다면, 한 집이 지불할 수 있는 비용은 M이다.
 * 4. 보안회사의 이익 = 집을 통해 얻는 수익(집의 수*집이 지불하는 비용 M) - 운영비용
 * 5. 보안회사의 이익이 가장 클 때, 서비스를 제공받는 집의 수 출력
 * 
 * 문제 해결
 * 1. 모든 칸 탐색 
 * 2. bfs 탐색 
 * 2-1. 집이 있으면 house++; cost+=M;
 * 2-2. 깊이+1 될수록 운영비용 증가
 * 3. bfs 갱신
 * 3-1. 현재까지 모은 수익 >= 운영비용
 * 3-2. 이익이 남는 상황이니까, 최대 집 수 갱신
 */

import java.io.*;
import java.util.*;

public class SWEA2117_홈방범서비스 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int totalCost;
	static int houseCnt;
	static int answer;
	static int[] dx = new int[] { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					totalCost = 0;
					houseCnt = 0;
					bfs(i, j, 1, 1); // x, y, 운영비용, depth
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void bfs(int x, int y, int cost, int depth) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y, cost, depth });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			int currCost = curr[2];
			int currDepth = curr[3];
			
			if(map[currX][currY]==1) {
				totalCost += M;
				houseCnt++;
			}
			
			if(totalCost >= currCost) {
				if(answer < houseCnt) {
					answer = houseCnt;
				}
			}
             
			for(int d = 0; d < 4; d++) {
				int nextX = currX+dx[d];
				int nextY = currY+dy[d];
				
				if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					q.offer(new int[] { nextX, nextY, currCost+currDepth*4, currDepth+1 });
				}
			}
		}
	}
}
