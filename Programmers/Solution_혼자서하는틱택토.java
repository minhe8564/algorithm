class Solution_혼자서하는틱택토 {
    public int solution(String[] board) {
        int B = board.length;
        char[][] game = new char[B][B];
        for(int i = 0; i < B; i++){
            game[i] = board[i].toCharArray();
        }
        
        int oCount = 0;
        int xCount = 0;
        
        for(int i = 0; i < B; i++) {
            for(int j = 0; j < B; j++) {
                if(game[i][j] == 'O') {
                    oCount++;
                } else if(game[i][j] == 'X') {
                    xCount++;
                }
            }
        }
        
        // 나올 수 없는 게임 상황 (o 가 선공이기 때문에 +1 많아야 함)
        // 1. x 가 선공인 경우
        if(oCount < xCount) {
            return 0;
        }
        
        // 2. o 가 x 보다 2개 이상 많은 경우
        if(oCount > xCount+1) {
            return 0;
        }
        
        // 3. o 랑 x 둘 다 이긴 경우
        boolean oWin = win(game, 'O');
        boolean xWin = win(game, 'X');
        if(oWin && xWin) {
            return 0;
        }
        
        // 4. x 가 이겼는데, x 랑 o 가 같지 않을 경우
        if(xWin && (xCount != oCount)) {
            return 0;
        }
        
        // 5. o 가 이겼는데, o 가 1개 더 많지 않을 경우
        if(oWin && (oCount != xCount+1)) {
            return 0;
        }
        
        // 나올 수 있는 게임 상황
        return 1;
    }
    
    public boolean win(char[][] game, char mark) {
        for(int i = 0; i < 3; i++) {
            if(game[i][0]==mark && game[i][1]==mark && game[i][2]==mark) {
                return true;
            }
            if(game[0][i]==mark && game[1][i]==mark && game[2][i]==mark) {
                return true;
            }
        }
        
        if(game[0][0]==mark && game[1][1]==mark && game[2][2]==mark) {
            return true;
        }
        if(game[0][2]==mark && game[1][1]==mark && game[2][0]==mark) {
            return true;
        }
        
        return false;
    }
}
