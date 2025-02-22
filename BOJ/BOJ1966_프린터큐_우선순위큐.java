package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1966_프린터큐_우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수 
			int M = Integer.parseInt(st.nextToken());  // 몇번째인지 궁금한 문서의 위치

			Queue<int[]> q = new ArrayDeque<int[]>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				int priority = Integer.parseInt(st.nextToken()); // 문서 우선순위 저장
				q.offer(new int[] { priority, n });
				pq.offer(priority);
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				
				if(curr[0] == pq.peek()) {
					pq.poll();
					cnt++;
					
					if(curr[1] == M) {
						sb.append(cnt).append("\n");
						break;
					}
				} else {
					q.offer(curr);
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
