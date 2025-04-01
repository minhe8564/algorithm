/*
 * BOJ 10800번 : 컬러볼
 * 메모리 : 855,992kb
 * 시간 : 1,004ms
 * 
 * 색이 같은 두 공에 대해
 * A의 크기보다 B의 크기가 크다면
 * A가 잡을 수 있는 공은 B가 모두 잡을 수 있다!
 * 
 * 1. 공들을 크기 기준 오름차순 정렬
 * 2. 현재까지 등장한 공 누적합 totalSum
 * 3. 색 별로 누적된 크기 합 colorSum[ball[m].color]
 * 4. 자기보다 크기가 작은 공들만 고려하면서  totalSum-colorSum[ball[n].color]
 */

import java.io.*;
import java.util.*;

public class BOJ10800_컬러볼 {
	static int N;
	static Ball[] ball;
	static int[] answer;
	static int[] colorSum;
	static class Ball implements Comparable<Ball> {
		int color, size, ballNum;
		public Ball(int color, int size, int ballNum) {
			this.color = color;
			this.size = size;
			this.ballNum = ballNum;
		}
		@Override
		public int compareTo(Ball o) {
			return this.size-o.size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ball = new Ball[N];
		answer = new int[N];
		colorSum = new int[N+1];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			ball[n] = new Ball(color, size, n);
		}
		Arrays.sort(ball);
		
		int totalSum = 0;
		int m = 0;
		for(int n = 0; n < N ; n++) {
			while(ball[n].size > ball[m].size) {
				totalSum += ball[m].size;
				colorSum[ball[m].color] += ball[m].size;
				m++;
			}
			answer[ball[n].ballNum] = totalSum-colorSum[ball[n].color];
		}
		
		for(int n = 0; n < N; n++) {
			sb.append(answer[n]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
