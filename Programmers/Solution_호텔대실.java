/*
 * 시작시간 기준 정렬 
 * 새로운 시작시간이 종료시간보다 크면 방 재사용 가능
 * 14:10, 19:20 / 14:20, 15:20 / 15:00, 17:00 / 16:40, 18:20 / 18:20, 21:20
 */
import java.util.*;

class Solution_호텔대실 {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            int startHour = Integer.parseInt(book_time[i][0].substring(0, 2));
            int startMin = Integer.parseInt(book_time[i][0].substring(3, 5));
            int startTime = startHour*60+startMin;
            
            int endHour = Integer.parseInt(book_time[i][1].substring(0, 2));
            int endMin = Integer.parseInt(book_time[i][1].substring(3, 5));
            int endTime = endHour*60+endMin+10;
            
            time[i][0] = startTime;
            time[i][1] = endTime;
        }
        
        Arrays.sort(time, (a,b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < time.length; i++) {
            if(!q.isEmpty() && time[i][0] >= q.peek()){
                q.poll();   
            }
            q.add(time[i][1]);
        }
        
        int answer = q.size();
        return answer;
    }
}
