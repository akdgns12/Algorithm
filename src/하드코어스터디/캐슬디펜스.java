package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class ĳ�����潺 {
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x =x ;
			this.y = y;
		}
	}
	static int[][] map,copy;
	static int[] archer;
	static int N,M,D;
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
	// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	D = Integer.parseInt(st.nextToken());
	
	archer=new int[M]; // �� �ü��� ���� ����
	for(int i=0;i<M;i++)
		archer[i]=i;
	
	map=new int[N][M];
	copy=new int[N][M];
	
	for(int i=0;i<N;i++) {
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<M;j++) {
			map[i][j]= Integer.parseInt(st.nextToken());
		}
	}
	
	int[] temp=new int[3];
	combi(0,0,temp);
	
	System.out.println(max);
}

static void copymap() {
	for(int i=0;i<N;i++)
		copy[i]=Arrays.copyOf(map[i],M);
}

static void combi(int depth, int start, int[] temp) {
	// 3���� �ü��� ��ġ�ߴٸ�
	if(depth==3) {
		copymap();
		
		int count=0; // ���� ������ ���� ��
		int turn=0; 
		Queue<Node> q=new LinkedList<>(); // ������ ���� ��ġ ����
		
		/*
		 * ������ �� �྿ �ű�� �ͺ��� �ü����� �� �� ���� �ø��� ���� �� ������!
		 * turn�� �����ϸ鼭 �ü����� �� �� ĭ�� ����
		 */
		while(turn<N) {
			// 3���� �ü� Ž��
			for(int k=0;k<3;k++) {
				int x=N-turn; // �ü��� ��
				int y=temp[k]; // �ü��� ��
				
				int min=Integer.MAX_VALUE; // �������� �ּҰŸ�
				int minX=-1; // ���� ��ġ ����
				int minY=-1;
				
				// ��� �� Ž��
				for(int i=N-1-turn;i>=0;i--) {
					for(int j=0;j<M;j++) {
						// ���� �ִٸ� �Ÿ� ���
						if(copy[i][j]==1) {
							int distance=Math.abs(i-x)+Math.abs(j-y);
							
							// ������ �Ÿ��� d ���϶�� ���� ����
							if(distance<=D) {
								// ������ �Ÿ��� ���� �ּҶ��
								if(distance<min) {
									// ���� ���� ����
									min=distance;
									minX=i;
									minY=j;
								}
								// �ּҰŸ��� ���� ���� �� �̻��̶��
								else if(distance==min) {
									// ���� ���ʿ� �ִ� �� ���� ����(minY�� ���� ���� �� ���ʿ� �ִ� ��)
									if(minY>j) {
										minX=i;
										minY=j;
									}
								}
							}
						}
					}
				}
				// ��� ���� Ž���ߴٸ� ������ ���� ��ġ ť�� ����
				if(minX!=-1&&minY!=-1) 
					q.offer(new Node(minX,minY));
			}
			
			// ������ ���� �� ���� 0���� ����, ������ ���� �� count
			while(!q.isEmpty()) {
				Node cur =q.poll();
				
				/*
				 * �̶� ���� �ü��� �ϳ��� ���� ������ �� �ֱ� ������ 
				 * ���� ���� �ü��� �ִ� ������(���� 1����) Ȯ���ϰ� ���� �ü����� ���� count���־�� �Ѵ�.
				 * �̹� �ռ� �ü��� ���� ���ŵ� ���ϼ� �ֱ� ����! 
				 */
				if(copy[cur.x][cur.y]==1) {
					copy[cur.x][cur.y]=0;
					count++;
				}
			}
			turn++; // �� �� ���� -> �ü��� �� ĭ ���� ����
		}
		
		max=Math.max(max,count); // �ִ� ����
		return;
	}
	
	// �ü��� ��ġ�� �� �ִ� mĭ �� 3���� ĭ�� �ü� ��ġ -> ��Ʈ��ŷ, ����
	for(int i=start;i<archer.length;i++) {
		temp[depth]=archer[i];
		combi(depth+1,i+1,temp);
	}
}
}