package �����ڵ�;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//
public class �ܾ����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// �ܾ���� ������ �迭
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextLine();
		}
		
		sc.nextLine(); // ���� ����
		//compare �޼ҵ� ���� Ÿ�� 3����
		/*
		 * -���� ����
		 * -0
		 * -���� �������� ������ ��� ��ġ �ٲٰ�,
		 * -0�̳� ���������� ��� �״��
		 */
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				//�ܾ� ���̰� ���� ���
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2); // ���� �� ����
				}
				//�� ���� ���
				else {
					return s1.length() - s2.length(); // ex) s1�� ���̰� ��ٸ� ���ϰ� ��� -> s1, s2��ġ �ٲ۴�
				}
			}
		});
		
		System.out.println(arr[0]);
		
		for(int i=1; i< N; i++) {
			// �ߺ����� �ʴ� �ܾ ���
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
	}

}
