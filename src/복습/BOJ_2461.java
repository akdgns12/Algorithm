package 복습;

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
		// 점수기준 오름차순으로 정렬
		Collections.sort(list, (o1,o2) -> o1.score - o2.score);
		
		int start = 0, end = 0;
		int cnt = 1; // 각 반에서 뽑은 총 인원 체크할 변수
		int count[] = new int[N];
		// 초기 start위치 팀 뽑은 횟수 증가시켜줌
		count[list.get(start).team] += 1; 
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			// 각 반에서 한명 씩 모두 뽑았을 때
			if(cnt == N) {
				ans = Math.min(ans, list.get(end).score - list.get(start).score);
				// start팀에서 뽑은 횟수 줄여주고
				count[list.get(start).team] -= 1;
				if(count[list.get(start).team] == 0) cnt--; // 총 뽑은 인원 줄여주고
				start++; // start증가
			}else if(cnt < N) { // 각 반에서 뽑은 인원이 아직 N보다 작을 때
				end++; 
				// 종료조건(end가 list범위 끝이라면)
				if(end == list.size()) break;
				// end 증가 후 해당 팀에서 뽑은 적 없다면 
				if(count[list.get(end).team] == 0) {
					cnt++;
				}
				count[list.get(end).team] += 1;
			}
		}
		
		System.out.println(ans);
	}
}
