package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1242 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken()); // 총 학생 수
        int K = Integer.parseInt(st.nextToken()); // K번째 학생이 탈락
        int M = Integer.parseInt(st.nextToken()); // M번 학생 번호 몇번째로 탈락?
       
        int remove = 0; // 현재 탈락할 위치
        int student = N; // 남은 학생 수
        int count = 0; // 탈락 순서
        
        while(true) {
        	// 현재 라운드에서 탈락할 학생 위치?
        	remove = (remove + K - 1) % student;
        	count++;
        	
        	// M번 학생이 탈락하는지?
        	if(remove + 1 == M) {
        		System.out.println(count);
        		break;
        	}
        	
        	// 탈락 이후, 재배치
        	student--;
        	if(M > remove + 1) {
        		M--;
        	}
        }

        
        br.close();
    }
}
