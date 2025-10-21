/*
 * BOJ 1927번 : 최소 힙
 * 메모리 : 25,412kb
 * 시간 : 240ms
 */

import java.io.*;
import java.util.*;

public class BOJ1927_최소힙 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.peek() == null) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            } else {
                pq.add(x);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
