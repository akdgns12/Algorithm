package īī������;
import java.util.*;

public class ����ä�ù� {
	public String[] solution(String[] record	) {	

		ArrayList<String> chatLog = new ArrayList<String>();
		HashMap<String, String> nickMap = new HashMap<String, String>();
		//HashMap key�� �ߺ� �Ұ���, ������ key�� �Է½� �ֽŰ� ���� �̿�
		for(String log : record) {
			StringTokenizer st = new StringTokenizer(log);
			String command = st.nextToken();
			String userId = st.nextToken();
			String nickname = "";
			
			if(!command.equals("Leave")) {
				nickname = st.nextToken();
			}
			
			switch(command) {
			case "Enter" :
				nickMap.put(userId, nickname);
				chatLog.add(userId + "���� ���Խ��ϴ�.");
				break;
			case "Leave" :
				chatLog.add(userId + "���� �������ϴ�.");
				break;
			case "Change" :
				nickMap.put(userId, nickname);
				break;
			}
		}
		
		String[] answer = new String[chatLog.size()];
		int logIdx = 0;
		
		for(String str : chatLog	) {
			int endOfId = str.indexOf("��");
			String userId = str.substring(0, endOfId);
			
			answer[logIdx++] = str.replace(userId, nickMap.get(userId));
		}
		
		return answer;
	}
}
