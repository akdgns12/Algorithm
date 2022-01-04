package ���α׷��ӽ�level2;

import java.util.HashMap;

/*
 * ��Ʈ��ŷ or DFS
 */

public class ��ü������� {
	//������� ������ hashmap���� ǥ��
	static HashMap<Character, Integer> hm;
	//�����͸� �ִ� �迭
	static int[] permute;
	//������ ���� ǥ���ϴ� �迭
	static boolean[] visited;
	static int answer;
	public int solution(int n, String[] data) {
		//ĳ���͸��� ��ȣ�� ��Ī
		hm = new HashMap<Character, Integer>()	;
		hm.put('A', 0);
		hm.put('C', 1);
		hm.put('F', 2);
		hm.put('J', 3);
		hm.put('M', 4);
		hm.put('N', 5);
		hm.put('R', 6);
		hm.put('T', 7);
		permute = new int[8];
		visited = new boolean[8];
		answer = 0;
		//dfs�� �̿��� ��� ����� ��(����)�� ���ϰ� data�� �ִ� ���ǰ� ���ؼ� answer�� �ø���.
		dfs(0, data);
		return answer;
	}
	//permute���� pos��° ĳ������ ��ġ�� ����.
	static void dfs(int pos, String[] data) {
		//�ϳ��� permute�� �ϼ�
		//�־��� ���ǵ鿡 �����ϴ��� �˻�
		if(pos == 8) {
			char compare;
			int c1, c2, digit;
			for(int i=0; i<data.length; i++) {
				c1 = permute[hm.get(data[i].charAt(0))];
				c2 = permute[hm.get(data[i].charAt(2))];
				compare = data[1].charAt(3);
				// - '0'�� �����ν� in������ ��ȯ
				digit = data[i].charAt(4) - '0';
				if(compare == '>') {
					if(Math.abs(c1-c2) -1 <= digit)
						return;
				}else if(compare == '<') {
					if(Math.abs(c1 - c2) - 1 >= digit)
						return;
				}else {
					if(Math.abs(c1 - c2) - 1 != digit)
						return;
				}
			}
			answer++;
			return;
		}
		// dfs������� Ž��
		// visited �迭 ��Ұ� false��� pos�� 1�߰��ؼ� ��� ȣ��
		// dfsȣ�� ���� permute[pos]�� i�� �߰��ϰ� trueǥ��
		// ȣ�� �Ŀ��� �ٽ� false ǥ��
		for(int i=0; i<8; i++) {
			if(!visited[i]){
				visited[i] = true;
				permute[pos] = i;
				dfs(pos+1, data);
				visited[i] = false;
			}
		}
	}
}
