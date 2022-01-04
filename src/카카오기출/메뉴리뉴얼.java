package īī������;
import java.util.*;
public class �޴������� {
	//coures �迭 = �ڽ��丮 ����
	//orders�迭 �մ��� �ֹ��� ��ǰ�޴� ����
	//return coures�� ���� �´� ��ǰ�޴� ���� �� 2���̻� ���°�
	static ArrayList<String> list = new ArrayList<>();
	public String[] solution(String[] orders, int[] course) {
		String[] answer;
		
		//orders�迭�� ���ҵ��� ���� �ѱ��ھ� �и�.
		//orders ���� for������ ���� �� ���ڿ����� ������ ���� ���ѵ� 
		//�� ������ 2���̻��̰� �ڽ��� �ܾ� ���� �´��� �˻�
		//�� ���ڿ����� �� = arrayList�� ���
		for(int i=0; i<orders.length; i++) { //�� order�� char array�� ��ȯ -> �������� ����
			char[] orders_char = orders[i].toCharArray();
			Arrays.sort(orders_char);
			
			for(int index = 0; i<orders_char.length-1; index++) { //�ѱ��ھ� ���ʴ�� ����, course �ϳ��� �ٲ㰡�鼭 dfsȣ��
				for(int j=0; j<course.length; j++) {
					dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
				}
			}
		}
		
		Map<String, Integer> map = new HashMap<>();
		for(String key : list) {
			map.put(key,  map.getOrDefault(key, 0) +1);
		}
		ArrayList<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		
		ArrayList<String> ansList = new ArrayList<>();
		for(int i=0; i<course.length; i++) {
			int max_value = 0;
			
			for(String key : keySetList) {
				if(map.get(key) >= 2 && key.length() == course[i]) {
					if(map.get(key) >= max_value) {
					ansList.add(key);
					max_value = map.get(key);
				}
			}
		}
	}
	Collections.sort(ansList);
	answer = new String[ansList.size()];
	ansList.toArray(answer);
		
		return answer;
	}
	
	public static void dfs(char[] arr, int idx, int length, int course, String str	) {
		if(length == course) { //�ܾ��� ���̰� course�� ���̿� ���ٸ� list�� �߰�
			list.add(str);
		}
		
		for(int i=idx+1; i<arr.length; i++) {
			dfs(arr, i, length+1, course, str+arr[i]);
		}
	}
}
