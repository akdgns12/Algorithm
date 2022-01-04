package 카카오기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
/*
 * DFS / HashSet을 이용한 중복제거 (조합, 중복 제거)
 * banned_id에 해당하는 아이디를 하나씩 고를 수 있는 조합을 찾는 문제
 * 
 * banned_id에 존재하는 *을 .로 변경한다면 쉽게 정규식을 사용이 가능하다.
 * 이후, str.matches(patter)을 사용해 문자열이 패턴과 일치 여부를 boolean값으로 받아올 수 있다.
 */

/*
 * <풀이>
 * DFS 백트래킹을 사용하여 뽑을 수 있는 모든 경우의 수를 뽑은 뒤 HasSet에 저장해
 * 중복된 값이 이미 있었으면 저장이 되지 않도록 하였다. 그리고 마지막으로 set의 size를 return
 * 
 * 문자열을 비교할 때는 정규식을 사용하기 위해 banned_id의 "*"을 모두 "."으로 바꾸어 주었다. 그리고
 * matches()함수를 사용해 정규식과 user_id의 포맷이 일치하는지 확인해 주었다.
 * 
 * user_id를 담을 때 공백을 두고 담고, 마지막에 banned_id에 해당하는 아이디를 모두 뽑고 난 후 string객체에
 * 공백을 기준으로 문자열을 나눠 담아주었다. 이는 뽑은 문자열을 정렬해 주기 위함이다. 정렬하는 이유는 set에 
 * 저장할 문자열의 순서가 다르면 다른 문자열로 인식하기 때문에 정렬하여 뽑은 순서가 달라도 뽑은 문자열들이 같다면 같다고
 * 생각해주기 위함이다.
 * 
 */
public class 불량사용자복습 {
	
	static HashSet<String> set;
	static String[] user;
	static boolean[] visited;
	static String[] regex;
	
	public static void main(String[] args) {
		String[] user_id = {"frodo","fradi","crodo","abc123","frdoc"};
		String[] banned_id = {"fro*d*","abc1**"};
		
		solution(user_id, banned_id);
	}
	
	 public static  int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		set = new HashSet<>();
		user = user_id;
		
		regex = new String[banned_id.length];
		for(int i=0; i<banned_id.length; i++) {
			regex[i] = banned_id[i].replace("*", ".");
		}
		
		visited = new boolean[user.length];
		backtracking(0, "");
		return set.size();
}
	public static void backtracking(int idx, String result) {
		if(idx == regex.length) {
			String[] str = result.split(" ");
			Arrays.sort(str);
			
			String newstr = "";
			for(int i=0; i<str.length; i++) {
				newstr += str[i];
			}
			set.add(newstr);
			return;
		}
		
		for(int i=0; i<user.length; i++) {
			if(visited[i] == false && user[i].matches(regex[idx])) {
				visited[i] = true;
				backtracking(idx+1, result + " " + user[i]);
				visited[i] = false;
			}
		}
		
	}
}
