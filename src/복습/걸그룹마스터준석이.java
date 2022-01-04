package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class �ɱ׷츶�����ؼ��� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // �ɱ׷��� ��
		int M = Integer.parseInt(st.nextToken()); // ������ �� ������ ��
		HashMap<String, String> map = new HashMap<>(); // team, name
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int j=0; j<num; j++) {
				String name = br.readLine();
				sb.append(name + " ");
			}
			map.put(team, sb.toString());
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine(); // �����̰ų�, �̸��̰ų�
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) { // ������ �°�� -> �ش����� �̸� ���
				st = new StringTokenizer(map.get(str));
				
				while(st.hasMoreTokens()) {
					result.add(st.nextToken());
				}
				
				Collections.sort(result);
				
				for(int j=0; j<result.size(); j++) {
					System.out.println(result.get(j));
				}
			}
			else { // �̸��� �� ��� -> ������ ȣ���������
				for(String key : map.keySet()) {
					st = new StringTokenizer(map.get(key));
					
					while(st.hasMoreTokens()) {
						if(str.equals(st.nextToken())) {
							System.out.println(key);
						}
					}
				}
			}
		}
	
	}
}
