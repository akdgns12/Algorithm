package DFS_BFS;

import java.util.*;

public class ��ü�������_level2 {
	static int[] position; //īī������� ���ִ� ��ġ
	static boolean[] visited; //īī�� �������� �湮����
	static int cnt; 
	static HashMap<Character, Integer> kakao;
	static boolean ok;
	
	public int solution(int n, String[] data) {
		int answer = 0;
		position = new int[8];
		visited = new boolean[8];
		cnt = 0;
		kakao = new HashMap<>();
		ok = true;
		//position�� index��ȣ�� ����
		kakao.put('A', 0);
		kakao.put('C', 1);
		kakao.put('F', 2);
		kakao.put('J', 3);
		kakao.put('M', 4);
		kakao.put('N', 5);
		kakao.put('R', 6);
		kakao.put('T', 7);
		
		//1.����
		perm(0, data);
		//2.���� �˻�
		answer = cnt;
		return answer;
		//������ ���� n
		//data �迤�� �־����� ������ �����ϴ� ����� ��
		//data char�� �о�鿩 ���� �и����༭ ���� ������
		
	}
	
	public static void perm(int idx, String[] data) {
		//��������, 8�� ���� �� �����ƴٸ�
		if(idx == 8) {
			if(isOk(data)) {
				cnt++;
			}
			return;
		}
		
		//���� 
		for(int i=0; i<8; i++) {
			//������� �����Ŷ��
			if(!visited[i]) {
				visited[i] = true;
				position[idx] = i;
				perm(idx+1, data);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isOk(String[] data) {
		//�Է¹��� �� ������ �˻�����
		
		for(int i=0; i<data.length; i++) {
			int X = kakao.get(data[i].charAt(0)); //data�迭�� i��° ������ ù��° ����
			int Y = kakao.get(data[i].charAt(2));//data�迭�� i��° ������ 3��° ����
			char type = data[i].charAt(3); // data�迭�� i��° ������ 4��° ���� = �ε�ȣ
			int diff = data[i].charAt(4) - '0'; // data�迭�� i��° ������ 5��° ���� int�� ���� 
			int Xpos = position[X];
			int Ypos = position[Y];
			if(type == '=') {
				if(Math.abs(Xpos - Ypos) - 1 != diff){
					return false;
				}
			}else if(type == '>') {
				if(Math.abs(Xpos - Ypos) - 1 <= diff) {
					return false;
				}
			}else if(type == '<') {
				if(Math.abs(Xpos - Ypos) -1 >= diff) {
					return false;
				}
			}
		}
		return true;
	}
}
