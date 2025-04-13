/*
 * BOJ 1504번 : 특정한 최단경로
 * 메모리 : 71,576kb
 * 시간 : 624ms
 * 
 * 1번 노드에서 N번 노드로 이동
 * u, v 반드시 거쳐야함
 */

import java.io.*;
import java.util.*;

public class BOJ1504_특정한최단경로 {
    static int N, E;
    static List<Node>[] edges;
    static class Node {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int u, v; // 반드시 거쳐야하는 정점
    static int minDis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        for(int n = 0; n <= N; n++) {
            edges[n] = new ArrayList();
        }
        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from].add(new Node(to, cost));
            edges[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        minDis = Integer.MAX_VALUE;

        // 순서가 달라졌을 때 최단거리가 달라질 수 있다!
        int[] from1 = dijkstra(1); // 1에서
        int[] fromU = dijkstra(u); // u에서
        int[] fromV = dijkstra(v); // v에서

        int path1 = from1[u] + fromU[v] + fromV[N]; // 1-u-v-N
        int path2 = from1[v] + fromV[u] + fromU[N]; // 1-v-u-N

        // 1->N 경로가 없을 때 유효성 검사
        if(from1[u]==Integer.MAX_VALUE || fromU[v]==Integer.MAX_VALUE || fromV[N]==Integer.MAX_VALUE) { path1 = Integer.MAX_VALUE; }
        if(from1[v]==Integer.MAX_VALUE || fromV[u]==Integer.MAX_VALUE || fromU[N]==Integer.MAX_VALUE) { path2 = Integer.MAX_VALUE; }

        minDis = Math.min(path1, path2);
        sb.append(minDis==Integer.MAX_VALUE ? "-1" : minDis);
        System.out.println(sb);
        br.close();
    }

    public static int[] dijkstra(int start) {
        // 1. 다익스트라 일고리즘 초기화 -> 거리배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 2. 최소 비용 저장 -> 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
        pq.offer(new Node(start, 0)); // start, cost
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.to] < curr.cost) {
                continue;
            }

            // 3. 선택한 노드의 주변 노드 고려
            for(int i = 0; i < edges[curr.to].size(); i++) {
                Node next = edges[curr.to].get(i);
                if(dist[next.to] > curr.cost + next.cost) {
                    dist[next.to] = curr.cost + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
        return dist;
    }
}
