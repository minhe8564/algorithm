/*
 * BOJ 11659번 : 구간 합 구하기 4
 * 메모리 : 60,880kb
 * 시간 : 580ms
 */

import java.io.*;
import java.util.*;

public class BOJ11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        for(int n = 1; n <= N; n++) {
            prefix[n] = prefix[n-1] + arr[n];
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int sum = 0;

            sum = prefix[j]-prefix[i-1];

            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
