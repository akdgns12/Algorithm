package �����ڵ�;

public class _2�����Ϸδٸ���Ʈ {
	import java.util.*;

	class Solution{
		public long[] solution(long[] numbers) {
			long[] answer = new long[numbers.length];
			
			for(int i=0; i<numbers.length; i++) {
				String BinaryString = Long.toBinaryString(numbers[i]);
				if(numbers[i] % 2 == 0) {
					//¦�� ���� ���� 0�� �ٲٱ�
					//��ǻ� �� ������ �ڸ��� 0�̱⿡ +1�� ���ش�
					answer[i] = numbers[i] + 1;
				}else {
					//Ȧ�� ���� ���� 0�� 1�� �ٲٰ�, ��� �ٲ۰ͺ��ٴ� ���� ��ġ���� 1�� 0���� �ٲٱ�
					int lastindex = BinaryString.lastIndexOf("0"); //�ڿ������� ó���߰ߵǴ� index��ȯ
					int firstindex = BinaryString.indexOf("1", lastindex); //1�� lastindex���� ã�ƶ�
					if(lastindex == -1) {//indexOf -> �ش� ���ڿ��� ���ٸ� -1�� ��ȯ�ϱ� ������ 0�� ���� ��쿡 �ش�
						//0�� ���� ��� +1�� ���ְ�
						//���� 10�� ���ΰ� �������� �� 1�� ���ش�.
						numbers[i] +=1;
						BinaryString = Long.toBinaryString(numbers[i]);
						BinaryString = BinaryString.substring(0,2) +
							BinaryString.substring(2, BinaryString.length()).replace("0","1");
					}else {
						BinaryString = BinaryString.substring(0, lastindex) + "1" +
									   BinaryString.substring(lastindex+1, firstindex) + "0" +
									   BinaryString.substring(firstindex+1, BinaryString.length());
					}
					
					answer[i] = Long.parseLong(BinaryString, 2);
				}
			}
			
			
			
			return answer;
		}
		
	}
}
