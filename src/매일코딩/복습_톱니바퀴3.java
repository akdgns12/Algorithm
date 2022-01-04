package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_��Ϲ���3 {
	static int K;
	static int[][] gear = new int[5][8];
	static int cnt;
	
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
		
		// ��Ϲ��� ȸ��
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			// ��Ϲ��� ��ȣ�� 1~4, �ε����� 0 ~ 3
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			solution(idx, dir);
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
	
	// �ش� ��Ϲ����� 9�� ������ 6, 3�� ������ 2 ������ �ش� ��Ϲ����� �´�� 
	// �ִ� ���� ��Ϲ��� �������δ� 9�� ������ 2, 3�� ������ 6
	public static void solution(int idx, int dir) {
		left(idx - 1, -dir);
		right(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	// ���ʿ� �ִ� ��Ϲ��� ȸ�� ���� ����
	public static void left(int idx ,int dir) {
		if(idx < 0) return; // ��������� ����
		
		if(gear[idx][2] != gear[idx+1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// �����ʿ� �ִ� ��Ϲ����� ȸ�� ���� ����
	public static void right(int idx, int dir) {
		if(idx > 3) return;
		
		if(gear[idx][6] != gear[idx-1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	// dir = 1 �ð����, dir = -1 �ݽð����
	public static void rotate(int idx ,int dir) {
		if(dir == 1) {
			int temp = gear[idx][7];
			
			for(int i=7; i>0; i--) {
				gear[idx][i] = gear[idx][i-1];
			}
			
			gear[idx][0] = temp;
			
		}else {
			int temp = gear[idx][0];
			
			for(int i=0; i<7; i++) {
				gear[idx][i] = gear[idx][i+1];
			}
			
			gear[idx][7] = temp;
		}
	}
}
