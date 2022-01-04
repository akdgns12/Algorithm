package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *  pi�迭 ���� ����
 *  j�� ���λ��� ��ġ, i�� ���̻��� ��ġ
 *  �⺻���� ���۰��� - j��i�� ��ġ���� ���� j�� i�� ��ġ���� �ʾ��� ���� ��츦 ������ �����غ��� �Ѵ�.
 *  
 *  - j ��ġ�� ���ڿ��� i ��ġ�� ���ڿ��� ��ġ���� ��� : �� ��ġ���� ���λ�� ���̻簡 ��ġ�ߴٴ� ���̹Ƿ�
 *  ���� ��ġ�� j�� i�� ���ڿ��� ��ġ�ϴ��� �˻��ؾ� �Ѵ�. ���� j�� i�� ��ġ�� ��ĭ�� ���������� �̵����ش�
 *  - j ��ġ�� ���ڿ��� i��ġ�� ���ڿ��� ��ġ���� ���� ��� : ���λ�� ���̻簡 ��ġ���� �ʴ´ٴ� ���̹Ƿ�
 *  �ٽ� �˻縦 �ؾ��ϴµ� �̶� �ƿ� ó������ ���ư� ���� ������ ��ȿ�����̴�. �׷��� ���±��� ��ġ�ߴ� ����������
 *  �ٽ� �˻縦 �ϴ� ���� �����մϴ�. ���� pi�迭�� �����Ͽ� j�� ��ġ�� pi[j-1]���� ����Ű�� ��ġ�� �̵� ���Ѻ��ϴ�.
 *  j-1�� ������ �ּ� j-1��ġ������ ���λ�� ���̻簡 ��ġ�ߴٴ� ���̹Ƿ� �̵��� �ּ�ȭ�� �� �ֱ� �����Դϴ�. �̵��� ��Ų �� 
 *  �ٽ� ��ġ�ϴ��� �˻��Ѵ�.
 *   */
/*
 * KMP �˰��� Ȱ�빮��
 * -KMP�˰����̶�
 * �ð����⵵�� O(N+M)���� ���Ʈ���� O(NM)���� �ſ� ����
 * ���λ�� ���̻縦 �˾ƾ���.
 * 
 * origin�� ���ڿ��� i�� ���� ���ڸ� ����Ű��, pattern�� ���ڿ��� j�� ���� ���ڸ� ����Ų��
 * origin[i] == pattern[j]�̸� i�� j ��� 1�� ���Ѵ�
 * ��ġ���� �ʰ� j�� 0�� �ƴ϶�� j = pi[j-1]�� ���� �� ������ ���ڷ� ���ư���(���� ���ڿ��� ���̻�� ���λ簡 ��ġ�ߴ� �κб���
 * ��ġ���� �ʰ� j�� 0�̶�� i�� 1�� ���Ѵ�.
 * ex)
 * <banana�� ���λ�>



b

ba

ban

bana

banan

banana



�� 6���� banana�� ���λ�(prefix) �Դϴ�.



<banana�� ���̻�>

a

na

ana

nana

anana

banana



�� 6���� banana�� ���̻�(suffix) �Դϴ�.

�ι�°�� pi�迭�Դϴ�.
pi[i]�� �־��� ���ڿ��� 0~i������ �κ� ���ڿ� �߿��� prefix == suffix�� �� �� �ִ�
�κ� ���ڿ� �߿��� ���� �� ���� ���� (�� �� prefix�� 0~i������ �κ� ���ڿ��� ������ �ȵȴ�.)



��ó: https://bowbowbow.tistory.com/6 [�۸۸�]
 */
// �⺻ �˰��� �ڵ�
//public class KMP{
//	public static int result, pi[];
//	public static String origin, pattern;
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		origin = br.readLine();
//		pattern = br.readLine();
//		
//		pi = new int[pattern.length()];
//		getPi();
//		KMP();
//	}
//	
//	private static void getPi() {
//		int j = 0;
//		for(int i=1; i<pattern.length(); i++) {
//			//�´� ��ġ�� ���ö����� j-1ĭ�� ���� �κ� ��ġ�� �̵�
//			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
//				j = pi[j-1]
//			}
//			//�´� ���
//			if(pattern.charAt(i) == pattern.charAt(j)) {
//				//���� ���ڿ��� ���� ���̴� j�� ��ġ +1
//				pi[i] = ++j;
//			}
//		}
//	}
//	
//	private static void KMP() {
//		int j = 0;
//		for(int i=0; i<origin.length(); i++) {
//			//�´� ��ġ�� ���Ë����� j-1ĭ�� ���� �κ� ��ġ�� �̵�
//			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
//				j = pi[j-1];
//			}
//			//�´� ���
//			if(origin.charAt(i) == pattern.charAt(j)) {
//				if(j == pattern.length() -1) {
//					result = 1;
//					break;
//				}
//				//�¾����� ������ ������ �ʾҴٸ� j�� �ϳ� ����
//				else
//					++j;
//					
//			}
//		}
//		System.out.println(result);
//	}
//}

public class KMP�˰���_�κй��ڿ� {
	
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String origin = br.readLine();
		String pattern = br.readLine();
		//P�� S�� �κ� ���ڿ��̸� return 1, or 0
		
		KMP(origin, pattern);
		System.out.println(answer);
	}
	
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for(int i=1; i<pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
	
	public static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for(int i=0; i<origin.length(); i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					answer = 1;
					break;
				}
				else
					j++;
			}
		}
	}

}