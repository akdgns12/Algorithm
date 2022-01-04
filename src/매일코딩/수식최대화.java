package 매일코딩;

import java.util.*;

class 수식최대화 {
    static long answer = Long.MIN_VALUE;
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<String> opList = new ArrayList<>();
    static String[] oper = {"+", "-", "*"};
    static String[] output = new String[3]; // 순열 결과 담을 배열
    static boolean[] visited = new boolean[3];
    
    public long solution(String expression) {
        String n = "";
        for(int i=0; i<expression.length(); i++){
            char exp = expression.charAt(i);
            if(exp >= '0' && exp <= '9'){
                n += exp;
            }else{
                numList.add(Long.parseLong(n));
                opList.add(exp + "");
                n = "";
            }
        }
        
        // 마지막 숫자 삽입
        numList.add(Long.parseLong(n));
        
        // 순열 만들기
        perm(0, oper.length);
        
        return answer;
    }
    
    public static void perm(int depth, int r){
        if(depth == r){
            solve(); // 연산
            
            return;
        }
        
        for(int i=0; i<oper.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = oper[i];
                perm(depth+1, r);
                visited[i] = false;
            }
        }
    }
    
    // 연산
    public static void solve(){
        // 연산자 우선순위에 따른 값을 얻기위해 List 복사
        ArrayList<String> oper = new ArrayList<>();
        oper.addAll(opList);
        
        ArrayList<Long> num = new ArrayList<>();
        num.addAll(numList);
        
        for(int i=0; i<output.length; i++){
            String curOper = output[i]; // 현재 우선순위 연산자
            
            for(int j=0; j<oper.size(); j++){
                if(oper.get(j).equals(curOper)){
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    
                    long result = calc(n1, n2, curOper);
                    
                    // 주의할 점 : list에서 
                    /*
                    num.remove(j);
                    num.remove(j+1);
                    이런 순서로 제거하게 되면 j가 두번 지워지는 것
                    j+1부터 지우고 j를 지워야한다.
                    */
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j); // 연산자 삭제
                    
                    // ArrayList에 add()메소드로 특정 인덱스에 삽입 가능 알아둬야할 표현
                    num.add(j, result); // 연산결과 넣어주기
                    
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }

        // 수식 계산
        public static long calc(long n1, long n2, String curOper){
            long res = 0;
            switch(curOper){
                case "+":
                    res = n1 + n2;
                    break;
                case "-" : 
                    res = n1 - n2;
                    break;
                case "*":
                        res = n1 * n2;
                    break;
            }
            
            return res;
        }
    }
