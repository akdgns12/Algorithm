package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Tree1 implements Comparable<Tree1>{
	int x, y, age;
	
	Tree1(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	@Override
	public int compareTo(Tree1 t) {
		return this.age - t.age;
	}
}
public class ����_��������ũ {
	static int N; // NxN ũ���� ��
	static int M;
	static int K; // �� ��
	
	static int x,y; // ������ ��ǥ
	static int z; // ������ ����
	
	static int[][] map; // �ʱ� ����� 5�� �־��� map
	static int[][] A; // �Է¹��� ����� ����
	
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	static ArrayList<Tree1> trees = new ArrayList<>();
	static ArrayList<Tree1> deadtrees; // ���������� ����Ʈ
	static ArrayList<Tree1> livetrees; // ����ִ� ���� ����Ʈ
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		A = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree1(x,y,z));
		}
		
		while(K > 0) {
			// ���� �ʱ�ȭ
			livetrees = new ArrayList<>();
			deadtrees = new ArrayList<>();
			// ����
			Collections.sort(trees);
			spring();
			summer();
			fall();
			winter();
			
		}
		
		System.out.println();
	}
	
	public static void spring() {
		for(int i=0; i<trees.size(); i++) {
			Tree1 t = trees.get(i);
			if(t.age > map[t.x][t.y]) {
				deadtrees.add(t);
			}else {
				map[t.x][t.y] -= t.age;
				t.age += 1;
				livetrees.add(t);
			}
		}
		
		//
		trees.clear();
		trees.addAll(livetrees);
	}
	
	public static void summer() {
		for(int i=0; i<deadtrees.size(); i++) {
			Tree1 t = deadtrees.get(i);
			map[t.x][t.y] += t.age/2;
		}
	}
	
	public static void fall() {
		for(int i=0; i<trees.size(); i++) {
			Tree1 t = trees.get(i);
			if(t.age % 5 == 0) {
				for(int j=0; j<8; j++) {
					int nx = t.x + dx[j];
					int ny = t.y + dy[j];
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						trees.add(new Tree1(nx, ny, 1));
					}
				}
			}
		}
	}
	
	public static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}
	
}
