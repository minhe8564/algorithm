package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2798_블랙잭 {
	static int N, M;
	static int[] card;
	static int[] result;
	static int maxSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		card = new int[N];
		result = new int[3];
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		maxSum = Integer.MIN_VALUE;
		comb(0, 0);
		sb.append(maxSum);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		int sum = 0;
		if(cnt == 3) {
			for(int i : result) {
				sum += i;
			}
			if(sum <= M) {
				maxSum =Math.max(maxSum, sum);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = card[i];
			comb(cnt+1, i+1);
		}
	}
}
