package algorithm;

import java.io.*;

public class BOJ2966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String answer = br.readLine();  // 문자열 그대로 사용

        String[] person1 = { "A", "B", "C" };
        String[] person2 = { "B", "A", "B", "C" };
        String[] person3 = { "C", "C", "A", "A", "B", "B" };

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        for (int n = 0; n < N; n++) {
            if (answer.charAt(n) == person1[n % 3].charAt(0)) {
                result1++;
            }
            if (answer.charAt(n) == person2[n % 4].charAt(0)) {
                result2++;
            }
            if (answer.charAt(n) == person3[n % 6].charAt(0)) {
                result3++;
            }
        }

        int max = Math.max(result1, Math.max(result2, result3));
        sb.append(max).append("\n");

        if (result1 == max) sb.append("Adrian").append("\n");
        if (result2 == max) sb.append("Bruno").append("\n");
        if (result3 == max) sb.append("Goran").append("\n");

        System.out.println(sb);
        br.close();
    }
}
