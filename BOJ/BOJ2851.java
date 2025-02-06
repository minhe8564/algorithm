package algorithm;

import java.io.*;

public class BOJ2851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] score = new int[10];
		for(int i = 0; i < score.length; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		int diff = 100;
		int answer = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
			
			if(Math.abs(100-sum) <= diff) {
				diff = Math.abs(100-sum);
				answer = sum;
			}
		}
		System.out.println(answer);
	}

}
