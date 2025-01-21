package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1244 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 1: 스위치ON, 2: 스위치OFF
		// 남학생 : 받은 수의 배수 -> 스위치 상태 변경
		// 여학생 : 받은 수를 중심으로 -> 좌우가 대칭 + 가장 많은 스위치 포함하는 구간 상태 변경 + 스위치 개수 홀수
		// 스위치의 마지막 상태는?
		
		int count = Integer.parseInt(br.readLine());
		int[] light = new int[count+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= count; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine());
		for(int n = 0; n < studentNum; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int lightNum = Integer.parseInt(st.nextToken());
			
			// 남학생
			if(gender == 1) {
				for (int i = lightNum; i <= count; i += lightNum) {
                    // light[i] = (light[i] == 1) ? 0 : 1;
					light[i] = 1 - light[i]; // 1이면 0, 0이면 1
                }
			}
			// System.out.println(Arrays.toString(light));
			
			// 여학생
			else {
				int left = lightNum - 1;
				int right = lightNum + 1;
				
				// 대칭 범위를 검사하고 상태를 변경
                while (left >= 1 && right <= count && light[left] == light[right]) {
                    light[left] = 1 - light[left]; // 스위치 상태 변경
                    light[right] = 1 - light[right]; // 스위치 상태 변경
                    left--;
                    right++;
                }

                // 중앙 스위치 상태 변경
                light[lightNum] = 1 - light[lightNum];
			}
			
		}
		
		for(int i = 1; i <= count; i++) {
			sb.append(light[i]).append(" ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
