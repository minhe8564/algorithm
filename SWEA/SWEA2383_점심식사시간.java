/*
 * SWEA 2383번 : 점심 식사 시간
 * 메모리 : 29,776kb 
 * 시간 : 107ms
 */

import java.io.*;
import java.util.*;

public class SWEA2383_점심식사시간 {
	static int N;
	static int[][] map;
	static Person[] persons;
	static Stair[] stairs;
	static int minTime;
	static boolean[] selected;
	static int personIdx, stairIdx;
	static class Person {
		int r, c;
		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Stair {
		int r, c, length;
		public Stair(int r, int c, int length) {
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			persons = new Person[10];
			stairs = new Stair[2];
			personIdx = 0; stairIdx = 0;
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) persons[personIdx++] = new Person(r,c);
					if(map[r][c] >= 2) stairs[stairIdx++] = new Stair(r,c,map[r][c]);
				}
			}
			selected = new boolean[personIdx];
			
			// 사람들이 어떤 계단을 선택할지
			minTime = Integer.MAX_VALUE;
			subset(0);
			
			sb.append(minTime).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void subset(int cnt) {
		if(cnt == personIdx) {
			// 최소시간 경우의 수 찾기
			minTime = Math.min(minTime, time());
			return;
		}
		
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);
	}
	
	private static int time() {		
		PriorityQueue<Integer> stairA = new PriorityQueue<>();
		PriorityQueue<Integer> stairB = new PriorityQueue<>();
		
		for(int i = 0; i < personIdx; i++) {
			Person p = persons[i];
			Stair s = selected[i] ? stairs[0] : stairs[1];
			int dis = Math.abs(p.r-s.r)+Math.abs(p.c-s.c);
			if(selected[i]) stairA.add(dis);
			else stairB.add(dis);
		}
		
		int timeA = move(stairA, stairs[0].length);
		int timeB = move(stairB, stairs[1].length);
		return Math.max(timeA, timeB);
	}
	
	private static int move(PriorityQueue<Integer> pq, int stairLen) { // 계단 도착거리, 계단길이
		Queue<Integer> q = new ArrayDeque<Integer>();
		int time = 0;
		
		while(!pq.isEmpty()) {	
			// 계단에서 내려간 사람 제거
			while(!q.isEmpty() && q.peek() <= time) {
				q.poll();
			}
			
			// 계단에 입장 가능한 사람 (3명 제한 + 도착 후 1분 대기)
			while(!pq.isEmpty() && q.size() < 3) {
				if(pq.peek() < time) {
					pq.poll();
					q.offer(time+stairLen);
				} else if(pq.peek() == time) {
					pq.poll();
					q.offer(time+stairLen+1);
				} else {
					break;
				}
			}
			
			time++;
		}
		
		// 남은 계단 이용자 처리
		while(!q.isEmpty()) {
			time = q.poll();
		}
		
		return time;
	}
}
