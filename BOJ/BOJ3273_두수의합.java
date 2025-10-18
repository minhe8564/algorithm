/* 
 * BOJ 3273번 : 두수의 합
 * 메모리 : 27,784kb
 * 시간 : 272ms
 */

import java.io.*;
import java.util.*;

public class BOJ3273_두수의합 {
    static int N, X;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        cnt = 0;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == X) {
                cnt++;
                left++;
                right--;
            } else if(sum < X) {
                left++;
            } else {
                right--;
            }
        }


        sb.append(cnt);
        System.out.println(sb);
        br.close();
    }
}
