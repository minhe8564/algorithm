/*
 * BOJ 1717번 : 집합의 표현
 * 메모리 : 54,688kb
 * 시간 : 344ms
 * 
 * 유니온 파인드 문제
 * - 서로소 집합 표현
 * - 여러 노드가 있을 때, 두 노드가 같은 그래프에 속해있는지 알 수 있다!
 * 
 * MST
 * - 프림
 * - 크루스칼 (유니온 파인드 사용함)
 */

import java.io.*;
import java.util.*;

public class BOJ1717_집합의표현 {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int n = 1; n <= N; n++) { // 부모 노드 추기화
			parent[n] = n;
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) { // 합집합
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			} else { // 두 원소가 같은 집합에 포함되어 있는지 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a)==find(b)) sb.append("YES\n"); 
				else sb.append("NO\n");
			}
		}
		
		System.out.print(sb);
		br.close();
	}
	
//	private static boolean union(int x, int y) {
//		x = find(x);
//		y = find(y);
//		
//		// 이미 같은 그래프에 속해있으면 false 반환
//		if(x==y) return false;
//		
//		if(x<=y) parent[y] = x;
//		else parent[x] = y;
//		return true;
//	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<=y) parent[y] = x; // 작은 값을 부모로
		else parent[x] = y;
	}
	
	private static int find(int x) {
		if(parent[x]==x) return x;
		return find(parent[x]);
//		return parent[x]=find(parent[x]);
	}
}
