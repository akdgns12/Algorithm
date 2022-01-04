package ����Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �ٸ����_������3 {
	static class Virus{
		int x, y, time;
		
		public Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N, M;
	static ArrayList<Virus> list = new ArrayList<>();
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int blank; // ��ĭ ���
	static int[] picked; // ���� ������ ���
	static int min = Integer.MAX_VALUE; // �����(�ּҽð�)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // ���̷����� ���
					list.add(new Virus(i,j,1));
				}else if(map[i][j] == 0) {
					blank++;
				}
			}
		}
		
		// ��ĭ ���� ��� �ٷ� ��
		if(blank == 0) {
			System.out.println(0);
			return;
		}
		
		// ���� ������ �����ϱ� ���� �迭
		picked = new int[M];
		
		// ���� + Ž�� ����
		combination(0,0);
		
		// �� ��ä��� �׳� ����
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(min);
	}
	
	// cnt(������� ���� ����), cur(���� ����Ű�� ��ȣ)
	public static void combination(int cnt, int cur) {
		if(cnt == M) {
			bfs(); // ���� �ϼ��Ǹ� Ž�� ����
			return;
		}
		
		for(int i=cur; i<list.size(); i++) {
			picked[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		visited = new boolean[N][N];
		
		// ���� ����� ���̷��� ����Ʈ�� �����ؼ� Q�� ����
		for(int i=0; i<M; i++) {
			q.add(list.get(picked[i]));
			visited[list.get(picked[i].x)][list.get(picked[i].y)];
		}
		
		int time = 0; // �ɸ� �ð� ���
		int count = 0; // ��ĭ Ȯ�� ī����
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// ������ �ִ� ���̷����� �ð����� �޾ƿ��Ƿ� ��� ������ �� �ۿ� ����
				time = virus.time;
				
				// ���� ��
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				// ��ĭ�̾ Ȯ���� ���
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					count++;
					q.add(new Virus(nx, ny, v.time+1));
				}
				
				// Ȯ���� �������� ������ �� �ִ� ���
				if(map[nx][ny] == 2) { // Ȱ��ȭ�� ���̷����� Ȱ��ȭ���� ���� ���̷����� ������ �� ����
					visited[nx][ny] = true;
					q.add(new Virus(nx , ny, v.time+1));
				}
			}
			
			// ���� �̹� ��ĭ�� ä�����ٸ� ������ �����Ŵ���ν� �ð����� ��� ������ ����
			if(count == blank) {
				time++; // �� ���, ���� ���� �ð��� �Ҵ��� �ȵǹǷ�, ���Ƿ� 1����
				break;
			}
		}
		
		if(count != blank) return; // �� ��ä��� �׳� ������
		
		// time-1�� ���� : �������� +1�� ���¸� q�� ������ ����
		min = Math.min(min, time-1);
	}
}
