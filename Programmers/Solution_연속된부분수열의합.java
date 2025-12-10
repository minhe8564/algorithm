class Solution_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int sum = 0; // 수열 합
        int len = sequence.length; // 수열 길이
        
        int left = 0;
        // int right = 0;
        int[] answer = new int[2];
        
        for(int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k) {
                // System.out.println(left + " " + right + " 길이: " + len);
                if(right-left < len) {
                    len = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }
}
