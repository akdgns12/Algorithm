package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_û�ҳ��� {
	static class Fish {
		int id, x, y, dir;
		int alive; // 0 : ����, 1: �������
		
		Fish(int id, int x, int y, int dir, int alive){
			this.id = id;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.alive = alive;
		}
	}
	static int[][] map;
	static Fish[] fish; // ����� ���� ����
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; // �� ���� �ݽðԹ������� �ȹ�
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[4][4];
		fish = new Fish[17];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int id = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				fish[id] = new Fish(id, i, j, dir, 1);
				map[i][j] = id; // map�� ����� ��ȣ ����
			}
		}
		
		int sx = 0, sy = 0; // �ʱ� ��� ��ġ
		int sd = fish[map[0][0]].dir; // �ʱ� ����� ����
		int eat = map[0][0]; // ���� ����� �� ���� ���� - (0,0) ����� ����
		
		fish[map[0][0]].alive = 0; // (0,0) ����� ����
		map[0][0] = -1; // �� �ִ� ��ġ�� -1�� ����
		
		dfs(sx, sy, sd, eat);
		
		System.out.println(ans);
	}
	
	public static void dfs(int sx, int sy, int sd, int eat) {
		ans = Math.max(ans, eat);
		
		//map �迭 ����
		int[][] tempMap = new int[map.length][map.length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		// Fish�迭 ����
		Fish[] tempFish = new Fish[fish.length];
		for(int i=0; i<17; i++) {
			tempFish[i] = new Fish(fish[i].id, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);
		}
		
		// ����� �̵�
		moveFish();
		
		// ����̵�
		for(int i=0; i<4; i++) {
			int nx = sx + dx[sd] * i;
			int ny = sy + dy[sd] * i;
			
			// ��踦 ����� �ʰ�, ����Ⱑ ���� ��ĭ�� �ƴ� ���
			if(nx >= 0 && ny >=0 && nx < 4 && ny < 4 && map[nx][ny] != 0) {
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].dir;
				map[sx][sy] = 0;
				map[nx][ny] = -1;
				fish[eatFish].alive = 0;
				
				dfs(nx, ny, nd, eat+eatFish);
				
				fish[eatFish].alive = 1; // ����� ����, ����� ��ġ ������� �ǵ�����
				
				map[sx][sy] = -1;
				map[nx][ny] = eatFish;
			}
		}
		
		/*
		 * ������ DFS�� ������ ���ϴ� ��� ���� �� ����
		 * DFS�� ���鼭 ����Ⱑ �̵��ϰ�, �� �̵��Ѵ�
		 * �� �������� ����Ⱑ �̵��ϰ�, �� �̵��ϳ�.
		 * ���� ������� ���� ���� ��Ҵ��� �׾����ķ� �ٲ�� �ȴ�.
		 * DFS�� ��͸� ���� ����Ǳ� ������, �� ��츦 üũ�ϰ� �� ���� ��츦 üũ�ϱ� ���ؼ�
		 * �����ߴ� ������ ��������ν� �ǵ��� ���� ������ �ʿ��ϴ�.
		 * ��, �ʰ� ������� ���¸� ����س���, �ٽ� ������ ���·� �ǵ��� ���� ������ �ʿ�
		 */
		
		// �� ����, ����� ���� �ǵ�����
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
		
		for(int i=0; i<17; i++) {
			tempFish[i] = new Fish(tempFish[i].id, tempFish[i].x, tempFish[i].y, tempFish[i].dir, tempFish[i].alive);
		}
	}
	
	public static void moveFish() {
		for(int i=1; i<17; i++) { // i�� ���� ����� ��ȣ
			if(fish[i].alive == 0) { //���� ������� �ѱ�
				continue;
			}
			
			int cnt = 0;
			int dir = fish[i].dir; // ���� i��° ������� ����
			int nx = 0, ny = 0; // ����Ⱑ �̵��� ĭ�� x,y ��
			
			while(cnt < 8) { // �̵��� �� �ִ� ��ġ�� ã�������� 45�� ���� �ٲٸ� �ݺ�
				dir %= 8; // ���� +1�� ���� �Ѿ�°� ó���ϱ� ���� ������ ����
				fish[i].dir = dir;
				
				nx = fish[i].x + dx[dir]; // ���⿡ �°� ��ǥ�̵�
				ny = fish[i].y + dy[dir];
				
				// �̵��� ��ġ�� �� ����, ��踦 ���� �ʴ´ٸ� �̵�����
				if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
					if(map[nx][ny] == 0) { //�̵��� ��ġ�� ��ĭ�̶��
						map[fish[i].x][fish[i].y] = 0; // ���� ��ġ ��ĭ����
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = 1;
					}else { // �̵��� ��ġ�� �ٸ� ����Ⱑ �ִ°��
						
						// �ٲ� ����� ��ġ ����
						int changeFish = fish[map[nx][ny]].id;
						
						fish[changeFish].x = fish[i].x;
						fish[changeFish].y = fish[i].y;
						map[fish[changeFish].x][fish[changeFish].y] = changeFish;
						
						// ���� ����� ��ġ ����
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				}else {
					dir++;
					cnt++;
				}
				
			}
			
		}
	}
}
