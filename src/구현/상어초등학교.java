package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//
public class ����ʵ��б� {
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
	static HashMap<Integer, Student> list = new HashMap<>(); // key : �л���ȣ, value : Student��ü, �� �л��� �ڸ��� ���� ���� list�� �ִ´�
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int len = N*N;
		map = new int[N][N];
		
		for(int i=0; i<len; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // �л� ��ȣ
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			int s4 = Integer.parseInt(st.nextToken());
			
		}
		
		
		calc();
		System.out.println();
	}
	
	
}
