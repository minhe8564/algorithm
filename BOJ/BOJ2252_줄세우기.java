import java.io.*;
import java.util.*;

public class BOJ2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N명의 학생
		int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

		int[] indegree = new int[N + 1]; // 진입 차수
		List<List<Integer>> graph = new ArrayList<>(); // 그래프 구성
		
		// 그래프 초기화
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 그래프 구성, 진입차수 계산
			graph.get(A).add(B);
			indegree[B]++;
		}

		Queue<Integer> q = new ArrayDeque<Integer>();

		// 1. 진입 차수가 0인 노드를 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		// 2. 위상정렬 수행
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");

			// 현재 노드와 연결된 노드들의 진입 차수를 감소시키고, 
			// 0이 되면 큐에 삽입
			for(int i = 0; i < graph.get(curr).size(); i++) {
				int next = graph.get(curr).get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(sb);
		br.close();
	}

}
