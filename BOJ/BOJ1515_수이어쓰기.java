/*
 * BOJ 1515번 : 수 이어 쓰기
 * 메모리 : 13,580kb
 * 시간 : 88ms
 */

import java.io.*;

public class BOJ1515_수이어쓰기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int idx = 0;
        int num = 0;

        while(idx < str.length()) {
            num++;
            String curr = Integer.toString(num);

            for(int i = 0; i < curr.length(); i++) {
                if(curr.charAt(i) == str.charAt(idx)) {
                    idx++;
                    if(idx == str.length()) break;
                }
            }
        }

        System.out.println(num);
        br.close();
    }
}
