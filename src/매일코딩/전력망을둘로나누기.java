package 매일코딩;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {
	static class Node{
		int index, num;
		
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}
	// 프로그래머스 위클리 챌린지 9주차 / 네이버 2020 하반기 2번 문제 쉬운버전
	static ArrayList<Node>[] list;
	// 1. 각 간선끊고
	// 2. bfs돌면서 몇개인지 체크
	
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		// 노드간의 관계나타낼 인접리스트 배열 초기화
		list = new ArrayList[n+1]; 
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// Node클래스에 간선 정보 넣어줌
		for(int i=0; i<n-1; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			list[a].add(new Node(b, i));
			list[b].add(new Node(a, i));
		}
		
		for(int i=0; i<n-1; i++) {
		 // i번 간선 끊기
			boolean[] visited = new boolean[n+1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(1);
			visited[1] = true;
			int cnt = 1;
			
			while(!q.isEmpty()) {
				int nowIndex = q.poll();
				
				// 여기서 현재 인덱스와 Node에 넣어놓은 노드정보 비교
				for(Node nextNode : list[nowIndex]) {
					if(nextNode.num == i || visited[nextNode.index]) {
						continue;
					}
					
					q.offer(nextNode.index);
					visited[nextNode.index]= true;
					cnt++;
				}
			}
			
			answer = Math.min(answer, Math.abs(n - cnt - cnt));
		}

		
		
		return answer;
	}
	
	
}
