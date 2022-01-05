package �����ڵ�;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// NxNũ���� ��
// ������ ĭ (r,c) r�� c�� 1���� ����
// ���� ó���� ����� ��� ĭ�� 5��ŭ ����ִ�.
//  M���� ����
// ������ �ڽ��� ���̸�ŭ ����� �԰�, ���̰� 1����
// ���� ���� ����� ������ �ڽ��� ���̸�ŭ ����� ���� �� ���� ������ ����� ���� ���ϰ� ��� �״´�.
// �������� �������� ������ ������� ���ϰ� ��. ������ ���� �������� ���̸� 2�� ���� ���� ������ �ִ� ĭ�� ������� �߰�
// �������� ������ ����. �����ϴ� ������ ���̰� 5�� ������̾�� �ϸ�, ������ 8���� ĭ�� ���̰� 1�� ������ �����.
// ������ ����� ĭ���� ������ ������ ����
// �ܿ￡�� ���� ���ƴٴϸ鼭 ���� ����� �߰��Ѵ�. �� ĭ�� �߰��Ǵ� ����� ���� �Է����� �־���
// k���� ���� �� ���� ���� ����ִ� ������ ������ ���ϴ� ���α׷�

/*
 * ����ִ� ������ �״� ���� ����Ʈ�� �ʱ�ȭ�� ����
 * ���̰� � �������� ����� �����Ƿ�
 * Tree class�� ������ ��, Comparable<Tree> interface�� implements�޾��ִ� �͸� �����Ѵ�.
 * ����Ʈ�� ������ ��, addAll() �޼��带 ����ϸ� ������ ����
 * list = new ArrayList<>(newList) �������� ������ �� �ִ�.
 * 
 * �޼��带 �� �и��ϰ� ���� ������ �ʱ�ȭ �ϴ� �Ϳ� �� �����ϸ� ������ ��Ǯ���
 */
class Tree implements Comparable<Tree>{
	int x, y, age;
	
	Tree(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	// ���� ������������ ����
	@Override
	public int compareTo(Tree t) {
		return this.age - t.age;
	}
}
public class ��������ũ {
	
	static int N; // ũ��
	static int M; // ������ ����
	static int K; // �� ��
	
	static int x, y; // ������ ��ǥ
	static int z; // ������ ����
	
	static int[][] A; // ����� ��  A
	static int[][] map; // �ʱ� �� ũ�� map
	
	static ArrayList<Tree> trees = new ArrayList<>(); // ���� ���� ��ǥ
	static ArrayList<Tree> liveTrees; //
	static ArrayList<Tree> deadTrees; // ����� ���� ���� �״� ����
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		A  = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken()); // ���� ����
			
			trees.add(new Tree(x, y, z));
		}
		
		while(K>0) {
			// ���� �ʱ�ȭ
			liveTrees = new ArrayList<>();
			deadTrees = new ArrayList<>();
			//����
			Collections.sort(trees);
			spring();
			summer();
			fall();
			winter();
			K--;
		}
		
		System.out.println(trees.size());
		
	}
	// ������ �ڽ��� ���̸�ŭ ����� �԰�, ���̰� 1����
	public static void spring() {
		for(int i=0; i<trees.size(); i++) {
			Tree t = trees.get(i);
			if(t.age > map[t.x][t.y]) {
				deadTrees.add(t);
			}else {
				map[t.x][t.y] -= t.age;
				t.age += 1;
				liveTrees.add(t);
			}
		}
		// ���� ����Ʈ ���� �� ����ִ� ������ �ʱ�ȭ
		trees.clear();
		trees.addAll(liveTrees);
	}
	
	// �������� �������� ������ ������� ���Ѵ�
	public static void summer() {
		for (int i = 0; i < deadTrees.size(); i++) {
			Tree t = deadTrees.get(i);
			map[t.x][t.y] += t.age / 2;
		}
	}
	
	// �������� ������ �����Ѵ�.
	public static void fall() {
		for(int i=0; i<trees.size(); i++) {
			Tree t = trees.get(i);
			if(t.age % 5 == 0) {
				for(int j=0; j<8; j++) {
					int nx = t.x + dr[j];
					int ny = t.y + dc[j];
					if(nx >=0 && ny >= 0 && nx < N && ny < N) {
						trees.add(new Tree(nx, ny, 1));
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
