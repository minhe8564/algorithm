/*
 * BOJ 11723번 : 집합
 * 메모리 : 324,700kb
 * 시간 : 948ms
 */

import java.io.*;
import java.util.*;

public class BOJ11723_집합 {
    static int M;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        nums = new ArrayList<>();
        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("add")) {
                nums.add(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                nums.remove((Integer)x);
            } else if(cmd.equals("check")) {
                if(nums.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(nums.contains(x)) {
                    nums.remove((Integer)x);
                } else {
                    nums.add(x);
                }
            } else if(cmd.equals("all")) {
                nums.clear();
                for(int j = 1; j <= 20; j++) {
                    nums.add(j);
                }
            } else if(cmd.equals("empty")) {
                nums.clear();
            }
        }

        System.out.println(sb);
        br.close();
    }
}
