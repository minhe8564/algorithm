import java.util.*;

class Solution_비밀코드해독 {
    static int[] arr;
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        arr = new int[5];
        dfs(n, q, ans, 0, 1);
        
        return answer;
    }
    
    public static void dfs(int n, int[][] q, int[] ans, int L, int s){
        if(L == 5) {
            if(check(q, ans)){
                answer++;
            }
            return;
        }
        
        for(int i = s; i <= n; i++) {
            arr[L] = i;
            dfs(n, q, ans, L+1, i+1);
        }
    }
    
    public static boolean check(int[][] q, int[] ans) {
        Set<Integer> set = new HashSet();
        for(int x : arr) {
            set.add(x);
        }
        
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;
            for(int j = 0; j < q[i].length; j++) {
                if(set.contains(q[i][j])){
                    cnt++;
                }
            }
            if(ans[i] != cnt) {
                return false;
            }
        }
        return true;
    }
}
