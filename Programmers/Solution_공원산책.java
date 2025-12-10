/*
 S : 시작 지점
 O : 이동 가능한 통로
 X : 장애물
*/
class Solution_공원산책 {
    public int[] solution(String[] park, String[] routes) {
        char[][] arr = new char[park.length][park[0].length()];
        int startX = -1;
        int startY = -1;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                arr[i][j] = park[i].charAt(j); 
                if(arr[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }
        
        for(String route : routes) {
            String dir = route.split(" ")[0];
            int num = Integer.parseInt(route.split(" ")[1]);
            
            int currX = startX;
            int currY = startY;
            
            for(int i = 0; i < num; i++) {
                if(dir.equals("N")) { // 북쪽
                    currY--;
                } else if(dir.equals("S")) { // 남쪽
                    currY++;
                } else if(dir.equals("W")) { // 서쪽
                    currX--;
                } else { // 동쪽
                    currX++;
                }
                
                if(currX < 0 || currY < 0 || currX >= arr[0].length || currY >= arr.length) continue;
                
                if(arr[currY][currX] == 'X') { // 장애물
                    break;
                }
                
                if(i == num-1) {
                    startX = currX;
                    startY = currY;
                }
            }
        }
        
        int[] answer = {startY, startX}; // 세로, 가로
        return answer;
    }
}
