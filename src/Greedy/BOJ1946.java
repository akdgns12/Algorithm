package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 신입사원
public class BOJ1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int test = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		int[] test_count = new int[test];
		
		while(count!=test) {
			int fail_count=0;
			int N = Integer.parseInt(br.readLine());
			Grade[] g = new Grade[N];
			for(int i =0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				g[i]=new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(g);
			
			int min = 100001;
			int ans = 0;
			for(int i=0; i<N; i++) {
				if(min>g[i].second_grade) {
					min=g[i].second_grade;
					ans++;
				}
			}
			
			test_count[count]=ans;
			count++;
		}
		
		for(int i=0; i<test_count.length; i++) {
			System.out.println(test_count[i]);
		}
	}
}
		
		class Grade implements Comparable<Grade>{
			int first_grade;
			int second_grade;
			
			public Grade(int first, int second) {
				first_grade = first;
				second_grade = second;
			}
			
			@Override
			public int compareTo(Grade arg0) {
				return Integer.compare(this.first_grade, arg0.first_grade);
			}
		}
		
	

// 서류 순위 기준으로 정렬 서류 순위가 5위인 지원자부터 확인을 해보면 만약 서류 순위 5위인 지원자의
// 면접순위가 다른 지원자의 면접 순위보다 높으면 탈락하지 않는 것. 따라서 정렬된 순위가 가장 낮은 지원자부터 
// 나머지 순위에 대해 탐색을 하면서 자신보다 낮은 순위가 있다면 뽑힐 수 있는 인원에 추가하면 된다.