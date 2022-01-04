package �����ڵ�;

public class �ĺ�Ű {
	import java.util.*;
	class Solution {	
	   	public static ArrayList<String> list = new ArrayList<>(); // ��� �ĺ�Ű ���� ���� 
		public static ArrayList<List<String>> candidateKeys = new ArrayList<>(); // ���ϼ�, �ּҼ� �����ϴ� �ĺ�Ű ���� 
	           
	    public int solution(String[][] relation) { 
			int tuple = relation.length;
			int column = relation[0].length;
			boolean[] visited = new boolean[column];
		
			for(int i = 1; i <= column; i++) { // ������ �̿��� ��� �ĺ�Ű ���� ���� 
				comb(visited, 0, i);
			}

			// �ĺ�Ű ���ϼ� �Ǻ�
			for(int i = 0; i < list.size(); i++) {  
				HashSet<String> set = new HashSet<>(); // �ߺ� ���� �����ϴ� HashSet�� �̿��� �ĺ�Ű �������� �̾��� Ʃ�� ���� 
				String[] keys = list.get(i).split("");

				for(int j = 0; j < relation.length; j++) {
					String r = "";

					for(int k = 0; k < keys.length; k++) {
						r += relation[j][Integer.parseInt(keys[k])];
					}
					set.add(r);
				}

				if(set.size() == tuple) { //��ü Ʃ���� ���� �ĺ�Ű �������� �̾��� Ʃ���� ���� ���ٸ� �ĺ�Ű ���ϼ� ��� 
					// �ĺ�Ű �ּҼ� �Ǻ� 
					// containsAll �޼��� ����ϱ� ���� List ���
					// ������ String�� contains �޼��� ���� 123, 13�� �������� �������� �Ǻ��ϱ� ���� 
					List<String> cKey = Arrays.asList(list.get(i).split("")); 

					boolean flag = true;
					for(int j = 0; j < candidateKeys.size(); j++) {
						if(cKey.containsAll(candidateKeys.get(j))) { // �ĺ�Ű ����Ʈ�� �κ��������� �ִٸ� �ּҼ� ���� X
							flag = false;
							break;
						}
					}

					if(flag) { // ��� �κ��������ζ� ���ٸ� �ּҼ� ��� 
						candidateKeys.add(cKey);
					}
				}
			}

			// ���ϼ��� �ּҼ� �Ǻ��� ����� �ĺ�Ű���� ��� �ִ� �ĺ�Ű ����Ʈ�� ����� �ٷ� ���� 
			return candidateKeys.size();
	    }
	    
	    	public static void comb(boolean[] visited, int start, int r) {
			if(r == 0) {
				String num = "";
				for(int i = 0; i < visited.length; i++) {
					if(visited[i]) {
						num = num + i;
					}
				}

				list.add(num);

				return;
			} else {
				for(int i = start; i < visited.length; i++) {
					visited[i] = true;
					comb(visited, i + 1, r - 1);
					visited[i] = false;
				}
			}
		}
	}
}
