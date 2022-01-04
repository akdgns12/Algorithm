package realiztion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * NBA ��
 * ���� �� Ƚ�� N(1<=N<100)
 * 1,2���� �ְ� �󱸰��� 48�а� ����
 * ù°�ٿ� 1���� �̱� �ִ� �ð�, ��°�ٿ� 2���� �̱�� �ִ� �ð� ���
 */

	public class BOJ_2852_��{
		private static final String COLON = ":";
		static int[][] time;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			time = new int[3][2]; // i = team, j[0] = min, j[1] = sec
			
			int balance = 0; // � ���� �̱�� �ִ��� �˷��� ����
			
			int min = 0;
			int sec =0;
			int goal = 0;
			int lastMin = 0;
			int lastSec = 0;
			
			boolean isFirst = true;
			
			while(N-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				goal = Integer.parseInt(st.nextToken());
				if(goal == 1) {
					balance++;
					
				}else {
					balance--;
				}
				
				st = new StringTokenizer(st.nextToken(), COLON);
				min = Integer.parseInt(st.nextToken());
				sec = Integer.parseInt(st.nextToken());
				
				if(balance > 0) {
					if(isFirst == true) {
						isFirst = false;
						lastMin = min;
						lastSec = sec;
						continue;
					}
					time[1][0] += (min - lastMin);  // 1���� ��
					time[1][1] += (sec - lastSec);	// 1���� ��
					
					
					if(time[1][1] >= 60) { // �ʰ� 60�� �Ѿ�� ���� ���������ְ� �ʿ��� 60�� ���ҽ����ش�
						time[1][0]++;
						time[1][1]--;
						
					} else if(time[1][1]<0) { // �ʰ� ������� 1���� ���ҽ�Ű�� �ʿ� 60�� ������Ų��
						time[1][0]--;
						time[1][1] += 60;
					}
				} else if(balance == 0) {
					isFirst = true;

					if (goal == 1) {
						time[2][0] += (min - lastMin);
						time[2][1] += (sec - lastSec);

						if (time[2][1] >= 60) {
							time[2][0]++;
							time[2][1] -= 60;

						} else if (time[2][1] < 0) {
							time[2][0]--;
							time[2][1] += 60;
						}
				}else { // ? ������� ���ϴ°���?
					time[1][0] += (min - lastMin);
					time[1][1] += (sec - lastSec);
					
					if(time[1][1] >= 60) {
						time[1][0]++;
						time[1][1] -= 60;
						
					} else if(time[1][1] <0) {
						time[1][0]--;
						time[1][1] += 60;
					}
				}
					
			} else {
				if(isFirst == true) {
					isFirst = false;
					lastMin = min;
					lastSec = sec;
					continue;
				}
				
				time[2][0] += (min - lastMin);
				time[2][1] += ( sec - lastSec);
			
				if(time[2][1] >= 60) {
					time[2][0]++;
					time[2][1] -= 60;
				} else if(time[2][1] <0) {
					time[2][0]--;
					time[2][1] += 60;
				}
			}
				lastMin = min;
				lastSec = sec;

		}
			
			if(balance>0) {
				time[1][0] += 48 - min;
				time[1][1] += 0 - sec;
			
				if(time[1][1] >= 60) {
					time[1][0] ++;
					time[1][1] -= 60;
					
				} else if(time[1][1] <0 ) {
					time[1][0]--;
					time[1][1] += 60;
				}
				
	} else if(balance<0) {
		time[2][0] += 48 - min;
		time[2][1] += 0 - sec;
		
		if(time[2][1] >= 60) {
			time[2][0]++;
			time[2][1] -= 60;
		
		} else if(time[2][1] <0) {
			time[2][0]--;
			time[2][1] += 60;
			}
		}
			System.out.println((time[1][0] < 10 ? "0" + time[1][0] : time[1][0]) + COLON + (time[1][1] < 10 ? "0" + time[1][1] : time[1][1]));
			System.out.println((time[2][0] < 10 ? "0" + time[2][0] : time[2][0]) + COLON + (time[2][1] < 10 ? "0" + time[2][1] : time[2][1]));
	}	
}
		
/*
 * public class BOJ_2852_�� { static int n; static int A,B = 0; // A,B�� ���ھ�
 * static int[] team; static String[] str; static int[] time = {0,0}; // ���� �����
 * ���� static int[] tempTime = {0,0}; //�ӽ� ����� ���� ������ ���� static int which = 0;
 * //���� � ���� �̱�� �ִ��� �˷��ִ� ����
 * 
 * public static void main(String[] args) throws IOException{ BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in));
 * 
 * n = Integer.parseInt(br.readLine()); team = new int[2]; str = new String[50];
 * 
 * StringTokenizer st = new StringTokenizer(br.readLine());
 * 
 * //Input for(int i=0; i<n; i++) { team[i] = Integer.parseInt(br.readLine());
 * str[i] = br.readLine(); int timetransfer = Integer.parseInt(str[i]);
 * 
 * if(team[i] == 1) A++; else B++;
 * 
 * if(A>B) { if( A - B <= 1 && which !=1) { // ��� �� �������� ���(�̱�� �ִ� ���� A�� �ƴ� ��)
 * tempTime[0] = timetransfer; }else { // ���� �̱�� ���� ��� �ƹ��͵� ���� } } else if(A<B)
 * { //B�� �ռ����� ��� if(B-A <=1 && which !=2) { // ��� �� �������� ���(�̱�� �ִ� ���� B�� �ƴ� ��)
 * tempTime[1] = timetransfer; }else { // ���� �̱�� �ִ� ������ ��� �ƹ��͵� ���� } } else { //
 * ���� �Ǿ��� ��� if(team[i] == 1) { //A���� ��� �� �־ ������ �� ��� // 2���� �ð� ����� ����
 * time[1] += timetransfer - tempTime[1]; } else { //1���� �ð������ ���� time[0] +=
 * timetransfer - tempTime[0]; } } // End of Input
 * 
 * // ���� � ���� �̱�� �ֳ� �Ǵ� if( A > B) which =1; else if( A<B) which = 2; else
 * which =0;
 * 
 * // ��� ����� Ư�� ���� �̱�� ���� �� if( i == n-1) { if(which ==1) { time[0] = time[0]
 * +47*60 + 60 - tempTime[0]; } else if(which ==2) { time[1] = time[1] + 48*60
 * -tempTime[1]; } }
 * 
 * } for(int i=0; i<=1; i++) { if(time[i] / 60 <10) { System.out.print('0'); }
 * System.out.print(time[i]/60 + ":"); if(time[i] % 60 <10) {
 * System.out.print('0'); } System.out.println(time[i] % 60); } } }
 */