package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class �ϱ�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			HashSet<Integer> set = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine()); // ��ø1�� ����ִ� ���� ����
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine()); // ��ø2�� ����ִ� ���� ����
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(set.contains(Integer.parseInt(st.nextToken()))){
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			System.out.print(sb);
		}
	}
}
