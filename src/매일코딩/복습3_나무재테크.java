package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Tree3 implements Comparable<Tree3>{
	int x, y, age;
	
	Tree3(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	@Override
	public int compareTo(Tree3 t) {
		return this.age - t.age;
	}
}
public class 복습3_나무재테크 {
	
	static int N;
	static int M;
	static int K;
	static int x,y; // 나무위치
	static int z; // 나무나이
	
	static int[][] map;
	static int[][] A; // 주어진 양분 정보 저장할 배열
	
	static ArrayList<Tree3> trees = new ArrayList<>();
	static ArrayList<Tree3> deadtrees;
	static ArrayList<Tree3> livetrees;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
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
			
			trees.add(new Tree3(x,y,z));
		}
		
		for(int i=0; i<K; i++) {
			deadtrees = new ArrayList<>();
			livetrees = new ArrayList<>();
			
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
			Tree3 t = trees.get(i);
			if(t.age > map[t.x][t.y]) {
				deadtrees.add(t);
			}
			else
				map[t.x][t.y] -= t.age;
			t.age += 1;
			livetrees.add(t);
		}
		
		trees.clear();
		trees.addAll(livetrees);
	}
	
	public static void summer() {
		for(int i=0; i<deadtrees.size(); i++) {
			Tree3 t = trees.get(i);
			map[t.x][t.y] += t.age / 2;
		}
	}
	
	public static void fall() {
		for(int i=0; i<trees.size(); i++) {
			Tree3 t = trees.get(i);
			if(t.age % 5 == 0) {
				for(int j=0; j<8; j++) {
					int nx = t.x + dx[j];
					int ny = t.y + dy[j];
					if(nx >=0 && ny >=0 && nx < N && ny < N) {
						trees.add(new Tree3(nx,ny,1));
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
