package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AC {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// R은 배열에 있는 숫자의 순서 뒤집는 함수 -> 반복문 
		// D는 첫 번째 숫자를 버리는 함수 -> 큐
		int TC = Integer.parseInt(br.readLine());
		
		while(TC --> 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			/*
			 *  [a,b,c,...,x] 중 구분해야 할 것은 대괄호([, ])와 반점(,) 이다.
			 *  StringTokenizer로 여러 구분자를 사용 하고 싶다면
			 *  구분할 문자들을 합쳐서 넘겨주면 된다.
			 *  
			 *  만약 split()을 사용하고싶은 경우 정규식으로는
			 *  String input = br.readLine();
			 *  String[] s = input.subString(1, input.length - 1).split(","); 을 해주어야 한다.
			 *  
			 *  subString을 쓰지않고, split("[^0-9]") 또는, 
			 *  split("[\\[\\]\\,") 같이 정규식으로만 쓴다면 첫 번째 인자가 정규식에 걸려
			 *  빈 문자열을 반환하게 되기 때문
			 *  
			 *  ex)
			 *  str = "[1,2,3,4]";
			 *  strr[] = str.split("[\\[\\]\\,");
			 *  
			 *  result)
			 *  strr[0] = ""
			 *  strr[1] = "1"
			 *  strr[2] = "2"
			 *  strr[3] = "3"
			 *  strr[4] = "4"
			 */
			st = new StringTokenizer(br.readLine(), "[],");
		}
		
	}
}
