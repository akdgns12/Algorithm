package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//��Ʈ��ŷ ī�װ��� ù ����
// �������ε�, �� �� �˰��������� �������ڸ�, � ����� '������'�� �Ǵ��� ��, �ش� ��尡 �������� �ʴٸ� �� ���� ���ư�
// �ٸ� �ڽ� ��带 ã�� ����̴�. �� ��� ����� ���� ã�ƺ�����, �� �߿����� ���ɼ��� �ִ� ����� ���� ã�ƺ��� ���
// ���Ʈ ���� = �� �״�� '��� ����� ��'�� ã�ƺ��� ��
/*
public class NM1 {
	
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// ���ڿ� �и��� ���� StringTokenizer ���
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		arr = new int[M];
		visit = new boolean[N];
		dfs(N,M,0);
		System.out.println(sb);
	}
	public static void dfs(int N, int M,int depth) {
		if(depth==M) {
			for(int val:arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(N,M,depth+1);
				visit[i]=false;
	
			}
		}
	}
}*/
public class NM1{
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth==M) {
			for(int val:arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}	
}
/*
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ���
���ϴ� ���α׷��� �ۼ��Ͻÿ�
* 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
�Է� : ù° �ٿ� �ڿ��� N�� M�� �־�����.(1<=N<=M<=8)
��� : �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ�
������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����Ͽ� ����ؾ� �Ѵ�.
������ �������� �����ϴ� ���� ����ؾ� �Ѵ�.
*/