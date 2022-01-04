import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();
        //stage, 실패율
        
        for(int i=1; i<=N; i++){
            int stage = i;
            int noClearPlayer = 0;
            int currentStagePlayer = 0;
            
            for(int j=0; j<stages.length; j++){
                int player = stages[j];
                //현재 스테이지 클리어하지 못한사람
                if(stage == player)
                    noClearPlayer++;
                //현재 스테이지 도전자
                if(stage <= player)
                    currentStagePlayer++;
            }
            //스테이지 도달한 유저가 없는 경우 실패율 = 0
            //실패율 = 현재 스테이지 클리어하지 못한 사람 / 현재 스테이지 도전자
            double failRate = 0;
            if(noClearPlayer !=0 && currentStagePlayer != 0){
                failRate = (double) noClearPlayer / (double)currentStagePlayer;    
            }          
            map.put(stage, failRate);
        }
        
        //내림차순으로 정렬해서 answer배열에 넣자
        for(int i=0; i<N; i++){
            double max = -1;
            int stage = 0;
            for(Integer key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    stage = key;
                }
            }
            
            answer[i] = stage;
            map.remove(stage);
        }
        
        return answer;
    }
}