package algorithm;

import java.io.*;
import java.util.*;

public class BOJ9205_맥주마시면서걸어가기 {
	static List<int[]> list;
	static boolean[] visited;
	static boolean isTrue;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			visited = new boolean[N+2];
			isTrue = false;
			
			for(int n = 0; n < N+2; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] { x, y });
			}
			
			bfs(0);
			
			if(isTrue) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			int[] curr = list.get(idx);
			
			// 페스티벌에 도착 가능하면 졸료
			if(idx == list.size()-1) {
				isTrue = true;
				return;
			}
			
			// 현재 위치에서 갈 수 있는 모든 장소 탐색
			for(int i = 0; i < list.size(); i++) {
				if(!visited[i]) {
					int[] next = list.get(i);
					int dist = Math.abs(curr[0] - next[0]) + Math.abs(curr[1] - next[1]);
					
					// 1000 이내일 경우 갈 수 있음
					if(dist <= 1000) {
						visited[i] = true;
						q.offer(i);
					}
				}
			}
		}
		
	}

}
