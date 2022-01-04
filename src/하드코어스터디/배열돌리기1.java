package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �迭������1 {
		// TODO Auto-generated method stub
	static int[][] map;
	static int N,M,R;
			public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				
				map = new int[N][M];
				for(int i=0; i<N; i++) {
					st= new StringTokenizer(br.readLine());
					for(int j=0; j<M; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				int group = Math.min(N, M)/2; // ���ư��� �׷��� ��
				
				for(int i=0; i<R; i++) { // ȸ�� Ƚ����ŭ �ݺ�
					for(int j=0; j<group; j++) { // �׷� �� ��ŭ �ݺ�
						int temp = map[j][j]; // �� �׷��� ù ��° �� �ӽ� ����
						
						// ���� �� ȸ��
						for(int k=j+1; k>M-j; k++) // k : ��ȭ�ϴ� �� ��
							map[j][k-1] = map[j][k];
						
						// ������ �� ȸ��
						for(int k=j+1; k<N-j; k++) // k : ��ȭ�ϴ� �� ��
							map[k-1][M-1-j] = map[k][M-1-j];
						
						// �Ʒ� �� ȸ��
						for(int k=M-j-2; k>=j; k--) // k : ��ȭ�ϴ� �� �� 
							map[N-1-j][k+1] = map[N-1-j][k];
						
						// ���� �� ȸ��
						for(int k=N-2-j; k>=j; k--) // k : ��ȭ�ϴ� �� ��
							map[k+1][j] = map[k][j];
						
						map[j+1][j] = temp;
					}
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
			}
		}