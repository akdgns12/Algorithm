package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class 무한수열{
	static int p;
	static int q;
	static HashMap<Long, Long> map;
	
	static long go(long n) {
		// 첫 항은 1이라고 주어졌다. 
		if( n == 0 ) return 1;
		// 메모된 값이 있다면 그걸 쓰자 
		if(map.containsKey(n)) {
			return map.get(n);
		}
		// 없다면 직접 구해주자~!!
		map.put(n, go(n/p) + go(n/q));
		
		// 반환한다 
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
