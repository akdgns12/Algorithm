package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Tree2 implements Comparable<Tree2>{
	int x,y,age;
	
	Tree2(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	@Override
	public int compareTo(Tree2 t) {
		return this.age - t.age;
	}
}
public class 복습2_나무재테크 {
	static int N;
	static int M;
	static int K;
	static int x,y;
	static int z;
	
	static int[][] map;
	static int[][] A;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	k
	static ArrayList<Tree2> trees = new ArrayList<>();
	static ArrayList<Tree2> deadtrees;
	static ArrayList<Tree2> livetrees;
	
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
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree2(x,y,z));
		}
		
		while(K-->0) {
			// 구분 초기화
			livetrees = new ArrayList<>();
			deadtrees = new ArrayList<>();
			// 정렬
			Collections.sort(trees);
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
	}
	
	public static void spring() {
		for(int i=0; i<trees.size(); i++) {
			Tree2 t = trees.get(i);
			if(t.age > map[t.x][t.y]) {
				deadtrees.add(t);
			}else {
				map[t.x][t.y] -= t.age;
				t.age += 1;
				livetrees.add(t);
			}
		}
		// trees 리스트 초기화
		trees.clear();
		trees.addAll(livetrees);
	}
	
	public static void summer() {
		for(int i=0; i<deadtrees.size(); i++) {
			Tree2 t = deadtrees.get(i);
			map[t.x][t.y] += t.age/2;
		}
	}
	
	public static void fall() {
		for(int i=0; i<trees.size(); i++) {
			Tree2 t = trees.get(i);
			if(t.age % 5 == 0) {
				for(int j=0; j<8; j++) {
					int nx = t.x + dx[j];
					int ny = t.y + dy[j];
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						trees.add(new Tree2(nx ,ny, 1));
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
