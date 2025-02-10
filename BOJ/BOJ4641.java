package algorithm;

import java.io.*;
import java.util.*;

public class BOJ4641 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int[] num = new int[16];
			int i = 0;
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int token = Integer.parseInt(st.nextToken());
				if(token == -1) return;
				num[i] = token;
				i++;
			}
			
			Arrays.sort(num);
			for(int j = 0; j < 16; j++) {
				for(int k = 0; k < 16; k++) {
					if(num[j] == 0 || num[k] == 0) continue;
					if(num[k] == num[j]*2) count++;
				}
			}
			
			System.out.println(count);
		}
		
	}

}
