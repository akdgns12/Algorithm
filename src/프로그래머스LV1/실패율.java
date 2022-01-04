import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();
        //stage, ������
        
        for(int i=1; i<=N; i++){
            int stage = i;
            int noClearPlayer = 0;
            int currentStagePlayer = 0;
            
            for(int j=0; j<stages.length; j++){
                int player = stages[j];
                //���� �������� Ŭ�������� ���ѻ��
                if(stage == player)
                    noClearPlayer++;
                //���� �������� ������
                if(stage <= player)
                    currentStagePlayer++;
            }
            //�������� ������ ������ ���� ��� ������ = 0
            //������ = ���� �������� Ŭ�������� ���� ��� / ���� �������� ������
            double failRate = 0;
            if(noClearPlayer !=0 && currentStagePlayer != 0){
                failRate = (double) noClearPlayer / (double)currentStagePlayer;    
            }          
            map.put(stage, failRate);
        }
        
        //������������ �����ؼ� answer�迭�� ����
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