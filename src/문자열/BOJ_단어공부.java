package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_단어공부 {
/*
 * 알파벳 대소문자로 된 단어가 주어지면,
 * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램
 * 
 */
	/*
	 * <해결방법>
	 * 먼저 각각의 알파벳이 나온 빈도수를 체크하기 위해 alpha[ ] 배열을 만들어주었습니다.
입력받은 str을 한 글자씩 잘라 보면서 alpha 배열에 카운트를 1씩 증가시켜주어 몇 번 등장했는지 알 수 있도록 해주었습니다.
카운팅을 완료한 이후 max와 max_idx를 만들어 max는 가장 높은 빈도수, idx는 max값일 때의 문자를 기록하기 위해 두 변수를 사용했습니다.
추가적으로 max값이 똑같을 경우,  ? 를 출력해주어야 하기 때문에 이를 구분하기 위한 flag 변수를 만들었습니다.
새로운 max값이 등장할 때 if문 안에서 flag를 false로 초기화해주었고,
만약 똑같은 max 값이 발생한다면 flag를 true로 바꿔 그 경우에는 결과값? 를 출력해주었습니다.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		String str = br.readLine().toUpperCase();
		boolean flag = false;
		int max = 0;
		int max_idx = 0;
		
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}
		
		for(int i=0; i<alpha.length; i++) {
			if(max < alpha[i]) {
				max = alpha[i];
				flag = false;
				max_idx = i;
			}else if(max == alpha[i]) {
				flag = true;
			}
		}
		if(flag == true)
			System.out.println("?");
		else
			System.out.println((char)('A' + max_idx));
	}	
}
