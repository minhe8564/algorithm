import java.io.*;
import java.util.*;

public class BOJ14567_선수과목 {
	static int N, M;
	static int[] indegree;
	static List<List<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		graph = new ArrayList<List<Integer>>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		int[] result = new int[N+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				result[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int i = 0; i < graph.get(curr).size(); i++) {
				int next = graph.get(curr).get(i);
				indegree[next]--;
				result[next] = Math.max(result[next], result[curr]+1);
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.print(sb);
		br.close();
	}

}
