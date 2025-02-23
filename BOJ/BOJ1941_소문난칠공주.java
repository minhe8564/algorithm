package algorithm;

import java.io.*;
import java.util.*;

/*
 * 1. 25명 중 7명 선택 
 * 2. bfs로 7명이 연결되어 있는지 확인
 * 3. S가 4명이상 인지 확인
 * 
 * 메모리 : 13796kb
 * 시간 : 340ms
 */

public class BOJ1941_소문난칠공주 {
	static char[][] room;
	static List<int[]> students;
	static int[] selected; // 7명 선택
	static boolean[][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		room = new char[5][5];
		students = new ArrayList<int[]>();
		selected = new int[7];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				room[i][j] = str.charAt(j);
				students.add(new int[] { i, j });
			}
		}
		
		comb(0, 0, 0);
		
		sb.append(answer);
		System.out.println(sb);
		br.close();
	
	}
	
	private static void comb(int cnt, int start, int sCnt) {
		if(cnt == 7) {
			if(isConnected() && sCnt >= 4) {
				answer++;
			}
			return;
		}
		
		for(int i = start; i < 25; i++) {
			int[] student = students.get(i);
			int sx = student[0];
			int sy = student[1];
			selected[cnt] = i;
			comb(cnt+1, i+1, (room[sx][sy] == 'S' ? sCnt+1 : sCnt));
		}
	}
	
	private static boolean isConnected() {
		visited = new boolean[5][5];
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[] start = students.get(selected[0]);
		int sx = start[0];
		int sy = start[1];
		q.offer(new int[] { sx, sy });
		visited[sx][sy] = true;
		
		int idx = 1; // selected 배열 탐색 변수
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int x = cx + dx[d];
				int y = cy + dy[d];
				
				for(int i = idx; i < 7; i++) { // 선택된 7명 중에서 탐색
					int[] next = students.get(selected[i]);
					int nx = next[0];
					int ny = next[1];
					
					if(nx==x && ny==y && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(next);
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 7) {
			return true;
		}
		
		return false;
	}
	
}
