package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] board = new String[N][M];
		for (int n = 0; n < N; n++) {
			String[] str = br.readLine().split("");
			for (int m = 0; m < M; m++) {
				board[n][m] = str[m];
			}
		}

		int minCount = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				minCount = Math.min(minCount, getMinCount(board, i, j));
			}
		}

		System.out.println(minCount);
		br.close();
	}

	public static int getMinCount(String[][] board, int x, int y) {
		String[] board1 = { "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
				"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
		String[] board2 = { "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
				"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(!board[x+i][y+j].equals(Character.toString(board1[i].charAt(j)))){
					count1++;
				}
				if(!board[x+i][y+j].equals(Character.toString(board2[i].charAt(j)))){
					count2++;
				}
			}
		}
		return Math.min(count1, count2);
	}

}
