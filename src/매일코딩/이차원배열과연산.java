package 매일코딩;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	static class Num implements Comparable<Num>{
		int num;
		int cnt;
		
		public Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Num o) {
			if(this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	static int r,c,k;
	static int R,C;
	static int[][] map;
	static int answer;
	static List<Num> rows[], cols[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		R = 3;
		C = 3;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(time <= 100) {
			if(r < N && c < M && map[r][c] == k	) {
				break;
			}
			if(map.length >= map[0].length) {
				sortByRow();
			}else {
				sortByCol();
			}
			time++;
		}
		
		if(time <= 100) {
			System.out.println(time);
		}else {
			System.out.println(-1);
		}
	}
	
	public static void srotByRow() {
		int max = 0;
		rows = new List[R];
		
	}
}
