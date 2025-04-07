/*
 * BOJ 1941번 : 소문난 칠공주
 * 메모리 : 158,644kb
 * 시간 : 532ms
 * 
 * 1. 25명 중 7명 조합
 * 2. bfs로 서로 인접해 있는지 확인
 * 3. '이다솜파' 학생이 4명 이상인지 확인
 */

import java.io.*;
import java.util.*;

public class BOJ1941_소문난칠공주 {
	static char[][] room;
	static boolean[][] visited;
	static List<int[]> students;
	static int[] selected;
	static int sCnt, yCnt; // sCnt+yCnt=7, sCnt>=4
	static int answer;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		room = new char[5][5];
		students = new ArrayList<int[]>();
		selected = new int[7];
		for(int i = 0; i < 5; i++) {
			String line = br.readLine();
			for(int j = 0; j < 5; j++) {
				room[i][j] = line.charAt(j);
				students.add(new int[] { i, j });
			}
		}
		
		comb(0, 0, 0);
		
		sb.append(answer);
		System.out.print(sb);
		br.close();
	}
	
	// 25명 중 7명 조합
	private static void comb(int cnt, int start, int sCnt) {
		if(cnt==7) {
			if(bfs() && sCnt >= 4) {
				answer++;
			}
			return;
		}
		
		for(int i = start; i < 25; i++) {
			selected[cnt] = i;
			int[] student = students.get(i);
			if(room[student[0]][student[1]] == 'S') {
				comb(cnt+1, i+1, sCnt+1);
			} else {
				comb(cnt+1, i+1, sCnt);
			}
		}
	}
	
	// 서로 인접해 있는지 확인
	private static boolean bfs() {
		visited = new boolean[5][5];
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		int[] start = students.get(selected[0]);
		q.offer(new int[] { start[0], start[1] });
		visited[start[0]][start[1]] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
				
				for(int i = 1; i < 7; i++) { // 선택된 7명의 학생들 중 탐색
					int[] next = students.get(selected[i]);
					
					if(nx==next[0] && ny==next[1] && !visited[next[0]][next[1]]) {
						visited[next[0]][next[1]] = true;
						q.offer(new int[] { next[0], next[1] });
						cnt++;
					}
				}
			}
			if(cnt==7) return true;
		}
		return false;
	}
}
