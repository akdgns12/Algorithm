package �����ڵ�;

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
                    // for���� ���� list�� �ִ� enter[]�� �ִ� ������ �־��ش�.
                    // ��, list�� ���� �߰��ɶ����� answer�� ���� ��ȭ�����ش�.
                    // list�� ���� üũ�Ͽ� ��� ���� ����� ���� list.size()-1 ��ŭ�� ����� ���������� �̹� list�� �ִ� ������ ���ο� ����� ���� ���̹Ƿ� +1 ���ش�.
                    list.add(enter[i]); 
                    for(int j=0; j<list.size(); j++){
                        if(enter[i] == list.get(j)){
                            answer[list.get(j) - 1] = list.size() - 1;
                        }else{
                            answer[list.get(j) - 1]++;
                        }
                    }
                    
                    // ����� ����� ó����, ����� ������ �� Ȯ���ϴµ�
                    // leave�� �ε������� list�� �ִ��� üũ�ϰ� �ִٸ�,
                    // ����ó��, ���ٸ� �� �ε����� �ӹ��� �־�� �Ѵ�.
                    while(idx < answer.length && list.contains(leave[idx])){
                        list.remove(Integer.valueOf(leave[idx++]));
                    }
                }
                
                return answer;
            }
        }

   