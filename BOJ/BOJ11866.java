package algorithm;

import java.io.*;
import java.util.*;

public class BOJ11866 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<Integer>();
        for(int n = 1; n <= N; n++) {
        	q.offer(n);
        }
        
        sb.append("<");
        while(!q.isEmpty()) {
        	for(int k = 0; k < K-1; k++) {
        		q.offer(q.poll());
        	}
        	if(q.size() == 1) {
        		sb.append(q.poll());
        	} else {
        		sb.append(q.poll()).append(", ");
        	}
        }
        sb.append(">");
        
        System.out.println(sb);
        br.close();
	}

}
