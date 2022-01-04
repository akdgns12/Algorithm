package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class �ñ׳� {
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int leng = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		map = new char[5][leng/5];
		
		//5����ؼ� �迭�� �ִ´�
		for(int i=0; i<5; i++) {
			map[i] = str.substring(i*leng/5, leng/5*(i+1)).toCharArray();
		}
		
		//�Է� ��
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//�� ���� �� �˻�
		
		for(int i=0; i<leng/5; i++) {
			//#�̸� �˻��Ѵ�
			if(map[0][i] == '#') {
				
				if(i+2 <= leng/5) {
					if(map[0][i+1] == '#' && map[0][i+2] == '#') {
						
						list.add(choice(i)); //###�� ��� (2,3,5,6,7,8,9)�� ã�Ƽ� �����Ѵ�
						
						i = i + 3; //3ĭ�� �Ա� ������ i = i + 3
						
						if(i >= leng/5) break; //i+3�� ������ ����� ���� for������ ������ ���⶧����, ���ᱸ���� ����.
						
						continue; //�Ʒ� (1,4)���� �ȵǹǷ�, continue;
					}
				}
				
				/*
				 * ###�� �ƴ� ���, �� 1(#)�̰ų� 4(#.#)�� ��
				 * 1�� (3,i)�� '#' ������, 4�� '.'�̴�
				 * 
				 * .#. .#.#. <-- �� �κ��� ���� �����Ƿ� Ȯ������ �ʴ´�
				 * .#. .#.#.
				 * .#. .###.	
				 * .#. ...#. <-- �� �κ��� ('#' or '.'���� Ȯ��)
				 * .#. ...#. <-- �� �κ��� Ȯ���ص� ����.
				 */
				if(map[3][i] == '#') list.add(1); //(3,i)�� #�̸� 1��
				else {//�׷��� ������ 4�� �߰��Ѵ�. 4���� 3ĭ�� �����ϱ� ������, i = i+3�� �� ���ش�.
					list.add(4);
					i = i+3;
					if(i >= leng/5) break; //i+3�� ����� ������ ������� ������ ���� ������, ���ᱸ���� ���ش�.
				}
			}
		}
		
		for(int n : list) {
			System.out.println(n);
		}
	}
	
	//###�� ���, (2,3,5,6,7,8,9)�� ã�� �Լ�.
	private  static int choice(int x) {
		StringBuilder sb = new StringBuilder();
		//�� ���� Strin���� �����.
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				sb.append(map[i][j+x]);
			}
		}
		return check(sb.toString());
	}
	
	//ã�´�.
	private static int check(String sb) {
		int result = 10;
		String[] num = new String[10];
		
		//1�� 4�� �ʿ����.
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";
		
		for(int i=0; i<num.length; i++) {
			if(sb.equals(num[i])) {
				result = i;
				break;
			}
		}
		return result;
	}

}
