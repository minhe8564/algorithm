/*
 * BOJ 2568번 : 전깃줄2
 * 메모리 : 59,140kb
 * 시간 : 576ms
 * 
 * 1. A 전봇대 기준으로 오름차순 정렬 -> A가 정렬되면, B에 대해서만 LIS 구하면 됨
 * 2. B 전봇대 기준으로 LIS 구하기 -> 겹치지 않고 이어지는 전깃줄 개수
 * 3. 전체-LIS -> 나머지 전기줄은 겹치니까 제거 
 */

import java.io.*;
import java.util.*;

public class BOJ2568_전깃줄2 {
	static int N;
	static int[][] arr;
	static int[] LIS;
	static int[] POS;

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
//		System.out.println(Arrays.deepToString(arr));
		
		LIS = new int[N]; // 각 길이를 LIS로 만족하는 가장 끝에 오는 최소값
		POS = new int[N];
		
		LIS[0] = arr[0][1]; // LIS 시작
		int length = 1; // 현재 LIS 길이
		POS[0] = 0; // arr[0][1]은 LIS의 0번째 위치에 있음
		
		for(int n = 1; n < N; n++) {
			// arr[n][1]이 LIS의 마지막 값보다 크면 LIS에 그대로 추가
			if(arr[n][1] > LIS[length-1]) {
				LIS[length] = arr[n][1];
				POS[n] = length; // arr[n][1]은 length번째 자리에 들어감
				length++; // LIS 길이 증가
			} else {
				// arr[n][1]이 LIS 값보다 작거나 같으면, 이진탐색으로 들어갈 위치 찾기
				int pos = binarySearch(0, length-1, arr[n][1]);
				LIS[pos] = arr[n][1]; // 해당 위치의 값을 arr[n][1]로 교체
				POS[n] = pos; // arr[n][1]은 LIS의 pos번째 자리에 들어감
			}
			
//			System.out.println(Arrays.toString(LIS));
		}
		sb.append(N-length).append("\n");
		
		// 자리에 들어간걸 역추적
		Set<Integer> setList = new HashSet<>();
		int idx = length-1; // 마지막 LIS 인덱스부터 찾기(끝에서부터 거꾸로)
		
		for(int n = N-1; n >= 0; n--) {
			// POS[n]==idx이면 arr[n][1]은 LIS에서 해당 위치에 들어간 수라는 의미
			if(POS[n]==idx) {
				setList.add(arr[n][0]);
				idx--;
			}
			
			if(idx < 0) break;
		}
		
		// 제거해야하는 전깃줄 저장
		List<Integer> removeList = new ArrayList<Integer>();
		for(int n = 0; n < N; n++) {
			if(!setList.contains(arr[n][0])) {
				removeList.add(arr[n][0]);
			}
		}
		
		for(int r : removeList) {
			sb.append(r).append("\n");
		}
		
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
