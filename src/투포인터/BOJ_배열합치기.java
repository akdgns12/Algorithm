package ��������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_�迭��ġ�� {
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" "); // ù ��° ���� �б�
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int size = n+m;
		int[] result = new int[size];
		
		String[] arrayA = br.readLine().split(" "); // �� ��° �� �б�
		String[] arrayB = br.readLine().split(" "); // �� ��° �� �б�
		
		int idx = 0;
		for(int i=0; i<n; i++) { // �迭 A�ֱ�
			result[idx++] = Integer.parseInt(arrayA[i]);
		}
		for(int i=0; i<m; i++) { // �迭 B�ֱ�
			result[idx++] = Integer.parseInt(arrayB[i]);
		}
		Arrays.sort(result); //�������� ����
		
		for(int r : result) {
			bw.write(String.valueOf(r) + " ");
		}
		
		//write()�� ���״�� ���ۿ� ���� ���̱� ������, flush(), close()�� ���� 
		//���ۿ� ����� �� ��Ʈ���� �ݾƾ��Ѵ�.
		bw.flush();
		bw.close();
	}
}
