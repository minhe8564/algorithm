/* 
 * BOJ 11404번 : 이항계수3
 * 메모리 : 42,504kb
 * 시간 : 140ms
 * 
 * N, K가 주어졌을 때 이항계수를 1,000,000,007로 나눈 나머지 구하기
 * 1. factorial : 1부터 어떤 수까지 곱한 값 배열 미리 계산
 * 2. a/b mod m -> 이런식으로 모듈러 나눗셈은 그냥 할 수 없다. -> 나눗셈 대신 역원을 곱해야 한다.
 * 3. 역원을 구하기 위해 -> 페르마의 소정리
 * 4. a^-1 mod p = a^(p-2) mod p
 * 5. 빠른 거듭제곱 연산 사용
 */

import java.io.*;
import java.util.*;

public class BOJ11401_이항계수3 {
	static int N, K;
	static int MOD = 1_000_000_007;
	static long[] factorial;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 팩토리얼 미리 계산
		factorial = new long[N+1];
		factorial[0] = 1;
		for(int i = 1; i <= N; i++) {
			factorial[i] = (factorial[i-1] * i) % MOD;
		}

		long top = factorial[N]; // 분모
		long bottom = (factorial[K] * factorial[N-K]) % MOD; // 분자
		long result = (top * modInverse(bottom)) % MOD;
		
		sb.append(result);
		System.out.print(sb);
		br.close();
	}
	
	// 페르마의 소정리로 역원 구하기
	private static long modInverse(long a) {
		return modPow(a, MOD-2);
	}
	
	// 이진 거듭제곱
	private static long modPow(long base, long exp) {
		long result = 1;
		base %= MOD;
		
		while(exp > 0) {
			if(exp%2 == 1) {
				result = (result*base) % MOD;
			}
			base = (base*base) % MOD;
			exp /= 2;
		}
		
		return result;
	}
}
