package algorithm;

import java.io.*;

public class BOJ2447 {
	static StringBuilder sb = new StringBuilder();
	private static void star(int i, int j, int N) {
		if(N == 1) {
			sb.append("*");
			return;
		}
		
		int newN = N/3;
		
		// 중앙 공백 체크
		if((i/newN)%3==1 && (j/newN)%3==1) {
			sb.append(" ");
		}
		else {
//			sb.append("*");
			star(i, j, newN);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				star(i, j, N);
				
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
