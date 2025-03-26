/*
 * SWEA 1238번 : Contact
 * 메모리 : 25,472kb
 * 시간 : 87ms
 */

import java.io.*;
import java.util.*;

public class SWEA1238_Contact {
	static int L, S;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
        	sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            graph = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<>();
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            visited = new boolean[101];
            rank = new int[101];
            bfs(S);

            int maxRank = Integer.MIN_VALUE;
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i <= 100; i++) {
                if (rank[i] > maxRank) {
                    maxRank = rank[i];
                    answer = i;
                } else if (rank[i] == maxRank) { // 가장 마지막 도달 노드에서 번호가 큰 사람
                    answer = Math.max(answer, i);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = true;
        rank[s] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    rank[next] = rank[curr]+1;
                    q.offer(next);
                }
            }
        }
    }
}
