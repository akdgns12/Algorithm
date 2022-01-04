package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <백트래킹과 조합>활용
 * 
 */
public class 가르침 {
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
		 * 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어가 최대가 되는가
		 * 남극언어는 "anta"로 시작하고, "tica"로 끝난다.
		 * 남극언어에는 단어 N개밖에 없다고 가정한다.
		 * 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하라.
		 * 
		 */
		//N개의 줄에 남극언어의 단어가 주어진다. 단어는 영어 소문자로만  이루어져있고,
		//길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든단어는 중복되지 않는다.
		
		//모든 단어는 "anta"로 시작하고, "tica"로 끝난다
		/*
		 * 알파벳을 뽑았는지 확인하기 위해 boolean타입의 visited배열을 선언해주고
		 * 이미 알고있는 a,c,n,t,i를 true로 설정해준다. 그리고 뽑은 알파벳들을
		 * true로 바꾼 후 조건에 맞는 수의 알파벳을 다뽑고 난 후 읽을 수 있는 단어의 
		 * 개수를 계산한다.
		 * 이 때 a,c,n,t,i가 이미 5개의 알파벳이므로 k가 5개이하의 개수가 들어온다면
		 * 읽을 수 있는 단어의 개수가 없다.
		 * 그리고 k가 26이 입력된다면 모든 알파벳을 읽을 수 있다는 의미이므로 n을 반환해주면 된다.
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
		
		visited = new boolean[26]; //각 알파벳을 배웠는지 체크
		//무조건 배워야 하는 단어
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
			for(int i=0; i<N; i++) {//뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트
				boolean read = true;
				for(int j=0; j<word[i].length(); j++) {
					//배우지 않은 알파벳이 있는 경우
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
