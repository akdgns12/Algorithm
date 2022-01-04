package 프로그래머스_Level_1;

import java.util.HashMap;

/* 
 * 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 
 * / 스테이지에 도달한 플레이어 수
 * 전체 스테이지의 개수 N
 * 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을
 * return 하도록 하는 solution 완성하라.
 */
/*<알고리즘>
 * 아직 클리어하지 못한 플레이어의 수  = 현재 스테이지에 도달한 플레이어의 수
 * 스테이지에 도달한 플레이어 수 = 현재 스테이지에 도달한 플레이어수와 현재 스테이지보다
 * 윗단계 스테이지에 도달한 플레이어의 수의 합
 * 
 * 먼저 각 스테이지의 실패율을 저장시킬 배열이 필요하다. 이를 answer이라고 하고
 * 길이는 N으로 만들자. 다음은, stages배열을 탐색할 차례. stages를 탐색하면서
 * 각 stage에 몇명의 플레이어가 있는지 확인을 하면된다. 이 때, 이중 반복문을
 * 활용해서 stage1에 포함된 플레이어 수를 찾고, stage2에 플레이어 수를 찾는 방식으로
 * 탐색을 진행하면 된다.
 * 실패율의 정의에 따라서, 실패율을 구한 후 이를 map 자료구조에 저장하자.
 * key값은 stage로 하고 value는 각 stage의 실패율.
 * 최종적으로 map을 탐색하면서 큰 값을 찾아내고 이를 answer배열에 추가하는 방식
 * 으로 전체탐색을 진행하면 실패율이 높은 순서대로 정렬된 각 stage를 answer배열에
 * 넣을 수 있다.
 * 
 */
public class 실패율 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		HashMap<Integer, Double> failmap = new HashMap<Integer,Double>();
		
		for(int i=1; i<=N; i++) {
			int stage = i;
			int incompletePlayers = 0; //아직 클리어하지 못한 플레이어의 수
			int curretStageTotalPlayers = 0; // 스테이지에 도달한 플레이어의 수
			
			for(int j=0; j<stages.length; j++) {
				int player =stages[j];
				
				if(stage == player) {
					incompletePlayers++;
				}
				if(player >= stage) {
					curretStageTotalPlayers++;
				}
			}
			
			double failureRate = 0;
			
			if(incompletePlayers != 0 && curretStageTotalPlayers !=0) {
				failureRate = (incompletePlayers / (double)curretStageTotalPlayers);
			}
			failmap.put(stage, failureRate);
		}
		
		for(int i=0; i<N; i++) {
			double max = -1;
			int maxkey = 0;
			for( Integer key : failmap.keySet()) {// hashmap전체를 탐색하면서 가장 큰 실패율을 고르고  그걸 arr[i]번째에 저장한뒤 제거 
				if(max < failmap.get(key)) {
					max = failmap.get(key);
					maxkey = key;
				}
			}
			
			answer [i] = maxkey;
			failmap.remove(maxkey);
		}
		
		return answer;
	}
}
