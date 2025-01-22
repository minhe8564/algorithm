package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 기동의 개수
		int[][] arr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[n][0] = Integer.parseInt(st.nextToken()); // 왼쪽 면의 위치 L (x츅 위치)
			arr[n][1] = Integer.parseInt(st.nextToken()); // 높이 H
		}
		// 1. 막대기 위치 (x축 위치) 기준 오름차순 정렬
		// 2. 최고 높이 막대 기준으로 좌 우 분리
		// 3. 좌 우 따로 계산
		// 3. 최고 높이 막대의 너비와 높이 곱해서 area 추가하기
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		// System.out.println(Arrays.deepToString(arr));
		
		int yMax = Integer.MIN_VALUE;
		int yMaxIdx = 0;
		
		for(int i = 0; i < N; i++) {
			if(arr[i][1] > yMax) {
				yMax = arr[i][1];
				yMaxIdx = i;
			}
		}
		
		int area = 0;
		
		int leftMax = arr[0][1];
		for(int i = 1; i <= yMaxIdx; i++) {
			area += (arr[i][0] - arr[i-1][0]) * leftMax;
			if(arr[i][1] > leftMax) {
				leftMax = arr[i][1];
			}
		}
		
		int rightMax = arr[N-1][1];
		for(int i = N-2; i >= yMaxIdx; i--) {
			area += (arr[i+1][0] - arr[i][0]) * rightMax;
			if(arr[i][1] > rightMax) {
				rightMax = arr[i][1];
			}
		}
		
		area += yMax;
		System.out.println(area);
		br.close();
	}

}
