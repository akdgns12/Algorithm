package ���α׷��ӽ�_Level_1;

/*
 * ����Ʈ�� Ű�е忡�� �޼հ� �������� �����հ������� �̿��ؼ�
 * ���ڸ��� �Է��Ϸ� �Ѵ�.
 * �� ó�� �޼� �����հ����� * Ű�е忡 ������ �����հ����� # Ű�е忡 ��ġ����
 * ����. 
 * �����հ��� ��� ��Ģ
 * 1. �����հ����� �����¿� 4���� �������θ� �̵������ϸ� Ű�е� �̵��� ĭ�� 
 * �Ÿ��� 1
 * 2. ���� ���� 3���� ���� 1,4,7�� �Է��� ���� �޼�
 * 3. ������ 3���� ���� 3,6,9�� �Է��� ��� ������
 * 4. ��� ���� 4���� ���� 2,5,8,0�� �Է��� ���� �� �����հ����� ����
 * Ű�е��� ��ġ���� �� ����� �����հ����� ���
 * 4-1 ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���,
 * �޼����̴� �޼� �����հ����� ���
 * 
 * ������� ���� ��ȣ�� ��� �迭 numbers, �޼��������� ���������������� 
 * ��Ÿ���� ���ڿ� hand�� �Ű�����, �� ��ȣ�� ���� �����հ����� �޼�����
 * ������������ ��Ÿ���� ���ӵ� ���ڿ� ���·� return�ϴ� solution
 * 
 */
/*
 * <�˰���> 
 * 1. 1,4,7 �϶��� �޼��� ����ϰ�, 3,6,9 �϶��� ������ �������� ����ϰ�,
 * ���� Left, Right�� ��ġ�� �����Ѵ�
 * 2.��Ģ (Ű�е� -1 ) / 3 �� x��ǥ, (Ű�е� - 1) %3�� Y��ǥ
 * 3. Ű�е� 0�� 11�� �ٲ�����Ѵ�. *,# �� ���� 10,12�� �ٲ��ش�
 * 4. ���������� L�Ǵ� R�� ��ġ�� ��ǥ�� �������� Ű�е�(n)�� ���̸� ���Ѵ�.
 */
public class Ű�е崩���� {
	public String solution(int[] numbers, String hand) {
		StringBuilder bd = new StringBuilder();

        int leftLocation = 10;
        int rightLocation = 12;

        for(int number : n) {
            if(number ==1 || number == 4 || number == 7) {
                bd.append("L");
                leftLocation = number;
            }else if(number == 3 || number == 6 || number == 9) {
                bd.append("R");
                rightLocation = number;
            }else { // 2 5 8 0 
                int distanceL = getDist(leftLocation, number);
                int distanceR = getDist(rightLocation, number);

                if(distanceL > distanceR) {
                    bd.append("R");
                    rightLocation = number;
                }else if(distanceL < distanceR) {
                    bd.append("L");
                    leftLocation = number;
                }else {
                    if(hand.equals("right")) {
                        bd.append("R");
                        rightLocation = number;
                    }else {
                        bd.append("L");
                        leftLocation = number;
                    }
                }

            }
        }
        return bd.toString();
    }

    public static int getDist(int location, int number) {

        if(number == 0) {
            number = 11;
        }

        if(location == 0) {
            location = 11;
        }

        int locationX = (location-1) / 3;
        int locationY = (location-1) % 3;

        int numberX = (number-1) / 3;
        int numberY = (number-1) % 3;

        return Math.abs(locationX-numberX) + Math.abs(locationY - numberY);

    }
}
