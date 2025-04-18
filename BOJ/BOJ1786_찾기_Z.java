import java.io.*;
import java.util.*;

public class BOJ1786_찾기_Z {
	static String text, pattern;
	static String concat;
	static int[] Z;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		text = br.readLine();
		pattern = br.readLine();

		// Z 알고리즘을 위해 문자열 결합 : 패턴 + "$" + 텍스트
		concat = pattern + "$" + text;

		Z = new int[concat.length()];
		getZArray();

		int pLength = pattern.length();
		int count = 0; // 패턴 등장 횟수
		ArrayList<Integer> answer = new ArrayList<>(); // 패턴 등장 위치 저장

		// Z 배열 탐색
		// 텍스트 부분부터 검사 (i는 패턴 이후부터 시작)
		for(int i = pLength+1; i < Z.length; i++) {
			if(Z[i] == pLength) {
				count++; // 패턴과 정확히 일치하는 부분 발견
				answer.add(i-pLength); // 실제 텍스트에서의 시작 위치 (1-based)
			}
		}

		sb.append(count).append("\n");
		for(int pos : answer) {
			sb.append(pos).append(" ");
		}

		System.out.print(sb);
		br.close();
	}

	// Z 배열 생성 함수
	// Z[i]는 s[0:](패턴)와 s[i:]의 최대 공통 접두사 길이
	public static void getZArray() {

		int left = 0;
		int right = 0; // [left, right]은 현재 가장 긴 Z-box 범위

		// 1부터 시작, Z[0]은 전체 문자열과 자기자신이므로 생략
		for (int i = 1; i < concat.length(); i++) {
			
			// 현재 인덱스 i가 Z-box 안에 있는 경우
			if (i <= right) {
				// 기존 Z-box를 활용한 초기 Z 값 추정
				Z[i] = Math.min(right-i+1, Z[i-left]);
			}
			
			// 확장 비교
			// i부터 시작해서 얼마나 prefix와 일치하는지 확인
			while (i+Z[i] < concat.length() 
					&& concat.charAt(Z[i]) == concat.charAt(i+Z[i])) {
				Z[i]++;
			}
			
			// 새로운 Z-box를 갱신
			if (i+Z[i] > right) {
				left = i;
				right = i+Z[i]-1;
			}
		}
	}
}
