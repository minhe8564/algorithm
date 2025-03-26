/*
 * BOJ 1043번 : 거짓말
 * 메모리 : 11,600kb 
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1043_거짓말 {
	static int N, M;
	static int[] parent;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int n = 1; n <= N; n++) {
			parent[n] = n;
		}

		st = new StringTokenizer(br.readLine());
		int knowNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람
		int[] know = new int[knowNum];
		for (int i = 0; i < knowNum; i++) {
			know[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer>[] party = new ArrayList[M];
		for (int m = 0; m < M; m++) {
			party[m] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken()); // 파티에 오는 사람
			int first = Integer.parseInt(st.nextToken()); 
			party[m].add(first);
			int temp = find(first);
			for (int i = 1; i < num; i++) {
				int person = Integer.parseInt(st.nextToken());
				party[m].add(person);
				union(temp, person);
			}
		}
//		System.out.println(Arrays.toString(parent));

		answer = 0;
		for (int m = 0; m < M; m++) {
			boolean flag = true;
			for (int p : party[m]) {
				for (int i = 0; i < knowNum; i++) {
					if (find(p) == find(know[i])) {
						flag = false;
						break;
					}
				}
			}
			if (flag) answer++;
		}

		sb.append(answer);
		System.out.print(sb);
		br.close();
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<=y) parent[y]=x;
		else parent[x]=y;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}
