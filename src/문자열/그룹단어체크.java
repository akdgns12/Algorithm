package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �׷�ܾ�üũ {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// �׷�ܾ� üũ�� �迭 ����
		boolean[] alphabet = new boolean[26];
		
		int count = N;
		// �ݺ��� ���� 
		for(int i = 0; i < N; i++) { 
			// �ܾ� �Է� 
			String str = br.readLine(); 
			// �迭�� false�� ä���ִ´� 
			Arrays.fill(alphabet, false); 
			alphabet[str.charAt(0) - 97] = true; 
			// �ݺ��� ���� 
			for(int j = 1; j < str.length(); j++) { 
				// �յڰ� �ٸ� ��� 
				if(str.charAt(j) != str.charAt(j - 1)) { 
					// �̹� trueó���� �Ǿ������� �׷� �ܾ �ƴϹǷ� count--; 
					if(alphabet[str.charAt(j) - 97] == true) { 
						count--; 
						break; 
						}
					// false�� �Ǿ������� true�� ���� 
					else { 
						alphabet[str.charAt(j) - 97] = true; 
					}
				}
			}
		} 
		// ��� ���
		System.out.print(count);
	}
}
