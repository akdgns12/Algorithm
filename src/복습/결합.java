package 복습;
import java.io.*;
import java.util.*;

public class 결합 {
	public static String[][] inp = new String[9][3];
	public static boolean[][][] check = new boolean[9][9][9];
	//public static int[][][] arr = new int[9][9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			inp[i] = br.readLine().split(" ");
		}
		int hap = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				for (int k = j + 1; k < 9; k++) {
					if (junchuri(inp[i], inp[j], inp[k])) {
						//System.out.println(i + " " + j + " " + k);
						check[i][j][k] = true;
						hap++;
					}
				}
			}

		}
		//System.out.println("\n합의 개수" + hap);

		int n = Integer.parseInt(br.readLine());
		int score = 0;
		boolean g = false;

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			char gh = s[0].charAt(0);
			if (gh == 'H') {
				int[] arr = new int[3];
				
				for (int j = 1; j <= 3; j++) {
					arr[j-1] = Integer.parseInt(s[j]);
				}
				Arrays.sort(arr);
				//System.out.println("input : " + arr[0] + " " + arr[1] + " " + arr[2]);
				if(check[arr[0]-1][arr[1]-1][arr[2]-1]) {
					score += 1;
					hap--;
					check[arr[0]-1][arr[1]-1][arr[2]-1] = false;
				}else {
					score -= 1;
				}
				
				
			} else {
				if (hap == 0 && !g) {
					g = true;
					score += 3;
				} else {
					score -= 1;
				}
			}
			
			//System.out.println(score);
		}
		System.out.println(score);

	}

	public static boolean junchuri(String[] fir, String[] sec, String[] thr) {
		boolean ans = false, tmp = true;
		for (int i = 0; i < 3; i++) {
			if ((fir[i].equals(sec[i]) && sec[i].equals(thr[i]))
					|| (!fir[i].equals(sec[i]) && !fir[i].equals(thr[i]) && !sec[i].equals(thr[i]))) {

			} else {
				tmp = false;
				break;
			}
			//

		}
		ans = (ans || tmp) ? true : false;
		return ans;
	}
}