package ���α׷��ӽ�_Level_1;
/*
 * 1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution
 * �Ҽ��� 1�� �ڱ��ڽ����θ� ���������� ��
 * (1�� �Ҽ��� �ƴ�)
 */
// ���� 2�� ����� Ǯ��
/*
public class �Ҽ�ã�� {
	public int solution(int n) {
		int answer = 0;
		int count = 0; //�Ҽ� �Ǻ� ����
		int primeNum = 1; //�Ҽ����� ��ȯ����
		
		for(int i=3; i<=n; i++) {//3���� n����
			for(int j=2; j<i; j++) {
				if(i%j==0)
					count++;
			}
			if(count==0)
				primeNum++;
			count = 0;
		}
		
		return answer = primeNum;
	}
}
*/
/*
 * ���� �ϳ� ����� Ǯ��
 * class Solution {
  public int solution(int n) {
      int answer = 1;
      int count =0;//�Ҽ��Ǻ� ����
     
      for(int i=3; i<=n;i++){//3���� n����
         for(int j=2; j<i; j++){
              if(i%j==0)
                  count++;
            }
          if(count==0)
                answer++;
          count=0;
      }
           return answer;
  }
}
 */
/*
 * �����佺�׳׽��� ü ����� Ǯ��
 * �����佺�׳׽� ����
 * 1. �ڽ��� ���� ��Ʈ ���� ���Ѵ�
 * 2. 2���� ��Ʈ �� ������ ������ ������� �� ���ش�
 * 3. �׸��� �������� �Ҽ�
 * */
 class Solution {
  public int solution(int n) {
      int answer = 0;
      boolean[] sosu =new boolean [n+1];
      
      for(int i=2; i<=n ; i++)
          sosu[i]=true;
       
      int root=(int)Math.sqrt(n);
      
     for(int i=2; i<=root; i++){
         if(sosu[i]==true){
             for(int j=i; i*j<=n; j++)
                    sosu[i*j]=false;
         }      
     }
      for(int i =2; i<=n; i++)  { 
          if(sosu[i]==true)
          answer++;
      }
      return answer;
  }
}

