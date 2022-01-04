package NHN����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_â��ٰ��� {
	// BOJ â��ٰ��� �ǹ� 2 / �־��� ��յ��� ���̿� ��ġ�� â��ٰ����� ���� return /��Ž?
	static class Node{
		int idx;
		int h;
		public Node(int idx, int h) {
			this.idx = idx;
			this.h = h;
		}
	}
	
	static int N;
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine()); // ��� ����
	
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.idx - o2.idx;
			}
		});
		
		int max = 0;
		int max_idx = 0;
		for(int i=0; i<N; i++) {
			if(max < list.get(i).h) {
				max = list.get(i).h;
				max_idx = i; // ���� ���� ����� idx
			}
		}
		
		int sum = list.get(max_idx).h;
		int left_idx = max_idx;
		
		// ���ʿ��� ���� ū ��ձ���
		int sum = 0;
		int h = 0;
		for(int i=min_idx; i<max_height_idx; i++) {
			h = Math.max(h, map[i]);
			sum += h;
		}
		
		h = 0;
		
		// �����ʿ��� ���� ū ��ձ���
		for(int i=max_idx; i>max_height_idx; i--) {
			h = Math.max(h, map[i]);
			sum += h;
		}
		
		int left_sum = 0;
		int right_sum = 0;
		for(int i=0; i<map.length; i++) {
			if(i > max_height_idx) {
				left_sum += map[i];
			}
		}
		
		for(int i=0; i<map.length; i++) {
			if(i > max_height_idx) {
				right_sum += map[i];
			}
		}
		
		System.out.println(map[max_height_idx] + sum);
	}
}
