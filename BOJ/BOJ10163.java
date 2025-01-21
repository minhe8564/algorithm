package algorithm;

import java.io.*;
import java.util.*;

public class BOJ10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N + 1];
		int[][] arr = new int[1001][1001];
		
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < (x+width); i++) {
				for(int j = y; j < (y+height); j++) {
					arr[i][j] = n;
				}
			}
		}
		
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				count[arr[i][j]]++;
			}
		}
		
		for(int n = 1; n <= N; n++) {
			System.out.println(count[n]);
		}
	}

}
