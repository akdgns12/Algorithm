package ���α׷��ӽ�_Level_1;

import java.util.HashMap;

//import java.util.Arrays;

/*
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ ��������
 * �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� 
 * return �ϵ��� �ϴ� solution�Լ�
 */
/*
 * <����>
 * 
 */
/*
public class �����������Ѽ��� {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		String temp = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i=0;
		while(i<completion.length) {
			if(!completion[i].equals(participant[i])) {
				temp = participant[i];
				break;
			}else {
				i++;
			}
		}
		
		if(!temp.equals("")) {
			answer = temp;
		}else {
			answer = participant[participant.length-1];
		}
		
		return answer;
	}
}
*/
// �ٸ� Ǯ�� hashmap ���
public class �����������Ѽ���{
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		//hashmap, getOrDefault(key, 0) ã��Ű�� ���� �����ϸ� Ű�� ���� ��ȯ�ϰ� ���ٸ� 0��ȯ
		for(String player : participant) hm.put(player, hm.getOrDefault(player,0)+1);
		for(String player : completion) hm.put(player, hm.get(player) - 1);
		
		//keySet map�� Ű�� �� �޾ƿ�, entrySet map�� key���� value�� �� �̾ƿ�
		for(String key : hm.keySet()) {
			if(hm.get(key) !=0	) {
				answer = key;
			}
		}
		return answer;
	}
}