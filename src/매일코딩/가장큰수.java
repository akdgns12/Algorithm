package 매일코딩;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] result = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            result[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬(람다식 이용)
        Arrays.sort(result, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        /*
        a.compareTo(b)
        - 앞에서부터 비교하다 다른 문자열이 나오면 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴
        
        위 메소드에서 a,b순서로 있을 때(b+a).compareTo(a+b)를 했을 경우 'b+a'가 더 크다면 자리를 바꿔주면 되므로 아래와 같이 작성해주면 된다
        */
        
        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if(result[0].equals("0")){
            return "0";
        }
        
        String answer = "";
        // 정렬된 문자 하나로 합치기
        for(String a : result){
            answer += a;
        }
        
        
        return answer;
    }
}