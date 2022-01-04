package �����ڵ�;

import java.util.HashMap;

public class ��Ŭ��ç����_4�����ϼ��� {

	public static void main(String[] args) {

	}
	public String solution(String[] table, String[] languages, int[] preference) {
		// �������� <���, ��ȣ��>
		HashMap<String, Integer> lang_prefer = new HashMap<>();
		for(int i=0; i<languages.length; i++) {
			lang_prefer.put(languages[i], preference[i]);
		}
		
		String answer = "";
		int max = 0;
		for(String info : table) {
			String[] jobs = info.split(" "); // jobs = SI JAVA JAVASCRIPT SQL PYHTON C#
			int resultPoint = 0;
			for(int i=1, point=5; i<jobs.length; i++, point--)
				resultPoint += lang_prefer.getOrDefault(jobs[i], 0) * point;
			
			// �̸��� ���������� ���� ���� ������
			if(resultPoint >= max) {
				if(resultPoint > max) {
					max = resultPoint;
					answer = jobs[0];
				}
				else {
					if(answer.compareTo(jobs[0]) < 0)
						continue;
					answer = jobs[0];
				}
			}
		}
		
		
		return answer;
	}
}
