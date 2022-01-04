import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String temp = "";
        int[] sum = new int[3];
        int cnt = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(c >= '0' && c <= '9'){
                temp += String.valueOf(c);
            }else if(c == 'S' || c == 'D' || c == 'T'){
                int num = Integer.parseInt(temp);
                if(c == 'S'){
                    num = (int)Math.pow(num, 1);
                }else if(c == 'D'){
                    num = (int)Math.pow(num, 2);
                }else if(c == 'T'){
                    num = (int)Math.pow(num, 3);
                }
            sum[cnt] = num;
            cnt++;
            temp = "";
            }else{
                if(c == '#'){
                    sum[cnt-1] *= -1;
                }else{
                    sum[cnt-1] *= 2;
                    if(cnt - 2 >= 0){
                        sum[cnt-2] *= 2;
                    }
                }
            }
        }
        
        for(int i: sum){
            answer += i;
        }
        return answer;
    }
}