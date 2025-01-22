package algorithm;

import java.io.*;
import java.util.*;

public class BOJ9372 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a  = Integer.parseInt(st.nextToken());
				int b  = Integer.parseInt(st.nextToken());
			}
			
			// 최소 신장 트리 : 사이클 없이 간선 가중치의 합이 최소
			sb.append(N-1).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	

}
