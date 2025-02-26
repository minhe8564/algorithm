package algorithm;
import java.io.*;

/*
 * 메모리 : 25,968kb
 * 시간 : 332ms 
 */

import java.util.*;

public class BOJ18248_제야의종 {
	static int N, M;
	static int[][] people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N][M+1];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int m = 0; m < M; m++) {
				people[n][m] = Integer.parseInt(st.nextToken());
				sum += people[n][m];
			}
			people[n][M] = sum; // 종이 울린 횟수 저장
		}
//		System.out.println("정렬전");
//		System.out.println(Arrays.deepToString(people));
		Arrays.sort(people, (o1, o2) -> o2[M]-o1[M]);
//		System.out.println("정렬후");
//		System.out.println(Arrays.deepToString(people));
		
		// N명의 위치 변화는 없다.
		// 가장 많은 타종을 들은 사람이 가까이에 있다.
		// 불가능한 상황 -> 먼 사람이 들었는데 가까운 사람이 못들은 상황 -> 사전 순으로 정렬 했을 때 뒤가 크면 안됨
		
		boolean answer = true;
		for (int m = 0; m < M; m++) {
			int check = people[0][M]; // 가장 많이 종이 울린 횟수 저장
            for (int n = 0; n < N; n++) {
            	if(check < people[n][m]) {
            		answer = false;
            		break;
            	}
            	check = people[n][m];
            }
        }

		if(answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		br.close();
	}
}
