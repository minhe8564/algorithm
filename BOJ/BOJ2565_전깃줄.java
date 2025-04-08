/*
 * BOJ 2565번 : 전깃줄
 * 메모리 : 18,152kb
 * 시간 : 184ms
 * 
 * 1. A 전봇대 기준으로 오름차순 정렬 -> A가 정렬되면, B에 대해서만 LIS 구하면 됨
 * 2. B 전봇대 기준으로 LIS 구하기 -> 겹치지 않고 이어지는 전깃줄 개수
 * 3. 전체-LIS -> 나머지 전기줄은 겹치니까 제거
 */

import java.io.*;
import java.util.*;

public class BOJ2565_전깃줄 {
	static int N;
	static int[][] arr;
	static int[] LIS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1,o2) -> o1[0]-o2[0]);
		
		LIS = new int[N]; // 각 길이를 LIS로 만족하는 가장 끝에 오는 최소값
		
		LIS[0] = arr[0][1];
		int length = 1; // 현재 LIS 길이
		
		for(int n = 1; n < N; n++) {
			if(arr[n][1] > LIS[length-1]) {
				// 현재 값이 LIS 끝보다 크면 -> 수열 뒤에 붙일 수 있음
				LIS[length++] = arr[n][1];
			} else {
				// 수열 중간에 들어가야 할 경우 -> 이분탐색으로 위치 찾기
				// 가능한 작은 값으로 수열 앞쪽을 유지해야 뒤에 더 많은 수가 올 수 있음
				int pos = binarySearch(0, length-1, arr[n][1]);
				LIS[pos] = arr[n][1];
			}
		}
		
		sb.append(N-length);
		System.out.print(sb);
	}
	
	private static int binarySearch(int left, int right, int target) {
		while(left < right) {
			int mid = (left+right)/2;
			if(LIS[mid] < target) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
