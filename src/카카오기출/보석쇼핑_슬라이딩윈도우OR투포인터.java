package 카카오기출;

import java.util.*;

class 보석쇼핑_슬라이딩윈도우OR투포인터 {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(); //보석의 종류를 담은 set
        HashMap<String, Integer> map = new HashMap<>(); // idx부터 현재까지의 보석과 그 개수를 저장하는 map
        Queue<String> q = new LinkedList<String>();// idx부터 현재까지의 보석들을 중복을 포함하여 담은 queue
        //우선 보석 종류를 파악한다
        for(String gem : gems){
            set.add(gem);
        }
        
        int start = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<gems.length; i++){
            //맵에 보석의 개수를 추가해주고
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            //고른 보석을 큐에 넣어준다.
            q.add(gems[i]);
            
            while(true){
                String temp = q.peek();
                //제일 먼저 고른 보석이 또 나올 경우 제일 먼저 고른 보석을 빼준다.
                //최소를 구해야 하기 때문에 보석이 두개 겹치면 제일 먼저 고른 보석을 빼주어야 최소를 찾을 수 있다.
                if(map.get(temp) > 1){
                    map.put(temp, map.get(temp) -1);
                    //중복된 보석 poll
                    q.poll();
                    //맨 앞에거를 빼줬으므로 시작 idx는 +1이 된다.
                    idx++;
                }
                else{
                    
                    break;
                }
            }    
        //앞에 조건은 보석을 모두 고른 경우
        //뒤에 조건은 최소값인 경우 start 인덱스의 값을 갱신
        if(map.size() == set.size() && min > q.size()) {
            min = q.size();
            start = idx;
            }
        }
        
       
        return new int[]{start + 1, start + min};
    }
}