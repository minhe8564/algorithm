/*
 * 숫자 등장 횟수 세기
 * X, Y 에서 공통으로 사용 가능한 숫자 확인하기 (min 값)
 * 큰 숫자부터 결과 만들기
 * 결과 없으면 -1, 전부 0이면 0 리턴
 */

class Solution_숫자짝꿍 {
    public String solution(String X, String Y) {
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        for(int x = 0; x < X.length(); x++) {
            numX[X.charAt(x)-'0']++;
        }
        for(int y = 0; y < Y.length(); y++) {
            numY[Y.charAt(y)-'0']++;
        }
        
        int[] num = new int[10];
        for(int i = 0; i < 10; i++){
            num[i] = Math.min(numX[i], numY[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            int count = num[i];
            while(count > 0) {
                sb.append(i);
                count--;
            }
            
        }

        if(sb.length() == 0) {
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        }
        
        String answer = sb.toString();
        return answer;
    }
}
