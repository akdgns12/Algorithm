package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ��й�ȣã�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // ����� �ּ��� ��
		int M = Integer.parseInt(st.nextToken()); // ��й�ȣ�� ã������ ����Ʈ �ּ��� ��
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String juso = st.nextToken();
			String password = st.nextToken();
			
			map.put(juso, password);
		}
		
		for(int i=0; i<M; i++) {
			String juso = br.readLine();
			System.out.println(map.get(juso));
		}
	}
}
