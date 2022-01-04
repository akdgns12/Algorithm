package īī������;

import java.util.*;

class ��������_�����̵�������OR�������� {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(); //������ ������ ���� set
        HashMap<String, Integer> map = new HashMap<>(); // idx���� ��������� ������ �� ������ �����ϴ� map
        Queue<String> q = new LinkedList<String>();// idx���� ��������� �������� �ߺ��� �����Ͽ� ���� queue
        //�켱 ���� ������ �ľ��Ѵ�
        for(String gem : gems){
            set.add(gem);
        }
        
        int start = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<gems.length; i++){
            //�ʿ� ������ ������ �߰����ְ�
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            //�� ������ ť�� �־��ش�.
            q.add(gems[i]);
            
            while(true){
                String temp = q.peek();
                //���� ���� �� ������ �� ���� ��� ���� ���� �� ������ ���ش�.
                //�ּҸ� ���ؾ� �ϱ� ������ ������ �ΰ� ��ġ�� ���� ���� �� ������ ���־�� �ּҸ� ã�� �� �ִ�.
                if(map.get(temp) > 1){
                    map.put(temp, map.get(temp) -1);
                    //�ߺ��� ���� poll
                    q.poll();
                    //�� �տ��Ÿ� �������Ƿ� ���� idx�� +1�� �ȴ�.
                    idx++;
                }
                else{
                    
                    break;
                }
            }    
        //�տ� ������ ������ ��� �� ���
        //�ڿ� ������ �ּҰ��� ��� start �ε����� ���� ����
        if(map.size() == set.size() && min > q.size()) {
            min = q.size();
            start = idx;
            }
        }
        
       
        return new int[]{start + 1, start + min};
    }
}