package 카카오기출;
import java.util.*;

public class 오픈채팅방 {
	public String[] solution(String[] record	) {	

		ArrayList<String> chatLog = new ArrayList<String>();
		HashMap<String, String> nickMap = new HashMap<String, String>();
		//HashMap key값 중복 불가능, 동일한 key값 입력시 최신값 적용 이용
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
				chatLog.add(userId + "님이 들어왔습니다.");
				break;
			case "Leave" :
				chatLog.add(userId + "님이 나갔습니다.");
				break;
			case "Change" :
				nickMap.put(userId, nickname);
				break;
			}
		}
		
		String[] answer = new String[chatLog.size()];
		int logIdx = 0;
		
		for(String str : chatLog	) {
			int endOfId = str.indexOf("님");
			String userId = str.substring(0, endOfId);
			
			answer[logIdx++] = str.replace(userId, nickMap.get(userId));
		}
		
		return answer;
	}
}
