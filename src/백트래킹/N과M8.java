package ��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N��M8 {
	static int N,M;
	static int[] map;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N���� �ڿ���
		M = Integer.parseInt(st.nextToken()); // �ڿ��� M
		// ������ �����ϴ� ���̰� M�� ������ ��� ���϶�
		/*
		 * N���� M��
		 * ���� �� ������ ��� ��.
		 * ������ ���� ��������
		 */
		map = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		
		combi(0,0,sb);
		
		System.out.println(sb);
	}
	
	public static void combi(int start, int cnt, StringBuilder sb) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
		}
		
		for(int i=start; i<N; i++) {
			result[cnt] = map[i];
			combi(i, cnt+1, sb);
		}
	}
}
