package �̺�Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	static int N, C;
	static int arr[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// �̺�Ž���� ���� ���� ����
		Arrays.sort(arr);
		// �̺�Ž���� ���� �������� ���� ����
		int start = arr[0];
		int end = arr[arr.length-1];
		int maxRange = 0;
		int d = 0; // �� ���� �Ÿ� üũ�ϴ� ����
		int ans = 0;
		// �̺�Ž�� ����
		while(start <= end) {
			int mid = (start + end) / 2;
			int reStart = arr[0];
			int count = 1; // ������ ��ġ gap ����
			for(int i=0; i<N; i++) {
				d = arr[i] - reStart; // �� ���� �Ÿ� üũ
				if(d >= mid) { // ������ ��ġ �������� ���� üũ
					count++;
					start = arr[i]; // ��ġ�ߴٸ� ���������� �ٽ� �Ÿ�üũ
				}
			}// end for
			
			if(count >= C) {
				ans = mid;
				start = mid + 1; // �� ���� gap���� ������ ��ġ�� ���ִ��� ���� Ȯ��
			}else {
				end = mid - 1;  // �� ���� gap���� ������ ��ġ�� �� �ִ��� ���� Ȯ��
			}	
		}// end while
		System.out.println(ans);
		
	}
}
