package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수 
			int M = Integer.parseInt(st.nextToken());  // 몇번째인지 궁금한 문서의 위치
			st = new StringTokenizer(br.readLine());
			int[] priority = new int[N];
			Queue<Integer> q = new ArrayDeque<Integer>();
			for (int n = 0; n < N; n++) {
				priority[n] = Integer.parseInt(st.nextToken()); // 문서 우선순위 저장
				q.offer(n);
			}
			
			int cnt = 0;
			while(true) {
				int max = 0;
				for (int n = 0; n < N; n++) {
					if(max > priority[n]) max = priority[n];
				}
				
				int curr = q.poll();
				if(max == priority[curr]) {
					cnt++;
					priority[curr] = 0; // 다음 max값 위해서 초기화
					
					if(M == curr) {
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
