package �Ӹ����_�����;
// BOJ 1254
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �Ӹ���� = �Ųٷ� �о ���� ��
 * ���Ѽ��� ���� �̸��� �־����� �Ӹ�������� ����� ���α׷�
 * 
 */
/*
 * 1. �Է¹��� ���ڿ� S�� ������ ���ڿ� R�� ����
 * 2. S�� ���̻��̸鼭 R�� ���λ��� ���ڿ��� ã�´�
 * 3. ���ڿ��� ã����, �� �� R�� ���� �κ��� S�ڿ� ���̸� �Ӹ������ �ȴ�
 * 4. �̷� ��찡 �������� �ִٸ�, �� �� �Ӹ������ ���̰� �ּҰ� �Ǵ� ��츦 ã���� �ȴ�.
 * 
 */
public class �Ӹ���Ҹ���� {
	
	static char[] S,R;
	static int len;
	static int cnt = 1001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		S = input.toCharArray(); // toCharArray ���ڿ��� char�� �迭�� �ٲ۴�.
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
