package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//괄호를 적절히 지워서 식의 값을 최소로 만들어라
public class BOJ_잃어버린괄호_실버2 {
	// "-"를 기준으로 문자를 나눠주고, +로 다시 나눠주고 각각의 정수 더해준다
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		String[] subtraction = br.readLine().split("-");
		
		
		for(int i=0; i<subtraction.length; i++) {
			int temp = 0;
			//뺼셈으로 나누니 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			String[] addition = subtraction[i].split("\\+"); //split 사용할 떄 +앞에 \\붙여줘야한다
			//덧셈으로 나뉜 토큰들을 모두 더한다.
			for(int j=0; j<addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			//첫 번쨰 토큰인 경우 temp값이 첫 번째 수가 된다.
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}
