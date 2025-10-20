/* 
 * BOJ 14217번 : 그래프 탐색
 * 메모리 : 41,328kb
 * 시간 : 868ms
 */

import java.io.*;
import java.util.*;

public class BOJ14217_그래프탐색 {
    static int N, M, Q;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            graph[city1].add(city2);
            graph[city2].add(city1);
        }

        Q = Integer.parseInt(br.readLine());
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(a==1) {
                graph[i].add(j);
                graph[j].add(i);
            } else {
                graph[i].remove(Integer.valueOf(j));
                graph[j].remove(Integer.valueOf(i));
            }

            int[] dist = bfs(1);
            for(int n = 1; n <= N; n++) {
                sb.append(dist[n]).append(n==N ? "\n" : " ");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static int[] bfs(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        visited = new boolean[N+1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph[curr]) {
                if(!visited[next]) {
                    queue.add(next);
                    dist[next] = dist[curr]+1;
                    visited[next] = true;
                }
            }
        }
        return dist;
    }
}
