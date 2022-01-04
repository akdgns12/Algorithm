package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1411비슷한단어 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			int[] alpha = new int[26];
			int cnt = 0;
			for(int j=0; j<temp.length; j++) {
				int idx = temp[j] - (int)'a';
				if(alpha[idx] == 0)
					alpha[idx] = ++cnt;
				sb.append((char)(alpha[idx] - 1 + (int)'a'));
			}
			word[i] = sb.toString();
		}
		
		Arrays.sort(word);
		
		int result = 0;
		for(int i=0; i<word.length-1; i++) {
			for(int j=i+1; j<word.length; j++) {
				if(word[i].equals(word[j]))
					result++;
				else
					break;
			}
		}
		System.out.println(result);
	}
}

