package algorithm;

// city[0]에서 city[N]까지 갈 수 있는 최소 비용 구하기

import java.io.*;
import java.util.*;

public class BOJ13305_주유소 {
	static int N;
	static long[] dis;
	static long[] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dis = new long[N-1];
		cost = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			dis[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long minCost = cost[0];
		
		// 현재 주유소가 이전 주유소보다 기름이 쌀 경우 
		// minCost 갱신 
		for(int i = 0; i < N-1; i++) {
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			sum += minCost*dis[i];
		}
		
		sb.append(sum);
		System.out.println(sb);
		br.close();
	}

}
