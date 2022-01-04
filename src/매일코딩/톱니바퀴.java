package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��Ϲ���
 * �� 8���� ��ϸ� ������ �ִ� ��Ϲ��� 4���� �Ϸķ� ������ �ִ�.
 * ��ϴ� N�� �Ǵ� S�� �� �ϳ�
 * ��Ϲ����� �ٸ� ��Ϲ����� ���� �´�� ����� ���� �ٸ��� ���� �ݴ�������� ȸ���ϰ� ��
 * ���� ���̶�� ȸ������ �ʴ´�.
 */
public class ��Ϲ���{
	
	// ��Ϲ��� 4���� ��� ����(12�� ������� ����)(N���� 0, S���� 1)
	static int[][] gear = new int[5][9]; // [1~4][1~8]
	static int k; // ȸ��Ƚ��
	static int gearIdx; // ȸ���� ���(1~4)
	static int dir; // �Է� ���� �� ȸ������
	static int[] gearDir = new int[5]; // �� ��Ϲ������� ȸ�� ����(�ð���� : 1, �ݽð���� : -1, ���� : 0)
	static int result; // �� ��Ϲ����� ������ ��
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i=1; i<=4; i++) {
			String s = br.readLine();
			for(int j=1; j<=8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		// ��Ϲ��� ȸ��
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gearIdx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			caculateGearDir();
			rotateGear();
		}
		
		result = 0;
		calculateScore();
		System.out.println(result);
	}
	
	// �Է¹��� gearIdx, dir�� �̿��� �ٸ� ��� ȸ�� ���� ���ϱ�
	public static void caculateGearDir() {
		//�ʱ�ȭ
		for(int i=1; i<=4; i++) {
			gearDir[i] = 0;
		}
		
		// �ش� gear���� �Է¹��� dir������ ����
		gearDir[gearIdx] = dir;
		
		// �ٸ� ��Ϲ����� ������ �κ� 3, 7
		switch(gearIdx) {
		
			// ��Ϲ��� 1�� ȸ���� ��� 1->2->3->4
		case 1:
			// ��Ϲ��� 1�� ȸ���ϰ� �¹��� �κ��� ���� �ٸ� �� ��Ϲ���2 �ݴ�������� ȸ��
			if(gearDir[1] != 0 && gear[1][3] != gear[2][7])
				gearDir[2] = gearDir[1] * -1;
			
			// ��� 2�� ��� 3
			if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
				gearDir[3] = gearDir[2] * -1;
			
			// ��� 3�� ��� 4
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			
			break;
		
			// ��� ���� 2�� ȸ���ϴ� ��� 2->3->4 , 2-> 1
			
		case 2: 
			// ��� 2�� 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[3] = gearDir[2] * -1;
			
			// ��� 2�� 3
			if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
				gearDir[3] = gearDir[2] * -1;
			
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			break;
			
			// ��� ���� 3�� ȸ���ϴ� ��� 3->4 , 3->2->1
		case 3:
			// ��� 3�� 4
			if(gearDir[3] != 0 && gear[3][3] != gear[4][7])
				gearDir[4] = gearDir[3] * -1;
			
			// ��� 3�� 2
			if(gearDir[3] != 0 && gear[3][7] != gear[2][3])
				gearDir[2] = gearDir[3] * -1;
		
			// ��� 2�� 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[1] = gearDir[2] * -1;
			break;
			
			// ��Ϲ��� 4�� ȸ���ϴ� ��� 4->3->2->1
		case 4:
			// ��� 4�� 3
			if(gearDir[4] != 0 && gear[4][7] != gear[3][3])
				gearDir[3] = gearDir[4] * -1;
			
			// ��� 3�� 2
			if(gearDir[3] != 0 && gear[3][7] != gear[2][3])
				gearDir[2] = gearDir[3] * -1;
			
			// ��� 2�� 1
			if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
				gearDir[1] = gearDir[2] * -1;
			
			break;
		}
	}
	
	// �� ��Ϲ��� �� gearDir�� �°� ȸ��
	public static void rotateGear() {
		int[] tempGear;
		
		// ��� ��Ϲ��� gearDir�� �°� ȸ��������
		for(int i=1; i<=4; i++) {
			
			tempGear = new int[9];
			
			// �ش� ��Ϲ����� ȸ�� ���� ��(0)�� �Ѿ
			if(gearDir[i] == 0)
				continue;
			
			// �ش� ��Ϲ����� �ð����(1)
			if(gearDir[i] == 1) {
				tempGear[1] = gear[i][8];
			for(int j=2; j<=8; j++) {
				tempGear[j] = gear[i][j-1];
			}
		}
		
		// �ش� ��Ϲ����� �ݽð����(-1)
		else if(gearDir[i] == -1) {
			for(int j=1; j<=7; j++) {
				tempGear[j] = gear[i][j+1];
			}
			tempGear[8] = gear[i][1];
		}
		
		// ȸ���� �迭�� gear�� �ٽ� ��������
		gear[i] = tempGear.clone();
	}
}
	// K�� ȸ����Ų ���Ŀ� �� ��Ϲ��� ������ �� ���
		//1�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 1��
		//2�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 2��
		//3�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 4��
		//4�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 8��
	public static void calculateScore() {
		if(gear[1][1] == 1)
			result += 1;
		if(gear[2][1] == 1)
			result += 2;
		if(gear[3][1] == 1)
			result += 4;
		if(gear[4][1] == 1)
			result += 8;
	}
}