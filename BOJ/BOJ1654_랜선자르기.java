package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1654_랜선자르기 {
	static int K, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[] len = new int[K];
		long max = Integer.MIN_VALUE;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			len[k] = Integer.parseInt(st.nextToken());
			max = Math.max(max, len[k]);
		}
		
		long min = 1;
		long mid = 0;
		while(min <= max) {
			mid = (max+min)/2;
			
			long count = 0;
			for (int k = 0; k < K; k++) {
				count += (len[k] / mid);
			}
			
			// 자른 랜선 개수보다 N이 작다면 길이를 줄여야 함
			if(count < N) {
				max = mid-1;
			} else {
				min = mid+1;
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		br.close();
		
	}

}
