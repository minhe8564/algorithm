package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1475_방번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int[] count = new int[10];
		for(int i = 0; i < N.length(); i++) {
			int num = N.charAt(i) - '0';
			count[num]++;
		}
		
		int same = count[6] + count[9];
		count[6] = count[9] = (same+1) / 2;
		
		int maxCount = 0;
		for(int i = 0; i < 10; i++) {
			maxCount = Math.max(maxCount, count[i]);
		}

		System.out.println(maxCount);

	}
}
