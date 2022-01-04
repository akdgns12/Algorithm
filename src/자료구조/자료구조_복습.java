package �ڷᱸ��;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class �ڷᱸ��_���� {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int  t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt(); // ������ ����
			int m = sc.nextInt(); // ���ϴ� ������ ��ġ
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int i=0; i<n; i++) { // ���� ��ġ�� �߿䵵 ������ ����
				q.offer(new int[] {i,sc.nextInt()});
			}
			
			int count = 0; // ���°�� ��µǴ��� �� ����
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true; // front�� ���� ū �������� Ȯ���� boolean ����
				
				for(int i=0; i<q.size(); i++) {
					if(front[1] < q.get(i)[1]) { // ���� front���� �� ū �߿䵵�� �ִٸ�
						// ���� ���� �� i������ ���ҵ��� �ڷ� ������
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
