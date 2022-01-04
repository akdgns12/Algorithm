package �����ڵ�;

import java.util.*;

class �����ִ�ȭ {
    static long answer = Long.MIN_VALUE;
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<String> opList = new ArrayList<>();
    static String[] oper = {"+", "-", "*"};
    static String[] output = new String[3]; // ���� ��� ���� �迭
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
        
        // ������ ���� ����
        numList.add(Long.parseLong(n));
        
        // ���� �����
        perm(0, oper.length);
        
        return answer;
    }
    
    public static void perm(int depth, int r){
        if(depth == r){
            solve(); // ����
            
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
    
    // ����
    public static void solve(){
        // ������ �켱������ ���� ���� ������� List ����
        ArrayList<String> oper = new ArrayList<>();
        oper.addAll(opList);
        
        ArrayList<Long> num = new ArrayList<>();
        num.addAll(numList);
        
        for(int i=0; i<output.length; i++){
            String curOper = output[i]; // ���� �켱���� ������
            
            for(int j=0; j<oper.size(); j++){
                if(oper.get(j).equals(curOper)){
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    
                    long result = calc(n1, n2, curOper);
                    
                    // ������ �� : list���� 
                    /*
                    num.remove(j);
                    num.remove(j+1);
                    �̷� ������ �����ϰ� �Ǹ� j�� �ι� �������� ��
                    j+1���� ����� j�� �������Ѵ�.
                    */
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j); // ������ ����
                    
                    // ArrayList�� add()�޼ҵ�� Ư�� �ε����� ���� ���� �˾Ƶ־��� ǥ��
                    num.add(j, result); // ������ �־��ֱ�
                    
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }

        // ���� ���
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
