/*
 * BOJ 2493번 : 탑
 * 메모리 : 114,692kb
 * 시간 : 516ms
 * 
 * 나를 기준으로 왼쪽으로 봤을 때,
 * 나 다음으로 큰 배열 카운트
 */

import java.io.*;
import java.util.*;

public class BOJ2493_탑 {
    static int N;
    static int[] top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        top = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            top[n] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Deque<int[]> deque = new ArrayDeque<>(); // stack

        for(int n = 0; n < N; n++) {
            int height = top[n];

            while(!deque.isEmpty() && deque.peek()[0] < height) {
                deque.pop();
            }

            if(!deque.isEmpty()) {
                answer[n] = deque.peek()[1];
            } else {
                answer[n] = 0;
            }

            deque.push(new int[] { height, n+1 });
        }

        for(int n = 0; n < N; n++) {
            if(n > 0) sb.append(' ');
            sb.append(answer[n]);
        }

        System.out.println(sb);
        br.close();
    }
}
