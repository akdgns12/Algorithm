package ���α׷��ӽ�level2;
/*
 * ������ ó�� �������� �ǰ� ���� "����ġ"�� ���ڿ��� �����ϴ� ����� ���� ���θ�
 *  �ϰ� �ֽ��ϴ�. �ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� 
 *  ���� ���θ� �ϰ� �ִµ�, ���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������
 *   ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ��� �ٿ��� ǥ���ϴ� �˰����� 
 *   �����ϰ� �ֽ��ϴ�.
������ ���� "aabbaccc"�� ���
 "2a2ba3c"(���ڰ� �ݺ����� �ʾ� �ѹ��� ��Ÿ�� ��� 1�� ������)�� ���� ǥ���� ��
  �ִµ�, �̷��� ����� �ݺ��Ǵ� ���ڰ� ���� ��� ������� ���ٴ� ������ �ֽ��ϴ�.
   ���� ���, "abcabcdede"�� ���� ���ڿ��� ���� ������� �ʽ��ϴ�. 
   "����ġ"�� �̷��� ������ �ذ��ϱ� ���� ���ڿ��� 1�� �̻��� ������ �߶�
    �����Ͽ� �� ª�� ���ڿ��� ǥ���� �� �ִ��� ����� ã�ƺ����� �մϴ�.

���� ���, "ababcdcdababcdcd"�� ��� ���ڸ� 1�� ������ �ڸ���
 ���� ������� ������, 2�� ������ �߶� �����Ѵٸ� "2ab2cd2ab2cd"�� 
 ǥ���� �� �ֽ��ϴ�. �ٸ� ������� 8�� ������ �߶� �����Ѵٸ� "2ababcdcd"��
  ǥ���� �� ������, �̶��� ���� ª�� �����Ͽ� ǥ���� �� �ִ� ����Դϴ�.

�ٸ� ����, "abcabcdede"�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ�
 "abcabc2de"�� ������, 
 3�� ������ �ڸ��ٸ� "2abcdede"�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. �̶� 3�� ������ �ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.

������ ���ڿ� s�� �Ű������� �־��� ��, 
���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶� �����Ͽ� ǥ���� ���ڿ� �� 
���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.

 */
public class ���ڿ����� {
	public int solution(String s) {
		int answer = s.length();
		
		for(int n=1; n<=s.length()/2; n++) { // ���ڿ��� ������ ���� �̻����� �����ϴ°� �ǹ� �����Ƿ� �ݱ����� �����ش�
			StringBuilder temp = new StringBuilder();
			
			for(int i=0; i<s.length(); i= i+n) {
				String word = "";
				
				if(i+n >= s.length())
					word = s.substring(i, s.length());
				else word = s.substring(i, i+n);
				
				int cnt = 1;
				StringBuilder sb = new StringBuilder();
				
				for(int j=i+n; j<s.length(); j=j+n) {
					String word2 = "";
					
					if(j+n >= s.length()) {
						word2 = s.substring(j, s.length());
					}else {
						word2 = s.substring(j, j+n);
					}
					
					if(word.equals(word2)) {
						cnt++;
						i=j;
					}else {
						break;
					}
				}
				
				if(cnt==1)sb.append(word);
				else sb.append(cnt).append(word);
				
				temp.append(sb.toString());
			}
			
			answer = Math.min(answer, temp.toString().length());
		}
		
		
		return answer;
	}
}
