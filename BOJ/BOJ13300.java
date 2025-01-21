package algorithm;

import java.io.*;
import java.util.*;

public class BOJ13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 최대 인원 수
		int[][] arr = new int[2][6];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken()); // 성별 여0 남1
			int Y = Integer.parseInt(st.nextToken()); // 학년	
			
			arr[S][Y-1]++;		
		}
		
		int answer = 0;
		for(int s = 0; s < 2; s++) {
			for(int y = 0; y < 6; y++) {
				answer += Math.ceil((double)arr[s][y] / (double)K);
			}
		}
		
		System.out.println(answer);
	}
}
