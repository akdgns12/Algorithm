package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

// 2910 ������
// �� ���� ����
// 1. �ؽ��ʿ� Ű�� �󵵼��� �����Ѵ�.
// 2. �ؽ��ʿ� ����� ��� Ű���� ����Ʈ�� �����Ѵ�.
// 3. ����Ʈ��ȿ� ����� Ű���� �󵵿� ���� �����Ѵ�.
// 4. ���
// ����
public class BOJ_2910 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		str = br.readLine().split(" ");
		HashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();
		
		// �ؽ����� �̿�
		for(int i=0; i<n; i++) {
			//Ű�� �����ϸ� value�� +1
			if(list.containsKey(Integer.parseInt(str[i]))) {
				list.replace(Integer.parseInt(str[i]), list.get(Integer.parseInt(str[i]))+1);
			}
			// Ű�� ������  value ���� 1�� �����Ѵ�.
			else {
				list.put(Integer.parseInt(str[i]),1);
			}
		}
		//key���� ��� �迭�� �����Ѵ�.
		ArrayList<Integer> v = new ArrayList<Integer>(list.keySet());
		
		//�迭�� ����� Ű���� ���� value������ ������������ �����Ѵ�.
		Collections.sort(v, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				// list.get(b) �� list.get(a)�� ��ġ�� �ٲ�� ���������� �ȴ�.
				return Integer.compare(list.get(b), list.get(a));
			}
		});
		//Iterator�� ���ؼ� ����Ѵ�.
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			Integer element = it.next();
			for(int i=0; i<list.get(element); i++	) {
				System.out.println(element+ " ");
			}
		}
	}
}
