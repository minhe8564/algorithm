package algorithm;

import java.io.*;
import java.util.*;

public class BOJ7568_덩치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][2];
		int[] result = new int[N];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[n][0] = Integer.parseInt(st.nextToken());
			person[n][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N ; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if(i == j) continue; // 자기자신 빼기
				if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
					cnt++;
				}
			}
			result[i] = cnt;
		}
		
		for (int n = 0; n < N; n++) {
			sb.append(result[n]).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}

}
