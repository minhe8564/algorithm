/*
 * BOJ 5972번 : 택배 배송
 * 메모리 : 44,188kb
 * 시간 : 464ms
 */

import java.io.*;
import java.util.*;

public class BOJ5972_택배배송 {
    static int N, M;
    static class Node {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Node>[] edges;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        for(int n = 1; n <= N; n++) {
            edges[n] = new ArrayList();
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from].add(new Node(to, cost));
            edges[to].add(new Node(from, cost));
        }

        int[] dist = new int[N+1];
        for(int n = 1; n <= N; n++) {
            dist[n] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.to] < curr.cost) continue;

            for(Node next : edges[curr.to]) {
                if(dist[next.to] > curr.cost+next.cost) {
                    dist[next.to] = curr.cost+next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        result = dist[N];
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}
