package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//�÷��̵� �ͼ� �˰��� ���� ����
// �ڽ��� ������ ��� �������� ��� ������ ���Ͽ� �̵��� �� �ִ��� �ľ��ؾ� ��.
/*
 * 1. ������ �Է��� ���� �迭�� ���Ͽ� �÷��̵� �ͼ� �˰����� ���Ѵ�.
 * 2. ������ �Է°� �ݴ�� ���� �迭�� ���Ͽ� �÷��̵� �ͼ� �˰����� ���Ѵ�.
 * 3. 1���� 2���� �迭 or ����
 * 4. or ������ �迭���� �ڽ��� ������ �л� ��θ� Ž���� �� �ִ� �ε����� 
 * ������ ���
 * 
 */
/*
 * Floyd-Warshall �˰����� �̿��� ���
* 1. �÷��̵� ���� ����� ����� �� �ִ� ������ ������ ����. 
* 2. �÷��̵� ���� �˰����� ���� �� �������� �ٸ� ���������� ���� ª�� �Ÿ��� ���Ѵٰ� ���� ��
* 3. dist[i][j] �� ���� i���� �����Ͽ� ���� j������ �ִܰŸ��� �ǹ��Ѵ�. �� �� dist[i][j] �� �����ϸ� ���� �� �� �ִ� ���̹Ƿ�
* 4. ������ ������ ���忡�� ���캸�� i ���� ū ������ + 1, j ���� ���� ������ + 1 �� �ǰ� �ȴ�. 
* 5. ��� �Ÿ� �迭�� ������� �� �� ���������� ���� n - 1���� �Ǹ� �� �������� ��� �������� ���踦 �� �� �ִ� �����̴�. 
*/

public class BOJ_Ű���� {
	public static final int INF = (int)1e9;
	static int n,m;
	static int cnt;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		
		//�ִܰŸ� ���̺��� ��� �������� �ʱ�ȭ
		//�ڱ� �ڽſ��� ���� ����� 0���� �ʱ�ȭ
		for(int i=1; i<=n; i++) {
			Arrays.fill(graph[i],  INF);
			graph[i][i] = 0;
		}
		
		//���� ���� �Է¹���
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//��ΰ� �����Ѵٸ� cost�� 1�� �ش�
			graph[from][to] = 1;
		}
		
		//�÷��̵�
		for(int k=1; k<=n; k++) {//������
			for(int i=1; i<=n; i++) {//�����
				for(int j=1; j<=n; j++) {//������
					graph[i][j] = Math.min(graph[i][j],  graph[i][k] + graph[k][j]);
				}
			}
		}
		
		
		//path[i]���忡�� ���� i���� graph[i][j] = 1 �̶�°� i���� ū ������ �ϳ� �ִٴ� �Ҹ�
		//�׷��� graph[i][j]=1�̸鼭 <INF �϶� path[i] +=1�� ���ִٰ� path[i] == n-1�� �Ǹ� �ڽ��� ������ ������
		//��� �ľ� �����ϱ� ������ count +=1 ���ָ� �ȴ�. j���� ���忡���� ���� ����
		int[] path = new int[n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				if(graph[i][j] < INF) {
					path[i] += 1;
					path[j] += 1;
					if(path[i] == n - 1) cnt +=1;
					if(path[j] == n - 1) cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}
}
