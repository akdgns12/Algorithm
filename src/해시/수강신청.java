package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class ������û {
	// 1. Ŭ�� 2���̻� �� �л� ����Ͽ��� ����
	// 2. �� �տ������� �ִ� ���� �����ο� ����
	// 3. ���������� ������û�� ������ �ο� ���
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // ������ ���� �ο�
		int L = Integer.parseInt(st.nextToken()); // �л����� ��ư Ŭ���� ������ ����� ������� ����
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i=0; i<L; i++) {
			String number = br.readLine();
			if(set.contains(number)) set.remove(number);
			set.add(number);
		}
		
		Iterator<String> it = set.iterator();
		int cnt = 0;
		while(it.hasNext() && cnt < K) {
			System.out.println(it.next());
			cnt++;
		}		
	}

}
