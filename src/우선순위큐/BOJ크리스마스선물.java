package �켱����ť;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJũ������������ {
	// BOJ 14235 ũ�������� ���� �ǹ�3 / �켱���� ť
	static int n; // ������ �湮 Ƚ��
	static int a; // ���������� ������ ������ ����
	// �������� ����
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				if(pq.isEmpty()) System.out.println(-1);
				else System.out.println(pq.poll());
			}else {
				for(int j=0; j<a; j++) {	
					pq.offer(Integer.parseInt(st.nextToken()));	
				}
			}
		} // end of input
		
	
	}
}
