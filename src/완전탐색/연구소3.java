package ����Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������3 {
	// ���̷��� ��� ������ �ɸ��� �ּҽð�
	/*
	 * 1. M���� ���̷����� �����ϴ� Combination(��Ʈ��ŷ)
	 * 2. ���̷����� ��ǥ ArrayList<Virus> viruses�� ����
	 * 3. ��͸� ���� Ȱ��ȭ��ų ���̷��� ����Ʈ�� Virus[] active�� �޾� ����
	 * 4. ���̷��� ��Ʈ����� BFS��
	 * 5. ���̷��� ��Ʈ�� ���� ���� �����ؼ� ���
	 */
	static class Virus{
		int x, y, time;
		
		public Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Virus> viruses = new ArrayList<>();
	static Virus[] active;
	static int result = Integer.MAX_VALUE;
	static int OriginEmptySpace = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		active = new Virus[M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) { // ���̷���
					viruses.add(new Virus(i,j,0));
				}else if(map[i][j] == 0) { // �� ����
					OriginEmptySpace ++;
				}
			}
		}
		
		if(OriginEmptySpace == 0) {
			System.out.println(0);
		}else {
			selectVirus(0,0);
			// ��Ʈ�� �� ���� ��쿡�� -1 ���
			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
		
		
		
	}
	
	// ��Ʈ��ŷ���� M���� ���̷����� �����ϴ� Combination ����
	public static void selectVirus(int start, int selectCount) {
		if(selectCount == M) { // M���� ���̷��� ��� �����ߴٸ� ���̷��� ��Ʈ����
			spreadVirus(OriginEmptySpace);
			return;
		}
		
		for(int i=start; i<viruses.size(); i++) {
			active[selectCount] = viruses.get(i);
			selectVirus(i + 1, selectCount + 1);
		}
	}
	
	// ���̷��� ��Ʈ����
	public static void spreadVirus(int emptySpace) {
		Queue<Virus> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<M; i++) {
			Virus virus = active[i];
			visited[virus.x][virus.y] = true;
			// ť�� Ȱ��ȭ�� ���̷��� �ֱ�
			q.add(virus);
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];
				
				// map�� ���� ����� ��� skip
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// �̹� �湮�߰ų� ���ΰ�� skip
				if(visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if(map[nx][ny] == 0) { // ������̶��
					emptySpace--;
				}
				
				if(emptySpace == 0) {
					result = Math.min(result, virus.time + 1);
					return;
				}
				
				visited[nx][ny] = true;
				q.add(new Virus(nx, ny, virus.time + 1));
			}
		}
	}
}
