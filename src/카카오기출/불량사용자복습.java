package īī������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
/*
 * DFS / HashSet�� �̿��� �ߺ����� (����, �ߺ� ����)
 * banned_id�� �ش��ϴ� ���̵� �ϳ��� �� �� �ִ� ������ ã�� ����
 * 
 * banned_id�� �����ϴ� *�� .�� �����Ѵٸ� ���� ���Խ��� ����� �����ϴ�.
 * ����, str.matches(patter)�� ����� ���ڿ��� ���ϰ� ��ġ ���θ� boolean������ �޾ƿ� �� �ִ�.
 */

/*
 * <Ǯ��>
 * DFS ��Ʈ��ŷ�� ����Ͽ� ���� �� �ִ� ��� ����� ���� ���� �� HasSet�� ������
 * �ߺ��� ���� �̹� �־����� ������ ���� �ʵ��� �Ͽ���. �׸��� ���������� set�� size�� return
 * 
 * ���ڿ��� ���� ���� ���Խ��� ����ϱ� ���� banned_id�� "*"�� ��� "."���� �ٲپ� �־���. �׸���
 * matches()�Լ��� ����� ���Խİ� user_id�� ������ ��ġ�ϴ��� Ȯ���� �־���.
 * 
 * user_id�� ���� �� ������ �ΰ� ���, �������� banned_id�� �ش��ϴ� ���̵� ��� �̰� �� �� string��ü��
 * ������ �������� ���ڿ��� ���� ����־���. �̴� ���� ���ڿ��� ������ �ֱ� �����̴�. �����ϴ� ������ set�� 
 * ������ ���ڿ��� ������ �ٸ��� �ٸ� ���ڿ��� �ν��ϱ� ������ �����Ͽ� ���� ������ �޶� ���� ���ڿ����� ���ٸ� ���ٰ�
 * �������ֱ� �����̴�.
 * 
 */
public class �ҷ�����ں��� {
	
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
