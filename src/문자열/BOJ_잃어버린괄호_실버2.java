package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//��ȣ�� ������ ������ ���� ���� �ּҷ� ������
public class BOJ_�Ҿ������ȣ_�ǹ�2 {
	// "-"�� �������� ���ڸ� �����ְ�, +�� �ٽ� �����ְ� ������ ���� �����ش�
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		String[] subtraction = br.readLine().split("-");
		
		
		for(int i=0; i<subtraction.length; i++) {
			int temp = 0;
			//�E������ ������ ��ū�� �������� �и��Ͽ� �ش� ��ū���� ���Ѵ�.
			String[] addition = subtraction[i].split("\\+"); //split ����� �� +�տ� \\�ٿ�����Ѵ�
			//�������� ���� ��ū���� ��� ���Ѵ�.
			for(int j=0; j<addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			//ù ���� ��ū�� ��� temp���� ù ��° ���� �ȴ�.
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}
