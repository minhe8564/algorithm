package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655_N과M6 {
	static int N, M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		visited = new boolean[N];
		result = new int[M];
		
		perm(0, 0);
		
		System.out.println(sb);
		br.close();
	}
	
	private static void perm(int cnt, int start) {
		if(cnt == M) {
			for(int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = arr[i];
				perm(cnt+1, i);
				visited[i] = false;
			}
		}
	}

}
