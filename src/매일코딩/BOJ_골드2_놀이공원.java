package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - ó�� 0�п��� ��� ���̱ⱸ�� ������ŭ ���̵��� ž���Ѵ�. ��, 0�п��� �� M���� ���̵��� ž�°���
 * - N���� ������ ���� ������ ���̱ⱸ�� �� ����� ���̵��� ž���ߴ�����  N / ���̱ⱸ ���� �ð�(��)���� �� �� �ִ�.
 *
 *	n�Ф����� n % ���̱ⱸ�� ����ð�(��) = 0�� ���̱ⱸ�� ���ο� ���̰� ž���Ѵ�.
 *
 *	n�б��� ���̱ⱸ�� ž���� ���̵��� ���� ���� �� �ִٸ�, (n-1)�б����� ���̱ⱸ�� ž���� ���̵��� �� ���� ���� �� ���� ���̴�.
 *	n�б��� ���̱ⱸ�� ž���� ���̵� �� - (n-1)�б��� ���̱ⱸ�� ž���� ���̵� �� = n��°�� ���̱ⱸ�� ž���� ���̵� �� 
 *
 *	�׸��� ���̱ⱸ 1������ ���ʴ�� Ȯ���ϸ鼭 ����ð��� n������ ����������� ī��Ʈ�� �Ͽ���
 *	���������� n������ ������ �������� 0�� �Ǵ� ���̱ⱸ�� ��ȣ�� Ȯ���ϸ� �ȴ�.
 */

public class BOJ_���2_���̰��� {
	static long N;
	static int M;
	static int[] time;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = new int[M];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N <= M) {
			System.out.println(N);
			return;
		}
		else 
			Search();
		System.out.println(answer);
	
	}
	
	public static void Search() {
		long start = 1;
		long end = 2000000000 * 30L; // end���� N*M���� ��ƾ��Ѵ�.
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long next = sum(mid); // ���� �� ������ ���̵��� ����
			if(N <= next) { //���Ϸ��� ��ȣ���� ���̵��� ������ �� ũ�ų� ���� ���
				int ans = calc(sum(mid-1)-1, mid); //���� (�� ���� -1��)�� ���̵��� ���� +1�� ���� �м��� ���� �� ��
				if(ans == -1) end = mid -1; //���� N�� ��ã�Ҵٸ�
				else {//ã�Ҵٸ�
					answer = ans + 1;
					break;
				}
			}
			else 
				start = mid + 1;
		}
	}
	
	public static long sum(long mid) { // ���� �� �������� ���̵��� ����
		long ans = 0;
		for(int i=0; i<M; i++) 
			ans += mid / time[i];// (�� ��) / (���̱ⱸ ����ð�)
		return ans+M; // 0��(+M)
	}
	
	public static int calc(long cur, long mid) { //cur : (mid-1)���� ���̵� �� �� + 1
		for(int i = 0; i<M; i++) {
			if(mid %time[i] == 0) { // 0���� ������ �������� ���¾��̵��� ���̱ⱸ�� ž���ϴ� ���
				if(cur == N) return i; // ã���� �ϴ� ���̰� Ÿ�� ���̱ⱸ ��ȣ�� �˰ԵǸ� return
				else cur++;
			}
		}
		return -1; // �� ã�� ���
	}
}
