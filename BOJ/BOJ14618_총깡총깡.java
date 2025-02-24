package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14618_총깡총깡 {
	static int N, M;
	static int J, K;
	static int X, Y, Z;
	static List<Integer> houseA;
	static List<Integer> houseB;
	static List<Node>[] graph;
	static String type;
	static int dis;
	
	static class Node {
		int target, distance;
		
		public Node(int target, int distance) {
			this.target = target;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 집의 수
		M = Integer.parseInt(st.nextToken()); // 도로
		J = Integer.parseInt(br.readLine()); // 진서 집
		K = Integer.parseInt(br.readLine()); // 동물의 수
		houseA = new ArrayList<Integer>();
		houseB = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			houseA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			houseB.add(Integer.parseInt(st.nextToken()));
		}
		graph = new ArrayList[N+1];
		for (int n = 0; n <= N; n++) {
			graph[n] = new ArrayList<Node>();
		}
		for (int m = 0; m < M; m++) { // X번집, Y번집, 거리
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// 그래프에 도로 정보 저장 (양방향)
			graph[X].add(new Node(Y, distance));
			graph[Y].add(new Node(X, distance));
		}
		
		int[] distances = dijkstra(J);
//		System.out.println(Arrays.toString(distances));
		
		int disA = Integer.MAX_VALUE;
		for(int a : houseA) {
			disA = Math.min(disA, distances[a]);
		}
		int disB = Integer.MAX_VALUE;
		for(int b : houseB) {
			disB = Math.min(disB, distances[b]);
		}
		
		// 조건 고려하기!!!
		if(disA == Integer.MAX_VALUE && disB == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			if(disA <= disB) {
				type = "A";
				dis = disA;
			} else {
				type = "B";
				dis = disB;
			}
			sb.append(type).append("\n");
			sb.append(dis);
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static int[] dijkstra(int start) {
		// 1. 다익스트라 알고리즘 초기화
		int[] distances = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		// 2. 최소 거리 저장 - 우선순위 큐
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.distance-o2.distance);
		pq.offer(new Node(start, 0));
		distances[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currTarget = curr.target;
			int currDistance = curr.distance;
			
			// 3. 이미 더 짧은 거리면 건너뜀
			if(distances[currTarget] < currDistance) {
				continue;
			}

			// 4. 현재 집에서 연결된 도로 확인
			for(Node next : graph[currTarget]) {
				int nextTarget = next.target;
				int nextDistance = next.distance;
				
				// 5. 더 짧은 거리면 업데이트 (도달할 때까지의 경로 체크)
				if(distances[nextTarget] > nextDistance+currDistance) {
					distances[nextTarget] = nextDistance+currDistance;
					pq.offer(new Node(nextTarget, nextDistance+currDistance));
				}
			}
		}
		
		return distances;
	}

}
