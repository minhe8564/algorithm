/* 
 * BOJ 1932번 : 정수 삼각형
 * 메모리 : 25,092ms
 * 시간 : 208ms
 */

import java.io.*;
import java.util.*;

public class BOJ1932_정수삼각형 {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int m = 0; m < n+1; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        dp = new int[N][N];

        // 가장 아래에서 위로 올라오자!!!
        for(int m = 0; m < N; m++) {
            dp[N-1][m] = arr[N-1][m];
        }

        for(int n = N-2; n >= 0; n--) {
            for(int m =  0; m < n+1; m++) {
                dp[n][m] = arr[n][m] + Math.max(dp[n+1][m], dp[n+1][m+1]);
            }
        }


        sb.append(dp[0][0]);
        System.out.println(sb);
        br.close();
    }
}
