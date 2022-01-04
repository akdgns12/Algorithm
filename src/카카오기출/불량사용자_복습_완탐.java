package 카카오기출;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class 불량사용자_복습_완탐 {
	static HashSet<String> result;
	
	public int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<>();
		dfs(user_id, banned_id, new LinkedHashSet<>());
	}
	
	static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
		if(set.size() == banned_id.length) {
			if(isBannedUsers(set, banned_id)) {
				result.add(new HashSet<>(set));
			}
			
			return;
		}
		
		for(String userId : user_id) {
			if(!set.contains(userId)) {
				set.add(userId);
				dfs(user_id, banned_id, set);
				set.remove(userId);
			}
		}
	}
	
	static boolean isBannedUsers(Set<String> set, String[] banned_id) {
		int i=0;
		
		for(String user : set) {
			if(!isSameString(user, banned_id[i++])) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isSameString(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
}
