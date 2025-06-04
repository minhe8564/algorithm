/*
 * BOJ 1167번 : 트리의 지름
 * 메모리 : 101,116kb
 * 시간 : 760ms
 */

import java.io.*;
import java.util.*;

public class BOJ1167_트리의지름 {
    static int V;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int firstMaxDist = 0;
    static class Node {
        int num;
        int dist;
        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(br.readLine());
        tree = new List[V+1];
        for(int v = 1; v <= V; v++) {
            tree[v] = new ArrayList<>();
        }

        for(int v = 1; v <= V; v++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, dist));
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        dfs(firstMaxDist, 0);

        sb.append(maxDist);
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int curr, int dist) {
        visited[curr] = true;

        if(dist > maxDist) {
            maxDist = dist;
            curr = firstMaxDist;
        }
        
        for(Node next : tree[curr]) {
            if(!visited[next.num]) {
                dfs(next.num, dist+next.dist);
            }
        }
    }
}
