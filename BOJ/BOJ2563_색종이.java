import java.io.*;
import java.util.*;

// 구현
// 입력받은 좌표+10 = 1
// 1 카운트

/*
 * 메모리 : 11640kb
 * 시간 : 72ms
 */

public class BOJ2563_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(board[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
		br.close();
	}

}
