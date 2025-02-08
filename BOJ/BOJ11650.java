package algorithm;

import java.io.*;
import java.util.*;

public class BOJ11650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// x좌표가 같으면 y좌표가 증가하는 순서로 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) return o1[1]-o2[1];
			return o1[0]-o2[0];
		});

		for(int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
