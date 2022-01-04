package �����������繮��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ���̼����� {
	// BOJ 10814 ���̼� ���� / just ����
	// ���� ��������, ���� ������ ���� ������ �� ����
	static int N; // ȸ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken(); // �״�� ���ڷ� �޾��ش� ������ �ϱ� ���� �̹���� ����
			arr[i][1] = st.nextToken();
		}
		
		// compare �޼ҵ� ���,0,���� ��ȯ
		// ���� ������ ��� �� ��ü�� ��ġ ����
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// ���⼭ ���ڷ� �ٲ� �����ش� 
				// ��������� �̷��� ���ϸ� �������� ����
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); 
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(arr);
		}
		
	}
}
