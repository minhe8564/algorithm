package algorithm;

import java.io.*;
import java.util.*;

public class BOJ20546_기적의매매법 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int money = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] buy = new int[14];
		for (int i = 0; i < 14; i++) {
			buy[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 준현 : 주식을 살 수 있으면 바로바로 산다.
		// 2. 성민 : 3일 연속 상승하면 전량 매도, 3일 연속 하락하면 전량 매수
		int junResult = jun(money, buy);
		int songResult = song(money, buy);

		if (junResult > songResult) {
			sb.append("BNP");
		} else if (junResult < songResult) {
			sb.append("TIMING");
		} else if(junResult == songResult) {
			sb.append("SAMESAME");
		}
		System.out.println(sb);
		br.close();
	}

	private static int jun(int money, int[] buy) {
		int cnt = 0;
		for (int i = 0; i < 14; i++) {
			if (money >= buy[i]) {
				cnt += money / buy[i];
				money %= buy[i];
			}
		}

		return money + buy[13] * cnt;
	}

	private static int song(int money, int[] buy) {
		int cnt = 0;
		for (int i = 4; i < 14; i++) {
			// 3일연속 전일대비 하락 -> 전량 매수
			// 3일연속 전일대비 상승 -> 전량 매도
			if (buy[i-1] < buy[i-2]) {
				if (buy[i-2] < buy[i-3]) {
					cnt += money / buy[i];
					money %= buy[i];
				}
			}
			else if (buy[i-1] > buy[i-2]) {
				if (buy[i-2] > buy[i-3]) {
					money += buy[i] * cnt;
					cnt = 0;
				}
			}
		}
		
		return money + buy[13] * cnt;
	}

}
