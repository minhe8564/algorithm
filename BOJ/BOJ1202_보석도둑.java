/*
 * BOJ 1202번 : 보석 도둑
 * 메모리 : 131,724kb
 * 시간 : 1,532ms
 * 
 * 가방을 하나씩 보고
 * 그 가방에 들어갈 수 있는 보석 중 가장 비싼 것 고르기
 */

import java.io.*;
import java.util.*;

public class BOJ1202_보석도둑 {
    static int N, K;
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;
        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }
    static Jewel[] jewels;
    static int[] bags;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w, p);
        }
        Arrays.sort(jewels);

        bags = new int[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        result = 0;
        int n = 0;

        for(int i = 0; i < K; i++) {
            while(n < N && jewels[n].weight <= bags[i]) {
                pq.offer(jewels[n].price);
                n++;
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}
