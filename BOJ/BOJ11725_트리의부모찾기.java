/*
 * BOJ 11725번 : 트리의 부모 찾기
 * 메모리 : 65,600kb 
 * 시간 : 488ms
 */

import java.io.*;
import java.util.*;

public class BOJ11725_트리의부모찾기 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        for(int n = 1; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N+1];
        parent = new int[N+1];

        bfs(1);

        for(int n = 2; n <= N; n++) {
            // 각 노드의 부모 노드 번호
            sb.append(parent[n]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph[curr]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    parent[next] = curr;
                }
            }
        }
    }
}
