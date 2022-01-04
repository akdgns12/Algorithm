package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
/*
 * �ִ񰪰� �ּڰ��� ������ֱ� ���� remove�޼ҵ带 ����Ͽ� ť�� Ž���� ���� �����ߴ�.
 * O(n)�� �ð����⵵�� �ð��ʰ�....
 * TreeMap ����Ͽ� Ž���ð� �ذᰡ��
 * 1. �����͸� key���� ���� �ڵ����� ���Ľ��� ����
 * 2. �ش� ������ ������ Ʈ�����·� Ž���ӵ��� O(logN)
 * 
 * �켱���� ť�� Map�� �������� TreeMap�ϳ��� �ذ� ����
 */
/*
 * What is TreeMap?
 * TreeMap�� ����Ʈ���� ������� �� Map �÷���. ���� Tree������ �̷���� TreeSet���� ��������
 * TreeSet�� �׳� ���� �����Ѵٸ� TreeMap�� Ű�� ���� ����� Map, Entry�� �����Ѵٴ� ��. TreeMap��
 * ��ü�� �����ϸ� �ڵ����� ���ĵǴµ�, Ű�� ����� ���ÿ� ������������ ���ĵǰ� ���� Ÿ���� ���״� ������, ���ڿ� Ÿ���� ��쿡��
 * �����ڵ�� �����Ѵ�. ���� ������ �⺻������ �θ� Ű���� ���ؼ� Ű ���� ���� ���� ���� �ڽ� ��忡 Ű���� ���� ���� ������ �ڽ� ��忡 Map.Entry ��ü�� �����Ѵ�.
 * TreeMap�� �Ϲ������� Map���ν��� ������ HashMap���� ��������. TreeMap�� �����͸� ������ �� ��� �����ϱ⿡ �߰��� ������ HashMap���� �����ɸ���.
 * ������ ���ĵ� ���·� Map�� �����ؾ� �ϰų� ���ĵ� �����͸� ��ȸ�ؾ� �ϴ� ���� �˻��� �ʿ��� ��� TreeMap�� ����ϴ� ���� ȿ�����鿡�� ����.
 * 
 * (Red-Black-Tree)
 * TreeMap�� ����Ž��Ʈ���� �������� ������ �����Ʈ���� �̷���� �ִ�. �Ϲ����� ���� Ž�� Ʈ���� Ʈ���� ���̸�ŭ �ð��� �ʿ��ϴ�. ���� ��ü Ʈ���� �� �л�Ǿ� �ִٸ�
 * ȿ������ �־� ũ�� ������ ������ �����Ͱ� ���� �� ���� �������� ����ǰ� ���� ��� ���� ������� ũ�� ġ������ Ʈ���� �Ǿ� ������ ��ȿ������ �����ս��� ����. �� ������ �����ϱ� ����
 * �����Ʈ���� ����. �����Ʈ���� �θ� ��庸�� ���� ���� ������ ���� ���� �ڽ�����, ū ���� ������ ���� ������ �ڽ����� ��ġ�Ͽ� �������� �߰��� ������ Ʈ���� �������� ġ�������� �ʵ���
 * ������ �����ش�.
 * 
 * TreeMap<key, value>
 * key�� �ڵ����� �������� ����
 */

public class BOJ_���߿켱����ť_TreeMap���� {
	static int T; // �Է� �������� ��
	static int K; // ������ ������ ����
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1); // ���ڿ� �ش� ������ ���� ����
					
				}else if(command.equals("D")){
					if(map.size() == 0) continue; // �� ť�� �����͸� �����϶�� ������ �־��� ����, �ش� ������ ����
					
					int tgt = (num == 1 ? map.lastKey() : map.firstKey());
					
					int cnt = map.put(tgt, map.get(tgt) - 1);
					if(cnt == 1) map.remove(tgt);
				}
			}
			
			if(map.size() == 0) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		} // End of For
	}
}
