package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2458_키순서 {
	static int N, M;
	static List<ArrayList<Integer>> graph; // 인접 리스트 쓰기!!!
	static List<ArrayList<Integer>> reverseGraph; 
	static boolean[] visited;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine().trim());
//		for (int t = 1; t <= T; t++) {
//			N = Integer.parseInt(br.readLine().trim()); // 학생의 수
//			M = Integer.parseInt(br.readLine().trim()); // 학생의 키를 비교한 횟수
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			reverseGraph = new ArrayList<>();
			count = new int[N + 1];
			
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
				reverseGraph.add(new ArrayList<>());
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				// a인 학생이 b인 학생보다 키가 작다.
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph.get(a).add(b);
				reverseGraph.get(b).add(a);
			}
			

			// parent, child dfs 실행
			// dfs 정방향 일때 parent
			// dfs 역방향 일때 child
			for(int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				dfsParent(i);

				visited = new boolean[N + 1];
				dfsChild(i);
			}
			

			// 자신의 키가 몇 번째인지 알 수 있는 학생이 모두 몇명인지 출력
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (count[i] == N - 1) { // 자신 제외 N-1
					cnt++;
				}
			}

//			sb.append("#").append(t).append(" ").append(count).append("\n");
			sb.append(cnt).append("\n");
			System.out.println(sb);
			br.close();
//		}

	}
	
	private static void dfsParent(int cur) {
		visited[cur] = true;
		for(int next : graph.get(cur)) {
			if(!visited[next]) {
				count[next]++;
				dfsParent(next);
			}
		}
	}
	
	private static void dfsChild(int cur) {
		visited[cur] = true;
		for(int next : reverseGraph.get(cur)) {
			if(!visited[next]) {
				count[next]++;
				dfsChild(next);
				
			}
		}
	}


}
