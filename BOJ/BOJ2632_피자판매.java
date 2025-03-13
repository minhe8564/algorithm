/*
 * BOJ 2632번 : 피자판매 
 * 메모리 : 17,528kb
 * 시간 : 116ms
 * 
 * 모든 부분합 구해서 S 되는 경우 찾기 -> 시간초과!!!
 * 1. 각 피자에 대해 가능한 부분합 계산 
 * 1-1. 하나의 피자에서 여러 조각을 이어서 선택하기 때문에 (i+j)%size 원형으로 순환하기 
 * 2. 두 피자에 대해 부분합 조합해서 S가 되는 경우 찾기 
 * 2-1. 목표 합이 S가 되는 경우는 피자A에서 나오는 부분합 s와 피자B에서 나오는 부분합 S-s 경우의 수 구하기 
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2632_피자판매 {
	static int S;
	static int M, N;
	static int[] pizzaA;
	static int[] pizzaB;
	static int[] sumA;
	static int[] sumB;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		pizzaA = new int[M];
		pizzaB = new int[N];
		for(int m = 0; m < M; m++) {
			pizzaA[m] = Integer.parseInt(br.readLine());
		}
		for(int n = 0; n < N; n++) {
			pizzaB[n] = Integer.parseInt(br.readLine());
		}
		
		sumA = new int[S+1];
		sumB = new int[S+1];
		
		// 1. 아무조각도 선택하지 않은 경우의 수 반영 
		sumA[0] = 1;
		sumB[0] = 1;
				
		// 2. 전체 피자의 합 계산 
		// 전체 피자가 S를 넘지 않으면 해당 합 경우의 수 반영 
		int totalA = 0;
		for(int m = 0; m < M; m++) {
			totalA += pizzaA[m];
		}
		int totalB = 0;
		for(int n = 0; n < N; n++) {
			totalB += pizzaB[n];
		}
		if(totalA <= S) sumA[totalA] = 1;
		if(totalB <= S) sumB[totalB] = 1;
		
		// 부분합 계산 
		subSum(pizzaA, sumA, M);
		subSum(pizzaB, sumB, N);
		
		answer = 0;
		for(int s = 0; s <= S; s++) {
			answer += sumA[s] * sumB[S-s];
		}
		sb.append(answer);
		System.out.print(sb);
		br.close();
	}
	
	private static void subSum(int[] pizza, int[] sum, int size) {
		for(int i = 0; i < size; i++) {
			int s = 0;
			for(int j = 0; j < size; j++) {
				s += pizza[(i+j) % size]; // 원형 배열 순환 
				if(s > S) break; // 부분합이 목표값을 넘으면 탐색 종료 
				sum[s]++; // 해당 부분합이 가능한 경우의 수 증가 
			}
		}
	}
}
