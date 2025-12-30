/*
 * 멀로 풀어야하지
 * 스택을 사용하여 뒤부터 탐색
 */
import java.util.*;

class Solution_뒤에있는큰수 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        
        
        return answer;
    }
}
