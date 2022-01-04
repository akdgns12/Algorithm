package 네이버기출;

import java.util.ArrayList;
import java.util.Queue;

public class 위클리챌린지9주차 {
	// 프로그래머스 위클리 챌린지 9주차 / 그래프 탐색 / 인접 배열
	// 1. 모든 wires의 왼쪽 노드와 오른쪽 노드를 끊어가며 재귀를 통해 연결된 모든 노드의 개수를 계산
	// 2. 왼쪽 노드와 오른쪽 노드의 차이의 절대값 중 가장 작은 값을 answer에 저장
	static ArrayList[] array; // 그래프 관계를 나타낼 인접 배열 리스트
	static boolean[] visited; 
	
		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			array = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {  
				array[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<wires.length; i++) { // wires의 관계 인접 배열 리스트에 넣어준다.
				array[wires[i][0]].add(wires[i][1]);
				array[wires[i][1]].add(wires[i][0]);
			}
			
			for(int i=0; i<wires.length; i++) {
				visited = new boolean[n+1];
				visited[wires[i][0]] = true;
				visited[wires[i][1]] = true;
				int a = bfs(wires[i][0]); // bfs돌리며 해당 인덱스 노드의 연결된 노드가 몇개인지 리턴
				int b = bfs(wires[i][1]);
				answer = Math.min(answer, Math.abs(a-b));
			}
			
			return answer;
	}
		
		public static int bfs(int index) {
			int sum = 1;
			visited[index] = true;
			for(int i=0; i<array[index].size(); i++) {
				if(visited[(int)array[index].get(i)]) continue;
				sum += bfs((int)array[index].get(i));
			}
			return sum;
		}
}
