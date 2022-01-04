package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blackjack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		int result = search(arr,N,M);
		System.out.println(result);
	}
	
	//Ž��
	static int search(int[] arr, int N, int M) {
		int result = 0;
		
		// 3���� ���� ������ ù��° ī��� N-2 ������ ��ȸ
		for(int i = 0; i<N-2; i++) {
			
			// ù��° ī�尡 M���� ũ�� skip
			if(arr[i]>M) continue;
			
			// �ι�° ī��� ù��° ī�� �������� N-1������ ��ȸ
			for( int j = i + 1; j<N-1; j++) {
				
				// �ι�° ī��� ù��° ī���� ���� M���� ũ�� skip
				if(arr[i] + arr[j] > M) continue;
				
				// ����° ī��� �ι�° ī�� �������� N���� ��ȸ
				for(int k= j+1; k<N; k++) {
					
					// 3�� ī���� �� ���� temp
					int temp = arr[i] + arr[j] + arr[k];
					
					//M�� �� ī���� ���� ���ٸ� temp return �� ����
					if(M == temp) {
						return temp;
					}
					
					// �� ī���� ���� ���� �պ��� ũ�鼭 M���� ���� ��� result�� ����
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		// ��� ��ȸ�� ��ġ�� result ����
		return result;
	}

}

/* ī���뿡�� ���� �α� �ִ� ���� ������ ��Ģ�� ����� ����. ī���� ���� 21�� �����ʴ� �ѵ�������
 * ī���� ���� �ִ��� ũ�� ����� �����̴�. ������ ī���븶�� �پ��� ������ �ִ�.
 * �ѱ� �ְ��� ���� ��� �������� ���ο� ���� ��Ģ�� ����� ���, â���̿� �����Ϸ��Ѵ�.
 * ������ ������ ���迡�� �� ī�忡�� ���� ������ �����ִ�. �� ����. ������ N���� ī�带 ��� ���ڰ� ���̵��� �ٴڿ� ���´�.
 * �׷� �Ŀ� ������ ���� M�� ũ�� ��ģ��.
 * ���� �÷��̾�� ���ѵ� �ð��ȿ� N���� ī�� �߿��� 3���� ī�带 ���� �Ѵ�. ���� ���������̱� ������, �÷��̾ �� ī���� ���� M�� ���� �����鼭 M��
 * �ִ��� ������ ������ �Ѵ�.
 * N���� ī�忡 ���� �ִ� ���ڰ� �־����� ��, M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ���� ����Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� ī���� ����N(3<=N<=100)�� M(10<=M<=300,000)�� �־�����. ��° �ٿ��� ī�忡 ���� �ִ� ���� �־�����, �� ���� 100,000�� ���� �ʴ� ���� ����
 * ���� M�� ���� �ʴ� ī�� 3���� ã�� �� �ִ� ��츸 �Է����� �־�����.
 * ��� : ù° �ٿ� M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ����Ѵ�.
 */
