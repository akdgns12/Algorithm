package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �似Ǫ������ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(q.size() != 1) { // ť ����� 1�϶����� �ݺ�
			// K-1��° ������ ó���� �ִ� ���� �ǵڷ� ������
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			// K��° ���� poll�� �� ����Ѵ�
			sb.append(q.poll() + ", ");
		}
		
		// ť ����� 1�϶��� �ܼ��� poll�ϸ� �ȴ�.
		sb.append(q.poll() + ">");
		
		System.out.println(sb.toString());
	}
}
