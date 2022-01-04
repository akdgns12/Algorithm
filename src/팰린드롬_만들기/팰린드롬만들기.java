package 팰린드롬_만들기;
// BOJ 1254
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 팰린드롬 = 거꾸로 읽어도 같은 뜻
 * 임한수의 영어 이름이 주어지면 팰린드롬으로 만드는 프로그램
 * 
 */
/*
 * 1. 입력받은 문자열 S를 뒤집은 문자열 R을 생성
 * 2. S의 접미사이면서 R의 접두사인 문자열을 찾는다
 * 3. 문자열을 찾고나면, 이 때 R의 남은 부분을 S뒤에 붙이면 팰린드롬이 된다
 * 4. 이런 경우가 여러개가 있다면, 그 중 팰린드롬의 길이가 최소가 되는 경우를 찾으면 된다.
 * 
 */
public class 팰린드롬만들기 {
	
	static char[] S,R;
	static int len;
	static int cnt = 1001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		S = input.toCharArray(); // toCharArray 문자열을 char형 배열로 바꾼다.
		R = new StringBuffer(input).reverse().toString().toCharArray();
		
		len = S.length;
		
		for(int i=0; i<len; i++) {
			
			int tempCnt = 0;
			boolean flag = true;
			
			for(int j=0; j<len - i; j++) {
				if(S[i+j] == R[j]) {
					tempCnt++;
					
				}else {
					flag = false;
					break;
				}
			}
			
			if(tempCnt > 0 && flag) {
				tempCnt = len - tempCnt;
				
				cnt = cnt > tempCnt ? tempCnt : cnt;
			}
		}
		
		System.out.println(len+cnt);
	}
}
