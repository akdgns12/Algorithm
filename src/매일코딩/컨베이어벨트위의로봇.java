package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ���� ���� : �������� 0�� ĭ�� ������ k�� �̻��̶�� ���� �׷��������� 1����������
// ����Ǿ��� �� �� ��° �ܰ谡 �������̾����� ���϶�.

public class �����̾Ʈ���Ƿκ� {
	static int N,K;
	static int[] map; // ��Ʈ�� ������
	static int left, right; // ��Ʈ �迭���� �ε����� ����Ű�� ����
	static boolean[] robot; // �κ��� �����ϴ��� ������ �迭
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[2*N];
		robot = new boolean[N];
		
		for(int i=0; i<2*N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(simulation(0));
			
	}
	public static int simulation(int cnt) {
		while(isOk()) {
			int temp = map[map.length-1]; // 1. ��Ʈ ��ĭ ȸ��
			for(int i=map.length-1; i>0; i--) {
				map[i] = map[i-1];
			}
			map[0] = temp;
			
			// �κ��� ��Ʈ�� ���� ȸ��
			for(int i=robot.length; i>0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false; // �ø��� ��ġ
			robot[N-1] = false; // ������ ��ġ
			
			// 2.�κ� �̵������ϸ� �̵�
			for(int i=N-1; i>0; i--) {
				if(robot[i-1] && !robot[i] && map[i] >= 1) {
					robot[i] = true;
					robot[i-1] = false;
					map[i]--;
				}
			}
		
			// 3.�ö󰡴� ��ġ�� �κ� �ø���
			if(map[0] > 0) {
				robot[0] = true;
				map[0]--;
			}
			
			cnt++;
		}
		return cnt;
	}
	
	public static boolean isOk() {
		int cnt = 0;
		
		for(int i=0; i<map.length; i++) {
			if(map[i] == 0) {
				cnt++;
			}
			if(cnt >= K) {
				return false;
			}
		}
		return true;
	} // end of isOk
	
}
