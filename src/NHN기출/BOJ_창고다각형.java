package NHN기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_창고다각형 {
	// BOJ 창고다각형 실버 2 / 주어진 기둥들의 높이와 위치로 창고다각형의 면적 return /완탐?
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
		
		N = Integer.parseInt(br.readLine()); // 기둥 개수
	
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
				max_idx = i; // 가장 높은 기둥의 idx
			}
		}
		
		int sum = list.get(max_idx).h;
		int left_idx = max_idx;
		
		// 왼쪽에서 가장 큰 기둥까지
		int sum = 0;
		int h = 0;
		for(int i=min_idx; i<max_height_idx; i++) {
			h = Math.max(h, map[i]);
			sum += h;
		}
		
		h = 0;
		
		// 오른쪽에서 가장 큰 기둥까지
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
