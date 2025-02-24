package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1874_스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();
        int idx = 0;
        int num = 1;

        while (idx < N) {
            if (!s.isEmpty() && s.peek() == arr[idx]) {
                s.pop();
                sb.append("-\n");
                idx++;
            } else if (num <= N) {
                s.push(num);
                sb.append("+\n");
                num++;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
