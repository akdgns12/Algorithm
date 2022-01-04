package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 그룹단어체크 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 그룹단어 체크용 배열 선언
		boolean[] alphabet = new boolean[26];
		
		int count = N;
		// 반복문 시작 
		for(int i = 0; i < N; i++) { 
			// 단어 입력 
			String str = br.readLine(); 
			// 배열을 false로 채워넣는다 
			Arrays.fill(alphabet, false); 
			alphabet[str.charAt(0) - 97] = true; 
			// 반복문 시작 
			for(int j = 1; j < str.length(); j++) { 
				// 앞뒤가 다른 경우 
				if(str.charAt(j) != str.charAt(j - 1)) { 
					// 이미 true처리가 되어있으면 그룹 단어가 아니므로 count--; 
					if(alphabet[str.charAt(j) - 97] == true) { 
						count--; 
						break; 
						}
					// false로 되어있으면 true로 변경 
					else { 
						alphabet[str.charAt(j) - 97] = true; 
					}
				}
			}
		} 
		// 결과 출력
		System.out.print(count);
	}
}
