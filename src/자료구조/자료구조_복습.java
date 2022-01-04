package 자료구조;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class 자료구조_복습 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int  t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt(); // 문서의 개수
			int m = sc.nextInt(); // 원하는 문서의 위치
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int i=0; i<n; i++) { // 문서 위치와 중요도 쌍으로 넣음
				q.offer(new int[] {i,sc.nextInt()});
			}
			
			int count = 0; // 몇번째로 출력되는지 셀 변수
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true; // front가 가장 큰 원소인지 확인할 boolean 변수
				
				for(int i=0; i<q.size(); i++) {
					if(front[1] < q.get(i)[1]) { // 만약 front보다 더 큰 중요도가 있다면
						// 뽑은 원소 및 i이전의 원소들을 뒤로 보낸다
						for(int j=0; j<i; j++) {
							q.offer(front);
							q.offer(q.poll());
						}
						
						isMax = false;
						break;
					}
				}
				
				if(isMax == false) continue;
				
				count++;
				if(front[0] == m) {
					break;
				}
			}
			
			sb.append(count).appned('\n');
		}
		
		System.out.println(sb);
		
	}
}
