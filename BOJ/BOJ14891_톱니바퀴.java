package algorithm;

import java.io.*;
import java.util.*;

/*
 * 메모리 : 11764kb
 * 시간 : 72ms
 */

public class BOJ14891_톱니바퀴 {
	static int[][] cogwheel;
	static int K;
	static Node[] command;
	static int answer;

	static class Node {
		int num, dir;

		public Node(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		cogwheel = new int[5][8];
		for (int i = 1; i <= 4; i++) { // 톱니바퀴 번호, 상태
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				cogwheel[i][j] = str.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());
		command = new Node[K];

		for (int i = 0; i < K; i++) { // 회전시킨 톱니바퀴 번호, 방향
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			command[i] = new Node(num, dir);
		}

		answer = 0;
		solution();

		sb.append(answer);
		System.out.print(sb);
		br.close();
	}

	private static void solution() {
		for (int k = 0; k < K; k++) {
			int currNum = command[k].num;
			int currDir = command[k].dir;

			// 옆에 있는 톱니바퀴가 연쇄적으로 움직여야 함
			// 맞닿은 부분 극이 다르다면 반대방향으로 회전, 같으면 같은방향으로 회전
			// 맞닿은 부분 cogwheel[currNum][6] 와 cogwheel[currNum-1][2]
			// 맞닿은 부분 cogwheel[currNum][2] 와 cogwheel[currNum+1][6]

			int[] rotate = new int[5];
			rotate[currNum] = currDir;

			// 왼쪽
			for (int i = currNum; i > 1; i--) {
				if (cogwheel[i][6] != cogwheel[i-1][2]) {
					rotate[i-1] = -rotate[i];
				} 
			}

			// 오른쪽 
			for (int i = currNum; i < 4; i++) {
				if (cogwheel[i][2] != cogwheel[i+1][6]) {
					rotate[i+1] = -rotate[i];
				}
			}

			for (int i = 1; i <= 4; i++) {
				if (rotate[i] != 0) {
					change(i, rotate[i]);
				}
			}
		}

		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				if (cogwheel[i][0] == 1) {
					answer += 1;
				}
				break;
			case 2:
				if (cogwheel[i][0] == 1) {
					answer += 2;
				}
				break;
			case 3:
				if (cogwheel[i][0] == 1) {
					answer += 4;
				}
				break;
			case 4:
				if (cogwheel[i][0] == 1) {
					answer += 8;
				}
				break;
			}
		}
		return;
	}

	private static void change(int currNum, int currDir) {
		if (currDir == 1) { // 시계
			int temp = cogwheel[currNum][7];
			for (int i = 7; i > 0; i--) {
				cogwheel[currNum][i] = cogwheel[currNum][i - 1];
			}
			cogwheel[currNum][0] = temp;

		} else if (currDir == -1) { // 반시계
			int temp = cogwheel[currNum][0];
			for (int i = 0; i < 7; i++) {
				cogwheel[currNum][i] = cogwheel[currNum][i + 1];
			}
			cogwheel[currNum][7] = temp;
		}
	}
}
