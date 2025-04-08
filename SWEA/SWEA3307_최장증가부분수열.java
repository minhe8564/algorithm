import java.io.*;
import java.util.*;

public class SWEA3307_최장증가부분수열 {
	static int N;
	static int[] arr;
	static int[] LIS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			LIS = new int[N];
			LIS[0] = arr[0];
			int length = 1;
			
			for(int n = 1; n < N; n++) {
				if(arr[n] > LIS[length-1]) {
					LIS[length++] = arr[n];
				} else {
					int pos = binarySearch(0, length-1, arr[n]);
					LIS[pos] = arr[n];
				}
			}
			
			sb.append(length).append("\n");
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
