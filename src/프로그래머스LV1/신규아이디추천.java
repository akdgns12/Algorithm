import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1. ��� �빮�ڸ� �ҹ��ڷ� ġȯ
        new_id = new_id.toLowerCase();
        //2. ���ĺ� �ҹ���, ����, ����, ��ħǥ�� ������ ��� ���� ����
        String id = "";
        for(int i=0; i<new_id.length(); i++){
            char ch = new_id.charAt(i);
            if(ch >= '0' && ch <= '9'){
                id += String.valueOf(ch);
            }else if(ch >= 'a' && ch <= 'z'){
                id += String.valueOf(ch);
            }else if(ch == '-' || ch == '_' || ch == '.'){
                id += String.valueOf(ch);
            }
        }
        
        //3. ��ħǥ�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ�� ġȯ
        for(int i=0; i<id.length(); i++){
            if(id.charAt(i) == '.'){
                int j = i+1;
                String dot = ".";
                while(j != id.length() && id.charAt(j) == '.'){
                    dot += ".";
                    j++;
                }
                
                if(dot.length() > 1)
                    id = id.replace(dot, ".");
            
            }
        }
        
        //4. ��ħǥ�� ó���̳� ���� ��ġ�Ѵٸ� ����
        if(id.startsWith(".")){
            id = id.substring(1, id.length());
        }
        if(id.endsWith(".")){
            id = id.substring(0, id.length()-1);
        }
        
        //5. �� ���ڿ��̶�� "a" ����
        if(id.length() == 0){
            id += "a";
        }
        // 6. ���̰� 16�̻��̸�, ù 15���� ���ڸ� ������ ������ ���ڸ� ��� ����
        if(id.length() >= 16){
            id = id.substring(0, 15);
        }
        if(id.endsWith(".")){
            id = id.substring(0, id.length()-1);
        }
        //7. ���̰� 2�� ���϶��, ������ ���ڸ� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ����
         String last = id.charAt(id.length()-1) + "";
        if(id.length() <= 2){
            while(id.length() < 3)
                id += last;
        }
        return id;
    }
}