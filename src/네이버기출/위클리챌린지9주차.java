package ���̹�����;

import java.util.ArrayList;
import java.util.Queue;

public class ��Ŭ��ç����9���� {
	// ���α׷��ӽ� ��Ŭ�� ç���� 9���� / �׷��� Ž�� / ���� �迭
	// 1. ��� wires�� ���� ���� ������ ��带 ����� ��͸� ���� ����� ��� ����� ������ ���
	// 2. ���� ���� ������ ����� ������ ���밪 �� ���� ���� ���� answer�� ����
	static ArrayList[] array; // �׷��� ���踦 ��Ÿ�� ���� �迭 ����Ʈ
	static boolean[] visited; 
	
		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			array = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {  
				array[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<wires.length; i++) { // wires�� ���� ���� �迭 ����Ʈ�� �־��ش�.
				array[wires[i][0]].add(wires[i][1]);
				array[wires[i][1]].add(wires[i][0]);
			}
			
			for(int i=0; i<wires.length; i++) {
				visited = new boolean[n+1];
				visited[wires[i][0]] = true;
				visited[wires[i][1]] = true;
				int a = bfs(wires[i][0]); // bfs������ �ش� �ε��� ����� ����� ��尡 ����� ����
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
