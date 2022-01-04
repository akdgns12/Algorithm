package DFS_BFS;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// �ＺSW ���� �׽�Ʈ ����
/*
 * N*N�� ���ð� �־����� ġŲ���� �ִ밳�� M�� �־����� ��
 * �־��� ġŲ�� �� ��� M���� ����
 * ������ ġŲ �Ÿ��� ���� �۰� ���� ���ϴ� ���α׷�
 */

/*
 *  <����>
 *  BFS�� �ִܰŸ��� ���ϰ�, ����Լ��� �̿��Ͽ� �ذ��Ϸ� ������ �ð��ʰ� �̽�
 *  <�˰���>
 *  DFS�� ��Ʈ��ŷ�� �̿��ϸ� �����ϰ� Ǯ���� ����
 *  ���� ġŲ���� ��ǥ�� ���� ArraysList�� �־� ��������� �Ѵ�
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
	
	static int N,M;
	static int[][] map;
	static boolean[] open;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		//Input �̸� ���� ġŲ���� �ش��ϴ� ��ǥ�� ArrayList�� �־� ��
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE; // ���� ������ ġŲ �Ÿ��� �ּڰ�
		open = new boolean[chicken.size()]; // 
		DFS(0,0);
		
		System.out.println(ans);
		
	}

	/*������ ġŲ �Ÿ��� �ּڰ��� ���ؾ� �Ѵ�!!!
	  ġŲ �Ÿ��� ���� ���� ����� ġŲ�� ������ �Ÿ�. �� ġŲ �Ÿ��� ���� �������� ��������, ������ ���� ġŲ �Ÿ��� ������ �ִ�.
	  ������ ġŲ �Ÿ��� ��� ���� ġŲ �Ÿ��� ��
	*/
	// ans = ��� ���� ġŲ �Ÿ��� ��
	/*
	 * 1. ���� ġŲ���� ��ǥ�� ���� list�� �����صд�
	 * 2. ġŲ���� open �� ������ M�� ���ٸ�, ��� ���� ���Ͽ� M���� ġŲ�� �� �ִܰŸ��� ����Ѵ�.
	 * 3. Ž���� �����ϴ� ������ ġŲ�� list�� ����� ����� �Ǹ� Ž���� �����Ѵ�.
	 */
	static void DFS(int start, int depth) {
		if(depth == M) { // dpeth�� �Էµ� �����Ű�� ���� �ִ� ġŲ���� ���� M
			int res = 0;
			
			for(int i=0; i<home.size(); i++) {
				int temp = Integer.MAX_VALUE;
			
				//� ���� ġŲ �� �� open�� ġŲ���� ��� �Ÿ��� ���Ѵ�
				//�� ��, �ּ� �Ÿ��� ���Ѵ� = ���� ġŲ �Ÿ�
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance); //�� �� �ּҰŸ�
					}
				}
				res += temp; // res �ӽ� ������ �ּҰŸ� ���� ����
			}
			
			ans = Math.min(ans, res); 
			return;
		}
		
		//��Ʈ��ŷ
		for(int i= start; i<chicken.size(); i++) {
			open[i] = true;
			DFS(i + 1, depth + 1);
			open[i] = false;
		}
	}
}
