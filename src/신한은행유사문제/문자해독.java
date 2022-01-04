package �����������繮��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �����ص� {
	// BOJ 1593 / �����̵������� / S�� ��� �ε������� ��� g ũ�⸸ŭ ���ؼ� ���Ѵ�.
	static String w, s;
	static int wLen; // w�� ����
	static int sLen; // ���ڿ� s�� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		wLen = Integer.parseInt(st.nextToken());
		sLen = Integer.parseInt(st.nextToken());
		
		char[] w = br.readLine().toCharArray();
		char[] s = br.readLine().toCharArray();
		
		/*
		 * w�� ������ ���ĺ��� ����Ƚ���� �� ���ĺ��� �ش��ϴ� ĭ�� +1�� ���ش�.
		 * �׸��� s�� ó������ w���̸�ŭ ��� ���ϴµ�
		 * �� ������ w�� s�� �����ϴ� ���ĺ��� Ƚ���� ��ġ�Ѵٸ� w�� ������ s��
		 * ���� �� �ִٴ� ���̱� ������ answer++;
		 */
		/*
		 * �����̵� ������
		 * w�� ���̸�ŭ s�� ���ڿ� ������ �����̵� ������ �س�����.
		 */
		
		// �빮��, �ҹ��� �� 52�� �� �迭 
		int[] wAlpha = new int[52];
		// ���ĺ� ������� ��ŷ ���ش�.
		for(int i=0; i<wLen; i++) {
			if(w[i] < 'a') wAlpha[w[i] - 'A']++;
			else wAlpha[w[i] - 'a' + 26]++;
		}
	
		int[] sAlpha = new int[52];
		int next, len = 0, answer = 0, from = 0;
		// ���ڿ� m�� ���ĺ� ��ŷ
		for(int i=0; i<sLen; i++) {
			if(s[i] < 'a') // �빮���� ���
				next = s[i] - 'A';
			else
				next = s[i] - 'a' + 26;
			
			len++;
			sAlpha[next]++;
			if(len == wLen) { // ���̸� wLen��ŭ �÷� �ְ� �� ���̰� ���� ��
				if(same(wAlpha, sAlpha)) answer++;
				
				// �� �۾��� �����̵� ������ ���� �� ���ϱ� ���� 
				// �����̵� ������ �պκ� �ø��� �޺κ� ���̴� �۾�
				// ���� len���� ������� �����̵� ������
				// sAlpha from�ε����� ���ְ� from �ϳ� �������Ѽ�
				// �����̵� ������ ������ �������� �̵��� �� �ֵ��� ���ش�.
				if(s[from] < 'a') sAlpha[s[from] - 'A']--;
				else sAlpha[s[from] - 'a' + 26]--;
				from++;
				len--;
			}
		}
	}
	
	public static boolean same(int[] w, int[] s) {
		for(int i=0; i<52; i++)
			if(w[i] != s[i]) return false;
		return true;
	}

}
