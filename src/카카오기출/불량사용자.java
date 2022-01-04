package īī������;
import java.util.*;

class Solution {
    private int user_len,ban_len;
    private String[] user_id,banned_id;
    private boolean[] visited;//������ ID�� �湮 ����
    private HashSet<String> set;//�ҷ� ����� ��� ��Ʈ
    
    public int solution(String[] User_id, String[] Banned_id) {
        
        user_id = User_id;
        banned_id = Banned_id;
        
        user_len = user_id.length;
        ban_len = banned_id.length;
        
        visited = new boolean[user_id.length];
        
        set = new HashSet<>();
        
        int answer = 0;
        
        dfs(0,"");//DFS ��ȯ Ž���� ���ؼ� ������� HashSet�� ����
        
        answer = set.size();
            
        return answer;
    }
    
    public void dfs(int idx, String str) {//idx�� ���� �ҷ� ����� �迭 �ε���,  
                                          //str�� ��ġ�ϴ� �ҷ� ����� ���
        
        if (idx == ban_len) {//�ҷ� ����� �迭�� ���� �ε����� �ҷ� ����� �迭�� ������� ���� ��
                             //��, DFS�� ��ȯ�� �������� ��,
            
            StringBuilder sb = new StringBuilder("");//���ڿ��� �߰��ϱ� ������ String���� ����
            
            for (int i = 0; i < user_len; i++) {//������ ���̵� ��Ͽ� ���ԵǾ��ִٸ� sb�� �߰�
                                                //���� ������� �������ֱ� ����!
                
                if (str.contains(""+i)) sb.append(""+i);
            }
            
            if (!set.contains(sb.toString())) {//���ĵ� ����� HashSet�� ���ԵǾ����� �ʴٸ�,
                                               //set�� �߰������ش�.
                 //System.out.println(str);
                set.add(sb.toString());
            }
            
            return;
        }
        
        for (int i = 0; i < user_len; i++) {//������ ���̵� �߿��� ���� �ҷ� ����ڿ� ��ġ�ϴ� ���� ã�´�.
            
            if (visited[i]) continue;//�̹� ��Ͽ� ����ִ� ���̸� �н��Ѵ�.
            
            String regex = banned_id[idx].replace("*",".");//���Խ� üũ fr*d* -> fr.d.
                
                if (user_id[i].matches(regex)) {//���Խİ� ��ġ�Ѵٸ�,
                                                //�ش� �������� �湮 ���θ� �ٲ��ְ� DFS Ž���� �Ѵ�.
                    
                    visited[i] = true;
                    dfs(idx+1,str+i);
                    visited[i] = false;
                }
        }
        
    }
}