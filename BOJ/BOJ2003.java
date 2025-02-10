package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		while(true) {
			if(sum >= M) {
				sum -= arr[start++];
			} 
			else if(end == N) {
				break;
			}
			else {
				sum += arr[end++];
			}
			
			if(sum == M) {
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
	}

}
