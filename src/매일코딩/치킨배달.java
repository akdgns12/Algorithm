package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 0 : �� ĭ, 1 : ��, 2 : ġŲ ��
// ġŲ �Ÿ� = ���� ���� ����� ġŲ�� ������ �Ÿ�
// ������ ġŲ�Ÿ� = ��� ���� ġŲ�Ÿ��� ��
// ���ÿ� �ִ� ġŲ�� �߿��� �ִ� M���� ����, ������ ġŲ���� ��� ���
// ��� ����, ������ ġŲ �Ÿ��� ���� �۰� ���� ���϶�.
// ���� �� ġŲ���� �����ϰ� ������.
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * ����
 * 1. ���� ġŲ���� ��ǥ�� ���� list�� �־��ش�. 
 * 2. ġŲ���� open�� ������ M�� �������, ��� ���� ���Ͽ� M���� ġŲ�� �� �ִܰŸ��� ���
 * 3. Ž���� �����ϴ� ������ ġŲ�� list�� ����� ����� �Ǹ� Ž�� ����
 */
class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class ġŲ��� {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
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
		
		// �̸� ���� ġŲ���� �ش��ϴ� ��ǥ�� ArrayList�� �־� ��
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if(map[i][j] == 1) {
					person.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
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
				
				// � ���� ġŲ�� �� open�� ġŲ���� ��� �Ÿ��� ���Ѵ�.
				// �� ��, �ּ� �Ÿ��� ���Ѵ�.
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
		
		// ��Ʈ��ŷ
		for(int i=start; i<chicken.size(); i++) {
			open[i] = true;
			dfs(i+1, cnt+1);
			open[i] = false;
		}
	}
	
}
