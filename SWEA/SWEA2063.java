package algorithm;

import java.util.Scanner;
import java.util.Arrays;

public class SWEA2063{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int result = nums[N/2];
		System.out.println(result);
		sc.close();
	}
}
