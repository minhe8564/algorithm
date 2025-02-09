package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<Integer>();
        for(int n = 1; n <= N; n++) {
        	q.offer(n);
        }
        
        // 제일 위 카드 바닥에 버린다.
        // 다음 제일 위 카드를 제일 아래에 있는 가드 밑으로 옮긴다.
        while(!q.isEmpty()) {
        	
        	if(q.size() == 1) break;
        	
        	q.poll();
        	q.offer(q.peek());
        	q.poll();
        }
        
        System.out.println(q.peek());
        br.close();
	}

}
