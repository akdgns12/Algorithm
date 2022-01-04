package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * [���� Ǯ�� ����]
 * 1. 2���� int �迭 map���� �� ������ ������ �����ϰ�, 2���� ArrayList �迭 order�� �� ��ġ����
 * 	  ������ �����Ѵ�.
 * 2. turn�� Ƚ���� 1000�� �Ѿ�ų� ���� �Ѱ��� �������� �� ���� ���� ������ 4���� �� ������ while�� �ݺ�
 * 
 * 3. k���� ���� ó������ �Ѱ��� �����̱� �����ϴµ�, ���� ���� ���� �ؿ� ���� ���� ������ ���� �߰��� ���� ����
 * �ֱ� ������ idx��� ������ ���ؼ� ���� ��ġ�� ���Ѵ�
 * 
 * 4. ���� ������ ���� ���� ������ ��� queue�� �����Ѵ�. queue�� �� �������� ������ �� ������ �ٲ�� ������ Deque �ڷᱸ�� ���
 * 
 * 5. ���� ���� �����̴� ��ġ(nx,ny)�� ���ϰ� �� ��ǥ�� ������ Ȯ���Ѵ�
 * 
 * 6. ������ ����ų� �Ķ��� �����̸� �̵� ������ �ٲٰ� ��ĭ �̵�
 * 
 * 7. ������ ��ǥ�� ���츦 ����ų� �Ķ��� �����̸� �ݴ�������� �����δ�. �� ������ �ᱹ �����ڸ��� ���� ��
 * 
 * 8. ��� �����̸� queue�� �պ��� poll�ؼ� �׾��ش�.
 * 
 * 9. ������ �����̸� queue�� �ں��� �׾���� �ϱ� ������ pollLast�޼ҵ带 ����Ѵ�
 * 
 * 10. �Ű��� ���� ���� �����Ѵ�.
 */
public class ����_���ο����2 {
	static int[][] horses, map;
	static int n;
	static Deque<Integer>[][] horseIndexs;
	static int[] moveX = { 1, -1, 0, 0 }; // ��, ��, ��, �Ʒ�
	static int[] moveY = { 0, 0, -1, 1 };
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		horses = new int[k + 1][3]; // 1 ~ k �ε��� ��.  0: x, 1: y, 2: direction  
		map = new int[n + 1][n + 1];
		horseIndexs = new ArrayDeque[n + 1][n + 1];
		
		// �� �׸��� (ĭ�� ��)
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int element = Integer.valueOf(st.nextToken());
				map[i][j] = element;	
				horseIndexs[i][j] = new ArrayDeque<Integer>();
			}
		}
		
		// �� �ʿ� ����ֱ�
		for(int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			int direction = Integer.valueOf(st.nextToken()) - 1;
			
			horses[i][0] = x;
			horses[i][1] = y;
			horses[i][2] = direction; 
			horseIndexs[y][x].offer(i);
			
		}
		
		int time = 1;
		while(time <= 1000) {
			for(int i = 1; i <= k; i++) {
				int x = horses[i][0];
				int y = horses[i][1];
				int direction = horses[i][2];
				
				if(move(x, y, direction, i, false)) {
					System.out.println(time);
					return;
				}	
			}			
			time++;
		}
		System.out.println(-1);
	}
	
	// true : ����,  false : ��� ����
	static boolean move(int x, int y, int direction, int index, boolean visitedBlue) {
		int nextX = x + moveX[direction];
		int nextY = y + moveY[direction];
		Deque<Integer> tempDeque = new ArrayDeque<Integer>();
		int color;
		boolean checked = false;
		
		if(isOutOfMap(nextX, nextY)) {
			color = 2;
		}
		else {
			color = map[nextY][nextX];
		}


		switch(color) {
		case 0:	// ���
			for(int ele : horseIndexs[y][x]) {
				if(checked) {
					horseIndexs[nextY][nextX].offerLast(ele);
					horses[ele][0] = nextX;
					horses[ele][1] = nextY;
				}
				else {
					if(ele == index) {
						horseIndexs[nextY][nextX].offerLast(ele);
						horses[ele][0] = nextX;
						horses[ele][1] = nextY;
						checked = true;
					}
					else {
						tempDeque.offer(ele);	
					}	
				}
			}
			horseIndexs[y][x] = tempDeque;
			return horseIndexs[nextY][nextX].size() >= 4 ? true : false;
		case 1:	// ������
			while(!checked) {
				if(horseIndexs[y][x].peekLast() == index) {
					checked = true;
				}
				int moveIndex = horseIndexs[y][x].pollLast();
				horseIndexs[nextY][nextX].offerLast(moveIndex);
				horses[moveIndex][0] = nextX;
				horses[moveIndex][1] = nextY;
			}
			return horseIndexs[nextY][nextX].size() >= 4 ? true : false;
		case 2:	// �Ķ���
			// �־��� ���� ������ �濡 �°� �ݴ� ���� ���ϱ�
			int oppositeDirection = direction % 2 == 0 ? direction + 1 : direction - 1;
			if(!visitedBlue) {	// �̹� �Ķ����� ������ �ڵ��� ���
				horses[index][2] = oppositeDirection;
				return move(x, y, oppositeDirection, index, true);
			}
			return false;
		}
		return false;	// �ӽ�. ���� ��
	}
	
	// �� ������� �Ǵ�
	static boolean isOutOfMap(int x, int y) {
		return x > n || x <= 0 || y > n || y <= 0 ? true : false;  
	}
}