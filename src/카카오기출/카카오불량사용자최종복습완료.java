package 카카오기출;
import java.util.*;

class Solution {
    static String[]  user;
    static boolean[] visited;
    static HashSet<String> set; //제재 아이디 목록
    static String[] regex;
    
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        set = new HashSet<>();
       
        regex = new String[banned_id.length];
        
        for(int i=0; i<banned_id.length; i++){
            regex[i] = banned_id[i].replace("*", ".");
        }
        visited = new boolean[user_id.length];
        dfs(0,"");
        return set.size();
    }
    // idx : 불량사용자 배열 인덱스, result : 불량사용자 목록
    public static void dfs(int idx, String result){
        if(idx == regex.length){
            String[] str = result.split(" ");
            Arrays.sort(str);
            
            String newStr = "";
            for(int i=0; i<str.length; i++){
                newStr += str[i];
            }
            
            set.add(newStr);
            return;
        }
        
        //응모자 아이디에서 구할 수 있는 경우의 수
        for(int i=0; i<user.length; i++){
            if(visited[i] == false && user[i].matches(regex[idx])){
                visited[i] = true;
                dfs(idx + 1, result + " " + user[i]);
                visited[i] = false;
            }
        }
    }
}