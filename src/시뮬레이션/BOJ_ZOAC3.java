package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_ZOAC3 {
	// BOJ ZOAC3 실버4 / 시뮬레이션
	static class Keyboard {
		int x, y;
		public Keyboard(int x, int y) {
			this.x =x ;
			this.y = y;
		}
	}
	
	static String l; // 왼손 검지손가락 처음 위치
	static String r; // 오른손 검지손가락 처음 위치
	static HashMap<String, Keyboard> ja; // 자음
	static HashMap<String, Keyboard> mo; // 모음
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		l = st.nextToken();
		r = st.nextToken();
		
		String str = br.readLine();
		
		ja = new HashMap<>();
		mo = new HashMap<>();
		
		makeKeyboard();
		calcTime(str, l, r);
		System.out.println(result);
	}
	public static void makeKeyboard() {
		// 맨윗줄
		ja.put("q", new Keyboard(0,0));
		ja.put("w", new Keyboard(1,0));
		ja.put("e", new Keyboard(2,0));
		ja.put("r", new Keyboard(3,0));
		ja.put("t", new Keyboard(4,0));
		mo.put("y", new Keyboard(5,0));
		mo.put("u", new Keyboard(6,0));
		mo.put("i", new Keyboard(7,0));
		mo.put("o", new Keyboard(8,0));
		mo.put("p", new Keyboard(9,0));
		// 2번째줄
		ja.put("a",new Keyboard(0,1));
	    ja.put("s",new Keyboard(1,1));
	    ja.put("d",new Keyboard(2,1));
	    ja.put("f",new Keyboard(3,1));
	    ja.put("g",new Keyboard(4,1));
	    mo.put("h",new Keyboard(5,1));
	    mo.put("j",new Keyboard(6,1));
	    mo.put("k",new Keyboard(7,1));
	    mo.put("l",new Keyboard(8,1));
	    //3줄
	    ja.put("z",new Keyboard(0,2));
	    ja.put("x",new Keyboard(1,2));
	    ja.put("c",new Keyboard(2,2));
	    ja.put("v",new Keyboard(3,2));
	    mo.put("b",new Keyboard(4,2));
	    mo.put("n",new Keyboard(5,2));
	    mo.put("m",new Keyboard(6,2));
	}
	
	public static void calcTime(String str, String l, String r) {
		String lTmp = l,  rTmp = r;
		for(int i=0; i<str.length(); i++) {
			if(ja.containsKey(str.charAt(i) + "")) {
				Keyboard k1 = ja.get(l);
				Keyboard k2 = ja.get(str.charAt(i) + "");
				result += (Math.abs(k1.x - k2.x) + Math.abs(k1.y - k2.y));
				result++;
				l = str.charAt(i) + "";
			}else {
				Keyboard k1 = mo.get(r);
				Keyboard k2 = mo.get(str.charAt(i) + "");
				result += (Math.abs(k1.x -k2.x) + Math.abs(k1.y - k2.y));
				result++;
				r = str.charAt(i) + "";
			}
		}
	}
}
