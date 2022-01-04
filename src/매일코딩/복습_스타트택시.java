package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_��ŸƮ�ý� {
	static class Taxi{
		int x, y, move;
		
		Taxi(int x, int y, int move){
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}
	
	static class Passenger{
		int id, sx, sy, ex, ey;
		
		Passenger(){
			
		}
	}
	static int N, M, fuel;
	static int[][] map = new int[21][21];
	static Taxi taxi;
	// ����Ÿ�� �ִ� �°�. null�̸� �ƹ��� Ÿ�� ���� ����, ������ Ÿ�� �ִٸ� �ش� �°� ��ü�� ����.
	static Passenger taken = null;
	// �°� ����Ʈ. �°��� �������� ���� ������ �ش�°��� ���������鼭 ��� �°��� ���ȴ��� üũ
	static HashMap<Integer, Passenger> passMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �ý� ��ǥ
		st = new StringTokenizer(br.readLine());
		taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// �°� Ŭ���� ��ü ����
			Passenger p = new Passenger();
			p.id = i+2; // 0 : ��ĭ, 1 : �� �̹Ƿ� 2���� �� �°��� �ѹ������ش�
			p.sx = Integer.parseInt(st.nextToken()); // �����ǥ
			p.sy = Integer.parseInt(st.nextToken());
			p.ex = Integer.parseInt(st.nextToken()); // ������ǥ
			p.ey = Integer.parseInt(st.nextToken());
			
			passMap.put(p.id, p);
			
			// ������� ��ġ�� �ʱ⶧���� �ʿ� ���
			map[p.sx][p.sy] = p.id;
		}
		
		solution();
	}
	
	// ��� �°��� �������ٶ����� BFS�ݺ��ϸ� ������ ���� Ȯ���Ѵ�.
	public static void solution() {
		while(!passMap.isEmpty()) { 
			int toStartFuel = bfs();
			fuel -= toStartFuel;
			
			if(fuel < 0)
				break;
			
			int toDesFeul = bfs();
			fuel -= toDesFeul;
			
			if(fuel < 0)
				break;
			
			fuel += toDesFeul * 2;
		}
		System.out.println(fuel < 0 ? -1 : fuel);
	}
	
	public static int bfs() {
		Queue<Taxi> q = new LinkedList<>();
		// �ý÷κ��� ���� �Ÿ��� �ִ� �°���. �ýÿ� Ż �� �ִ� �ĺ����̸� ������� ���ϱ� ���� ����Ѵ�.
		Queue<Passenger> candidates = new LinkedList<>();
		boolean[][] visited = new boolean[21][21];
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int preMove = taxi.move;
		visited[taxi.x][taxi.y] = true;
		q.add(taxi);
		
		while(!q.isEmpty()) {
			Taxi now = q.poll();
			
			// �̵��߿� ���ᰡ �������� ����
			if(fuel - now.move < 0) {
				return Integer.MAX_VALUE;
			}
			
			// �ý� �̵� �ð��밡 �ٸ��� candidates�� �̹� �����ϸ� break;
			if(preMove != now.move && !candidates.isEmpty()) {
				break;
			}
			
			preMove = now.move;
			
			if(taken == null) {
				// �ýð� ����ִ� ��� ���� ����� �°� �ĺ��� �������� candidate�� �߰�
				int id = map[now.x][now.y];
				
				if(id > 1) {
					Passenger p = passMap.get(id);
					candidates.add(p);
				}
			}else {
				// �ýÿ� �°��� �ִ� ��� �������� ������ ����
				if(now.x == taken.ex && now.y == taken.ey)){
					passMap.remove(taken.id);
					taken = null;
					taxi = new Taxi(now.x, now.y, 0);
					return preMove;
				}
			}
			
			// �������� �̵�
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx > 0 && nx < N+1 && ny > 0 && ny < N+1) {
					if(map[nx][ny] != 1 && !visited[nx][ny]) {
						q.add(new Taxi(nx, ny, now.move+1));
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		// while���� �����µ� candidates�� �ƹ��� ������ ���� ������ ���� ����
		if(candidates.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		
		taken = findNearest(candidates);
		taxi = new Taxi(taken.sx, taken.sy, 0);
		map[taken.sx][taken.sy] = 0;
		return preMove;
	}
	
	// ���� �Ÿ��� x�� �۰�, y��  ���� �������
	public static Passenger findNearest(Queue<Passenger> q ) {
		Passenger target = q.poll();
		
		while(!q.isEmpty()) {
			Passenger compare = q.poll();
			
			if(compare.sx < target.sx) {
				target = compare;
			}else if(compare.sx == target.sx && compare.sy < target.sy) {
				target = compare;
			}
		}
		
		return target;
	}
}
