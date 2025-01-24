package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2116 {
	static int N;
	static int[][] dices ;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 6; i++) {
				dices[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 6; i++) {
			findSideMax(1, i, 0);
		}
		
		sb.append(max);
		System.out.println(sb);
		br.close();
	}
	
	public static void findSideMax(int count, int bottom, int sum) {
		int pair = 0;
		switch(bottom) {
		case 0: pair=5; break;
		case 5: pair=0; break;
		case 1: pair=3; break;
		case 3: pair=1; break;
		case 2: pair=4; break;
		case 4: pair=2; break;
		}
		
		int sideMax = Integer.MIN_VALUE;
		int currentSum = sum;
				
		for(int i = 0; i < 6; i++) {
			if(i == pair || i == bottom)
				continue;
			sideMax = Math.max(sideMax, dices[count-1][i]);
		}
		
		currentSum += sideMax; 
		
		// 주사위 다 쌓았을 때
		if(count == N) {
			max = Math.max(max, currentSum);
			return;
		}
		
		// 다음 주사위 쌓기
		for(int i = 0; i < 6; i++) {
			if(dices[count-1][pair] == dices[count][i]) {
				findSideMax(count+1, i, currentSum);
				break;
			}
		}
	}
}

