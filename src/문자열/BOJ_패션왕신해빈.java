package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_�мǿս��غ� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			//key : �ǻ����� , value : �ǻ� ����
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			while(n --> 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); //�� �̸��� �ʿ����
				String kind = st.nextToken(); // �� ��
				
				/*
				 * �ش� ������ ���� �ؽøʿ� �������
				 * �ؽøʿ� ����Ǿ� �ִ� �ش� ������ ������ +1������Ų��.
				 * 
				 * �ش� ������ ���� �ؽøʿ� ���� ���
				 * �ش� ������ ���� 1�� �ִ´�
				 */
				
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				}else {
					map.put(kind, 1);
				}
			}
			
			int result = 1;
			
			/*
			 * �� �Դ� ��츦 ����Ͽ� �� ������ ���� ������ +1 ���� ����
			 * �����־�� �Ѵ�.
			 * ex)
			 * [headgear] : hat, turban, NULL
			 * [eyewear] : sunglasses, NULL
			 * 3C1 * 2C1 - 1(�ƹ��͵� ���Դ� ���) = answer
			 */
			for(int val : map.values()) {
				result *= (val+1);
			}
			//�˸��� ���¸� �������־�� �ϹǷ� �������� -1�� ����
			sb.append(result - 1).append('\n');
		}
		System.out.println(sb);
	}
}
