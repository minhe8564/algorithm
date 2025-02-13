import java.io.*;
import java.util.*;

public class BOJ17471_게리맨더링 {
	static int N;
	static int[] person;
	static int[][] map;
	static boolean[] selected;
	static int minPerson = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		person = new int[N];
		for (int n = 0; n < N; n++) {
			person[n] = Integer.parseInt(st.nextToken());
		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int adj = Integer.parseInt(st.nextToken());
			for (int i = 0; i < adj; i++) {
				int connect = Integer.parseInt(st.nextToken()) - 1;
				map[n][connect] = map[connect][n] = 1;
			}

		}

		// 1. N개의 지역 중에 1~N개 선택한거 조합
		// 서로 연결되어 있는 경우, 조합 가능하다.
		city(0, 0);

		// 2. 선거구별 인구 차이 구해야 한다.
		// 선거구 A, B 나누기 bfs로 확인

		// 3. 최소 인구 차이 출력
		if (minPerson == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(minPerson);
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void city(int cityNum, int cityCount) {
		if(cityCount >= 1 && cityCount < N) {
			List<Integer> cityA = new ArrayList<>();
			List<Integer> cityB = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					cityA.add(i);
				}
				else {
					cityB.add(i);
				}
			}
			
			if(bfs(cityA) && bfs(cityB)) {
				minCount(cityA, cityB);
			}
		}
		
		for(int i = cityNum; i < N; i++) {
			selected[i] = true;
			city(i + 1, cityCount + 1);
			selected[i] = false;
		}
	}
	
	private static boolean bfs(List<Integer> city) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		q.offer(city.get(0));
		visited[city.get(0)] = true;
		int count = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : city) {
				if(map[curr][next] == 1 && !visited[next]) {
					visited[next] = true;
					q.offer(next);
					count++;
				}
			}
		}
		
		return count == city.size();
	}
	
	private static void minCount(List<Integer> cityA, List<Integer> cityB) {
		int sumA = 0;
		int sumB = 0;
		
		for(int node : cityA) {
			sumA += person[node];
		}
		for(int node : cityB) {
			sumB += person[node];
		}
		
		minPerson = Math.min(minPerson, Math.abs(sumA - sumB));
	}

	
}
