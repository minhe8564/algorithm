class Solution_퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;

        while (left < right) {
            long mid = (left+right) / 2;

            if (isPossible(diffs, times, mid, limit)) {
                right = mid;
            } else {
                left = mid+1;    
            }
        }
        return (int)left;
    }

    public boolean isPossible(int[] diffs, int[] times, long mid, long limit) {
        long time = times[0];

        for (int i = 1; i < diffs.length; i++) {

            if (diffs[i] > mid) {
                time += ((long)diffs[i] - mid) * ((long)times[i] + (long)times[i-1]);
            }
            time += (long)times[i];
        }

        return limit >= time; 
    }
}

