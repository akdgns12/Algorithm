package 프로그래머스_Level_1;
/*
 * 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임
 * 
 */
/*
 * 1. 각 구간별 합을 저장할 정수형 배열을 3의 크기로 만든다.

2. 저장할 원소의 위치를 지정할 정수형 변수 cnt를 만들어 0으로 초기화합니다.

3. 각 구간별 숫자를 담을 문자열 temp를 만듭니다.

 

4. 주어진 문자열 길이만큼 반복문을 돌립니다.

    - i번째 문자를 문자형 변수 c에 저장합니다.

    - 문자가 0~9일 때 temp에 문자열로 변환시켜 저장합니다.

      (10 이상 숫자가 나올 수 있기 때문에 += 해준다.)

 

    - 문자가 S, D, T 일 때 정수형 변수 num에 temp를 정수형 변환해 넣어줍니다.

    - S일 땐 1 제곱, D일 땐 2 제곱, T일 땐 3 제곱합니다.

    - sum[cnt]에 num을 넣고, cnt++, temp를 초기화 합니다.

      (cnt는 다음 원소를 넣어야 하기 때문에 +1, temp는 다음 숫자를 담아야 하기 때문에 초기화)

 

    - 그 이외에는 기호일 때를 고려해 계산합니다.

    - #일 때 sum[cnt-1] 원소에 -1을 곱해줍니다.(cnt는 +1된 상태이기 때문에 -1을 해줘야 한다.)

    - *일 때 sum[cnt-1] 원소에 2를 곱해줍니다.

    - cnt-2 가 0 이상일 때 cnt-2 위치에도 2를 곱해줘야 하기 때문에 sum[cnt-2] *= 2를 합니다.

 

5. sum원소를 모두 answer에 합하면서 넣습니다.
 */
public class _1차다트게임{
	public int solution(String dartResult) {
		int answer = 0;
		
		int[] sum = new int[3];
		int cnt = 0;
		
		String temp = "";
		
		for(int i=0; i<dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			
			if(c >= '0' && c <= '9') {
				temp += String.valueOf(c);
			}else if(c == 'S' || c == 'D' || c == 'T') {
				int num = Integer.parseInt(temp);
				if( c == 'S') {
					num = (int)Math.pow(num, 1);
				}else if(c == 'D') {
					num = (int)Math.pow(num, 2);
				}else if(c == 'T') {
					num = (int)Math.pow(num, 3);
				}
				
				sum[cnt] = num;
				cnt++;
				temp = "";
			}else {
				if( c == '#') {
					sum[cnt-1] *= -1;
				}else {
					sum[cnt-1] *= 2;
					if(cnt-2 >= 0) {
						sum[cnt-2] *= 2;
					}
				}
			}
		}
		
		for(int i: sum) {
			answer += i;
		}
		
		return answer;
	}
}
// 내가 처음에 직관적으로 풀었던 풀이(오답임)
/*
public class _1차다트게임 {
	public int solution(String dartResult) {
		int answer = 0;
		String[] dartArr = dartResult.split("");
		int temp_s = 0;
		int temp_d =0;
		int temp_t = 0;
		int temp_st = 0; // *에 대한 임시 저장 값
		int temp_a = 0;
		for(int i=0; i<dartResult.length(); i++) {
			if(dartArr[i].charAt(0) == 'S') {
				temp_s += dartArr[i-1].charAt(0) * 1;
			}
			else if(dartArr[i].charAt(0) == 'D') {
				temp_d += dartArr[i-1].charAt(0) * dartArr[i-1].charAt(0);
			}else if(dartArr[i].charAt(0) == 'T') {
				temp_t += dartArr[i-1].charAt(0) * dartArr[i-1].charAt(0) * dartArr[i-1].charAt(0);
			}else if(dartArr[i].charAt(0) == '#') {
				 temp_a += dartArr[i-1].charAt(0)*(-1);
			}else if(dartArr[i].charAt(0) == '*') {
				for(int j=0; j<i; j++) {
					if(dartArr[j].charAt(0) == 'S') {
						temp_st += (temp_s)*2;
					}else if(dartArr[j].charAt(0) == 'D') {
						temp_st += (temp_d)*2;
					}else if(dartArr[j].charAt(0)== 'T') {
						temp_st += (temp_t)*2;
					}else if(dartArr[j].charAt(0)=='#') {
						temp_st += (temp_a)*2;
					}
				}
			}
		}
		
		answer = temp_st + temp_a + temp_s + temp_d + temp_t;
		return answer;
	}
}
*/