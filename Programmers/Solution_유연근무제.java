class Solution_유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int[] limitTimes = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++) {
            limitTimes[i] = addTime(schedules[i]);
        }
        
        boolean[] weekend = new boolean[7];
        for(int day = 0; day < 7; day++){
            int week = (startday-1 + day) % 7 + 1; // startday 1~7 이니까 -1 로 조정, day 뒤 요일, 0~6 으로 정규화, 다시 +1
            if(week == 6 || week == 7) {
                weekend[day] = true;
            }
        }
        
        for(int i = 0; i < schedules.length; i++) {
            boolean ok = true;
            
            for(int day = 0; day < 7; day++) {
                if(weekend[day]) continue;
                
                int realTime = timelogs[i][day];
                if(limitTimes[i] < realTime) {
                    ok = false;
                    break;
                }
            }
            
            if(ok) answer++;
        }
        
        return answer;
    }
    
    public int addTime(int time) {
        int hour = time/100;
        int min = time%100;
        
        min+=10;
        if(min >= 60) {
            hour+=1;
            min-=60;
        }
        
        return hour*100+min;
    }
}
