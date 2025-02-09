package algorithm;

import java.io.*;
import java.util.*;

public class BOJ24511 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[N];
		for(int n = 0; n < N; n++) {
			data[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if(data[n] == 0) {
				q.offer(num);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int m = 0; m < M; m++) {
			int addNum = Integer.parseInt(st.nextToken());
			q.offerFirst(addNum);
			sb.append(q.pollLast()).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}

}
