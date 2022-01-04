package 문자열;

import java.io.IOException;
import java.util.Scanner;

public class 잃어버린괄호 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		/*
		 * 1.-를 기준으로 분리한다
		 * 2.1에서 분리한거를 +를 기준으로 분리해준다.
		 * 3. 처음엔 -가 안붙어 있으므로 더해주고 그 뒤 부터는 쭉 빼준다.
		 */
		String input = sc.nextLine();
		//split은 정규식 표현을 따르기 때문에 +,- 앞에 \\을 해줘야한다
		int result = 0;
		String[] minusArr = input.split("\\-"); 
		for(int i=0; i<minusArr.length; i++) {
			String[] plusArr = minusArr[i].split("\\+");
			for(int j=0; j<plusArr.length; j++) {
				if(i==0) {
					result += Integer.parseInt(plusArr[j]);
				}else {
					result -= Integer.parseInt(plusArr[j]);
				}
			}
		}
		System.out.println(result);
	}	
}