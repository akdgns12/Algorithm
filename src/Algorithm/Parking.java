package Algorithm;

import java.util.Scanner;

public class Parking {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[100];
		int start, end, max = 0;
		int min = 0;
		int sum = 0;
		
		for(int i=0; i<3; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			min = Math.min(min, start); // ���� ���� �����ϴ� �ð�, Math.min or Math.max ������ �� �� ���� ��, ū �� ����
			max = Math.max(max, end);	// ���� �ʰ� ������ �ð�
			
			//Ʈ�� �Ѵ��� start ~ end �ð����� �迭�� +1 ���ش�.
			for(int j = start; j<end; j++) {
				arr[j]++;
			}
		}
		//���� ó�� ���� �ð����� ���� ������ �ð����� ����� �Ѵ�.
		for(int i = min; i<max; i++) {
			switch(arr[i]) {
			case 1:
				sum = sum + A*arr[i];
				break;
			case 2:
				sum = sum + B*arr[i];
				break;
			case 3:
				sum = sum + C*arr[i];
				break;
			}
		}
	System.out.println(sum);
	}
}

/*
 * ����̴� Ʈ���� �� �� �� ������ �ִ�. ������ Ʈ���� �����ϴµ� ����� �󸶳� �ʿ�����
 * �˾ƺ����� �Ѵ�. ����̰� �̿��ϴ� �������� �����ϴ� Ʈ���� ���� ���� ���������
 * ������ �ش�. Ʈ���� �� �� ������ ���� 1�п� �� ��� A���� ���� �Ѵ�. �� �븦 ������ ��
 * �� 1�п� �� ��� B��, �� �븦 ������ ���� 1�п� �� ��� C���� ���� �Ѵ�.
 * A,B,C�� �־�����, ������� Ʈ���� �����忡 ������ �ð��� �־����� ��, �����������
 * �󸶸� ���� �ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� : ù° �ٿ� �������� ������ ���� ��� A,B,C�� �־�����(1<=C<=B<=A<=100)
 * ���� ���� �ٿ��� �� ������ �־�����. �� ������ ����̰� ������ �ִ� Ʈ���� �����忡 ������
 * �ð��� �����忡�� ���� �ð��̴�. ������ �ð��� �׻� ���� �ð����� �ռ���. �Է����� �־�����
 * �ð��� 1�� 100���� �̴�.
 * ��� : ù ° �ٿ� ����̰� �����ϴ� ���� ����� ����Ѵ�.
 * */
 