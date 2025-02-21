import java.io.*;
import java.util.*;

/*
 * 메모리 : 22476kb
 * 시간 : 184ms
 */

public class BOJ12891_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] cnt = new int[4];
        int result = 0;

        for (int i = 0; i < P; i++) {
            if (dna[i] == 'A') cnt[0]++;
            if (dna[i] == 'C') cnt[1]++;
            if (dna[i] == 'G') cnt[2]++;
            if (dna[i] == 'T') cnt[3]++;
        }
        if(cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
        	result++;
        }
        
        for(int i = P; i < S; i++) {
        	// 맨 왼쪽 문자 제거
        	if(dna[i-P] == 'A') cnt[0]--;
        	if(dna[i-P] == 'C') cnt[1]--;
        	if(dna[i-P] == 'G') cnt[2]--;
        	if(dna[i-P] == 'T') cnt[3]--;
        	
        	if (dna[i] == 'A') cnt[0]++;
        	if (dna[i] == 'C') cnt[1]++;
        	if (dna[i] == 'G') cnt[2]++;
        	if (dna[i] == 'T') cnt[3]++;
        	
        	if(cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
        		result++;
        	}
        }

        System.out.println(result);
        br.close();
    }
}
