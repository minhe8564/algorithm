package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2108_통계학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int sum = 0;
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(br.readLine());
			sum += nums[n];
		}
		
		// 산술평균
		sb.append(Math.round((double)sum/N)).append("\n");
		
		// 중앙값
		Arrays.sort(nums);
		int mid = (int) N/2;
		sb.append(nums[mid]).append("\n");
		
		// 최빈값
		int[] cnt = new int[8001]; // -4000 ~ 4000
		int maxCnt = 0;
		for (int n = 0; n < N; n++) {
			cnt[nums[n] + 4000]++;
			maxCnt = Math.max(maxCnt, cnt[nums[n] + 4000]);
		}
		
		int secondCnt = 0;
		boolean second = false;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] == maxCnt) {
				if(second) {
					secondCnt = i - 4000;
					break;
				}
				secondCnt = i - 4000;
				second = true;
			}
		}
		sb.append(secondCnt).append("\n");
		
		
		// 범위
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			max = Math.max(max, nums[n]);
			min = Math.min(min, nums[n]);
		}
		sb.append(max-min);
		
		System.out.println(sb);
		br.close();
	}

}
