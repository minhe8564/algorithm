package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 라운드 수
		for(int n = 0; n < N; n++) {
			int a, b;
			int[] A = new int[5];
			int[] B = new int[5];
			int count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int aNum = Integer.parseInt(st.nextToken()); // 그림 수
			for(int i = 1; i <= aNum; i++) {
				a = Integer.parseInt(st.nextToken());
				A[a]++; // 그림 별4 동그라미3 네모2 세모1				
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int bNum = Integer.parseInt(st.nextToken()); // 그림 수
			for(int i = 1; i <= bNum; i++) {
				b = Integer.parseInt(st.nextToken());
				B[b]++; // 그림 별4 동그라미3 네모2 세모1						
			}
			
			for(int i = 4; i > 0; i--) {
				if(A[i] > B[i]) {
					System.out.println("A");
					break;
				} 
				else if(A[i] < B[i]) {
					System.out.println("B");
					break;
				}
				else count++;
			}
			if(count == 4) {
				System.out.println("D");
			}
			
		}
		
	}

}
