/*
 * SWEA 3289번 : 서로소 집합
 * 메모리 : 118,996kb
 * 시간 : 442ms
 */

import java.io.*;
import java.util.*;

public class SWEA3289_서로소집합 {
	static int N, M;
	static int[] parent;
	static int[] rank;
	
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
			rank = new int[N+1];
			for(int n = 1; n <= N; n++) {
				parent[n] = n;
			}
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) { // 합집합
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					union(a, b);
				} else { // 포함되어 있는지 확인
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					if(find(a) == find(b)) sb.append(1); // 같은 집합
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

    // 최적화 1 : rank
		// rank 배열
		// rank 더 작은쪽이 자식으로, 같으면 한쪽에++
		if(rank[x]==rank[y]) rank[x]++;
		if(rank[x]>rank[y]) parent[y]=x;
		else parent[x]=y;
		
//		if(x<=y) parent[y]=x;
//		else parent[x]=y;
	}
	
	private static int find(int x) {
		if(parent[x]==x) return x;
    // 최적화 2 : 경로 압축
		else return parent[x]=find(parent[x]);
	} 
}
