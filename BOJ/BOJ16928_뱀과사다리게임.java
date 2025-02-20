package algorithm;

import java.io.*;
import java.util.*;

public class BOJ16928_뱀과사다리게임 {
	static int N, M;
//	static int[][] board;
	static boolean[] visited;
	static List<int[]> move;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리의 수
		M = Integer.parseInt(st.nextToken()); // 벰의 수
//		board = new int[10][10];
		visited = new boolean[101];
		
//		int num = 1;
//		for(int i = 9; i >= 0; i--) {
//			if(i % 2 != 0) {
//				for(int j = 0; j <= 9; j++) {
//					board[i][j] = num++;
//				}
//			} else {
//				for(int j = 9; j >= 0; j--) {
//					board[i][j] = num++;
//				}
//			}
//		}
		
		move = new ArrayList<int[]>();
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move.add(new int[] { x, y });
		}
		
		count = 0;
		bfs();
		
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
	
	// 1. 주사위 1~6 굴려 나온 수 만큼 이동
	// 2. 도착 칸 사다리 : 타고 위로 올라감
	// 3. 도착 칸 뱀 : 타고 아래로 내려감
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 1, 0 }); // 시작위치, 이동횟수
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int num = curr[0];
			count = curr[1];
			
			if(num == 100) {
				return;
			}
			
			for(int dice = 1; dice <= 6; dice++) {
				int next = num + dice;
				
				if(next > 100 || visited[next]) {
					continue;
				}
				
				for(int[] m : move) {
					if(m[0] == next) {
						next = m[1];
						break;
					}
				}
				
				visited[next] = true;
				q.offer(new int[] { next, count + 1 });
			}
		}
	}

}
