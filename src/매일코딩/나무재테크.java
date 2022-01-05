package 매일코딩;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// NxN크기의 땅
// 각각의 칸 (r,c) r과 c는 1부터 시작
// 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
//  M개의 나무
// 봄에는 자신의 나이만큼 양분을 먹고, 나이가 1증가
// 만약 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
// 여름에는 봄에죽은 나무가 양분으로 변하게 됨. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
// 가을에는 나무가 번식. 번식하는 나무는 나이가 5의 배수이이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
// 범위를 벗어나는 칸에는 나무가 생기지 않음
// 겨울에는 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 입력으로 주어짐
// k년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램

/*
 * 살아있는 나무와 죽는 나무 리스트들 초기화에 주의
 * 나이가 어린 나무부터 양분을 받으므로
 * Tree class를 정의할 때, Comparable<Tree> interface를 implements받아주는 것만 주의한다.
 * 리스트를 복사할 때, addAll() 메서드를 사용하면 되지만 또한
 * list = new ArrayList<>(newList) 형식으로 가져갈 수 있다.
 * 
 * 메서드를 잘 분리하고 전역 변수를 초기화 하는 것에 더 주의하며 문제를 잘풀어보자
 */
class Tree implements Comparable<Tree>{
	int x, y, age;
	
	Tree(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}
	
	// 나이 오름차순으로 정렬
	@Override
	public int compareTo(Tree t) {
		return this.age - t.age;
	}
}
public class 나무재테크 {
	
	static int N; // 크기
	static int M; // 나무의 개수
	static int K; // 년 수
	
	static int x, y; // 나무의 좌표
	static int z; // 나무의 나이
	
	static int[][] A; // 양분의 양  A
	static int[][] map; // 초기 땅 크기 map
	
	static ArrayList<Tree> trees = new ArrayList<>(); // 나무 심은 좌표
	static ArrayList<Tree> liveTrees; //
	static ArrayList<Tree> deadTrees; // 양분을 먹지 못해 죽는 나무
	
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
			z = Integer.parseInt(st.nextToken()); // 나무 나이
			
			trees.add(new Tree(x, y, z));
		}
		
		while(K>0) {
			// 구분 초기화
			liveTrees = new ArrayList<>();
			deadTrees = new ArrayList<>();
			//정렬
			Collections.sort(trees);
			spring();
			summer();
			fall();
			winter();
			K--;
		}
		
		System.out.println(trees.size());
		
	}
	// 나무가 자신의 나이만큼 양분을 먹고, 나이가 1증가
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
		// 나무 리스트 리셋 후 살아있는 나무로 초기화
		trees.clear();
		trees.addAll(liveTrees);
	}
	
	// 여름에는 봄에죽은 나무가 양분으로 변한다
	public static void summer() {
		for (int i = 0; i < deadTrees.size(); i++) {
			Tree t = deadTrees.get(i);
			map[t.x][t.y] += t.age / 2;
		}
	}
	
	// 가을에는 나무가 번식한다.
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
