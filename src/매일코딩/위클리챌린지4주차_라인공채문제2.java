package �����ڵ�;

import java.util.HashMap;
import java.util.StringTokenizer;

public class ��Ŭ��ç����4����_���ΰ�ä����2 {
	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		// ������ HashMap ����(���� -> ���迭), ������ ����
		HashMap<String, String[]> jobs = new HashMap<>();
		
		for(int i=0; i<table.length; i++) {
			StringTokenizer st = new StringTokenizer(table[i]);
			String job = st.nextToken();
			jobs.put(job, new String[5]);
			
			for(int j=0; j<5; j++) {
				jobs.get(job)[j] = st.nextToken();
			}
		}
		
		// ��ȣ�� HashMap ����(��� -> ����), ������ ����
		HashMap<String, Integer> prefer = new HashMap<>();
		
		for(int i=0; i<languages.length; i++) {
			prefer.put(languages[i], preference[i]);
		}
		
		// �ִ� ������ ��Ÿ���� ����
		int max = -1;
		
		// ������ ���� ��� ���������� ���� �������� return�ϹǷ�, ���� �� ����
		String[] list = {"CONTENTS", "GAME", "HARDWARE", "PORTAL", "SI"};
		
		for(int i=0; i<list.length; i++) {
			int tmp = 0;
			
			String[] job_list = jobs.get(list[i]);
			
			for(int j=0; j<job_list.length; j++) {
				if(prefer.containsKey(job_list[j])) {
					tmp += ((5-j) * prefer.get(job_list[j]));
				}
			}
			
			if(tmp > max) {
				max = tmp;
				answer = list[i];
			}
		}
		return answer;
	}
}
