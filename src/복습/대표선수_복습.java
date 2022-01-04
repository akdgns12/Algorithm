package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 대표선수_복습 {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int score = Integer.parseInt(st.nextToken());
				list.add(new Student(i,score)); // 점수, 반
			}
		}
		// 점수기준 오름차순 정렬
		Collections.sort(list, (o1,o2) -> o1.score - o2.score);
	    int start = 0, end = 0;
	    int count[] = new int[N];
	    int min = Integer.MAX_VALUE;
	    count[list.get(0).team] += 1; 
	    int cnt = 1; // 각 학급이 모두 들어가있는지 확인

        while (true) {
            //각 학급의 대표자들이 1명씩 뽑힌 상황
            if (cnt == N) {
                min = Math.min(min, list.get(end).score - list.get(start).score);
                count[list.get(start).team] -= 1;
                if(count[list.get(start).team] == 0) cnt--;
                start++;
            } else if (cnt < N) {
                end++;
                if(end == list.size()) break;

                if(count[list.get(end).team] == 0){
                    cnt++;
                }
                count[list.get(end).team] += 1;
            }
        }
        System.out.println(min);
	}
}
