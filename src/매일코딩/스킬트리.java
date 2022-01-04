package 매일코딩;

public class 스킬트리 {
	import java.util.ArrayList;
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
			int skill_index = 0;
			
			ArrayList<String> skill_order = new ArrayList<>();
			for(int i=0; i<skill.length(); i++) {
				skill_order.add(skill.substring(i, i+1)); //skill의 한글자씩 arralist에 넣어준다
			}
			
			for(int i=0; i<skill_trees.length; i++) { // skill_trees의 원소 한문자씩 skill_order와 비교
				for(int j=0; j<skill_trees[i].length(); j++) {
					String x = skill_trees[i].substring(j, j+1);
					
					// 포함 안되어 있으면 통과
					if(!skill_order.contains(x)) {
						if(j == skill_trees[i].length()-1) {//skill_order를 포함하고 있지 않고 해당 원소의 길이가 j라면 skill_order가 아예 포함되어 있지 않은 상태로 answer++
							answer ++;
							break;
						}
						continue;
					}
					
					//포함되어 있으면 순서 체크
					if(skill_order.get(skill_index).equals(x)) { //순서가 맞다면
						if( j == skill_trees[i].length()-1	) {
							answer ++;
							break;
						}
						skill_index++;
						continue;
					}else { // 순서가 틀리다면
						break;
					}
			}
			skill_index = 0; //0으로 초기화
			}
	        return answer;
	    }
	}
}
