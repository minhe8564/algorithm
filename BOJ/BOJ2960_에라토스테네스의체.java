import java.io.*;
import java.util.*;

public class BOJ2960_에라토스테네스의체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) { // i의 배수를 지워나가기
                if (isPrime[j]) {
                    isPrime[j] = false;
                    cnt++;
                    if (cnt == K) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
