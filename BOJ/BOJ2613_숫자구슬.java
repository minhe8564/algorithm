import java.io.*;
import java.util.*;

public class BOJ2613_숫자구슬 {
	static int N, M;
	static int[] beads;
	static int groupMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		beads = new int[N];
		int maxBead = Integer.MIN_VALUE;
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			beads[n] = Integer.parseInt(st.nextToken());
			maxBead = Math.max(maxBead, beads[n]);
			sum += beads[n];
		}
		
		// 1. 이분 탐색으로 그룹 최대값의 최소 찾기
		int left = maxBead;
		int right = sum;
		while(left <= right) {
			int mid = (left+right)/2;
			int currCnt = 1;
			int currSum = 0;
			
			for(int n = 0; n < N; n++) {
				if(currSum+beads[n] > mid) {
					currCnt++;
					currSum = 0;
				}
				currSum += beads[n];
			}
			
			if(currCnt <= M) {
				groupMax = mid;
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		sb.append(groupMax).append("\n");
		
		// 2. 그룹 나누기
		int currCnt = 0;
		int currSum = 0;
		for(int n = 0; n < N; n++) {
			if(currSum+beads[n] > groupMax) { // 새로운 그룹 시작
				sb.append(currCnt).append(" "); // 이전 그룹의 크기 정답에 추가
				M--; // 남은 그룹 수 줄이기
				currSum = beads[n]; // 새로운 그룹을 시작하면서 첫번째 요소 저장
				currCnt = 1; // 새로운 그룹의 첫 요소니까 1로 초기화
			} else {
				currSum += beads[n];
				currCnt++;
			}
			// 남은 숫자 구슬 개수가 남은 그룹 수와 같아지면,
			// 이후 숫자는 각 숫자별로 1개씩 그룹을 만들어야 하니까 break;!!!
			if(N-n == M) { 
				break;
			}
		}
		// 3. 마지막으로 남은 그룹 처리
		while(M > 0) { // 남은 그룹 개수만큼
			sb.append(currCnt).append(" "); // 현재 그룹 크기 추가
			currCnt = 1; // 남은 숫자는 1개씩 그룹을 만들어야 하니까 1로 설정
			M--; // 남은 그룹 수 줄이기
		}
		
		System.out.print(sb);
		br.close();
	}
}
