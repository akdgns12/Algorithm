import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1. 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();
        //2. 알파벳 소문자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
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
        
        //3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
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
        
        //4. 마침표가 처음이나 끝에 위치한다면 제거
        if(id.startsWith(".")){
            id = id.substring(1, id.length());
        }
        if(id.endsWith(".")){
            id = id.substring(0, id.length()-1);
        }
        
        //5. 빈 문자열이라면 "a" 대입
        if(id.length() == 0){
            id += "a";
        }
        // 6. 길이가 16이상이면, 첫 15개의 문자를 제외한 나머지 문자를 모두 제거
        if(id.length() >= 16){
            id = id.substring(0, 15);
        }
        if(id.endsWith(".")){
            id = id.substring(0, id.length()-1);
        }
        //7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
         String last = id.charAt(id.length()-1) + "";
        if(id.length() <= 2){
            while(id.length() < 3)
                id += last;
        }
        return id;
    }
}