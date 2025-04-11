/*
 * BOJ 17135번 : 캐슬 디펜스
 * 메모리 : 22,792kb
 * 시간 : 268ms
 * 
 * 1. 궁수 어디에 배치할지 중복 없이 조합
 * 2. 궁수 공격!!!해서 적 물리치기
 * 3. 적 아래로 한칸 내려오기
 * 4. 모든 적이 격자판에서 제외될 때까지 반복
 * 2~4번 반복해서 제거할 수 있는 적의 최대 수 세기 
 */

import java.io.*;
import java.util.*;

public class BOJ17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static int[][] copy;
	static int enemy;
	static int maxEnemy;
	static int[] num; // 궁수의 위치 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		num = new int[3];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = copy[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxEnemy = Integer.MIN_VALUE;
		
		comb(0, -1); // cnt, start
		
		sb.append(maxEnemy);
		System.out.print(sb);
		br.close();
	}
	
	private static void comb(int cnt, int start) {
		if(cnt==3) {
			maxEnemy = Math.max(maxEnemy, attack(num));
			for(int n = 0; n < N; n++) {
				map[n] = copy[n].clone();
			}
			return;
		}
		
		// 중복 없는 조합
		for(int i = start+1; i < M; i++) {
			num[cnt] = i;
			comb(cnt+1, i);
		}
	}
	
	private static int attack(int[] num) {
		int enemy = 0;
		
		for(int turn = 0; turn < N; turn++) {
			List<int[]> list = new ArrayList<int[]>(); // 공격할 적 저장
			boolean[][] visited = new boolean[N][M]; // 공격할 적 중복 제거 위한 배열
			
			for(int i = 0; i < 3; i++) {
				int r1 = N;  // 궁수의 행
				int r2 = num[i]; // 궁수의 열
				
				int minDist = Integer.MAX_VALUE;
				int c1 = -1; // 적의 행 초기화
				int c2 = -1; // 적의 열 초기화
				
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(map[n][m] == 1) {
							int dist = Math.abs(r1-n)+Math.abs(r2-m);
							
							if(dist <= D) { // 공격 거리 제한
								// 가장 가까운 적, 왼쪽에 있는 적
								if(dist < minDist || (dist==minDist && m < c2)) { 
									minDist = dist;
									c1 = n;
									c2 = m;
								}
							}
						}
					}
				}
				
				// 적 중복공격 방지해서 공격 가능한 적 리스트 추가
				if(c1 != -1 && c2 != -1 && !visited[c1][c2]) {
					visited[c1][c2] = true;
					list.add(new int[] { c1, c2 });
				}
			}
			
			// 적 제거 
			for(int[] pos : list) {
				if(map[pos[0]][pos[1]] == 1) {
					map[pos[0]][pos[1]] = 0;
					enemy++;
				}
			}
			down();
		}
		return enemy;
	}
	
	private static void down() {
		// 아래쪽으로 한칸씩 이동
		for(int n = N-1; n > 0; n--) {
			for(int m = 0; m < M; m++) {
				map[n][m] = map[n-1][m];
			}
		}
		
		// 맨 윗줄은 0으로
		for(int m = 0; m < M; m++) {
			map[0][m] = 0;
		}
	}
}
