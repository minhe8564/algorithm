/*
 * BOJ 1806번 : 부분 합
 * 메모리 : 22,328kb
 * 시간 : 196ms
 */

import java.io.*;
import java.util.*;

public class BOJ1806_부분합 {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0;
        for(int right = 0; right < N; right++) {
            sum += arr[right];

            while(sum >= S) {
                minLen = Math.min(minLen, right-left+1);
                sum -= arr[left++];
            }
        }

        sb.append(minLen==Integer.MAX_VALUE ? 0 : minLen);
        System.out.println(sb);
        br.close();
    }
}
