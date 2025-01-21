package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2578 {
	static int[][] userGrid;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		userGrid = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				userGrid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 사회자가 부르는 번호 -> 유저 빙고 판 = true
		// 2. 한판 끝날 때 마다 빙고 검사
		// 3. 한 줄 만들어지면 값 증가 -> 3줄 되면 빙고
		// 4. 몇번째 판에 빙고?
		
		count = 0;
		int answer = 0;
		outer: for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				int ownerNum = Integer.parseInt(st.nextToken());
				answer++;
				
				for(int x = 0; x < 5; x++) {
					for(int y = 0; y < 5; y++) {
						if(userGrid[x][y] == ownerNum) {
							userGrid[x][y] = 0; // 0: true
						}
					}
				}
				
				count = 0;
				wCheck();
				hCheck();
				lrCheck();
				rlCheck();
				
				if(count >= 3) {
					break outer;
				}
			}
		}
		
		sb.append(answer);
		System.out.println(sb);
		br.close();
		
	}
	
	// 가로
	public static void wCheck() {
		for(int i = 0; i < 5; i++) {
			int trueCount = 0;
			for(int j = 0; j < 5; j++) {
				if(userGrid[i][j] == 0) {
					trueCount++;
				}
			}
			if(trueCount == 5) {
				count++;
			}
		}
	}
	
	// 세로
	public static void hCheck() {
		for(int i = 0; i < 5; i++) {
			int trueCount = 0;
			for(int j = 0; j < 5; j++) {
				if(userGrid[j][i] == 0) {
					trueCount++;
				}
			}
			if(trueCount == 5) {
				count++;
			}
		}
	}
	
	// 왼쪽에서 오른쪽 대각선
	public static void lrCheck() {
		int trueCount = 0;
		for(int i = 0; i < 5; i++) {
			if(userGrid[i][i] == 0) {
				trueCount++;
			}
		}
		if(trueCount == 5) {
			count++;
		}
	}
	
	// 오른쪽에서 왼쪽 대각선
	public static void rlCheck() {
		int trueCount = 0;
		for(int i = 0; i < 5; i++) {
			if(userGrid[i][4-i] == 0) {
				trueCount++;
			}
		}
		if(trueCount == 5) {
			count++;
		}
	}

}
