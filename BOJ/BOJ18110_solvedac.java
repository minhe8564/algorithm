package algorithm;

import java.io.*;
import java.util.*;

public class BOJ18110_solvedac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int removePerson = (int) (Math.round(N * 0.15));
		double sum = 0; 
		int cnt = 0;
		for(int n = removePerson; n < N-removePerson; n++) {
			sum += arr[n];
			cnt++;
		}
		int avg = (int) Math.round(sum/cnt);

		sb.append(avg);
		System.out.println(sb);
		br.close();
	}

}
