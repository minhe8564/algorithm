import java.io.*;
import java.util.*;

public class BOJ1786_찾기_RabinKarp {

	// 해시 충돌 방지를 위한 서로 다른 세 지수값 (BASE 역할)
	private static final int EXPONENT1 = 31;
    private static final int EXPONENT2 = 37;
    private static final int EXPONENT3 = 41;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int count = 0; // 일치 횟수 저장
        int textLength = text.length;
        int patternLength = pattern.length;
        
        // 3가지 해시값 및 지수 누적 값
        int textHash1 = 0;
        int patternHash1 = 0;
        
        int textHash2 = 0;
        int patternHash2 = 0;
        
        int textHash3 = 0;
        int patternHash3 = 0;
        
        // 각 해시용 지수 거듭제곱
        int power1 = 1;
        int power2 = 1;
        int power3 = 1;
        
        // 매칭된 위치 저장 리스트
        List<Integer> list = new ArrayList<>();
        
        // 슬라이딩 윈도우 : i는 현재 텍스트에서 비교 시작 위치
        for(int i = 0; i <= textLength-patternLength; i++) {
        	// text[i ... i + patternLength - 1] 이 pattern과 같은지 확인
        	if(i == 0) {
        		// 초기 윈도우에 대해 패턴 및 텍스트의 해시값 계산
        		for(int j = 0; j < patternLength; j++) {
        			// patternLength - 1 - j : 거꾸로 계산 (뒤에서 부터)
        			// 각각의 해시값 누적 계산 (문자 * 지수)
        			textHash1 += hash(text[patternLength - 1 - j], power1);
        			patternHash1 += hash(pattern[patternLength - 1 - j], power1);
        			
        			textHash2 += hash(text[patternLength - 1 - j], power2);
        			patternHash2 += hash(pattern[patternLength - 1 - j], power2);
        			
        			textHash3 += hash(text[patternLength - 1 - j], power3);
        			patternHash3 += hash(pattern[patternLength - 1 - j], power3);
        			
        			// 다음 자리수의 거듭제곱 준비
        			if(j < patternLength - 1) {
        				power1 *= EXPONENT1;
        				power2 *= EXPONENT2;
        				power3 *= EXPONENT3;
        			}
        		}
        	} else {
        		// 슬라이딩 : 해시값을 재계산하지 않고, 효율적으로 업데이트
        		// (이전 해시값에서 빠진 문자 제거, 새 문자 추가)
        		textHash1 = EXPONENT1 * (textHash1 - hash(text[i-1], power1)) 
        				+ text[patternLength - 1 + i];
        		textHash2 = EXPONENT2 * (textHash2 - hash(text[i-1], power2)) 
        				+ text[patternLength - 1 + i];
        		textHash3 = EXPONENT3 * (textHash3 - hash(text[i-1], power3)) 
        				+ text[patternLength - 1 + i];
        	}
        	
        	// 해시값이 모두 일치하면 실제로 문자열이 같은지 확인
        	if(textHash1 == patternHash1 && textHash2 == patternHash2
        			&& textHash3 == patternHash3) {
        		
        		boolean match = true;
        		for(int j = 0; j < patternLength; j++) {
        			if(text[i+j] != pattern[j]) {
        				match = false;
        				break;
        			}
        		}
        		
        		if(match) {
        			count++; // 매칭 수 증가
        			list.add(i+1); // 1-based 위치 저장
        		}
        	}
        }
        
        sb.append(count).append("\n");
        if(count > 0) {
        	for(int result : list) {
        		sb.append(result).append(" ");
        	}
        }
        
        System.out.print(sb);
        br.close();
    }
    
    // 해시 계산 : 문자 * 지수 승
    private static int hash(int value, int power) {
    	return value * power;
	}
}
