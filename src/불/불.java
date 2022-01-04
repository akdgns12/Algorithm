package ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ_5427
/*
class f_Point{
	int x;
	int y;
	f_Point(int y, int x){
		this.x = x;
		this.y = y;
	}
}

public class �� {
	
	static int tc,w,h;
	static int cnt;
	static int[][] map;
	static boolean[][] s_visited;
	static boolean[][] f_visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue fire_Q;
	static Queue sangun_Q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		s_visited = new boolean[h][w];
		f_visited = new boolean[h][w];
		fire_Q = new LinkedList();
		sangun_Q = new LinkedList();
		cnt = 0;
		
		for(int i=0; i<h; i++	) {
			String s = br.readLine();
			for(int j=0; j<w; j++	) {
				char c = s.charAt(i);
				if( c == '.') map[i][j] = 0;
				if(c == '#') map[i][j] = 1;
				if(c == '*') {
					map[i][j] = 2;
					fire_Q.add(new f_Point(i,j));
					f_visited[i][j] = true;
				}
				if(c == '@') {
					map[i][j] =3;
					sangun_Q.add(new f_Point(i,j));
					s_visited[i][j] = true;
				}
			}
		}
		
		while(true) {
			cnt +=1;
			fire_Move();
			if(sangun_Move()) {
				System.out.println(cnt);
				break;
			}
			//����� false�̸�
			if(!escapePossible()) {
				System.out.println("IMPOSSIBLE");
				break;
			}
		}
		}
	}
	
	public static void print_Map() {
		System.out.println("----------");
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.println(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
	
	public static boolean escapePossible() {
		if(sangun_Q.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void fire_Move() {
		int fireSize = fire_Q.size();
		
		for(int s=0; s<fireSize; s++) {
			f_Point fp = (f_Point) fire_Q.poll();
			int sero = fp.y;
			int garo = fp.x;
			for(int i=0; i<4; i++) {
				int nx = garo + dx[i];
				int ny = sero + dy[i];
				if( nx >=0 && nx<w && ny >=0 && ny < h) {
					//�� �����̸� �� ������
					if(map[ny][nx] !=1 && !f_visited[ny][nx]) {
						map[ny][nx] = 2;
						f_visited[ny][nx] = true;
						fire_Q.add(new f_Point(ny, nx));
					}
				}
			}
		}
	}
	
	public static boolean sangun_Move() {
		int fireSize = sangun_Q.size();
		for(int s=0; s<fireSize; s++) {
			f_Point fp = (f_Point) sangun_Q.poll();
			int sero = fp.y;
			int garo = fp.x;
			for(int i=0; i<4; i++) {
				int nx = garo + dx[i];
				int ny = sero + dy[i];
				//Ż�� ���� �Ͻ�
				if(nx < 0 || nx >= w || ny < 0 || ny >=h) {
					return true;
				}
				if(nx >=0 && nx < w && ny >=0 && ny < h) {
					//�� �����̸� �� ������
					if(map[ny][nx] == 0 && !s_visited[ny][nx]) {
						map[ny][nx] = 3;
						s_visited[ny][nx] =true;
						sangun_Q.add(new f_Point(ny, nx));
					}
				}
			}
		}
		return false;
	}
}

*/

class f_Point{
	int x;
	int y;
	f_Point(int y, int x){
		this.x = x; 
		this.y = y; 
	}
}
public class �� {
	static int n;
	static int w;
	static int h;
	static int testCase ;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] s_Visit;
	static boolean[][] f_Visit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Queue fire_Q;
	static Queue sangun_Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		for ( int t = 0; t < testCase; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			//�ʱ�ȭ
			map = new int[h][w];
			s_Visit = new boolean[h][w];
			f_Visit = new boolean[h][w];
			fire_Q = new LinkedList();
			sangun_Q = new LinkedList();
			cnt = 0;
			//�ʱ�ȭ ��
			for ( int i = 0 ; i < h; i++) {
				String s = br.readLine();
				for (int j=0; j< w; j++) {
					char c = s.charAt(j);
					if ( c == '.' ) map[i][j] = 0;
					if ( c == '#' ) map[i][j] = 1;
					if ( c == '*' ) {
						map[i][j] = 2;
						fire_Q.add(new f_Point(i, j));
						f_Visit[i][j] = true;
					}
					if ( c == '@' ) {
						map[i][j] = 3;
						sangun_Q.add(new f_Point(i,j));
						s_Visit[i][j] = true;
					}
					
				}
			}
			
			while(true) {
				//print_Map();
				cnt += 1;
				fire_Move();
				if ( sangun_Move()) {
					System.out.println(cnt);
					break;
				}
				//����� false�� 
				if(!escapePossible()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
			}
		}
	
	}
	
	/*public static void print_Map() {
		System.out.println("----------");
		for (int i = 0; i< h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}*/
	
	public static boolean escapePossible() {
		if( sangun_Q.isEmpty() ) {
			return false;
		}
		return true;
	}
	public static void fire_Move() {
		int fireSize = fire_Q.size() ;
		
		for ( int s = 0; s < fireSize; s++ ) {
			f_Point fp = (f_Point) fire_Q.poll();
			int sero = fp.y;
			int garo = fp.x;
			for (int i = 0 ; i < 4; i++) {
				int xx = dx[i] + garo;
				int yy = dy[i] + sero;
				if ( xx >= 0 && xx < w && yy >= 0 && yy < h ) {
					// �� �����̸� �� ������ 
					if ( map[yy][xx] != 1 && !f_Visit[yy][xx]) {
						map[yy][xx] = 2;
						f_Visit[yy][xx] = true;
						fire_Q.add(new f_Point(yy,xx));
						
					}
				}
				
			}
		}
	}
	public static boolean sangun_Move() {
		int fireSize = sangun_Q.size() ;
		for ( int s = 0; s < fireSize; s++ ) {
			f_Point fp = (f_Point) sangun_Q.poll();
			int sero = fp.y;
			int garo = fp.x;
			for (int i = 0 ; i < 4; i++) {
				int xx = dx[i] + garo;
				int yy = dy[i] + sero;
				//Ż�� ���� �Ͻ� 
				if ( xx < 0 || xx >= w || yy < 0 || yy >= h ) {
					return true;
				}
				if ( xx >= 0 && xx < w && yy >= 0 && yy < h ) {
					// �� �����̸� �� ������ 
					if ( map[yy][xx] == 0 && !s_Visit[yy][xx]) {
						map[yy][xx] = 3;
						s_Visit[yy][xx] = true;
						sangun_Q.add(new f_Point(yy,xx));
						
					}
				}
				
			}
		}
		return false;
	}

}
class Pos{
	int x;
	int y;
	int time;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Pos(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
/*
 * class ��{ static int R,C; // ��, �Ʒ�, ����, ������ static int[] dx = {-1,1,0,0};
 * static int[] dy = {0,0,-1,1}; static int min;
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in));
 * 
 * int T = Integer.parseInt(br.readLine()); for(int tc=1; tc<=T; tc++) {
 * String[] temp = br.readLine().split(" "); R = Integer.parseInt(temp[1]); C =
 * Integer.parseInt(temp[0]); Pos person = null; // �ʱ� ����� ��ġ Queue<Pos> fires =
 * new LinkedList<>(); // �ʱ� ���� ��ġ
 * 
 * // �Ұ� ����� �湮 ���� üũ // ���� ������ �ѷ��δ� �ڽ����·� ��,�Ʒ�,����,���������� �� ĭ�� �� ũ�� ����� int[][]
 * visited = new int[R+2][C+2];
 * 
 * //�Է¹ޱ� for(int i=1; i<R+1; i++) { String s = br.readLine(); for(int j=1;
 * j<C+1; j++) { char c = s.charAt(j-1); if(c == '*') { fires.offer(new
 * Pos(i,j)); visited[i][j] = -1; } else if(c == '@') person = new Pos(i,j,0);
 * else if(c == '#') visited[i][j] = -1; } }
 * 
 * min = Integer.MAX_VALUE; bfs(person, fires, visited); // bfsŽ��
 * 
 * // MAX_VALUE �״�� ��� ���� �������� ���� ���̹Ƿ� IMPOSSIBLE ��� if(min !=
 * Integer.MAX_VALUE) System.out.println(min); else
 * System.out.println("IMPOSSIBLE"); } }
 * 
 * private static void bfs(Pos person, Queue<Pos> fires, int[][] visited) {
 * Queue<Pos> q = new LinkedList<>();
 * 
 * //�ʱ�ȭ visited[person.x][person.y] = 1; q.offer(person);
 * 
 * //������� ��ġ�� ���� queue�� �������� ���� while(!q.isEmpty()) { //�� ���� �۶߸��� // �ð� ���� ��Ʈ����
 * ���� �ʱ� ����ִ� ���� ������ŭ�� �����ϰ� // ���� �̵��� ���� ���� �ݺ��� ��Ʈ����. for(int i=0;
 * end=fires.size(); i<end; i++ ) { Pos f = fires.poll(); int fx = f.x; int fy =
 * f.y;
 * 
 * for(int j=0; j<4; j++) { int dfx = fx + dx[i]; int dfy = fy + dy[i];
 * 
 * if(dfx > 0 && dfy > 0 && dfx < R+1 && dfy < C+1 && visited[dfx][dfy] != -1 )
 * { visited[dfx][dfy] = -1; fires.offer(new Pos(dfx, dfy)); } } }
 * 
 * // ����� �̵� for(int i=0; end=q.size(); i<end; i++) { Pos p = q.poll(); int x =
 * p.x; int y = p.y; int time = p.time;
 * 
 * //���� ������ ��� min�� update if(x == 0 || y == 0 || x == R+1 || y == C+1) { min =
 * min > time ? time : min; continue; }
 * 
 * for(int j=0; j<4; j++) { int nx = x + dx[j]; int ny = y + dy[j]; //������ ��ȿ�ϰ�
 * ���� ������ �ʾҰ� ����̰� �湮�� ���� �ƴ϶�� �湮ó�� (1)
 * 
 * if( nx >= 0 && ny >= 0 && nx <= R+1 && ny <= C+1) { if(visited[nx][ny] != -1
 * && visited[nx][ny] !=1) { q.offer(new Pos(nx,ny,time+1)); visited[nx][ny] =
 * 1; } } } } } } }
 */