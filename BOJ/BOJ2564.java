package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2564 {
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int total = (X + Y) << 1;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		for (int n = 0; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken()); // 1:북, 2:남, 3:서, 4:동
			arr[n] = Integer.parseInt(st.nextToken()); // 북,남:왼쪽 경게로부터 거리 / 동,서 :위쪽 경계로부터 거리
			
			if (dir == 2)
				arr[n] = X-arr[n];
			else if(dir == 3)
				arr[n] = Y-arr[n];
			
			switch (dir) {
			case 3:
				arr[n] += X;
			case 2:
				arr[n] += Y;
			case 4:
				arr[n] += X;
			}
		}
		
		// 상점-동근위치 빼고, 그 길이와 토탈-길이 비교하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int len = Math.abs(arr[N] - arr[i]);
			sum += Math.min(len, total - len);
		}
		
		System.out.println(sum);
		br.close();

	}

}
