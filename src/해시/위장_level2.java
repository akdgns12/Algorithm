package �ؽ�;
import java.util.HashMap;
import java.util.HashSet;

public class ����_level2 {
	public int solution(String[][] clothes) {
		int answer = 1; //������ ���Ͽ� 1�� �ٲ���
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//key = ����, value= �̸�
		
		for(int i=0; i<clothes.length; i++) {
			//�ǻ�����, ����
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);	// map�� ���� ,�̸� ����
		}
		
		
		HashSet<String> keySet = new HashSet<String>(map.keySet());
		
		for(String key : keySet) {
			answer *= map.get(key) +1 ; //�� �������� �ϳ��� �԰ų�, 
			//���԰ų��� �������� �ֱ� ������ ���� ������ ���Դ� �������� �ϳ� �߰��Ѵ�
			// �׸��� ���� ���� ������ ���ÿ� �Ͼ�� ���̱� ������, �� �ʵ��� ���� ����� ���� ���Ѵ�.
			}
		
		return answer-1; //�ƹ��͵� ���Դ� ��츦 ���ش�
	}
}
