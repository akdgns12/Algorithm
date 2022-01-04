package 매일코딩;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 오픈채팅방 {
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> chatLog = new ArrayList<>();
		
		for(String str : record) {
			StringTokenizer st = new StringTokenizer(str);
			String command = st.nextToken();
			String user_Id = st.nextToken();
			String name = "";
			
			if(!command.equals("Leave")) {
				name = st.nextToken();
			}
			
			switch(command) {
			case "Enter":
				map.put(user_Id, name);
				chatLog.add(user_Id + "님이 들어왔습니다.");
				break;
			case "Change":
				map.put(user_Id, name);
				break;
			case "Leave":
				chatLog.add(user_Id + "님이 나갔습니다.");
				break;
			}
		}
		
		String[] answer = new String[chatLog.size()];
		int logIdx = 0;
		
		for(String str : chatLog) {
			int endOfId = str.indexOf("님");
			String user_Id = str.substring(0,endOfId);
			
			answer[logIdx++] = str.replace(user_Id, map.get(user_Id)); 
		}
		
		return answer;
	}
}
