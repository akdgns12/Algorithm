package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ��Ϲ���
// �� 8���� ��ϸ� ������ �ִ� ��Ϲ��� 4���� �Ϸķ� ������ �ִ�.
// ��ϴ� N�� �Ǵ� S�� �� �ϳ�
// ��Ϲ����� �ٸ� ��Ϲ����� ���� �´�� ����� ���� �ٸ��� ���� �ݴ�������� ȸ���ϰ� ��

public class ����_��Ϲ���2 {
	
	// ��Ϲ��� 4���� ��� ����(12�� ������� ����) (N���� 0, S���� 1)
	static int K; // ȸ�� Ƚ��
	static int[][] gear = new int[4][8]; // [1~4][1~8]
	static int[] gearDir = new int[4]; // �� ��Ϲ������� ȸ�� ����(�ð���� : 1, �ݽð� ���� : -1, ���� : 0)
	static int gearIdx; // ȸ���� ��Ϲ�ȣ(1~4)
	static int dir; // �Է¹��� ��
	static int cnt; // �� ��Ϲ��� ������ ��
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			calculateGearDir();
			rotateGear();
		}
		
		cnt = 0;
		if(gear[0][0] == 1) {
			cnt += 1;
		}
		if(gear[1][0] == 1) {
			cnt += 2;
		}
		if(gear[2][0] == 1) {
			cnt += 4;
		}
		if(gear[3][0] == 1) {
			cnt += 8;
		}
		
		System.out.println(cnt);
	}
	
	// �Է¹��� gearIdx, dir�� �̿��� �ٸ� ��� ȸ������ ���ϱ�
	public static void calculateGearDir() {
		// �ʱ�ȭ
		for(int i=0; i<4; i++) {
			gearDir[i] = 0;
		}
		
		// �ش� ������ �Է¹��� dir������ ����
		gearDir[gearIdx] = dir;
		
		// �ٸ� ��Ϲ����� ������ �κ� 3, 7
		switch(gearIdx) {
			// ��Ϲ��� 1�� ȸ���� ��� 1->2->3->4
			case 0:
				// ��Ϲ��� 1�� ȸ���ϰ� �¹��� �κ��� ���� �ٸ��� ��Ϲ���2 �ݴ�������� ȸ��
				if(gearDir[0] != 0 && gear[0][3] != gear[1][7])
					gearDir[1] = gearDir[0] * -1;
				
				// ��� 2�� 3
				if(gearDir[1] != 0 && gear[1][3] != gear[2][7])
					gearDir[2] = gearDir[1] * -1;
				
				// ��� 3�� 4
				if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
					gearDir[3] = gearDir[2] * -1;
				
				break;
				
			// ��Ϲ��� 2�� ȸ���� ��� 2->3->4, 2->1
			case 1:
				// ���2�� 1
				if(gearDir[1] != 0 && gear[1][7] != gear[0][3])
					gearDir[0] = gearDir[1] * -1;
				
				// ��� 2�� 3
				if(gearDir[1] != 0 && gear[1][3] != gear[2][7])
					gearDir[2] = gearDir[2] * -1;
				
				// ��� 3�� 4
				if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
					gearDir[3] = gearDir[2] * -1;
				
				break;
				
			// ��Ϲ��� 3�� ȸ���� ��� 3->4, 3->2->1
			case 2:
				// ��� 3�� 4
				if(gearDir[2] != 0 && gear[2][3] != gear[3][7])
					gearDir[3] = gearDir[2] * -1;
				
				// ��� 3�� 2
				if(gearDir[2] != 0 && gear[2][7] != gear[1][7])
					gearDir[1] = gearDir[2] * -1;
				
				// ��� 2�� 1
				if(gearDir[1] != 0 && gear[1][7] != gear[0][3])
					gearDir[0] = gearDir[1] * -1;
				
				break;
				
			// ��Ϲ��� 4�� ȸ���� ��� 4->3->2->1
			case 3:
				// ��� 4�� 3
				if(gearDir[3] != 0 && gear[3][7] != gear[2][3])
					gearDir[2] = gearDir[3] * -1;
				
				// ��� 3�� 2
				if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
					gearDir[1] = gearDir[2] * -1;
				
				// ��� 2�� 1
				if(gearDir[2] != 0 && gear[2][7] != gear[1][3])
					gearDir[1] = gearDir[2] * -1;
				
				break;
		}
	}
	
	// �� ��Ϲ��� �� gearDir�� �°� ȸ��
	public static void rotateGear() {
		int[] tempGear;
		
		// ��� ��Ϲ��� gearDir�� �°� ȸ��
		for(int i=1; i<=4; i++) {
			tempGear = new int[9];
			
			// �ش� ��Ϲ����� ȸ�� ���ҋ�(0)�� �Ѿ
			if(gearDir[i] == 0)
				continue;
			// �ش� ��Ϲ����� �ð����(1)
			if(gearDir[i] == 1) {
				tempGear[1] = gear[i][8];
				for(int j=2; j<=8; j++) {
					tempGear[j] = gear[i][j-1];
				}
			}
			else if(gearDir[i] == -1) {
				for(int j=1; j<=7; j++) {
					tempGear[j] = gear[i][j+1];
				}
				tempGear[8] = gear[i][1];
			}
			
			// ȸ���� �迭�� gear�� �ٽ�����
			gear[i] = tempGear.clone();
		}
	}
}
