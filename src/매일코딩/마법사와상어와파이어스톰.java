package �����ڵ�;
//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * �ٸ� ���� �Ϲ� bfs������ ũ�� �ٸ� ���� ���µ� �迭 ȸ���ϴ� �κ��� ������� �Ф� 
������ �� �� �غ��� �������� �ߴµ� ���� ����� ���ϰھ����������
���̰� 4�϶�
ù ���� ������
2
1
5
7
�� ù ���� �����ٷ� ����� ���ؼ� 
2	1	5	7
�������� �� ��ȣ�� ���ȣ�� sx, sy��� ������ ���� ���� ������Ű�� 
ù ���� �������� for���� ������ ������ ������� �����.
������ �迭�����⹮���� Ǯ�鼭 ������ ���� �� �ؾ߰ڴ�. �Ｚ ���⿡�� �� ������ �� ����.
+ ���� ���̴� �� �Ǽ��ߴµ� �� ������ ������ �� 3���̻����� ����ؼ� ���̰� �� ���� ĭ ���̰� �̷��� �ȵȴ٤���
�� ���� ���� ���� �� ����� �Ŀ� �Ѳ����� �쿩�ߵȴ�.
���� arraylist�� ���� ���� ��ǥ�� �־��� �� �� ���� �쿩���.
 */

/*
 * // �������� ��� ����(������ ������ �� ���� ���� ���κ����� �������� ����ش�)
		for(int startRow = 0; startRow < M; startRow += len) {
			for(int startCol = 0; startCol < M; startCol += len) {
				// ȸ��                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// ó�� ���� ���� ��� ���� ������
						// ��� ���� ����  = ���� �� - ó�� ���� �� - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
 */
public class ������ͻ������̾��{
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
		
		//�ܰ迡 ���� �߶� �迭 ������ ���̱�
		for (int l = 0; l <q; l++) {
			int len=(int)Math.pow(2,level[l]);
			rotate(len);
			
		}
        //���� ���� �հ�
		int sum=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
		
		biggest();
		
				
	}
    //���� ���� ���� ū �� ã��
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
		
		// �迭 90�� �ð���� ȸ����Ű��
		for(int startRow = 0; startRow < m; startRow += len) {
			for(int startCol = 0; startCol < m; startCol += len) {
				// ȸ��                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// ó�� ���� ���� ��� ���� ������
						// ��� ���� ����  = ���� �� - ó�� ���� �� - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
		//���� ������ ��ǥ�� ���� ����Ʈ
		ArrayList<Pos> arr=new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map2[i][j]==0)continue;
				int cnt=0;//����  ���� ���� 
				for (int k = 0; k < 4; k++) {
					int y=i+ypos[k];
					int x=j+xpos[k];
					if(x<0 || y<0 || x>=m || y>=m)continue;
					if(map2[y][x]!=0) {
						cnt++;
					}
				}
				if(cnt<3) {
                //���� ���̴� ����Ʈ�� �־���
					arr.add(new Pos(i,j));
				}
			}
		}
		//�Ѳ����� �쿩�ش�.
		for (int i = 0; i < arr.size(); i++) {
			int y=arr.get(i).y;
			int x=arr.get(i).x;
			map2[y][x]-=1;
		}
		
		
		//���� �迭�� ���� ���� �� �ٽ� �����ϱ�
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
	}