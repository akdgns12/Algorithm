package Greedy;

import java.io.IOException;
import java.util.Scanner;
// 잃어버린 괄호
/* 핵심은 입력받은 문자열을 -로 분리
 * 분리한 문자열을 차례대로 순회하며 +로 분리
 * 분리한 문자열을 덧셈계산해준 뒤
 * 양수인 첫번째 문자를 제외해놓고 빼기
 */
public class BOJ1541 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.nextLine();
		String[] str = temp.split("\\-");
		
		int answer = 0;
		for(int i=0; i<str.length; i++) {
			String[] subStr = str[i].split("\\+");
			
			int calc = 0;
			for(String item : subStr) {
				calc += Integer.parseInt(item);
			}	
			
			if(i==0) {
				answer += calc;
			}	else {
				answer -= calc;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}

//문자열 분리 2가지 메소드
/*
 * split[] 메소드
 * int sum = Integer.MAX_VALUE;
 * String[] subtraction = br.readLine().split("-");
 * 
 * for(int i = 0; i<subtraction.length; i++){
 * int temp = 0;
 * 
 * //뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
 * String[] addition = subtraction[i].split("\\+");
 * 
 * //덧셈으로 나뉜 토큰들을 모두 더한다.
 * for(int j=0; j<addition.length; j++){
 * temp+=Integer.parseInt(addition[j]);
 * }
 * 
 * 	//첫 번째 토큰인 경우 temp값이 첫 번째 수가 됨
 * if(sum==Integer.MAX_VALUE){
 * sum = temp;
 * }else{
 * sum-=temp;
 * }
 * }
 * 
 * StringTokenizer 메소드
 * int sum = Integer.MAX_VALUE; //초기상태 여부 확인을 위한 값으로 설정
 * StringTokenizer subtraction = new StringTokenizer(br.readLine(),"-");
 * 
 * while(subtraction.hasMoreTokens()){
 * int temp=0;
 * 	// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
 * StringTokenizer addition = new StringTokenizer(subtraction.nextToken(),"+");
 * 
 * while(addition.hasMoreTokens()){
 * temp+=Integer.parseInt(addition[j]);
 * }
 * 
 * 	//첫 번째 토큰인 경우 temp값이 첫 번째 수가 됨
 * if(sum==Integer.MAX_VALUE){
 * sum = temp;
 * }else{
 * sum-=temp;
 * }
 * }
 */
