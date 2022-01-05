package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//
public class 상어초등학교 {
	static class Student{
		int x, y;
		int[] flist;
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	static int N;
	static int[][] map;
	static int[][] nearEmptySeatCnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static HashMap<Integer, Student> list = new HashMap<>(); // key : 학생번호, value : Student객체, 한 학생이 자리를 고르고 나면 list에 넣는다
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int len = N*N;
		map = new int[N][N];
		
		for(int i=0; i<len; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 학생 번호
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			int s4 = Integer.parseInt(st.nextToken());
			
		}
		
		
		calc();
		System.out.println();
	}
	
	
}
