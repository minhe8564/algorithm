package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arrN[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int target = Integer.parseInt(st.nextToken());
			if(binarySearch(arrN, target)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static boolean binarySearch(int[] arrN, int target) {
		int left = 0;
		int right = arrN.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(arrN[mid] == target) {
				return true;
			} else if (arrN[mid] > target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return false;
	}

}
