/*
 * 1. K 칸 점프 : K 만큼 건전지
 * 2. 순간이동 : (현재온거리)*2, 건전지 그대로
 */

import java.util.*;

public class Solution_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        
        // 순간이동 우선
        while(n != 0) {
            if(n%2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}
