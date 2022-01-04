package realiztion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * NBA 농구
 * 골이 들어간 횟수 N(1<=N<100)
 * 1,2팀이 있고 농구경기는 48분간 진행
 * 첫째줄에 1팀이 이긱 있던 시간, 둘째줄에 2팀이 이기고 있던 시간 출력
 */

	public class BOJ_2852_농구{
		private static final String COLON = ":";
		static int[][] time;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			time = new int[3][2]; // i = team, j[0] = min, j[1] = sec
			
			int balance = 0; // 어떤 팀이 이기고 있는지 알려줄 변수
			
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
					time[1][0] += (min - lastMin);  // 1팀의 분
					time[1][1] += (sec - lastSec);	// 1팀의 초
					
					
					if(time[1][1] >= 60) { // 초가 60을 넘어가면 분을 증가시켜주고 초에서 60을 감소시켜준다
						time[1][0]++;
						time[1][1]--;
						
					} else if(time[1][1]<0) { // 초가 음수라면 1분을 감소시키고 초에 60을 증가시킨다
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
				}else { // ? 여기부터 뭐하는거지?
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
 * public class BOJ_2852_농구 { static int n; static int A,B = 0; // A,B팀 스코어
 * static int[] team; static String[] str; static int[] time = {0,0}; // 최종 출력할
 * 변수 static int[] tempTime = {0,0}; //임시 계산을 위해 선언한 변수 static int which = 0;
 * //현재 어떤 팀이 이기고 있는지 알려주는 변수
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
 * if(A>B) { if( A - B <= 1 && which !=1) { // 방금 막 역전했을 경우(이기고 있는 팀이 A가 아닐 때)
 * tempTime[0] = timetransfer; }else { // 원래 이기고 있을 경우 아무것도 안함 } } else if(A<B)
 * { //B가 앞서나갈 경우 if(B-A <=1 && which !=2) { // 방금 막 역전했을 경우(이기고 있는 팀이 B가 아닐 때)
 * tempTime[1] = timetransfer; }else { // 원래 이기고 있던 상태일 경우 아무것도 안함 } } else { //
 * 비기게 되었을 경우 if(team[i] == 1) { //A팀이 방금 골 넣어서 동점이 될 경우 // 2팀의 시간 기록은 멈춤
 * time[1] += timetransfer - tempTime[1]; } else { //1팀의 시간기록은 멈춤 time[0] +=
 * timetransfer - tempTime[0]; } } // End of Input
 * 
 * // 현재 어떤 팀이 이기고 있나 판단 if( A > B) which =1; else if( A<B) which = 2; else
 * which =0;
 * 
 * // 경기 종료시 특정 팀이 이기고 있을 때 if( i == n-1) { if(which ==1) { time[0] = time[0]
 * +47*60 + 60 - tempTime[0]; } else if(which ==2) { time[1] = time[1] + 48*60
 * -tempTime[1]; } }
 * 
 * } for(int i=0; i<=1; i++) { if(time[i] / 60 <10) { System.out.print('0'); }
 * System.out.print(time[i]/60 + ":"); if(time[i] % 60 <10) {
 * System.out.print('0'); } System.out.println(time[i] % 60); } } }
 */