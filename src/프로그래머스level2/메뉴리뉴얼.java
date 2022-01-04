package ���α׷��ӽ�level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * ����� 20�� �� �� �� ������ �������� Ǯ����� ���ƾ�..
 * ���� ��Ƴ� ����
 */
// �մԵ��� �ֹ��� ��ǰ�޴��� ��� �迭 orders
// �ڽ��丮�� �����ϴ� ��ǰ�޴����� ������ ��� �迭 course
// ���� �߰��ϰ� �� �ڽ��丮�� �޴� ������ ���ڿ� ���·� �迭�� ��� return
public class �޴������� {
	
	//12. combi �޼ҵ忡�� map�� �����ϱ� ���� ���������� ����.
	static HashMap<String, Integer> map;
	//13. ������ ���ϴ� �޼ҵ�(�� ����� �޴�����, ������ ���� StringBuilder, ������ ���� idx
	// �ڽ��丮 ������ ���� ���������� ���� cnt�� n)
	public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
		//14. �� �ڽ��丮�� ������ŭ ������ �Ǹ�.
		if(cnt == n) {
			//15. map�� �ش� ������ ���� �� ī����.
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}
		
		//16. idx���� ���������ν� ������ ���� �� �ִ�.
		for(int i=idx; i<str.length(); i++) {
			//17.sb�� �ٿ�������.
			sb.append(str.charAt(i));
			//18.���ȣ��.
			combi(str, sb, i+1, cnt+1, n);
			//19. �ٿ����� �ٽ� ����.
			sb.delete(cnt, cnt+1);
		}
	}
	public ArrayList<String> solution(String[] orders, int[] course) {
		
		
		ArrayList<String> answer = new ArrayList<>();
		
		//1. �� ���ڿ��� �������� ����.
		for(int i=0; i<orders.length; i++) {
			//2. �� ���ڿ��� ������ �迭�� ��ȯ
			char[] charArr = orders[i].toCharArray(); //tocharArray�� ���ڿ��� �� ���ھ� �ɰ��� �̸� charŸ���� �迭�� ����־��ִ� ģ���� �޼ҵ�
			//3. �ش� ������ �迭�� ����.
			Arrays.sort(charArr);
			//4. ���ĵ� ������ �迭�� ���ڿ��� ��ȯ�� ����.
			orders[i] = String.valueOf(charArr);
		}
		
		//5. course�� ���̸�ŭ �ݺ��Ͽ� �ʿ��� ������ ����.
		for(int i=0; i<course.length; i++) {
			//6. HashMap���� ������ ���� ī����.
			map = new HashMap<>();
			//7. course�� ��쿡 ���� ���� ���յ� �� ���� ���� �ֹ��� Ƚ���� ����
			int max = Integer.MIN_VALUE;
			//8. �� ������� ������ ���ϱ� ���� Ž��.
			for(int j=0; j<orders.length; j++) {
				//9. ������ ���ϱ� ���� ���ڿ��� ������ StringBuilder.
				StringBuilder sb = new StringBuilder();
				//10. �ڽ��� ���� <= �� ���ڿ��� ������ ��� ������ ���Ѵ�.
				if(course[i] <= orders[j].length())
					//11. ������ ���ϱ� ���� �޼ҵ� ȣ��
					combi(orders[j], sb, 0, 0, course[i]);
			}
			//20. ���� ���� �ֹ��� Ƚ���� max�� ����.
			for(Entry<String, Integer> entry : map.entrySet()) {
				max = Math.max(max, entry.getValue());
			}
			
			//21. �ּ� 2�� �̻� �ֹ��� �����̸�, �ش� Ƚ���� ��ġ�ϴ� ������ ArrayList�� ����
			for(Entry<String, Integer> entry : map.entrySet()) {
				if(max >= 2 && entry.getValue() == max)
					answer.add(entry.getKey());
			}
		}
		//22. �߰��� ���յ��� �������� ����.
		Collections.sort(answer);
			
			
		return answer;
	}
}
