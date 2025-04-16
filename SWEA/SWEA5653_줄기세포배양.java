/*
 * SWEA 5653번 : 줄기세포배양
 * 메모리 : 83,472kb
 * 시간 : 238ms
 */

import java.io.*;
import java.util.*;

public class SWEA5653_줄기세포배양 {
	static int N, M, K;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<Cell> list;
	static class Cell implements Comparable<Cell> {
		int x, y, time, count;
		public Cell(int x, int y, int time, int count) {
			this.x = x;
			this.y = y;
			this.time = time; // 생명력
			this.count = count; // 남은시간=비활성+활성=생명력*2
		}
		@Override
		public int compareTo(Cell o) {
			return o.time-this.time; // 큰 time 먼저(내림차순)
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            visited = new boolean[500][500];
            list = new ArrayList<>();
            
            for(int n = 0; n < N; n++) {
            	st = new StringTokenizer(br.readLine());
            	for(int m = 0; m < M; m++) {
            		int time = Integer.parseInt(st.nextToken());
            		if(time > 0) {
            			list.add(new Cell(n+250, m+250, time, time*2)); // x, y, time, count
            			visited[n+250][m+250] = true;
            		}
            	}
            }
            
            bfs();
            
            sb.append(list.size()).append("\n");
        }
        System.out.print(sb);
        br.close();
	}
	
	private static void bfs() {
		int time = 1;
		while(!list.isEmpty() && time <= K) {
			Collections.sort(list); // 생명력 높은 세포부터 분열
			int size = list.size(); // 현재 시간대의 세포 수 저장
			
			for(int i = 0; i < size; i++) {
				Cell curr = list.remove(0); // 현재 시간 전에 있던 세포만 처리
				
				if(curr.count == curr.time) {
					for(int d = 0; d < 4; d++) {
						int x = curr.x + dx[d];
						int y = curr.y + dy[d];
						
						if(x < 0 || y < 0 || x >= 500 || y >= 500) continue;
						if(visited[x][y]) continue;
						
						visited[x][y] = true;
						list.add(new Cell(x, y, curr.time, curr.time*2));
					}
				}
				
				// 아직 안 죽었으면
				if(curr.count-1 > 0) {
					// 한 시간 감소 후 리스트에 다시 넣기
					list.add(new Cell(curr.x, curr.y, curr.time, curr.count-1));
				}
			}
			
			// 다음시간 으로
			time++;
		}
	}
}
