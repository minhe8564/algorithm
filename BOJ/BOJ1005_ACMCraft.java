/*
 * BOJ 1005번 : ACM Craft
 * 메모리 : 242,800kb
 * 시간 : 720ms
 */

import java.io.*;
import java.util.*;

public class BOJ1005_ACMCraft {
    static int T, N, K, W;
    static int[] time;
    static List<Integer>[] graph;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            time = new int[N + 1];
            for (int n = 1; n <= N; n++) {
                time[n] = Integer.parseInt(st.nextToken());
            }
            graph = new ArrayList[N + 1];
            for (int n = 1; n <= N; n++) {
                graph[n] = new ArrayList<>();
            }
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[to].add(from); // to 건물을 짓기 위해 from 선행 필요
            }
            W = Integer.parseInt(br.readLine());
            memo = new int[N + 1];
            Arrays.fill(memo, -1);

            sb.append(dfs(W)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int dfs(int curr) { // to -> from
        if(memo[curr] != -1) {
            return memo[curr];
        }

        int maxTime = 0;
        for(int time : graph[curr]) {
            maxTime = Math.max(maxTime, dfs(time));
        }

        memo[curr] = maxTime+time[curr];
        return memo[curr];
    }
}
