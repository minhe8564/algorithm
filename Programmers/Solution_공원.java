class Solution_공원 {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        // park 배열에서 가장 큰 정사각형 찾기
        int maxCount = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    int count = 1;
                    while(square(i, j, count, park)) {
                        count++;
                    }
                    
                    maxCount = Math.max(maxCount, count-1);
                }
            }
        }
        
        for(int i = 0; i < mats.length; i++) {
            if(mats[i] <= maxCount) {
                answer = Math.max(answer, mats[i]);
            }
        }
        
        return answer;
    }
    
    public boolean square(int x, int y, int count, String[][] park) {
        if(x+count > park.length || y+count > park[0].length) return false;
        
        for(int i = x; i < x+count; i++) {
            for(int j = y; j < y+count; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
