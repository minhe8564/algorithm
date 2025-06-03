/*
 * 메모리 : 11,600kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1205_등수구하기 {
    static int N, newScore, P;
    static List<Integer> scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        scores = new ArrayList<>();
        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
        }

        int rank = 1;
        for(int i = 0; i < scores.size(); i++) {
            if (newScore > scores.get(i)) {
                break;
            } else if (newScore < scores.get(i)) {
                rank++;
            }
        }

        if(N == P && newScore <= scores.get(N-1)) {
            sb.append(-1);
        } else {
            sb.append(rank);
        }

        System.out.println(sb);
        br.close();
    }
}
