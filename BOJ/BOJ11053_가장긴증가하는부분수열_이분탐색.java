/*
 * BOJ 11053번 : 가장 긴 증가하는 부분 수열 
 * 이분탐색 O(NlogN)
 * 메모리 : 11,832kb
 * 시간 : 72ms
 */

import java.io.*;
import java.util.*;

public class BOJ11053_가장긴증가하는부분수열_이분탐색 {
	static int N;
	static int[] A;
	static int[] LIS;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		LIS = new int[N]; // 현재까지의 증가하는 부분 수열 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = A[0];
		int length = 1;
		
		for(int n = 1; n < N; n++) {
			// 현재 값이 LIS 배열 마지막 값 보다 크면 -> LIS 추가 
			if(A[n] > LIS[length-1]) {
				LIS[length++] = A[n];
			} else {
				// 현재 값이 LIS 중간에 들어가야할 경우 -> 이분탐색으로 위치 찾기 
				// 가능한 작은 값으로 수열 유지해야 뒤에 더 많은 수가 올 수 있다
				int pos = binarySearch(0, length-1, A[n]);
				LIS[pos] = A[n];
			}
		}
		
		answer = length;
		sb.append(answer);
		System.out.print(sb);
		br.close();
	}
	
	private static int binarySearch(int left, int right, int target) {
		while(left < right) {
			int mid = (left+right)/2;
			if(LIS[mid] < target) { // 오른쪽 이동 
				left = mid+1;
			} else { // 왼쪽 이동 
				right = mid;
			}
		}
		return left;
	}
}
