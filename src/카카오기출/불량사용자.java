package 카카오기출;
import java.util.*;

class Solution {
    private int user_len,ban_len;
    private String[] user_id,banned_id;
    private boolean[] visited;//응모자 ID의 방문 여부
    private HashSet<String> set;//불량 사용자 목록 세트
    
    public int solution(String[] User_id, String[] Banned_id) {
        
        user_id = User_id;
        banned_id = Banned_id;
        
        user_len = user_id.length;
        ban_len = banned_id.length;
        
        visited = new boolean[user_id.length];
        
        set = new HashSet<>();
        
        int answer = 0;
        
        dfs(0,"");//DFS 순환 탐색을 통해서 결과값을 HashSet에 저장
        
        answer = set.size();
            
        return answer;
    }
    
    public void dfs(int idx, String str) {//idx는 현재 불량 사용자 배열 인덱스,  
                                          //str은 일치하는 불량 사용자 목록
        
        if (idx == ban_len) {//불량 사용자 배열의 현재 인덱스가 불량 사용자 배열의 사이즈와 같을 때
                             //즉, DFS의 순환이 마지막일 때,
            
            StringBuilder sb = new StringBuilder("");//문자열을 추가하기 때문에 String보다 적합
            
            for (int i = 0; i < user_len; i++) {//응모자 아이디가 목록에 포함되어있다면 sb에 추가
                                                //값을 순서대로 정렬해주기 위함!
                
                if (str.contains(""+i)) sb.append(""+i);
            }
            
            if (!set.contains(sb.toString())) {//정렬된 목록이 HashSet에 포함되어있지 않다면,
                                               //set에 추가시켜준다.
                 //System.out.println(str);
                set.add(sb.toString());
            }
            
            return;
        }
        
        for (int i = 0; i < user_len; i++) {//응모자 아이디 중에서 현재 불량 사용자와 일치하는 값을 찾는다.
            
            if (visited[i]) continue;//이미 목록에 들어있는 값이면 패스한다.
            
            String regex = banned_id[idx].replace("*",".");//정규식 체크 fr*d* -> fr.d.
                
                if (user_id[i].matches(regex)) {//정규식과 일치한다면,
                                                //해당 응모자의 방문 여부를 바꿔주고 DFS 탐색을 한다.
                    
                    visited[i] = true;
                    dfs(idx+1,str+i);
                    visited[i] = false;
                }
        }
        
    }
}