/*
 * 1. orders 배열 오름차순 정렬
 * 2. 조합, 부분집합?
 * 3. 맵에 조합 카운트 저장
 * 4. 2가지 이상의 메뉴, 2명 이상의 손님이 주문
 */

import java.util.*;

class Solution_메뉴리뉴얼 {
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < orders.length; i++) {
            // 1. 오름차순 정렬, 조합 망가지지 않게 하기 위해
            String order = orders[i];
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            
            // 2. 조합
            for(int j = 0; j < course.length; j++) {
                int len = course[j];
                comb(orderArr, 0, len, new StringBuilder());
            }
                // System.out.println();
        }
        
        // 4. 2가지 이상의 메뉴, 2명 이상의 손님이 주문
        for(int i = 0; i < course.length; i++) {
            int len = course[i];
            
            int max = 0; // 여러명이 주문한 경우
            for(String key : map.keySet()) {
                if(key.length() == len) {
                    max = Math.max(max, map.get(key));
                }
            }
            
            if(max < 2) { // 2명 이상
                continue;
            }
            
            for(String key : map.keySet()){
                if(key.length() == len && map.get(key) == max) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void comb(char[] orderArr, int idx, int len, StringBuilder sb) {
        if(sb.length() == len) { // 3. 맵에 저장
            // System.out.println(sb.toString() + " " + map.getOrDefault(sb.toString(), 0)+1);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        
        for(int i = idx; i < orderArr.length; i++){
            sb.append(orderArr[i]);
            comb(orderArr, i+1, len, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
