/*
 * BOJ 17219번 : 비밀번호 찾기
 * 메모리 : 64,008kb
 * 시간 : 448ms
 */

import java.io.*;
import java.util.*;

public class BOJ17219_비밀번호찾기 {
    static int N, M;
    static HashMap<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            String url = st.nextToken();
            String password = st.nextToken();
            map.put(url, password);
        }

        for(int m = 0; m < M; m++) {
            String find = br.readLine();
            sb.append(map.get(find)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
