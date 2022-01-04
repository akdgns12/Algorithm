package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ���ڿ�
// ��, ���ڿ� S�ȿ��� ���ڿ� W�� ���� �� �ϳ��� �κ� ���ڿ��� ����ִ�
// ��� ����� ���� ����϶�

// w�� ���ڵ�� ���� �� �ִ� ��� ���� ���� �� �˻��ϸ� �ð��ʰ�
// �˻��ؾ��ϴ� ���ڿ��� ���̴� �����̱� ������ �����̵� ������ ����� ����Ͽ�
// ������ �˻�
public class �����ص� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int g = Integer.parseInt(st.nextToken()); // W�ܾ��� ����
		int s = Integer.parseInt(st.nextToken()); // S�ܾ��� ����
		String W = br.readLine(); // W�ܾ�
		String S = br.readLine(); // S�ܾ�
		
		int[] word = new int[26*2]; // �빮�� 26, �ҹ��� 26
		int[] sentence = new int[26*2];
		
		for(int i=0; i<g; i++) {
			if(W.charAt(i) >= 'a' && W.charAt(i) <= 'z') {
				word[W.charAt(i) - 'a'] += 1;
			}else {
				word[W.charAt(i) - 'A' + 26] += 1;
			}
		}
		
		int start= 0;
		int length = 0;
		int count = 0;
		
		// ���ڿ� S�� ���� �����̵� ������
		for(int i=0; i<s; i++) {
			if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
				sentence[S.charAt(i) - 'a'] += 1;
			}else {
				sentence[S.charAt(i) -'A' + 26] += 1;
			}
			length += 1;
			
			if(length == g) {
				if(word[i] == sentence[i]) {
					count += 1;
				}
				if(sentence[start] >= 'a' && sentence[start] <= 'z') {
					sentence[S.charAt(i) - 'a'] -= 1;
				}else {
					sentence[S.charAt(i) - 'A' + 26] -= 1;
				}
				start += 1;
				length -= 1;
			}
	
		} // end for
	}
}
