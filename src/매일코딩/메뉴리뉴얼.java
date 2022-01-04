package �����ڵ�;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// 1. �մԵ��� �ֹ��� orders�� �����ִ� �� �޴��鿡 ���� ��� ������ ���Ѵ�
// 2. ���� ����� ������ ��� Map�� key�� �����ϰ� �׿� ���� count�� value����
// �־��� ���� value�� �������� �������� �������ش�.
// 3. ������ ���� ������ ���ǿ� �´� �ڽ��丮 �޴��� ��� ���

/*
 * 1�� ����
 * orders �迭�� ��� ������ ��� ���� 2�� �̻��� �κ������� ���� ���̴�.
 * orders�� course�� �ִ� ������ �׸� ũ�� �ʾƼ� ���� �� �ִ� ���
 * �ڽ��޴� ������ ���Ʈ������ �� ��ȸ�� ���̴�. ������ ��������� �ʾƵ� �ǹǷ�
 * ������ ���ϸ� �ȴ�.
 * ex) ABC -> AB, AC, BC, ABC
 * 
 * 2�� ����
 * 1������ ���� ��� �κ����յ��� map�� �����ϸ鼭 ī��Ʈ���ָ� �ǹǷ� �����ϴ�.
 * key: �ڽ��޴�
 * value : �ش� �ڽ��޴� �ֹ� ����
 * �׸����� Value�� �������� Map �������� ���� ���ָ� �ȴ�.
 * 
 * 3������
 * ������������ ���ĵ� �ֹ��� �������� ������ �ڽ��޴� ����(course)�� ����
 * �ĺ����� ����ָ� �ȴ�. ������ �ּ� 2�� �̻��� ��Ų �޴��� �ĺ��� �ְ�,
 * �ߺ��� ����ϹǷ� �� ���� ���Ǹ� ����ϸ� �ȴ�.
 */
/*
 * 1. ������ �����
 * 2. ��ǰ�޴������� ���̺��� �з��ϰ�, �ش� ��ǰ�޴��� ��� ���õǾ����� üũ�Ѵ�
 * 	�׸��� ��ǰ�޴��� list�� ��´�
 * 3. list�� ���鼭 ���� ���� ���õ� �޴��� answer�� ��´�
 * 4. �������� �������ְ� answer�� return�Ѵ�
 */
/*
 * 1. �־��� ���ڿ� �迭���� �������� ���ڸ� �����
 * 2. ������� ���ڸ� hashmap��  key������ �ְ� ���� �󵵼��� value������ �ִ´�
 *  2-1 ���� ���� ���� ���ڸ� ��� �迭�� �־���ϹǷ� �ִ��� ã�� �����Ѵ�.
 * 3. ��� ���ڸ� �� ����� map�� �־��ٸ� value�� �� �ִ񰪰� ���� ������ �켱���� ť�� �ִ´�.
 */
import java.util.*;

class Solution {
    // ���� ���� �Բ� �ֹ��� ��ǰ�޴����� -> �ڽ��丮 �޴��� �Ѵ�.
    // �ִ� ��� �޴�
    static HashMap<String, Integer> map;
    static int m;
    public String[] solution(String[] orders, int[] course) {
        // ������ ���ڿ� �������� ��������� �ϹǷ� �켱���� ť ���
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(int i : course){ // 1. course[i]�� ��ŭ�� orders���� ���ž�
            m = 0; // m 0���� �ʱ�ȭ
            map = new HashMap<>(); // hashmap �ʱ�ȭ 
            for(String s : orders){ // 2. orders���� ���ڿ����� ex)"ABCFG" ���� course[i] ��ŭ  ex) 2
                dfs(i, s,"",0,0); // ���� ���ϱ� course[i] = target, orders���ڿ�, String now = cnt�� ���� ���ڿ��� �ӽ÷� ���� �س��� ����, int cnt = ���� ���� , int index = orders�迭 �ε���
            } //  dfs�� �����ϸ� course[i]�� �̴� ���տ� ���� orders�迭�� ������
             // ex) 2������ �̴°�� -> 2������ �̴� ���յ� �� ���� ���� ���� ��찡 map�� ����Ǿ� ���� �� -> m = ���� ���� ���� ����� �� 
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
        if(cnt == target){ // course[i]�� ��ŭ �̾Ҵٸ�
            char[] ch = now.toCharArray();
            Arrays.sort(ch);
            String tmp = "";
            for(char c : ch){
                tmp += c;
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            m = Math.max(m, map.get(tmp)); // ex) "ABCFG"���� AC�� �̾Ҵٸ� AC�� 
            
        }
        
        for(int i=index; i<word.length(); i++){
            char s = word.charAt(i);
            dfs(target, word, now+s, cnt+1, i+1);
        }
    }
}
