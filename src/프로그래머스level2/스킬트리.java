package ���α׷��ӽ�level2;

import java.util.ArrayList;

/*
 * ��ųƮ���� ���� ������� ��ų�� ������� ��
 * ��ųƮ���� �ش����� �ʴ� �ٸ� ��ų�� ������ ������� ��� �� �ִ�.
 */
//��ų���� ���ڿ� skill
//��ųƮ������ ���ڿ� skill_trees

public class ��ųƮ�� {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int skill_index = 0;
		
		ArrayList<String> skill_order = new ArrayList<>();
		for(int i=0; i<skill.length(); i++) {
			skill_order.add(skill.substring(i, i+1)); //skill�� �ѱ��ھ� arralist�� �־��ش�
		}
		
		for(int i=0; i<skill_trees.length; i++) { // skill_trees�� ���� �ѹ��ھ� skill_order�� ��
			for(int j=0; j<skill_trees[i].length(); j++) {
				String x = skill_trees[i].substring(j, j+1);
				
				// ���� �ȵǾ� ������ ���
				if(!skill_order.contains(x)) {
					if(j == skill_trees[i].length()-1) {//skill_order�� �����ϰ� ���� �ʰ� �ش� ������ ���̰� j��� skill_order�� �ƿ� ���ԵǾ� ���� ���� ���·� answer++
						answer ++;
						break;
					}
					continue;
				}
				
				//���ԵǾ� ������ ���� üũ
				if(skill_order.get(skill_index).equals(x)) { //������ �´ٸ�
					if( j == skill_trees[i].length()-1	) {
						answer ++;
						break;
					}
					skill_index++;
					continue;
				}else { // ������ Ʋ���ٸ�
					break;
				}
		}
		skill_index = 0; //0���� �ʱ�ȭ
		}
		return answer;
	}
}
