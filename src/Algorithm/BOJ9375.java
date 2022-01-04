package Algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// �мǿ� ���غ�
// �� �������� (�� ����+1) * (�� ���� + 1 ) * ... * (�� ���� + 1 ) -1 �� �� �˸��� �ƴ� ���·� �ǻ��� ���� �� �ִ� ����� �� �Դϴ�.
public class BOJ9375 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = sc.nextInt();
			for(int j=0; j<n; j++) {
				String name = sc.next();
				String type = sc.next();
				map.put(type, map.getOrDefault(type,0)+1); //map.getOrDefault = ã��Ű�� �����Ѵٸ� ã��Ű�� ���� ��ȯ�ϰ� ���ٸ� �⺻ ���� ��ȯ.
			}
			int ans = 1;
			for(String key : map.keySet()) { //keyset() key���� �ʿ��� ��� ���, entryset() key�� value �ΰ� ��� �ʿ��� ��� ���
				ans *= (map.get(key)+1);
			}
			System.out.println(ans-1);
		}
	}
}
// ���� ���� ���� �� ����, �߻� ��� and Ǯ�̵� �� ��ƽ�
