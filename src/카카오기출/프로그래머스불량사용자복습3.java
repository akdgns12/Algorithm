package 카카오기출;

import java.util.HashSet;

public class 프로그래머스불량사용자복습3{
	static String[] user, ban;
	static boolean[] visited; //응모자 아이디 방문 여부
	static HashSet<String> set; //제재 아이디 목록
	
	public int solution(String[] user_id, String[] banned_id) {
		user = user_id;
		ban = banned_id;
		visited = new boolean[user.length];
		
		set = new HashSet<>();
		
		int answer = 0;
		
		dfs(0, ""); //dfs 순환 탐색을 통해서 결과값을 HashSet에 저장
		
		return answer;
	}
	
	// idx는 불량사용자 배열 인덱스, str은 일치하는 불량사용자 목록
	public static void dfs(int idx , String str) {
		if(idx == ban.length) { //불량 사용자 배열의 현재 인덱스가 불량사용자 배열의 사이즈와 같을 때
			//즉, DFS의 순환이 마지막일 때
			StringBuilder sb = new StringBuilder(); //문자열을 추가하기 때문에 String보다 적합
			for(int i=0; i<user.length; i++) {//응모자 아이디가 목록에 포함되어 있다면 sb에 추가
				if(str.contains("" + i)) sb.append("" + i);
			}
			
			if(!set.contains(sb.toString())) {//정렬된 목록이 HashSet에 포함되어 있지않다면, 추가
				set.add(sb.toString());
			}
			return;
		}
		
		//DFS 재귀 이해 완료!!!!!!!
		/*
		 * for문을 돌리기 시작한 후 user.length만큼의 반복을 진행한다. 
		 * 이 때 그 안에서 dfs가 호출되어 다시 for문이 호출되어지면 첫번째 for문의 i=0일떄의 두번째 반복문인 for문이 호출된다고 생각하면 됨
		 * for문이 재귀적으로 호출됨으로써 즉, user.length가 6이라 쳤을 때
		 * 0 1 2 3 4 5 6
		 * 0 1 2 3 4 5 6 
		 * ..
		 * ..
		 * 이런식으로 for문이 재귀적으로 중첩되며 쌓인다 이때 dfs의 depth만큼 for문이 불려진다 
		 * 그래서 종료조건 명시 필요 
		 */
		for(int i=0; i<user.length; i++) {//응모자 아이디 중에서 현재 불량사용자와 일치하는 값을 찾는다.
			if(visited[i] = true) continue; //이미 목록에 들어있는 값이면 skip
			String regex = ban[idx].replace("*", "."); //정규식 체크 fr*d* -> fr.d.
			if(user[i].matches(regex)) {//정규식과 일치한다면
				//해당 응모자의 방문여부를 바꿔주고 dfs탐색을 한다.
				visited[i] = true;
				dfs(idx+1, str + i);
				visited[i] = false;
			}
		}
	}
}