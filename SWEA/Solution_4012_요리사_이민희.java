package algorithm;

import java.io.*;
import java.util.*;

/*
 * 메모리 : 41,720kb
 * 실행시간 : 217ms
 */

// N개에서 N/2개 구하기
// 대칭되는 시너지 합 구하기
// 맛의 차이가 최소가 되는 경우 구하기

// nCn/2 (16C8 * 50개 테케) = 128700*50 완탐 가능!!!
// 대칭되니까, 하나의 값 고정해두면 탐색 1/2 줄일 수 있음 (30ms 빨라진다..)
// ex) 1이 있는 경우와 없는 경우를 비교했을 때, 경우의 수는 딱 절반이다.

public class Solution_4012_요리사_이민희 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			visited[0] = true; // 하나의 값 고정
			comb(1, 1);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(visited));
			minDiff();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}

	private static void minDiff() {
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				A.add(i);
			} else {
				B.add(i);
			}
		}
		
		int sumA = 0;
		for(int i = 0; i < A.size(); i++) {
			for(int j = 0; j < A.size(); j++) {
				sumA += map[A.get(i)][A.get(j)];
			}
		}
		int sumB = 0;
		for(int i = 0; i < B.size(); i++) {
			for(int j = 0; j < B.size(); j++) {
				sumB += map[B.get(i)][B.get(j)];
			}
		}

		answer = Math.min(answer, Math.abs(sumA - sumB));
		return;
	}
}
