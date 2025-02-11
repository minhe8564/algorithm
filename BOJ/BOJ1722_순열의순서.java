package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1722_순열의순서 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] fac = new long[N + 1]; // 팩토리얼 저장 배열
        int[] per = new int[N]; // 순열 저장 배열
        boolean[] visited = new boolean[N + 1]; // 숫자 사용 여부
        
        fac[0] = 1;
        for (int i = 1; i <= N; i++) {
            fac[i] = fac[i - 1] * i;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int command = Integer.parseInt(st.nextToken()); // 첫 번째 입력 값 (1 또는 2)
        
        if (command == 1) {
            long k = Long.parseLong(st.nextToken()); // k번째 순열 찾기
            
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    
                    if (fac[N - i - 1] < k) {
                        k -= fac[N - i - 1];
                    } else {
                        per[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                System.out.print(per[i] + " ");
            }
            System.out.println();
        } 
        else if (command == 2) {
            for (int i = 0; i < N; i++) {
                per[i] = Integer.parseInt(st.nextToken());
            }
            
            long answer = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < per[i]; j++) {
                    if (visited[j]) continue;
                    answer += fac[N - i - 1];
                }
                visited[per[i]] = true;
            }
            
            System.out.println(answer);
        }
        br.close();
    }
}
