package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] dna = new String[N];
		for(int i = 0; i < N; i++) {
			dna[i] = br.readLine();
		}
		
		int hd = 0; // Hamming Distance
		
		for(int i = 0; i < M; i++) { // 8
			int[] count = new int[4]; // A C G T (사전순)
			for(int j = 0; j < N; j++) {  // 5
				char ch = dna[j].charAt(i);
				switch(ch) {
				case 'A' : count[0]++; break;
				case 'C' : count[1]++; break;
				case 'G' : count[2]++; break;
				case 'T' : count[3]++; break;
				}
			}
			
			int index = 0; 
			int max = 0; 
			for(int k = 0; k < 4; k++) {
				if(count[k] > max || (count[k] == max && k < index)) {
					max = count[k];
					index = k;
				}
			}
			
			switch(index) {
			case 0: sb.append('A'); break;
			case 1: sb.append('C'); break;
			case 2: sb.append('G'); break;
			case 3: sb.append('T'); break;
			}
			
			hd += N - max; // Hamming Distance
		}
		
		System.out.println(sb);
		System.out.println(hd);
		
	}

}
