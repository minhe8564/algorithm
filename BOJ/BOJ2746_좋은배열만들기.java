/*
 * BOJ 2746번 : 좋은 배열 만들기
 * 메모리 : 71,840kb
 * 시간 : 332ms
 * 
 * 정렬 + 투포인터 + 직접 조건 탐색
 */

import java.util.*;
import java.io.*;

public class BOJ2746_좋은배열만들기 {
	static int N;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		int[] cnt = new int[1000001];
		int len = 0;

		// 입력 + 등장 횟수 기록 + 총합 계산
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			if (cnt[arr[n]] == 0) len++;
			cnt[arr[n]]++;
			sum += arr[n];
		}

		// arr 정렬 + 중복 제거된 arr2 생성
		int[] arr2 = new int[len];
		int idx = 0, idx2 = 0;
		for (int i = 1; i <= 1000000; i++) {
			if (cnt[i] != 0) {
				for (int j = 0; j < cnt[i]; j++) arr[idx++] = i;
				arr2[idx2++] = i;
			}
		}

		long ans = 0;

		// Case 1: arr[N-1]을 기준으로
		long useSum = sum - arr[N - 1];
		long target = useSum - arr[N - 1];
		if (target > 0) {
			int left = 0;
			int right = len - 2;
			if (cnt[arr2[len - 1]] > 1) {
				right = len - 1;
				cnt[arr2[len - 1]]--;
			}
			while (left <= right) {
				long twoSum = arr2[left] + arr2[right];
				if (twoSum == target) {
					if (left != right) {
						ans += (long) cnt[arr2[left]] * cnt[arr2[right]];
					} else {
						ans += (long) cnt[arr2[left]] * (cnt[arr2[left]] - 1) / 2;
					}
					left++;
					right--;
				} else if (twoSum < target) {
					left++;
				} else {
					right--;
				}
			}
		}

		// Case 2: arr[N-2]를 기준으로
		useSum = sum - arr[N - 1] - arr[N - 2];
		target = useSum - arr[N - 2];
		if (target > 0) {
			for (int i = 0; i < N - 2; i++) {
				if (arr[i] == target) {
					ans++;
				}
				if (arr[i] > target) break;
			}
		}

		// Case 3: arr[N-3]를 기준으로
		long remain = sum - arr[N - 1] - arr[N - 2] - arr[N - 3];
		if (remain == arr[N - 3]) {
			ans++;
		}

		sb.append(ans);
		System.out.print(sb);
		br.close();
	}
}
