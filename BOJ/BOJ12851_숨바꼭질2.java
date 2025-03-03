package algorithm;

import java.io.*;
import java.util.*;

public class BOJ12851_숨바꼭질2 {
	static int N, K;
	static int time = Integer.MAX_VALUE;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		sb.append(time).append("\n").append(cnt);
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int[] visited = new int[100001]; 
		q.offer(new int[] { N, 0 }); // 현재 위치, 시간
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currPosition = curr[0];
			int currTime = curr[1];
			
			if(currPosition == K) {
				if(cnt == 0) 
					time = currTime;
				if(time == currTime)
					cnt++;
				continue;
			}
			
			int[] nextArr = new int[] { currPosition-1, currPosition+1, currPosition*2 };
			for(int i = 0; i < 3; i++) {
				int next = nextArr[i];
				if(next < 0 || next > 100000)
					continue;
				if(visited[next] == 0 || visited[next] == currTime+1) {
					visited[next] = currTime+1;
					q.offer(new int[] { next, currTime+1 });
				}
			}
		}
	}
}
