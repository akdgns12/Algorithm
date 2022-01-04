package 자료구조;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class 프린터큐 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>(); // 큐로 활용할 연결리스트
			
			for(int i=0; i<n; i++) {
				// 초기위치, 중요도
				q.offer(new int[] {i,sc.nextInt()});
			}
			
			int count = 0;	
			
			while(!q.isEmpty()) { // 한 케이스에 대한 반복문
				int[] front = q.poll();
				boolean isMax = true; // front 원소가 가장 큰 원소인지를 판단하는 변수
				
				// 큐에 남아있는 원소들과 중요도를 비교
				for(int i=0; i<q.size(); i++) {
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
					if(front[1] < q.get(i)[1]) {
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front);
						for(int j=0; j<i; j++) {
							q.offer(q.poll());
						}
						
						// front 원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						isMax = false;
						break;
					}
				}
				
				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax == false) {
					continue;
				}
				
				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				count++;
				if(front[0] == m) { // 찾고자 하는 문서라면 테케 종료
					break;
				}
			} // end inner while
			
			sb.append(count).append('\n');
			} // end testcase
		
		System.out.println(sb);
		
	}
}
