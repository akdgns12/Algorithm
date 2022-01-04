package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 결합 { 
	static class Point{
		String type, color, back;
		public Point(String type, String color, String back) {
			this.type = type;
			this.color = color;
			this.back = back;
		}
	}
	static int N;
	static Point map[][];
	static int[] arr;
	static Set<String> ans;
	static int score = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		ans = new HashSet<>();
		map = new Point[3][3];
		String type, typeColor, backColor;
		arr = new int[3];
		
		for(int i=0; i<9; i++) {
			int r = i/3;
			int c = i%3;
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();
			typeColor = st.nextToken();
			backColor = st.nextToken();
			map[r][c] = new Point(type, typeColor, backColor);
		}
		
		combi(0,0);
		
		N = Integer.parseInt(br.readLine());
		boolean useG = false;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command == "H") {
				int s[] = new int[3];
				for(int j=0; j<3; j++) {
					s[j] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(s);
				String hap = String.valueOf(s[0]) + String.valueOf(s[1]) + String.valueOf(s[2]);
				if(ans.contains(hap)) {
					score += 1;
					ans.remove(hap);
				}else {
					score -= 1;
				}
			}else if(command == "G") {
				if(!useG && ans.size() == 0) {
					score += 3;
					useG = true;
				}
				else
					score -= 1;
			}
		}
		System.out.println(score);
	}

	public static void combi(int arrIdx, int pickNum) {
		if(pickNum == 3) {
			if(checkHap()) {
				String tmp = String.valueOf(arr[0] + 1) +String.valueOf(arr[1] + 1) +String.valueOf(arr[2] + 1);
				ans.add(tmp);
			}
			return;
		}
		if(arrIdx == 9) {
			return;
		}
		arr[pickNum] = arrIdx;
		combi(arrIdx+1, pickNum+1);
		combi(arrIdx+1, pickNum);
	}
	
	public static boolean checkHap() {
		// 占쏙옙占�, 占쏙옙, 占쏙옙占쏙옙占쏙옙
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		int ar = a/3;
		int ac = a%3;
		int br = b/3;
		int bc = b%3;
		int cr = c/3;
		int cc = c%3;
		if ((map[ar][ac].type.equals(map[br][bc].type) && map[ar][ac].type.equals(map[cr][cc].type)) 
				|| (!map[ar][ac].type.equals(map[br][bc].type) && !map[ar][ac].type.equals(map[cr][cc].type)
						&& !map[br][bc].type.equals(map[cr][cc].type))) { 
			
		} else {
			return false; 
			} 
		if ((map[ar][ac].color.equals(map[br][bc].color) && map[ar][ac].color.equals(map[cr][cc].color)) 
				|| (!map[ar][ac].color.equals(map[br][bc].color) && !map[ar][ac].color.equals(map[cr][cc].color) 
						&& !map[br][bc].color.equals(map[cr][cc].color))) { 
			
		} else 
			return false; 
		if ((map[ar][ac].back.equals(map[br][bc].back) && map[ar][ac].back.equals(map[cr][cc].back)) 
				|| (!map[ar][ac].back.equals(map[br][bc].back) && !map[ar][ac].back.equals(map[cr][cc].back) 
						&& !map[br][bc].back.equals(map[cr][cc].back))) { 
			
		} else 
			return false; 
		return true; 
		} 
	}
