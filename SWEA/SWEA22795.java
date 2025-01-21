package algorithm;

import java.util.Scanner;

public class SWEA22795 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int t = 0; t < testCase; t++) {
			int[] height = new int[7];
			int max = 0;
			
			for(int i = 0; i < 6; i++) {
				height[i] = sc.nextInt();
				if(height[i] > max) {
					max = height[i];
				}
			}
			
			height[6] = max + 1;
			
			while (mean(height) % 7 != 0) {
				height[6]++;
			}
			
			System.out.println(height[6]);
		}
	
		sc.close();
		
	}
	
	public static double mean(int[] arr) {
		double sum = 0;
		for(int i = 0; i < 7; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
