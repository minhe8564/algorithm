package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2167 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 1; m <= M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int i = I; i <= X; i++) {
				for(int j = J; j <= Y; j++) {
					sum += arr[i][j];
				}
			}
			
			System.out.println(sum);
		}
		br.close();
	}

}
