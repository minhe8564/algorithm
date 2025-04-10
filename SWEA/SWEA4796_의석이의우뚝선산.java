/*
 * SWEA 4796번 : 의석이의 우뚝 선 산
 * 메모리 : 107,284kb
 * 시간 : 643ms
 */

import java.io.*;
import java.util.*;
 
public class SWEA4796_의석이의우뚝선산 {
    static int N;
    static int[] tree;
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
         
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            tree = new int[N];
            for (int n = 0; n < N; n++) {
                tree[n] = sc.nextInt();
            }
 
            int answer = 0;
            int leftCnt = 0;
            int rightCnt = 0;
             
            for(int i = 1; i < N; i++) {
                if(tree[i-1] < tree[i]) { // 오름차순
                    if(leftCnt > 0) {
                        answer += leftCnt*rightCnt;
                        leftCnt = 0;
                        rightCnt = 0;
                    }
                    rightCnt++;
                } else {
                    leftCnt++;
                }
            }
            answer += leftCnt*rightCnt;
             
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
