package ���α׷��ӽ�_Level_1;
/*
 * ���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������
 * ���ο� ���ڿ��� �����ϴ� �Լ�, solution
 * s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ���� ����
 */
public class ���ڿ������������ι�ġ�ϱ� {
	public String solution(String s) {
		String answer = "";
		
        String[] sArr = s.split("");
        String tmp;

        /**
         * ���� ����
         */
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j < s.length() - 1 - i; j++) {
                if (sArr[j].charAt(0) < sArr[j + 1].charAt(0)) {
                    tmp = sArr[j];
                    sArr[j] = sArr[j + 1];
                    sArr[j + 1] = tmp;
                }
            }
        }

        answer = String.join("", sArr);

		return answer;
	}
}
/*
 * Collections.reverseOrder() ���
 * class Solution {
 * public String solution(String s){
 * 	String answer = "";
 * 	String[] sArr = s.split("");
 * 
 *  Arrays.sort(sArr, Collections.reverseOrder());
 *  answer = String.join("", sArr);
 *  
 *  return answer;
 *  }
 *  }
 * 
 * 
 */
	