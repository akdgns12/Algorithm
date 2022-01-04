package 매일코딩;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// 1. 손님들이 주문한 orders에 속해있는 총 메뉴들에 대한 모든 조합을 구한다
// 2. 구한 경우의 수들을 모두 Map에 key로 저장하고 그에 대한 count를 value값에
// 넣어준 다음 value를 기준으로 오름차순 정렬해준다.
// 3. 정렬한 값을 가지고 조건에 맞는 코스요리 메뉴를 담아 출력

/*
 * 1번 로직
 * orders 배열에 담긴 값들을 모두 원소 2개 이상의 부분집합을 구할 것이다.
 * orders와 course의 최대 갯수가 그리 크지 않아서 나올 수 있는 모든
 * 코스메뉴 구성을 브루트포스로 다 조회할 것이다. 순서를 고려해주지 않아도 되므로
 * 조합을 구하면 된다.
 * ex) ABC -> AB, AC, BC, ABC
 * 
 * 2번 로직
 * 1번에서 구한 모든 부분집합들을 map에 저장하면서 카운트해주면 되므로 간단하다.
 * key: 코스메뉴
 * value : 해당 코스메뉴 주문 갯수
 * 그리고나서 Value를 기준으로 Map 오름차순 정렬 해주면 된다.
 * 
 * 3번로직
 * 오름차순으로 정렬된 주문된 정보들을 가지고 코스메뉴 갯수(course)에 맞춰
 * 후보들을 골라주면 된다. 문제에 최소 2명 이상이 시킨 메뉴만 후보에 넣고,
 * 중복을 허용하므로 두 가지 조건만 고려하면 된다.
 */
/*
 * 1. 조합을 만든다
 * 2. 단품메뉴조합을 길이별로 분류하고, 해당 단품메뉴가 몇번 선택되었는지 체크한다
 * 	그리고 단품메뉴를 list에 담는다
 * 3. list를 돌면서 가장 많이 선택된 메뉴를 answer에 담는다
 * 4. 오름차순 정렬해주고 answer를 return한다
 */
/*
 * 1. 주어진 문자열 배열에서 조합으로 문자를 만든다
 * 2. 만들어진 문자를 hashmap의  key값으로 넣고 나온 빈도수를 value값으로 넣는다
 *  2-1 가장 많이 나온 문자를 출력 배열에 넣어야하므로 최댓값을 찾고 저장한다.
 * 3. 모든 문자를 다 만들고 map에 넣었다면 value값 중 최댓값과 같은 값들을 우선순위 큐에 넣는다.
 */
import java.util.*;

class Solution {
    // 가장 많이 함께 주문된 단품메뉴들을 -> 코스요리 메뉴로 한다.
    // 최대 빈번 메뉴
    static HashMap<String, Integer> map;
    static int m;
    public String[] solution(String[] orders, int[] course) {
        // 정답은 문자열 오름차순 정렬해줘야 하므로 우선순위 큐 사용
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(int i : course){ // 1. course[i]개 만큼을 orders에서 고를거야
            m = 0; // m 0으로 초기화
            map = new HashMap<>(); // hashmap 초기화 
            for(String s : orders){ // 2. orders원소 문자열에서 ex)"ABCFG" 에서 course[i] 만큼  ex) 2
                dfs(i, s,"",0,0); // 조합 구하기 course[i] = target, orders문자열, String now = cnt개 뽑은 문자열을 임시로 저장 해놓는 변수, int cnt = 뽑은 갯수 , int index = orders배열 인덱스
            } //  dfs를 수행하며 course[i]개 뽑는 조합에 대해 orders배열을 돌고나면
             // ex) 2개문자 뽑는경우 -> 2개문자 뽑는 조합들 중 가장 많이 나온 경우가 map에 저장되어 있을 것 -> m = 가장 많이 나온 경우의 수 
            for(String key : map.keySet()){
                if(map.get(key) == m && m > 1){
                    pq.offer(key);
                }
            }
        }
        
        String[] answer = new String[pq.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = pq.poll();
        }
        return answer;
    }
    
    public static void dfs(int target, String word, String now, int cnt, int index){
        if(cnt == target){ // course[i]개 만큼 뽑았다면
            char[] ch = now.toCharArray();
            Arrays.sort(ch);
            String tmp = "";
            for(char c : ch){
                tmp += c;
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            m = Math.max(m, map.get(tmp)); // ex) "ABCFG"에서 AC를 뽑았다면 AC가 
            
        }
        
        for(int i=index; i<word.length(); i++){
            char s = word.charAt(i);
            dfs(target, word, now+s, cnt+1, i+1);
        }
    }
}
