package �丶��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs����
/*
 * �Ϸ翡 �����¿� ��ĭ�� �̵��ϴ� BFS�� �ٷ� ��������.
 * Ŭ������ ������ �ϳ� �� �߰��Ͽ� ī��Ʈ �ϴ� ������� Ǯ����.
 * �Ϲ������� BFS���������� visited 2���� �迭�� ����Ͽ� �ߺ� �湮�� ����������
 * �� ���������� 1�� �� ������ �ϰ� �ִ�.
 * 
 * <����>
 * 1. 2�� for������ box�迭�� ���鼭 ���� �丶�並 Queue �ڷᱸ���� �ֱ�
 * 2. bfs�� ���鼭 �丶�� ��� �Ͱ� �ϱ�
 * 3. �ٽ� 2�� for�� ���鼭 �� ���� �丶�䰡 �ִٸ� -1���, ������ ��¥ ���
 */
public class BOJ_7576 {
	
	static int m,n, count, day;
	static int[][] arr;
	static Queue q1 = new LinkedList();
	static Queue q2 = new LinkedList();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		count = n*m;
		arr = new int[n+1][m+1];
		
		String str = br.readLine();
		for(int i=0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1) {
					--count;
					q1.add(i);
					q2.add(j);
				}else if(arr[i][j]==-1) {
					--count;
				}
			}
		} // ���� ���߸� queue�� ���� �ֱ�
		
		while(!q1.isEmpty()) {
			
			int x = (int) q1.poll();
			int y = (int) q2.poll();
			
			for(int i=0; i<4; i++) { // �����¿� üũ
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && ny >=0 && nx<= n-1 && ny <= m-1) {
					if(arr[nx][ny] == 0) {  //���� ���� ���� �϶���
						q1.add(nx);
						q2.add(ny);
						arr[nx][ny] = arr[x][y] + 1;
						day = arr[x][y];
						--count;
					}
				}
			}
		}
		
		if(count==0) {
			System.out.println(day); // ���߰� ��� �;����� day ���
		}else if(count>0) {
			System.out.println("-1"); // ���� ���� ���߰� �������� -1 ���
		}
	}
}
