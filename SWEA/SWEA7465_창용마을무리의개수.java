/*
 * SWEA 7465번 : 창용 마을 무리의 개수
 * 메모리 : 27,776kb
 * 시간 : 137ms
 */

import java.io.*;
import java.util.*;

public class SWEA7465_창용마을무리의개수 {
	static int N, M;
	static int[] parent;
//	static int[] rank;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
//			rank = new int[N+1];
			for(int n = 1; n <= N; n++) {
				parent[n] = n;
			}
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
//			System.out.println(Arrays.toString(parent));
			
			// 다른 그룹이 몇 개 있는지?
			// 부모 값이 자기 자신과 같은 것의 개수가 그룹의 개수
			answer = 0;
			for(int n = 1; n <= N; n++) {
				if(parent[n] == n) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
//		if(rank[x]==rank[y]) rank[x]++;
//		if(rank[x]>rank[y]) parent[y]=x;
//		else parent[x]=y;
		
		if(x<=y) parent[y]=x;
		else parent[x]=y;
	}
	
	private static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x]=find(parent[x]);
	}
}
