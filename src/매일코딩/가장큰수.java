package �����ڵ�;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // ���ڸ� ���ڿ��� ��ȯ
        String[] result = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            result[i] = String.valueOf(numbers[i]);
        }
        
        // ����(���ٽ� �̿�)
        Arrays.sort(result, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        /*
        a.compareTo(b)
        - �տ������� ���ϴ� �ٸ� ���ڿ��� ������ 'a-b' ������ �ش� ������ �ƽ�Ű�ڵ� ���� �� ���(int)�� ����
        
        �� �޼ҵ忡�� a,b������ ���� ��(b+a).compareTo(a+b)�� ���� ��� 'b+a'�� �� ũ�ٸ� �ڸ��� �ٲ��ָ� �ǹǷ� �Ʒ��� ���� �ۼ����ָ� �ȴ�
        */
        
        // 0�� ������ �ִ� �迭�� ��� �ϳ��� 0�� ����
        if(result[0].equals("0")){
            return "0";
        }
        
        String answer = "";
        // ���ĵ� ���� �ϳ��� ��ġ��
        for(String a : result){
            answer += a;
        }
        
        
        return answer;
    }
}