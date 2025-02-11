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
            
            // 순열 채우기
            for (int i = 0; i < N; i++) {
            	// 1~N까지 중에서 아직 사용되지 않은 숫자 선택
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue; // 이미 사용된 숫자 건너뜀
                    
                    // 현재 위치에서 (N-i-K)!만큼의 경우의 수 확인
                    if (fac[N - i - 1] < k) {
                        k -= fac[N - i - 1]; // k번째가 뒤족에 있으므로 점프
                    } else {
                        per[i] = j; // 현재 위치에 숫자 j 선택
                        visited[j] = true; // 숫자 j 사용완료
                        break; // 다음 자리 숫자 선택
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
                    if (visited[j]) continue; // 이미 사용된 숫자 건너뜀
                    answer += fac[N - i - 1]; // 해당 숫자가 앞에 올 수 있는 경우의 수 더하기
                }
                visited[per[i]] = true; // 현재 숫자 사용완료
            }
            
            System.out.println(answer);
        }
        br.close();
    }
}
