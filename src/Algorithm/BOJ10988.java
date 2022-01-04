package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 팰린드롬인지 확인하기
// 팰린드롬 = 앞으로 읽을 때와 거꾸로 읽을 대가 똑같은 단어.
public class BOJ10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int ans = 1;
		// 마지막 인덱스와 첫번째 인덱스의 문자가 같은지.. 줄어들면서 같은원리로 비교하는 로직.
		for(int i = input.length()-1; i>=0; i--) {
			char c = input.charAt(i);
			// charAt = String으로 저장된 문자열 중에서 한글자만 선택해서 char 타입을 변환해준다.
			if(c != input.charAt(input.length() - i - 1)) {
				ans = 0;
				break;
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

// 