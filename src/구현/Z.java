package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class Z {
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N); // �� ���� ������
		
		find(size, r, c);
		System.out.println(count);
	}
	/*
	 * 1. ó���� ��͸� ���� �ʰ� ��Ģ�� ã�ƺ����ٰ� ���� �Ұ����ϴٴ� ���� �� �ð����� ���ݰ� ��͸� �����ߴ�..
	 * 2. ��ͷ� ������ �����ϴ�.
	 * �迭�� ��и����� ������, �Է¹��� r, c�� �� ��° ��и鿡 ���ϴ����� �˸� �ȴ�.
	 * 3. ��͸� ȣ���� ������ ���� r,c�� ��ġ�� ���� �տ� �� ���� �湮�� �ߴ��� ���ϴ� ���� count�� �����Ѵ�.
	 * 4. find �޼ҵ带 �����ϰ�, �Ű������� �� ���� ������ size�� Ÿ�� ��ġ �ε����� r, c�� �Ѱܹ޴´�.
	 * 4-1. r�� c�� 1��и鿡 ���Ѵٸ�, �տ��� �ƹ����� �湮���� �ʾ����Ƿ� count�� �׳� �ΰ�,
	 * find�޼ҵ忡 ���� size�� ����, 1��и鿡���� r,c �����ġ r,c�� �Ѱ��ش�.
	 * 4-2. r�� c�� 2��и鿡 ���Ѵٸ�, �տ��� 1��и��� �湮�ؾ��ϹǷ� count�� (size*size)/4�� ���Ѵ�.
        (�� ��и��� ũ��: ��ü �迭 ũ���� 4���)
        find�޼ҵ忡 ���� size�� ����, 2��и鿡���� r,c �����ġ r, c-size/2�� �Ѱ��ش�.
        4-3. r�� c�� 3��и鿡 ���Ѵٸ�, �տ��� 1,2 ��и��� �湮�ؾ��ϹǷ� count�� (size*size)/4 * 2�� ���Ѵ�.
        find�޼ҵ忡 ���� size�� ����, 3��и鿡���� r,c �����ġ r-size/2, c�� �Ѱ��ش�.
        4-4. r�� c�� 4��и鿡 ���Ѵٸ�, �տ��� 1,2,3 ��и��� �湮�ؾ��ϹǷ� count�� (size*size)/4 * 3�� ���Ѵ�.
        find�޼ҵ忡 ���� size�� ����, 4��и鿡���� r,c �����ġ r-size/2, c-size/2�� �Ѱ��ش�.
        4-5. ���� �ݺ��ϴٰ� size�� 1�� �Ǹ� ��͸� ������.
		5. count ���
	 */
	public static void find(int size, int r, int c) {
		if(size == 1) 
			return;
		
		if(r < size/2 && c < size/2) {
			find(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			find(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += (size * size / 4) * 2;
			find(size/2, r - size/2, c);
		}
		else {
			count += (size * size / 4) * 3;
			find(size/2, r - size/2, c - size/2);
		}
	}
}
