/*
 * BOJ 13269번 : 쌓기나무 
 * 메모리 : 40,476kb
 * 시간 : 296ms
 * 
 * 쌓기나무가 존재하는지 확인
 * 1. front 열 기준 
 * 1-1. shape[n][m] == front[m]인 위치가 한곳이라도 있어야 한다.
 * 2. right 행 기준 
 * 2-1. 마찬가지로, shape[n][m] == right[n]인 위치가 한곳이라도 있어야 한다. 
 */

import java.io.*;
import java.util.*;

public class BOJ13269_쌓기나무 {
	static int N, M;
	static int[][] shape;
	static boolean isExist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shape = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				shape[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] front = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			front[m] = Integer.parseInt(st.nextToken());
		}
		
		int[] right = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			right[n] = Integer.parseInt(st.nextToken());
		}
		int[] rightReverse = new int[N];
		for(int n = 0; n < N; n++) {
			rightReverse[n] = right[N-1-n];
		}
		
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(shape[n][m] != 0) {
					shape[n][m] = front[m];
				}
			}
		}
		
		for (int n = 0; n < N; n++) {
		    for (int m = 0; m < M; m++) {
		        if (shape[n][m] != 0 && shape[n][m] > rightReverse[n]) {
		            shape[n][m] = rightReverse[n];
		        }
		    }
		}
		
		// 쌓기 나무가 존재하지 않는 경우 판별 
		isExist = true;
		for (int m = 0; m < M; m++) {
		    if (front[m] > 0) {
		        boolean found = false;
		        for (int n = 0; n < N; n++) {
		            if (shape[n][m] == front[m]) {
		                found = true;
		                break;
		            }
		        }
		        if (!found) {
		            isExist = false;
		        }
		    }
		}
		for (int n = 0; n < N; n++) {
		    if (rightReverse[n] > 0) {
		        boolean found = false;
		        for (int m = 0; m < M; m++) {
		            if (shape[n][m] == rightReverse[n]) {
		                found = true;
		                break;
		            }
		        }
		        if (!found) {
		            isExist = false;
		        }
		    }
		}

		if(!isExist) {
			sb.append(-1);
		} else {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				sb.append(shape[n][m]).append(" ");
			}
			sb.append("\n");
		}
		}
		
		System.out.print(sb);
		br.close();
	}
}
