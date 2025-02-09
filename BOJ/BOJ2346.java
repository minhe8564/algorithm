package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> d = new ArrayDeque<int[]>(); // [풍선번호] = 이동값
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			d.offer(new int[] {n+1, Integer.parseInt(st.nextToken()) });
		}

		while(!d.isEmpty()) {
			int[] curr = d.pollFirst();
			sb.append(curr[0]).append(" ");
			
			if(d.isEmpty()) break;
			
			if(curr[1] > 0) {
				for(int i = 0; i < curr[1]-1; i++) {
					d.offerLast(d.pollFirst());
				}
			} else {
				for(int i = 0; i < Math.abs(curr[1]); i++) {
					d.offerFirst(d.pollLast());
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
