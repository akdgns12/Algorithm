package ���α׷��ӽ�_Level_1;
/*
 * ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ����
 * 
 */
/*
 * 1. �� ������ ���� ������ ������ �迭�� 3�� ũ��� �����.

2. ������ ������ ��ġ�� ������ ������ ���� cnt�� ����� 0���� �ʱ�ȭ�մϴ�.

3. �� ������ ���ڸ� ���� ���ڿ� temp�� ����ϴ�.

 

4. �־��� ���ڿ� ���̸�ŭ �ݺ����� �����ϴ�.

    - i��° ���ڸ� ������ ���� c�� �����մϴ�.

    - ���ڰ� 0~9�� �� temp�� ���ڿ��� ��ȯ���� �����մϴ�.

      (10 �̻� ���ڰ� ���� �� �ֱ� ������ += ���ش�.)

 

    - ���ڰ� S, D, T �� �� ������ ���� num�� temp�� ������ ��ȯ�� �־��ݴϴ�.

    - S�� �� 1 ����, D�� �� 2 ����, T�� �� 3 �����մϴ�.

    - sum[cnt]�� num�� �ְ�, cnt++, temp�� �ʱ�ȭ �մϴ�.

      (cnt�� ���� ���Ҹ� �־�� �ϱ� ������ +1, temp�� ���� ���ڸ� ��ƾ� �ϱ� ������ �ʱ�ȭ)

 

    - �� �̿ܿ��� ��ȣ�� ���� ����� ����մϴ�.

    - #�� �� sum[cnt-1] ���ҿ� -1�� �����ݴϴ�.(cnt�� +1�� �����̱� ������ -1�� ����� �Ѵ�.)

    - *�� �� sum[cnt-1] ���ҿ� 2�� �����ݴϴ�.

    - cnt-2 �� 0 �̻��� �� cnt-2 ��ġ���� 2�� ������� �ϱ� ������ sum[cnt-2] *= 2�� �մϴ�.

 

5. sum���Ҹ� ��� answer�� ���ϸ鼭 �ֽ��ϴ�.
 */
public class _1����Ʈ����{
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
// ���� ó���� ���������� Ǯ���� Ǯ��(������)
/*
public class _1����Ʈ���� {
	public int solution(String dartResult) {
		int answer = 0;
		String[] dartArr = dartResult.split("");
		int temp_s = 0;
		int temp_d =0;
		int temp_t = 0;
		int temp_st = 0; // *�� ���� �ӽ� ���� ��
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