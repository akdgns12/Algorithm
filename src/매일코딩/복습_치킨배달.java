package �����ڵ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ����_ġŲ��� {
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[][] map;
	static ArrayList<Point> person; // ������
	static ArrayList<Point> chicken; // ġŲ��
	static int ans;
	static boolean[] open;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					person.add(new Point(i, j));
				}
				else if(map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for(int i=0; i<person.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);
					
					temp = Math.min(temp, distance);
					}
				}
				 res += temp;
			}
			ans = Math.min(ans, res);
			
			return;
		}
		// i=0 ���� �ݺ��� ������ �ð��ʰ����� �Ű����� start�� �ؾ� �ð��ʰ� �ȳ�
		for(int i=start; i<chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, cnt + 1);
			open[i] = false;
		}
	}
}
