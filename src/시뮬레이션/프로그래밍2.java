package 시뮬레이션;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 프로그래밍2 {
	static String[] checkPw(String inp_str) {
		ArrayList<String> answer = new ArrayList<String>();
		//1
		if(inp_str.length() < 8 || inp_str.length() > 15) 
			answer.add("1");
		
		try {
			//2
			Pattern pAlphabetLow = null;
			Pattern pAlphabetUp = null;
			Pattern pNumber = null;
			Pattern pSpecialChar = null;
			//4
			Pattern pfourChar = null;
			//5
			Pattern pfiveChar = null;
			Matcher match;
			int cnt = 0;
			
			pAlphabetLow = Pattern.compile("[a-z]");
			pAlphabetUp = Pattern.compile("[A-Z]");
			pNumber		= Pattern.compile("[0-9]");
			pSpecialChar = Pattern.compile("\\p[Punct}");
			pfourChar = Pattern.compile("(\\p[Alnum})\\1{2,}");
			
			match = pAlphabetLow.matcher(inp_str);
			if(match.find()) cnt++;
			match = pAlphabetUp.matcher(inp_str);
			if(match.find()) cnt++;
			match = pNumber.matcher(inp_str);
			if(match.find()) cnt++;
			match = pSpecialChar.matcher(inp_str);
			if(match.find())cnt++; answer.add("2");
			
			match = pfourChar.matcher(inp_str);
			if(match.find()) 
				answer.add("4");
			
			match = pfiveChar.matcher(inp_str);
			if(match.find()) answer.add("5");
			
			//3
			if(cnt<3) {
				 answer.add("3");
			}else if(cnt>=3) answer.add("0");
			
		}catch(Exception e) {
			answer = "99";
		}
		return answer;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inp_str = br.readLine();
		
		checkPw(inp_str);
	}
}
