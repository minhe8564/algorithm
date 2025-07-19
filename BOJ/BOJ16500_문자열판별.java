/*
 * BOJ 16500번 : 문자열 판별
 * 메모리 : 11,720kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ16500_문자열판별 {
    static String S;
    static int N;
    static String[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        S = br.readLine();
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for(int n = 0; n < N; n++) {
            A[n] = br.readLine();
        }

        boolean[] dp = new boolean[S.length()+1];
        dp[0] = true;

        for(int s = 0; s < S.length(); s++) {
            if(!dp[s]) continue;

            for(int n = 0; n < N; n++) {
                if(s+A[n].length() <= S.length()) {
                    if(S.substring(s, s+A[n].length()).equals(A[n])) {
                        dp[s+A[n].length()] = true;
                    }
                }
            }
        }


        if(dp[S.length()]) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        System.out.println(sb);
        br.readLine();
    }
}
