package ���α׷��ӽ�level2;

import java.util.HashMap;
import java.util.Set;

/*
 * �����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����Ѵ�.
 * ���� �ٸ� ������ �ʵ��� �����ؾ��Ѵ�.
 * key���� value������ ����? hahsmap ����غ��� 
 */
public class ���� {
	public int solution(String[][] clothes) {
		int answer = 1; //������ ���� 1�� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//map ���ϱ�
		for(int i=0; i<clothes.length; i++) {
				// HashMap getOrDefault ����ϸ� �迭���� �ߺ��Ǵ� ���� �� �� �ִ��� Ȯ���� �� �ִ�.
				//�ǻ�����, ����
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1 ); // map.getOrDefault(clothes[i][1], 0) +1) clothes[i][1]��� Ű, clothes[i][1]�� ���� �����ϸ� �� ���� �־��ְ� ���ٸ� 0), �׸��� +1
		// getOrDefault ã��Ű�� �����Ѵٸ� ã��Ű�� ���� ��ȯ�ϰ� ���ٸ� �⺻ ���� ��ȯ�ϴ� �޼���
		// HashMap�� ��� ���� Ű ���� �߰��� ��� Value�� ���� ����Ⱑ �ȴ�.���� ���� key���� value�� ��� ����ϰ� ���� ��� getOrDefault�޼��带 ����Ѵ�.
		}
		//����
		Set<String> keySet = map.keySet(); // �ǻ�����.
		
		for(String key : keySet) {
			//1.�� �������� �ƹ��͵� �������� �ʴ� ��찡 �ֱ� ������ +1
			//2. �׷��� ���� ������ ��� �����ش�.
			//3. ���������� ���⼭ ���� �ƹ��͵� �������� �ʴ� ��� �ϳ� ���ָ� answer
			answer *= map.get(key) + 1;
		}
		
		return answer-1;
	}
}
