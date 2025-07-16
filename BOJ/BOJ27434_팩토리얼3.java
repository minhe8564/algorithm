/*
 * BOJ 27434번 : 팩토리얼 3
 * 메모리 : 366,428kb
 * 시간 : 3,304ms
 */

import java.io.*;
import java.math.*;

public class BOJ27434_팩토리얼3 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        sb.append(factorial(1, N));
        System.out.println(sb);
        br.close();
    }

    public static BigInteger factorial(int n, int N) {
        BigInteger num = BigInteger.valueOf(n);

        // n이 N보다 작으면
        if(n < N) {
            int mid = (n+N)/2;
            // 재귀함수 사용 -> n부터 mid까지 계산 -> mid+1부터 N까지 계산
            // n부터 N까지 재귀로 계산
            num = factorial(n, mid).multiply(factorial(mid+1, N));
        }

        return num;
    }
}
