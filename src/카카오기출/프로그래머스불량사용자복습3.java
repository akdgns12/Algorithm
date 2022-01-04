package īī������;

import java.util.HashSet;

public class ���α׷��ӽ��ҷ�����ں���3{
	static String[] user, ban;
	static boolean[] visited; //������ ���̵� �湮 ����
	static HashSet<String> set; //���� ���̵� ���
	
	public int solution(String[] user_id, String[] banned_id) {
		user = user_id;
		ban = banned_id;
		visited = new boolean[user.length];
		
		set = new HashSet<>();
		
		int answer = 0;
		
		dfs(0, ""); //dfs ��ȯ Ž���� ���ؼ� ������� HashSet�� ����
		
		return answer;
	}
	
	// idx�� �ҷ������ �迭 �ε���, str�� ��ġ�ϴ� �ҷ������ ���
	public static void dfs(int idx , String str) {
		if(idx == ban.length) { //�ҷ� ����� �迭�� ���� �ε����� �ҷ������ �迭�� ������� ���� ��
			//��, DFS�� ��ȯ�� �������� ��
			StringBuilder sb = new StringBuilder(); //���ڿ��� �߰��ϱ� ������ String���� ����
			for(int i=0; i<user.length; i++) {//������ ���̵� ��Ͽ� ���ԵǾ� �ִٸ� sb�� �߰�
				if(str.contains("" + i)) sb.append("" + i);
			}
			
			if(!set.contains(sb.toString())) {//���ĵ� ����� HashSet�� ���ԵǾ� �����ʴٸ�, �߰�
				set.add(sb.toString());
			}
			return;
		}
		
		//DFS ��� ���� �Ϸ�!!!!!!!
		/*
		 * for���� ������ ������ �� user.length��ŭ�� �ݺ��� �����Ѵ�. 
		 * �� �� �� �ȿ��� dfs�� ȣ��Ǿ� �ٽ� for���� ȣ��Ǿ����� ù��° for���� i=0�ϋ��� �ι�° �ݺ����� for���� ȣ��ȴٰ� �����ϸ� ��
		 * for���� ��������� ȣ������ν� ��, user.length�� 6�̶� ���� ��
		 * 0 1 2 3 4 5 6
		 * 0 1 2 3 4 5 6 
		 * ..
		 * ..
		 * �̷������� for���� ��������� ��ø�Ǹ� ���δ� �̶� dfs�� depth��ŭ for���� �ҷ����� 
		 * �׷��� �������� ��� �ʿ� 
		 */
		for(int i=0; i<user.length; i++) {//������ ���̵� �߿��� ���� �ҷ�����ڿ� ��ġ�ϴ� ���� ã�´�.
			if(visited[i] = true) continue; //�̹� ��Ͽ� ����ִ� ���̸� skip
			String regex = ban[idx].replace("*", "."); //���Խ� üũ fr*d* -> fr.d.
			if(user[i].matches(regex)) {//���Խİ� ��ġ�Ѵٸ�
				//�ش� �������� �湮���θ� �ٲ��ְ� dfsŽ���� �Ѵ�.
				visited[i] = true;
				dfs(idx+1, str + i);
				visited[i] = false;
			}
		}
	}
}