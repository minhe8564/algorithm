package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2920_음계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// c d e f g a b C
		// 1 2 3 4 5 6 7 8

		int[] arr = new int[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean isAscending = true;
		boolean isDescending = true;
		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] == i+1) {
//				isAscending = true;
//			}
//			한 번이라도 true면 true로 되기 때문에 오류
			
			if(arr[i] != i+1) {
				isAscending = false;
			}
			if(arr[i] != 8-i) {
				isDescending = false;
			} 
		}

		if(isAscending) sb.append("ascending");
		else if(isDescending) sb.append("descending");
		else sb.append("mixed");

		System.out.println(sb);
		br.close();
	}

}
