package 정규표현식_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23629 {
    

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] math = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String str = br.readLine();

        for (int i = 0; i < math.length; i++) {
            if (str.contains(math[i])) {
                str = str.replace(math[i], num[i]);
            }
        }

   
        // System.out.println(str);        
        
        String numAnswer = str; // 가능한 수식
        System.out.println(str);
        str = str.replace("=", "");
        
    }
}
