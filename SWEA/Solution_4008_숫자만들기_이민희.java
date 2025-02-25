package algorithm;

import java.io.*;
import java.util.*;

/*
* 메모리 : 26,624kb
* 실행 시간 : 85ms
*/

// 완전탐색 dfs
// 연산자 추가해가면서 재귀 호출
// N-1개 추가 후 값 계산
// 최대 최소 차이 출력

// n-1Pn-1 = (n-1)!
// 11! = 4천만 * 50개 테케 = 20억 20초..? 불가능??
// 4^11 = 4백만 완탐 가능!!!

public class Solution_4008_숫자만들기_이민희.java {
	static int N;
	static int[] oper;
	static int[] num;
	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			oper = new int[4];
			num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) { 
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			dfs(num[0], 1);
			
			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	
	private static void dfs(int sum, int cnt) {
		if (cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
//			System.out.println(max + " " + min);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				int nextSum = calc(sum, num[cnt], i);
				dfs(nextSum, cnt+1);
				oper[i]++;
			}
		}
		
	}
	
	private static int calc(int a, int b, int op) {
		switch(op) {
		case 0:
			return a+b;
		case 1:
			return a-b;
		case 2:
			return a*b;
		case 3:
			return a/b;
		default: 
			return 0;
		}
	}
	

}
