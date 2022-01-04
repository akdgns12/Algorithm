package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <��Ʈ��ŷ�� ����>Ȱ��
 * 
 */
public class ����ħ {
	static int N,K;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static String[] word;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		/*
		 * � K���� ���ڸ� �����ľ� �л����� ���� �� �ִ� �ܾ �ִ밡 �Ǵ°�
		 * ���ؾ��� "anta"�� �����ϰ�, "tica"�� ������.
		 * ���ؾ��� �ܾ� N���ۿ� ���ٰ� �����Ѵ�.
		 * �л����� ���� �� �ִ� �ܾ��� �ִ��� ���ϴ� ���α׷��� �ۼ��϶�.
		 * 
		 */
		//N���� �ٿ� ���ؾ���� �ܾ �־�����. �ܾ�� ���� �ҹ��ڷθ�  �̷�����ְ�,
		//���̰� 8���� ũ�ų� ����, 15���� �۰ų� ����. ���ܾ�� �ߺ����� �ʴ´�.
		
		//��� �ܾ�� "anta"�� �����ϰ�, "tica"�� ������
		/*
		 * ���ĺ��� �̾Ҵ��� Ȯ���ϱ� ���� booleanŸ���� visited�迭�� �������ְ�
		 * �̹� �˰��ִ� a,c,n,t,i�� true�� �������ش�. �׸��� ���� ���ĺ�����
		 * true�� �ٲ� �� ���ǿ� �´� ���� ���ĺ��� �ٻ̰� �� �� ���� �� �ִ� �ܾ��� 
		 * ������ ����Ѵ�.
		 * �� �� a,c,n,t,i�� �̹� 5���� ���ĺ��̹Ƿ� k�� 5�������� ������ ���´ٸ�
		 * ���� �� �ִ� �ܾ��� ������ ����.
		 * �׸��� k�� 26�� �Էµȴٸ� ��� ���ĺ��� ���� �� �ִٴ� �ǹ��̹Ƿ� n�� ��ȯ���ָ� �ȴ�.
		 */
		word = new String[N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			word[i] = str;
		}
		
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}
		
		visited = new boolean[26]; //�� ���ĺ��� ������� üũ
		//������ ����� �ϴ� �ܾ�
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		
		backtracking(0,0);
		System.out.println(max);
		
	}
	
	public static void backtracking(int alpha, int len) {
		if(len == K - 5) {
			int count = 0;
			for(int i=0; i<N; i++) {//���� ���ĺ����� ��� �ܾ ���� �� �ִ��� ī��Ʈ
				boolean read = true;
				for(int j=0; j<word[i].length(); j++) {
					//����� ���� ���ĺ��� �ִ� ���
					if(!visited[word[i].charAt(j) - 'a']) {
						read = false;
						break;
					}
				}
				if(read) count++;
			}
			max = Math.max(max,  count);
			return;
		}
		
		for(int i=alpha; i<26; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				backtracking(i, len+1);
				visited[i] = false;
			}
		}
	}
}
