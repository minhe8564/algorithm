/*
 * 메모리 : 207,952kb
 * 시간 : 676ms
 */

import java.io.*;
import java.util.*;

public class BOJ14003_가장긴증가하는부분수열5 {
	static int N;
	static int[] A;
	static int[] LIS;
	static int[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		LIS = new int[N];
		D = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = A[0];
		D[0] = 0;
		int length = 1;
		for(int n = 1; n < N; n++) {
			if(A[n] > LIS[length-1]) {
				LIS[length] = A[n];
				D[n] = length;
				length++;
			} else {
				int pos = binarySearch(0, length-1, A[n]);
				LIS[pos] = A[n];
				D[n] = pos; 
			}
		}
//		System.out.println(Arrays.toString(D));
//		System.out.println(Arrays.toString(LIS));
			
		sb.append(length).append("\n");
		List<Integer> result = new ArrayList<>();
		int idx = length-1;
		for(int n = N-1; n >= 0; n--) {
			if(D[n] == idx) {
				result.add(A[n]);
				idx--;
			}
			if(idx < 0) {
				break;
			}
		}
		
		Collections.reverse(result);
		
		for(int r : result) {
			sb.append(r).append(" ");
		}
		
		System.out.print(sb);
		br.close();
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
