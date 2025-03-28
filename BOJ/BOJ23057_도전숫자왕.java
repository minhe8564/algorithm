/*
 * BOJ 23057번 : 도전숫자왕
 * 메모리 : 82,580kb
 * 시간 : 468ms
 */

import java.io.*;
import java.util.*;

public class BOJ23057_도전숫자왕 {
	static int N;
	static int[] num;
	static boolean[] selected;
	static int max, cnt, answer;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
			max += num[n];
		}
		set = new HashSet<>();
		subset(0);
		
		answer = max-set.size()+1; // 공집합+1
		sb.append(answer);
		System.out.println(sb);
		br.close();
	}
	
	private static void subset(int cnt) {
		if(cnt==N) {
			set.add(sum());
			cnt++;
			return;
		}
		
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);
	}
	
	private static int sum() {
		int sum = 0;
		for(int n = 0; n < N; n++) {
			if(selected[n]) {
				sum += num[n];
			}
		}
		return sum;
	}
}
