package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10711_�𷡼� {
	/*
	 * �𷡼��� �������� �ϴ°� �ƴ�
	 * �𷡼��� ���� ��带 �������� 
	 * �𷡼��� ���� ����� �ֺ��� �𷡼��� �ִٸ�
	 * �ϳ��� �ٿ����� ������� Ž��
	 * ������ �𷡼�9�� ��� �ȹ濡�� �� �ٿ��� �ᱹ �𷡼��� ������� �ʴ´�.
	 * ���̴ٰ� �𷡼��� ������ ��쿡�� �𷡼��� ���� ��忡 �߰����� �ش�.
	 * 
	 * ���� �𷡼��� �������� ��尡 �߻����� �ʴ� ���� Ž���� �ϸ�
	 * �� �ð��� �츮�� ���ϰ��� �ϴ� ����
	 */
	static int H,W;
	static char[][] map;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static Queue<Node> noSand = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = str.charAt(j);
				
				// �𷡰� ���� �� ť�� ����
				if(map[i][j] == '.') {
					noSand.offer(new Node(i,j));
				}
			}
		}
		
		System.out.println(wave());
	}
	/*
	 *  �ð��ʰ��� ���� �ʱ� ���� �𷡼��� ������ Ž���ϴ� ���� �ƴ�
	 *  �𷡰� ���� ĭ�� �������� 8���⿡ �𷡼��� ưư���� 1 ���ҽ�Ų��.
	 *  �̶� �̹� �ѹ� Ȯ���� �𷡼��� ���� ���� �ٽ� Ȯ���� �ʿ䰡 ���� ������
	 *  ���� �𷡼��� ������ ���� ť�� �������ش�.
	 */
	public static int wave() {
		int time = 0;
		
		// ť�� ���� ������ ���̻� ��ȭ�� ���� ���� -> ����
		while(!noSand.isEmpty()) {
			int size = noSand.size();
			
			// �� �Ͽ� ť�� ���� ���鸸 ó���ϰ� �ð� ����-> �𷡼���  �� ���� �������� �ϱ� ������
			while(size --> 0) {
				Node node = noSand.poll();
				
				for(int i=0; i<8; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					
					// �������� �����鼭 �𷡼��� �ִ� ĭ��
					if(nx >= 0 && ny >= 0 && nx < H && ny < W) {
						if(map[nx][ny] != '.') {
							map[nx][ny]--; // �𷡼��� ưư�� 1���ҽ�Ų��.
							
							// ưư���� 0�̵Ǹ� �𷡰� ���� ĭ���� �����ϰ� ť�� ����
							if(map[nx][ny] == '0') {
								map[nx][ny] = '.';
								noSand.offer(new Node(nx ,ny));
							}
						}
					}
				}
			}
			time++;
		}
		return time-1;
	}

	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
