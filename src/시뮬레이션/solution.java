package 시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        
        boolean[] answer = {};
        commands  = new String[101];
        program = br.readLine();
        String[] flag_name;
        String[] flag_argument_type;
        
        for(int i=0; i<flag_name.length; i++) {
        	for(int j=0; j<flag_argument_type.length; j++) {
        		flag_name[i] = br.readLine();
        		flag_argument_type[j] = br.readLine();
        		
        		flag_rules[i] = flag_name[i] + flag_argument_type[j];
        		for(int k=0; k<commands.length; k++) {
        			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        			commands[k] = st1.nextToken();
        			if(commands[k].contains(flag_name[i])) {
        				if(commands[k].contains("-n")) {
        					//다음 토큰이 숫자여야한다
        					char tmp;
        					boolean output = true;
        					for(int l=0; l<commands[k].length(); l++	) {
        						tmp = commands[k].charAt(i);
        						
        						if(Character.isDigit(tmp) == false) {
        							output = false;
        						}
        				}
        				}else if(commands[k].contains("-s")) {
        					//다음 토큰이 문자
        					
        				}else if(commands[k].contains("-e")) {
        					//다음 토큰이 null
        				} answer[i] = true;
        			}else answer[i] = false;
        		}
        	}
        }
      
        return answer;
    }
}