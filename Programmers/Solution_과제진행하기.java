import java.util.*;

class Solution_과제진행하기 {
    public class Assignments {
        String name;
        int start;
        int playtime;
        
        public Assignments(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Assignments[] arr = new Assignments[plans.length];
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = time(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            
            Assignments assignment = new Assignments(name, start, playtime);
            arr[i] = assignment;
        }
        
        // 과제시작 시각 정렬
        Arrays.sort(arr, (o1, o2) -> {
            return o1.start-o2.start;
        });
        
        // 진행 중인 과제 없으면 -> 바로 진행
        // 진행 중, 현재 과제가 새로운 과제 전에 끝남 -> 현재 과제 완료, 새로운 과제 처리
        // 진행 중, 현재 과제가 새로운 과제 전에 안끝남 -> 현재 과제 중단, 새로운 과제 시작
        // 과제 처리 후, 남은 과제 처리
        Stack<Assignments> stack = new Stack<>();
        int idx = 0;
       
        for(int i = 0; i < arr.length-1; i++) {
            Assignments curr = arr[i];
            Assignments next = arr[i+1];
            int currEnd = curr.start+curr.playtime;
            
            if(currEnd <= next.start) { // 1. 현재 과제가 새로운 과제 전에 끝남
                answer[idx++] = curr.name;
                int betweenTime = next.start-(curr.start+curr.playtime);
                
                while(!stack.isEmpty() && betweenTime > 0){ // 새로운 과제 전 남는 시간
                    Assignments top = stack.pop(); // 최근 과제
                    
                    if(top.playtime <= betweenTime) { // 과제 끝낼 수 있음!
                        betweenTime -= top.playtime;
                        answer[idx++] = top.name;
                    } else { // 과제 끝낼 수 없으면, 일부만 진행하고 다시 넣기
                        top.playtime -= betweenTime;
                        betweenTime = 0;
                        stack.push(top);
                    }
                }
            } else { // 2. 현재 과제가 새로운 과제 전에 안끝남
                curr.playtime -= (next.start-curr.start); // 현재 과제를 실행하고, 남은 과제 playtime 에 저장
                stack.push(curr);
            }
        }
        
        // 남은 과제 처리
        answer[idx++] = arr[arr.length-1].name;
        
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }
        
        return answer;
    }
    
    public int time(String start) {
        String[] arr = start.split(":");
        int hour = Integer.parseInt(arr[0]) * 60;
        int min = Integer.parseInt(arr[1]);
        return hour+min;
    }
}
