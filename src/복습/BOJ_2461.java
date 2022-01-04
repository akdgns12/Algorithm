package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2461 {
	static class Student{
		int team, score;
		
		public Student(int team, int score) {
			this.team = team;
			this.score = score;
		}
	}
	static int N, M;
	static ArrayList<Student> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int score = Integer.parseInt(st.nextToken());
				list.add(new Student(i,score));
			}
		}
		// �������� ������������ ����
		Collections.sort(list, (o1,o2) -> o1.score - o2.score);
		
		int start = 0, end = 0;
		int cnt = 1; // �� �ݿ��� ���� �� �ο� üũ�� ����
		int count[] = new int[N];
		// �ʱ� start��ġ �� ���� Ƚ�� ����������
		count[list.get(start).team] += 1; 
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			// �� �ݿ��� �Ѹ� �� ��� �̾��� ��
			if(cnt == N) {
				ans = Math.min(ans, list.get(end).score - list.get(start).score);
				// start������ ���� Ƚ�� �ٿ��ְ�
				count[list.get(start).team] -= 1;
				if(count[list.get(start).team] == 0) cnt--; // �� ���� �ο� �ٿ��ְ�
				start++; // start����
			}else if(cnt < N) { // �� �ݿ��� ���� �ο��� ���� N���� ���� ��
				end++; 
				// ��������(end�� list���� ���̶��)
				if(end == list.size()) break;
				// end ���� �� �ش� ������ ���� �� ���ٸ� 
				if(count[list.get(end).team] == 0) {
					cnt++;
				}
				count[list.get(end).team] += 1;
			}
		}
		
		System.out.println(ans);
	}
}
