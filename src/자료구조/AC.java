package �ڷᱸ��;

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
		
		// R�� �迭�� �ִ� ������ ���� ������ �Լ� -> �ݺ��� 
		// D�� ù ��° ���ڸ� ������ �Լ� -> ť
		int TC = Integer.parseInt(br.readLine());
		
		while(TC --> 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			/*
			 *  [a,b,c,...,x] �� �����ؾ� �� ���� ���ȣ([, ])�� ����(,) �̴�.
			 *  StringTokenizer�� ���� �����ڸ� ��� �ϰ� �ʹٸ�
			 *  ������ ���ڵ��� ���ļ� �Ѱ��ָ� �ȴ�.
			 *  
			 *  ���� split()�� ����ϰ���� ��� ���Խ����δ�
			 *  String input = br.readLine();
			 *  String[] s = input.subString(1, input.length - 1).split(","); �� ���־�� �Ѵ�.
			 *  
			 *  subString�� �����ʰ�, split("[^0-9]") �Ǵ�, 
			 *  split("[\\[\\]\\,") ���� ���Խ����θ� ���ٸ� ù ��° ���ڰ� ���ԽĿ� �ɷ�
			 *  �� ���ڿ��� ��ȯ�ϰ� �Ǳ� ����
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
