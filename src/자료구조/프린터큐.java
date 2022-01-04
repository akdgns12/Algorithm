package �ڷᱸ��;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ������ť {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>(); // ť�� Ȱ���� ���Ḯ��Ʈ
			
			for(int i=0; i<n; i++) {
				// �ʱ���ġ, �߿䵵
				q.offer(new int[] {i,sc.nextInt()});
			}
			
			int count = 0;	
			
			while(!q.isEmpty()) { // �� ���̽��� ���� �ݺ���
				int[] front = q.poll();
				boolean isMax = true; // front ���Ұ� ���� ū ���������� �Ǵ��ϴ� ����
				
				// ť�� �����ִ� ���ҵ�� �߿䵵�� ��
				for(int i=0; i<q.size(); i++) {
					// ó�� ���� ���Һ��� ť�� �ִ� i��° ���Ұ� �߿䵵�� Ŭ ���
					if(front[1] < q.get(i)[1]) {
						// ���� ���� �� i ������ ���ҵ��� �ڷ� ������.
						q.offer(front);
						for(int j=0; j<i; j++) {
							q.offer(q.poll());
						}
						
						// front ���Ұ� ���� ū ���Ұ� �ƴϿ����Ƿ� false�� �ϰ� Ž���� ��ħ
						isMax = false;
						break;
					}
				}
				
				// front ���Ұ� ���� ū ���Ұ� �ƴϿ����Ƿ� ���� �ݺ������� �Ѿ
				if(isMax == false) {
					continue;
				}
				
				// front ���Ұ� ���� ū ���ҿ����Ƿ� �ش� ���Ҵ� ����ؾ��ϴ� ������.
				count++;
				if(front[0] == m) { // ã���� �ϴ� ������� ���� ����
					break;
				}
			} // end inner while
			
			sb.append(count).append('\n');
			} // end testcase
		
		System.out.println(sb);
		
	}
}
