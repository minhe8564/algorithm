package algorithm;

import java.io.*;
import java.util.*;

public class SWEA5656_벽돌깨기 {
    static int N, W, H;
    static int[][] map;
    static int[][] copy; // map 초기화할때 사용하기 위한 배열
    static int num[]; // 중복 순열에서 선택한 값 저장하기 위한 배열
    static int min;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 구슬 N번 쏘기 가능
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            copy = new int[H][W];
            num = new int[N]; // 중복 순열에서 선택한 값 저장
            min = Integer.MAX_VALUE;
            
            // 입력
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int w = 0; w < W; w++) {
                    map[h][w] = copy[h][w] = Integer.parseInt(st.nextToken());
                }
            }

            // 1. 똑같은 자리에 계속 구슬을 던질 수 있기 때문에, 어떤 위치에 구슬을 던질 지 중복 순열로 선택
            // 2. 구슬 위치 구했으면 해당 값으로 BFS 탐색
            // 3. BFS 탐색하면서 map[x][y]에 적힌 값만큼 연쇄적으로 폭발
            // 4. 삭제된 블럭을 제외하고 블럭을 아래로 내리기, 위에서브터 스택에 값을 담고 밑에서부터 스택의 값 빼기
            // 2~4번 반복해서 최소로 남은 구슬 구하기
            
            perm(0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    
    private static void perm(int cnt) {
    	if(cnt == N) { // N개의 구슬을 모두 선택했다면
    		start(num); 
    		min = Math.min(min, countMap());
    		mapCopy();
//    		System.out.println(Arrays.toString(num));
    		return;
    	}
    	
    	for(int i = 0; i < W; i++) { // W개의 열 중 하나 선택
    		num[cnt] = i; // 현재 구슬을 i번째 열에 떨어뜨림
    		perm(cnt+1); // 다른 구슬 선택
    	}
	}
    
    private static void start(int[] num) {
    	int x = 0;
    	int y = 0;
    	
    	for(int n = 0; n < N; n++) { // N번 구슬 떨어 뜨리기
    		for(int h = 0; h < H; h++) { // 해당 열의 가장 위쪽에 있는 벽돌 찾기
    			if(map[h][num[n]] != 0) { // 벽돌이 있는 경우
    				x = h;
    				y = num[n];
    				break;
    			}
    		}
    		bfs(x, y);
    		fillMap();
    	}
	}
    
    private static void bfs(int x, int y) {
    	Queue<int[]> q = new ArrayDeque<int[]>();
    	q.offer(new int[] { x, y, map[x][y] });
    	map[x][y] = 0;
    	
    	while(!q.isEmpty()) {
    		int[] curr = q.poll();
    		int cx = curr[0];
    		int cy = curr[1];
    		int step = curr[2];
    		
    		for(int s = 1; s < step; s++) {
    			for(int d = 0; d < 4; d++) {
    				int nx = cx + dx[d] * s;
    				int ny = cy + dy[d] * s;
    				
    				if(nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != 0) {
    					q.offer(new int[] { nx, ny, map[nx][ny] });
    					map[nx][ny] = 0;
    				}
    			}
    		}
    	}
	}
    
    private static int countMap() {
    	int count = 0;
    	for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if(map[h][w] != 0) {
                	count++;
                }
            }
        }
    	return count;
	}
    
    private static void fillMap() {
    	Stack<Integer> s = new Stack<>();
    	
    	for(int w = 0; w < W; w++) {
    		// 남아있는 벽돌을 스택에 저장
    		for(int h = 0; h < H; h++) {
    			if(map[h][w] != 0) 
    				s.add(map[h][w]);
    		}
    		// 스택에서 벽돌을 꺼내 아래에서부터 채움
    		for(int h = H-1; h >= 0; h--) {
    			if(s.isEmpty())
    				map[h][w] = 0;
    			else
    				map[h][w] = s.pop();
    		}
    	}
	}
    
    private static void mapCopy() {
    	for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                map[h][w] = copy[h][w];
            }
        }
	}
}
