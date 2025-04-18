/*
 * BOJ 7570번 : 줄 세우기
 * 메모리 : 119,688kb
 * 시간 : 388ms
 * 
 * - 최소한으로 이동시켜야 한다. → 1씩 증가하는 어린이들은 옮기지 않아도 된다.
 * - 최장 증가 수열은 놔두고 나머지 어린이들을 옮겨야 한다.
 * 
 * - dp[num] = dp[num-1] + 1
 *   - 현재 번호 num 앞에 num-1이 있었다면
 *   - 그 num은 그 수열 뒤에 붙을 수 있기 때문에 +1 해준다.
 *   
 * - N-count
 *   - 전체 N명 중에서 정렬되어 있는 수열의 길이 count만큼은 이동 하지 않아도 된다.
 */

import java.io.*;
import java.util.*;

public class BOJ7570_줄세우기 {
	static int N;
	static int[] dp;
	static int count;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1]; // 1~N
        count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num-1] + 1;
            count = Math.max(count, dp[num]);
        }

        sb.append(N-count);
        System.out.print(sb);
        br.close();
    }
}
