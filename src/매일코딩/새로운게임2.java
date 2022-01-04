package �����ڵ�;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * ��ǥ���� ������ ������� ������ �ڷᱸ���� ������ ������ ���� �ڷᱸ�� �ʿ�
 * ������ ������� �ϳ��� ������ ��ǥ�� Ȯ���Ѵ�.
 * �� ��ǥ���� �ش� �������� ���� ������ �Բ� �����̴µ� ��� ĭ �Ǵ� ������ ĭ�� ���� ������ �ڹٲ�� ���� ����Ѵ�.
 *	
 *list���� �ϳ��� ������ ������ �̵����⿡ ���� ���� ĭ�� ����
 *1) �Ķ� �Ǵ� �� : ������ �ٲ��� �� �ѹ� �� �������� ��. ��, �� �� �浹�� ����ؾ���
 *2) ��� : ���� �ִ� ��ǥ���� i��°�� ���� ��ġ�� �������� ã�� (x,y) -> (nx, ny)�� order�� �����ϰ�
 *	  	   ������ ����� �����Ѵ�.
 *3) ������ : ����� ����ϴ�. �����̹Ƿ� ���������� j��°�� ã�� �ڿ������� �����ϰ� ������ ����� �����ϸ� �ȴ�.
 */
public class ���ο����2 {
	static int n, k;

	static int [][] table = new int[12][12];
	// ��ǥ���� ������ ������ ����ϱ� ���� �ڷᱸ��
	static ArrayList<Integer>[][] order = new ArrayList[12][12];
	// ������ ������ ������� �ڷᱸ��
	static ArrayList<P> list = new ArrayList<>();

	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		for(int i=0 ; i<n ; i++) 
			for(int j=0 ; j<n ; j++)
				table[i][j] = sc.nextInt();

		for(int i=0 ; i<12 ; i++) 
			for(int j=0 ; j<12 ; j++)
				order[i][j] = new ArrayList<>();

		for(int i=0 ; i<k ; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();

			x--;
			y--;
			d--;

			list.add(new P(x, y, d));
			order[x][y].add(i);			
		}

		int time = 0;
		while(true) {

			time++;
			if (time > 1000) break;

			for (int i = 0; i < k; i++) {
				int y = list.get(i).y;
				int x = list.get(i).x;

				int ny = y + dy[list.get(i).d];
				int nx = x + dx[list.get(i).d];
				
				// ���� ĭ�� ������ ����ų� �Ķ����� ���
				if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[nx][ny] == 2) {
					list.get(i).d = change(list.get(i).d); // ������ �ٲ��ش�

					// �ٲ��� �������� ��ĭ �̵�
					ny = y + dy[list.get(i).d]; 
					nx = x + dx[list.get(i).d];
				}
				
				
				if (!(0 <= ny && ny < n && 0 <= nx && nx < n) || table[nx][ny] == 2) { 
					/* do nothing
					 * ���� ������ �ǵ����� ��� �� 
					 */
				} else if (table[nx][ny] == 0) { //�̵�ĭ�� ���
					int idx = -1;
					for (int j = 0; j < order[x][y].size(); j++) { //i to size ���� ��� �̵�
						int cand = order[x][y].get(j);

						if (cand == i) {
							idx = j;
						}
						if (idx == -1)
							continue;

						list.get(cand).y = ny;
						list.get(cand).x = nx;
						order[nx][ny].add(cand);
						
						if (order[nx][ny].size() >= 4) {
							System.out.println(time);
							System.exit(0);
						}
					}
					
					int size = order[x][y].size(); //����
					for (int j = idx; j < size; j++)
						order[x][y].remove(order[x][y].size() - 1);
				} else { //�̵��� ĭ�� ������
					int idx = -1;
					
					for (int j = order[x][y].size() - 1; j >= 0; j--) { //������ ���� j==i �ε��� ã��
						int cand = order[x][y].get(j);

						if (cand == i) {
							idx = j;
							break;
						}
					}
					
					for (int j = order[x][y].size() - 1; j >= idx; j--) { //���������� j���� �������� �̵�
						int cand = order[x][y].get(j);

						list.get(cand).y = ny;
						list.get(cand).x = nx;
						order[nx][ny].add(cand);
						if (order[nx][ny].size() >= 4) {
							System.out.println(time);
							System.exit(0);
						}

					}
					
					int size = order[x][y].size(); //����
					for (int j = idx; j < size; j++)
						order[x][y].remove(order[x][y].size() - 1);

				}

			}
		}

		System.out.println(-1);		
		sc.close();
	}

	public static int change(int d) {
		if(d == 0) return 1;
		else if(d == 1) return 0;
		else if(d == 2) return 3;
		else return 2;
	}
}

class P {
	int x; int y; int d;

	P(int x, int y, int d){
		this.x = x; this.y = y; this.d = d;
	}
}


