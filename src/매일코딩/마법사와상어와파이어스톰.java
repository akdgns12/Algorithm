package 매일코딩;
//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 다른 것은 일반 bfs문제와 크게 다를 것이 없는데 배열 회전하는 부분이 어려웠다 ㅠㅠ 
예전에 한 번 해봐서 괜찮겠지 했는데 수학 계산을 못하겠어서ㅋㅋㅋㅋㅋ
길이가 4일때
첫 열의 세로줄
2
1
5
7
을 첫 행의 가로줄로 만들기 위해서 
2	1	5	7
가로줄의 열 번호와 행번호를 sx, sy라는 변수를 따로 만들어서 증가시키고 
첫 열의 세로줄은 for문의 변수를 돌리는 방식으로 해줬다.
내일은 배열돌리기문제를 풀면서 돌리는 연습 좀 해야겠다. 삼성 기출에서 꽤 나오는 것 같다.
+ 얼음 녹이는 걸 실수했는데 한 곳에서 인접한 곳 3개이상인지 계산해서 녹이고 또 다음 칸 녹이고 이러면 안된다ㅎㅎ
한 번에 녹을 곳을 다 계산한 후에 한꺼번에 녹여야된다.
나는 arraylist에 녹을 곳의 좌표를 넣어준 후 한 번에 녹여줬다.
 */

/*
 * // 시작점을 잡기 위함(구역을 나눴을 때 왼쪽 제일 윗부분으로 시작점을 잡아준다)
		for(int startRow = 0; startRow < M; startRow += len) {
			for(int startCol = 0; startCol < M; startCol += len) {
				// 회전                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// 처음 열의 값은 결과 행의 값으로
						// 결과 열의 값은  = 행의 수 - 처음 행의 값 - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
 */
public class 마법사와상어와파이어스톰{
	static class Pos{
		int  y,x;
		
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int n,q,m;
	static int[][] map;
	static int[] xpos= {0,0,1,-1};
	static int[] ypos= {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		q=sc.nextInt();
		m=(int) Math.pow(2, n);
		map=new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[] level=new int[q];
		for (int i = 0; i < q; i++) {
			level[i]=sc.nextInt();
		}
		
		//단계에 따라서 잘라서 배열 돌리고 녹이기
		for (int l = 0; l <q; l++) {
			int len=(int)Math.pow(2,level[l]);
			rotate(len);
			
		}
        //남은 얼음 합계
		int sum=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
		
		biggest();
		
				
	}
    //얼음 군집 가장 큰 곳 찾기
	private static void biggest() {
		int max=0;
		boolean[][] vis=new boolean[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]!=0) {
					int cnt=1;
					Queue<Pos> q=new LinkedList<>();
					q.add(new Pos(i,j));
					vis[i][j]=true;
					while(q.size()!=0) {
						Pos cur=q.poll();
						int y=cur.y;
						int x=cur.x;
						for (int k = 0; k < 4; k++) {
							int yy=y+ypos[k];
							int xx=x+xpos[k];
							if(yy<0 || xx<0 || yy>=m || xx>=m)continue;
							if(map[yy][xx]==0)continue;
							if(vis[yy][xx])continue;
							vis[yy][xx]=true;
							cnt+=1;
							q.add(new Pos(yy,xx));
						}
					}
					if(max<cnt)max=cnt;
				}
			}
		}
		System.out.println(max);
	}
	private static void rotate(int len) {
		int[][] map2=new int[m][m];
		
		// 배열 90도 시계방향 회전시키기
		for(int startRow = 0; startRow < m; startRow += len) {
			for(int startCol = 0; startCol < m; startCol += len) {
				// 회전                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// 처음 열의 값은 결과 행의 값으로
						// 결과 열의 값은  = 행의 수 - 처음 행의 값 - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
		//녹일 얼음의 좌표가 들어가는 리스트
		ArrayList<Pos> arr=new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map2[i][j]==0)continue;
				int cnt=0;//인접  얼음 개수 
				for (int k = 0; k < 4; k++) {
					int y=i+ypos[k];
					int x=j+xpos[k];
					if(x<0 || y<0 || x>=m || y>=m)continue;
					if(map2[y][x]!=0) {
						cnt++;
					}
				}
				if(cnt<3) {
                //녹일 곳이니 리스트에 넣어줌
					arr.add(new Pos(i,j));
				}
			}
		}
		//한꺼번에 녹여준다.
		for (int i = 0; i < arr.size(); i++) {
			int y=arr.get(i).y;
			int x=arr.get(i).x;
			map2[y][x]-=1;
		}
		
		
		//원래 배열에 최종 변경 값 다시 저장하기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
	}