/*
 * BOJ 1563번 : 개근상
 * 메모리 : 11,640kb
 * 시간 : 68ms
 *
 * dp[day][late][sequence]
 * day : 오늘까지 며칠 채웠는지 (0~N)
 * late : 지각 사용 횟수 (0 or 1)
 * sequence : 연속 결석 수 (0, 1, 2) -> 3번 연속 결석하면 안됨!!!
 * 값 : 가능한 출석 기록의 경우의 수
 */

import java.io.*;
import java.util.*;

public class BOJ1563_개근상 {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N+1][2][3];
        dp[0][0][0] = 1;

        for(int day = 0; day < N; day++) {
            for(int late = 0; late <= 1; late++) {
                for(int sequence = 0; sequence <= 2; sequence++) {
                    int curr = dp[day][late][sequence];

                    // 오늘 출석
                    dp[day+1][late][0] = (dp[day+1][late][0] + curr) % MOD;

                    // 오늘 결석
                    if(sequence+1 < 3) { // 3번 연속 결석하면 안됨!!!
                        dp[day+1][late][sequence+1] = (dp[day+1][late][sequence+1] + curr) % MOD;
                    }

                    // 오늘 지각
                    if(late==0) { // 지각 없을 때만 가능
                        dp[day+1][1][0] = (dp[day+1][1][0] + curr) % MOD;
                    }
                }
            }
        }

        int answer = 0;
        for(int late = 0; late <= 1; late++) {
            for(int sequence = 0; sequence <= 2; sequence++) {
                answer = (answer + dp[N][late][sequence]) % MOD;
            }
        }
        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}
