class Solution_택배상자꺼내기 {
    public int solution(int N, int W, int num) {
        int height = 0;
        if(N%W==0) height = N/W;
        else height = N/W+1;
        
        int[][] box = new int[height][W];
        int n = 1;
        for(int h = 0; h < height; h++) {
            if(h%2==0){ 
                for(int w = 0; w < W; w++) {
                  if(n<=N) {
                      box[h][w] = n++;
                  }  
                }
            } else {
                for(int w = W-1; w >= 0; w--) {
                    if(n<=N) {
                        box[h][w] = n++;
                    }
                }
            }
        }
        
        int x = -1, y = -1;
        for(int h = 0; h < height; h++){
            for(int w = 0; w < W; w++) {
                if(box[h][w] == num){
                    x = h; y = w;
                }
            }
        }
        
        int answer = 0;
        for(int h = x; h < height; h++) {
            if(box[h][y] != 0) answer++;
        }
        
        return answer;
    }
}
