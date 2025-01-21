package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2669 {
	static int x = 0, y = 0, p = 0, q = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] arr = new int[101][101];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			for (int j = y; j < q; j++) {
				for(int k = x; k < p; k++) {
					arr[j][k] = 1;
				}
			}
		}

		int answer = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(arr[i][j] == 1) {
					answer++;
				}
			}
		}
		
		sb.append(answer);
		System.out.println(sb);
		br.close();
	}

}
