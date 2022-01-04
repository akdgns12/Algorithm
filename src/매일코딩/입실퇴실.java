package 매일코딩;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        import java.util.*;

        class Solution {
            public int[] solution(int[] enter, int[] leave) {
                int[] answer = new int[enter.length];
                ArrayList<Integer> list = new ArrayList<>();
                int idx = 0;
                
                for(int i=0; i<answer.length; i++){
                    // for문을 돌며 list에 있는 enter[]에 있는 값들을 넣어준다.
                    // 단, list에 값이 추가될때마다 answer의 값을 변화시켜준다.
                    // list의 값을 체크하여 방금 들어온 사람은 현재 list.size()-1 만큼의 사람을 마주쳤으며 이미 list에 있는 값들은 새로운 사람을 만난 것이므로 +1 해준다.
                    list.add(enter[i]); 
                    for(int j=0; j<list.size(); j++){
                        if(enter[i] == list.get(j)){
                            answer[list.get(j) - 1] = list.size() - 1;
                        }else{
                            answer[list.get(j) - 1]++;
                        }
                    }
                    
                    // 퇴실한 사람의 처리는, 사람이 입장한 후 확인하는데
                    // leave의 인덱스값이 list에 있는지 체크하고 있다면,
                    // 제거처리, 없다면 그 인덱스에 머물러 있어야 한다.
                    while(idx < answer.length && list.contains(leave[idx])){
                        list.remove(Integer.valueOf(leave[idx++]));
                    }
                }
                
                return answer;
            }
        }

   