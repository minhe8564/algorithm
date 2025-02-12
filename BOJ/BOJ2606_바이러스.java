package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2606_바이러스 {
	static int N;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        graph = new int[N][N];
        visited = new boolean[N];
        int pair = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
        for(int i = 0; i < pair; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken())-1;
        	int b = Integer.parseInt(st.nextToken())-1;
        	
        	graph[a][b] = graph[b][a] = 1;
        }
        
        // 1번 컴퓨터 웜 바이러스
        // 1번을 통해 윔 바이러스에 걸리게 되는 컴퓨터 수?
        System.out.println(bfs(graph));

	}
	
	private static int bfs(int[][] graph) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(0);
		visited[0] = true;
		int virus = 0;
		
		while(!q.isEmpty()) {
			int ca = q.poll();
		
			for(int i = 0; i < N; i++) {
				if(graph[ca][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					virus++;
				}
			}
		}
		
		return virus;
	}

}
