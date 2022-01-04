package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class ���Ѽ���{
	static int p;
	static int q;
	static HashMap<Long, Long> map;
	
	static long go(long n) {
		// ù ���� 1�̶�� �־�����. 
		if( n == 0 ) return 1;
		// �޸�� ���� �ִٸ� �װ� ���� 
		if(map.containsKey(n)) {
			return map.get(n);
		}
		// ���ٸ� ���� ��������~!!
		map.put(n, go(n/p) + go(n/q));
		
		// ��ȯ�Ѵ� 
		return map.get(n);
	}
	
     public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long n = Long.parseLong(st.nextToken());
    	p = Integer.parseInt(st.nextToken());
    	q = Integer.parseInt(st.nextToken());
    	
    	map = new HashMap<Long, Long>();
    	
    	System.out.println(go(n));
    	
     }
}
